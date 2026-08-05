//10/07/26
// package Java;

// import java.util.Scanner;

// public class practice {
//    float x =14.44f;
//    float y =7.76f;
//    float sum= x + y;
//    float diff = x-y;
//    float pro = x*y;
//    float div = (float)x/y;

//     public static void main(String[] args) {
//     practice a = new practice();
//     System.out.println("Sum of the numbers is: ");
//     System.out.println(a.sum);
//     // System.out.println("Sum of numbers using methods: ");
//     // System.out.println(a.add());
//     System.out.println("Difference of numbers:");
//     System.out.println(a.diff);
//     System.out.println("Product of numbers:");
//     System.out.println(a.pro);
//     System.out.println("Division of numbers");
//     System.out.println(a.div);
//     Pyramid p = new Pyramid();
//     p.printPyramid();
    
//    }
// void show()
// {
//     System.out.println(sum);
// }
// float add(){
//     return x + y;
// }
// class Pyramid {

//     void printPyramid() {

//         int rows = 5;

//         for (int i = 1; i <= rows; i++) {

//             for (int j = 1; j <= i; j++) {
//                 System.out.print("*");
//             }

//             System.out.println();
//         }
//     }
// }


// 13/07/26
// package Java;

// public class practice {

//     int id;
//     String name;
//     int prn;
//     int age;
//     int height;

    
//     practice() {
//         id = 0;
//         name = "abc";
//         height= 0;
//         prn=0;
//         age = 0;

        
//     }

    
//     practice(int id, String name, int age, int height, int prn ) {
//         this.id = id;
//         this.name = name;
//         this.age= age;
//         this.height= height;
//         this.prn=prn;
//     }

    
//     practice(practice obj) {
//         this.id = obj.id;
//         this.name = obj.name;
//         this.age= obj.age;
//         this.height= obj.height;
//         this.prn=obj.prn;
//     }

    
//     void display() {
//         System.out.println("ID = " + id);
//         System.out.println("Name = " + name);
//         System.out.println("Age = " + age);
//         System.out.println("Height: = " + height);
//         System.out.println("PRN = " + prn);
        

//     }

//     public static void main(String[] args) {

        
//         practice p1 = new practice(133301, "Mohit", 18 , 165, 262);

        
//         practice p2 = new practice(p1);

//         System.out.println("First Waala object:"); 
//         p1.display();

//         System.out.println();

//         System.out.println("Copied  Waala Object:");
//         p2.display();
//     }
// }



// package Java;

// public class Practical {
//     int x = 5;
//     int y = 7;
//     int z = 13;

//     public static void main(String[] args) {
//         Practical obj = new Practical();
//         System.out.println(obj.x + obj.y == obj.z);
//     }
// }

// 17/07/26

//Develop a calculator program using overload methods for addition of integers and decimals. Use a static variable to count calculations. 

// public class Practical{


//     static int count;
//     int a= 0;
//     int b=0;
//     int c=0;
//     int e=0;
//     int d= a+b;
//     Practical()
//     {
//         a=10;
//         b=20;
//         e=30;
//         count ++;
//     }
//     Practical(int b){
//         d= a+b;
//         count++;

//     }
//     void show()
//     {
//         d = a+ b;
//         System.out.println("a:"+a);
//         System.out.println("b:"+b);
//         System.out.println("Sum: a+b="+ d );
//         System.out.println("Count:"+Practical.count);
//     }
    

    
//     void show(int e)
//     {
//         d = a+ b+e;
//         System.out.println("a:"+a);
//         System.out.println("b:"+b);
//         System.out.println("e:"+ e);
//         System.out.println("Sum: a+b+e="+ d );
//         System.out.println("Count:"+Practical.count);
//     }
//     public static void main(String[]args){
//         Practical m = new Practical();
//         m.show();
//         // m.show(1000);
//          Practical m2 = new Practical();
//          m2.show();
//         // m2.show();
//         // m2.show(101);
//         // System.out.println("Count:"+ Practical.count);
//     }
//     }


    // Develop a restaurant Billing application where overloaded methods calculate bills for dine-in, takeaway, and delivery orders, while static variables track total orders.
    
    // 22/7/26

class Restaurant {

    static int totalOrders = 0;

    
    void bill(int amount) {
        totalOrders++;
        System.out.println("Dinein Bill = " + amount);
    }

    void bill(int amount, int packing) {
        totalOrders++;
        System.out.println("takeaway Bill = " + (amount + packing));
    }

    
    void bill(int amount, int packing, int delivery) {
        totalOrders++;
        System.out.println("Delivery order bill = " + (amount + packing + delivery));
    }
}

public class Practical {
    int amount;
    int packing;
    int delivery;
    int totalOrders;
    public static void main(String[] args) {

        assign3 r = new assign3();

        r.bill(453);          // only dine-in
        r.bill(654, 20 );   //only dine in + packing    
        r.bill(787, 20, 150);  // dine in + packing+ delievery

        System.out.println("Total Orders = " + assign3.totalOrders);
    }
}


