class Employee {

    int empId;
    String name;

    Employee(int empId, String name) {
        this.empId = empId;
        this.name = name;
    }

    void display() {
        System.out.println("Employee ID : " + empId);
        System.out.println("Employee Name : " + name);
    }
}

class Manager extends Employee {

    String department;

    Manager(int empId, String name, String department) {
        super(empId, name);
        this.department = department;
    }

    void displayManager() {
        super.display();
        System.out.println("Department : " + department);
    }

    public static void main(String[] args) {
        Manager m = new Manager(101, "Aarush", "Sales");
        m.displayManager();
    }
}


// class Vehicle {

//     String vehicleNo;
//     String owner;

//     Vehicle(String vehicleNo, String owner) {
//         this.vehicleNo = vehicleNo;
//         this.owner = owner;
//     }

//     void displayVehicle() {
//         System.out.println("Vehicle Number : " + vehicleNo);
//         System.out.println("Owner Name : " + owner);
//     }
// }

// class Insurance extends Vehicle {

//     String policyNo;

//     Insurance(String vehicleNo, String owner, String policyNo) {
//         super(vehicleNo, owner);
//         this.policyNo = policyNo;
//     }

//     void displayInsurance() {
//         super.displayVehicle();
//         System.out.println("Policy Number : " + policyNo);
//     }

//     public static void main(String[] args) {

//         Insurance obj = new Insurance("MH12AB1234", "Rahul", "INS90876");
//         obj.displayInsurance();
//     }
// }
