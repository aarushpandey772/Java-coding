// class StudentMarks {

//     public static void main(String[] args) {

//         String m1 = "85";
//         String m2 = "90";
//         String m3 = "88";

//         Integer mark1 = Integer.valueOf(m1);
//         Integer mark2 = Integer.valueOf(m2);
//         Integer mark3 = Integer.valueOf(m3);

//         int total = mark1 + mark2 + mark3;

//         System.out.println("Mark 1 = " + mark1);
//         System.out.println("Mark 2 = " + mark2);
//         System.out.println("Mark 3 = " + mark3);
//         System.out.println("Total Marks = " + total);
//     }
// }

import java.util.Scanner;

class EmployeePayroll {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Employee ID : ");
        String id = sc.nextLine();

        System.out.print("Enter Basic Salary : ");
        String basic = sc.nextLine();

        System.out.print("Enter Bonus : ");
        String bonus = sc.nextLine();

        Integer empId = Integer.valueOf(id);
        Double basicSalary = Double.valueOf(basic);
        Double bonusAmount = Double.valueOf(bonus);

        if (basicSalary < 0 || bonusAmount < 0) {
            System.out.println("Invalid Salary Details");
        } else {
            double netSalary = basicSalary + bonusAmount;

            System.out.println("Employee ID = " + empId);
            System.out.println("Basic Salary = " + basicSalary);
            System.out.println("Bonus = " + bonusAmount);
            System.out.println("Net Salary = " + netSalary);
        }

        sc.close();
    }
}