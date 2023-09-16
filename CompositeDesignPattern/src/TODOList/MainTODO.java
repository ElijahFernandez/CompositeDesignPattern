package TODOList;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Main Class
public class MainTODO {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n");

        displayMenu();

        int choice = 0;

        List<TaskList> tasklist = new ArrayList<>(); // A List of Task Lists

        do {
            System.out.println("Enter a number: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch(choice) {
                case 1:
                    System.out.println("Enter Task List name: ");
                    String tasklistName = sc.nextLine();
                    TaskList tdltask = new TaskList(tasklistName);
                    tasklist.add(tdltask); // This adds the composite child to the TREE of Composite

                    System.out.println("Create Tasks? (YES/NO): ");
                    String yesno = sc.nextLine();

                    while (yesno.equals("YES")) {
                        System.out.println("Add a task: ");
                        String newtask = sc.nextLine();
                        Tasks tdlItem = new Tasks(newtask);
                        tdltask.addItem(tdlItem);

                        System.out.println("Add another task? (YES/NO): ");
                        yesno = sc.nextLine();
                    }
                    break;
                case 2:
                    if (tasklist.isEmpty()) {
                        System.out.println("No task lists created yet.");
                    } else {
                        System.out.println("Task Lists:");
                        for (int i = 0; i < tasklist.size(); i++) {
                            TaskList tdl = tasklist.get(i);
                            System.out.println((i + 1) + ". " + tdl.getName());

                            List<TDLComponents> tasks = tdl.getItems();
                            if (!tasks.isEmpty()) {
                                System.out.println("   Tasks:");
                                for (int j = 0; j < tasks.size(); j++) {
                                    Tasks task = (Tasks) tasks.get(j);
                                    System.out.println("   " + (j + 1) + ". " + task.getName());
                                }
                            } else {
                                System.out.println("   No tasks in this task list.");
                            }
                        }
                    }
                    break;
                case 3:
                    if (tasklist.isEmpty()) {
                        System.out.println("No task lists created yet.");
                    } else {
                        System.out.println("Task Lists:");
                        for (int i = 0; i < tasklist.size(); i++) {
                            TaskList tdl = tasklist.get(i);
                            System.out.println((i + 1) + ". " + tdl.getName());
                        }

                        System.out.println("Enter the number of the task list to remove a task from: ");
                        int taskListNumber = sc.nextInt();
                        sc.nextLine(); // Consume the newline

                        if (taskListNumber >= 1 && taskListNumber <= tasklist.size()) {
                            TaskList selectedTaskList = tasklist.get(taskListNumber - 1);
                            List<TDLComponents> tasksInTaskList = selectedTaskList.getItems();

                            if (!tasksInTaskList.isEmpty()) {
                                System.out.println("Tasks in " + selectedTaskList.getName() + ":");
                                for (int j = 0; j < tasksInTaskList.size(); j++) {
                                    Tasks task = (Tasks) tasksInTaskList.get(j);
                                    System.out.println((j + 1) + ". " + task.getName());
                                }

                                System.out.println("Enter the number of the task to remove: ");
                                int taskNumber = sc.nextInt();
                                sc.nextLine(); // Consume the newline

                                if (taskNumber >= 1 && taskNumber <= tasksInTaskList.size()) {
                                    Tasks taskToRemove = (Tasks) tasksInTaskList.get(taskNumber - 1);
                                    selectedTaskList.removeTask(taskToRemove);
                                    System.out.println("Task removed successfully.");
                                } else {
                                    System.out.println("Invalid task number.");
                                }
                            } else {
                                System.out.println("No tasks in this task list.");
                            }
                        } else {
                            System.out.println("Invalid task list number.");
                        }
                    }
                    break;


            }
        } while(choice != 4);

    }


    public static void displayMenu() {
        System.out.println("||----------TO-DO LIST----------||");
        System.out.println("1. Create a Task List");
        System.out.println("2. Display your tasks");
        System.out.println("3. Finish a task ( Removes task from List )");
        System.out.println("4. Exit");
    }
}

