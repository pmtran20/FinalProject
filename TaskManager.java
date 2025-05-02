import java.util.ArrayList;
import java.util.Scanner;

public class TaskManager {
    static ArrayList<String> pendingTasks = new ArrayList<>();
    static String[] completedTasks = new String[0];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Load data
        pendingTasks = FileHandler.loadData("pending.txt");
        completedTasks = FileHandler.loadArray("completed.txt");

        while (true) {
            System.out.println("\n-- Task Manager Menu --");
            System.out.println("1. Add Task");
            System.out.println("2. View Pending Tasks");
            System.out.println("3. View Completed Tasks");
            System.out.println("4. Complete a Task");
            System.out.println("5. Exit");

            int choice = InputValidator.getIntInput("Choose an option (1-5): ");

            switch (choice) {
                case 1 -> addTask(sc);
                case 2 -> viewList(pendingTasks, "Pending");
                case 3 -> viewArray(completedTasks, "Completed");
                case 4 -> completeTask();
                case 5 -> {
                    FileHandler.saveData(pendingTasks, "pending.txt");
                    FileHandler.saveArray(completedTasks, "completed.txt");
                    System.out.println("Data saved. Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    static void addTask(Scanner sc) {
        System.out.print("Enter task description: ");
        pendingTasks.add(sc.nextLine());
    }

    static void viewList(ArrayList<String> list, String title) {
        System.out.println(title + " Tasks:");
        if (list.isEmpty()) System.out.println("[None]");
        else for (int i = 0; i < list.size(); i++)
            System.out.println(i + ". " + list.get(i));
    }

    static void viewArray(String[] array, String title) {
        System.out.println(title + " Tasks:");
        if (array.length == 0) System.out.println("[None]");
        else for (int i = 0; i < array.length; i++)
            System.out.println(i + ". " + array[i]);
    }

    static void completeTask() {
        viewList(pendingTasks, "Pending");
        if (pendingTasks.isEmpty()) return;
        int index = InputValidator.getIntInput("Enter index to mark as complete: ");
        try {
            String task = pendingTasks.remove(index);
            String[] newCompleted = new String[completedTasks.length + 1];
            System.arraycopy(completedTasks, 0, newCompleted, 0, completedTasks.length);
            newCompleted[completedTasks.length] = task;
            completedTasks = newCompleted;
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Invalid index.");
        }
    }
}
