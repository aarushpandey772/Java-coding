package Practical.Assignment2;
class Student1{
    String name;
    int rollNo;
    Student1(){
        System.out.println("Default Constructor");
    }

    Student1(String name, int rollNo ){
        this.name = name;
        this.rollNo = rollNo;
    }
    void display(){
         System.out.println("Name:"+ name + "\n" + "RollNo:" + rollNo);
    }
    public static void main (String[]args){
        Student1 obj = new Student1();
        Student1 obj1 = new Student1("Aarush", 262);
        obj1.display();
    }
}