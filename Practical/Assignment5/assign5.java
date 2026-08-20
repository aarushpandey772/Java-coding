package Practical.Assignment5;
// import java.util.ArrayList;

// class ToDoList {

//     public static void main(String[] args) {

//         ArrayList<String> tasks = new ArrayList<>();

//         tasks.add("Complete Java Assignment");
//         tasks.add("Prepare for Practical");
//         tasks.add("Submit Lab Manual");
//         tasks.add("Revise OOP Concepts");

//         StringBuffer list = new StringBuffer();

//         list.append("TO-DO LIST\n");

//         for (int i = 0; i < tasks.size(); i++) {
//             list.append((i + 1) + ". " + tasks.get(i) + "\n");
//         }

//         System.out.println(list);
//     }
// }

import java.util.ArrayList;
import java.util.Scanner;

class CourseRegistration {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<String> courses = new ArrayList<>();

        int choice;

        do {

            System.out.println("\n----- Student Course Registration -----");
            System.out.println("1. Add Course");
            System.out.println("2. Remove Course");
            System.out.println("3. View Courses");
            System.out.println("4. Exit");
            System.out.print("Enter Choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter Course Name: ");
                    String course = sc.nextLine();
                    courses.add(course);
                    System.out.println("Course Added Successfully.");
                    break;

                case 2:
                    System.out.print("Enter Course Name to Remove: ");
                    String remove = sc.nextLine();

                    if (courses.remove(remove))
                        System.out.println("Course Removed Successfully.");
                    else
                        System.out.println("Course Not Found.");

                    break;

                case 3:

                    StringBuffer sb = new StringBuffer();

                    sb.append("\nRegistered Courses\n");

                    if (courses.isEmpty()) {
                        sb.append("No Courses Registered.");
                    } else {

                        for (int i = 0; i < courses.size(); i++) {
                            sb.append((i + 1) + ". ");
                            sb.append(courses.get(i));
                            sb.append("\n");
                        }
                    }

                    System.out.println(sb);

                    break;

                case 4:
                    System.out.println("Exiting Program...");
                    break;

                default:
                    System.out.println("Invalid Choice.");

            }

        } while (choice != 4);

        sc.close();

    }
}