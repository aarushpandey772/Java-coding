package Practical.Assignment11;
// interface Printable {

//     void print();
// }

// class Student implements Printable {

//     String name = "Aarush";
//     int rollNo = 101;

//     public void print() {
//         System.out.println("Student Details");
//         System.out.println("Name : " + name);
//         System.out.println("Roll No : " + rollNo);
//     }
// }

// class Employee implements Printable {

//     int empId = 501;
//     String empName = "Rahul";

//     public void print() {
//         System.out.println("\nEmployee Details");
//         System.out.println("Employee ID : " + empId);
//         System.out.println("Employee Name : " + empName);
//     }
// }

// public class assign11 {

//     public static void main(String[] args) {

//         Student s = new Student();
//         Employee e = new Employee();

//         s.print();
//         e.print();
//     }
// }


interface Switchable {

    void turnOn();
}

class Light implements Switchable {

    public void turnOn() {
        System.out.println("Light is ON");
    }
}

class Fan implements Switchable {

    public void turnOn() {
        System.out.println("Fan is ON");
    }
}

public class assign11 {

    public static void main(String[] args) {

        Light light = new Light();
        Fan fan = new Fan();

        light.turnOn();
        fan.turnOn();
    }
}