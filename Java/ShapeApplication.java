class Shape {

    void area() {
        System.out.println("Area Calculation");
    }
}

class Circle extends Shape {

    double radius = 5;

    void area() {
        double area = 3.14 * radius * radius;
        System.out.println("Area of Circle = " + area);
    }
}

class Rectangle extends Shape {

    int length = 10;
    int breadth = 5;

    void area() {
        int area = length * breadth;
        System.out.println("Area of Rectangle = " + area);
    }
}

public class ShapeApplication {

    public static void main(String[] args) {

        Circle c = new Circle();
        Rectangle r = new Rectangle();

        c.area();
        r.area();
    }
}

// interface Product {

//     void display();
// }

// class Item {

//     int id;
//     String name;

//     Item(int id, String name) {
//         this.id = id;
//         this.name = name;
//     }
// }

// class Electronic extends Item implements Product {

//     Electronic(int id, String name) {
//         super(id, name);
//     }

//     public void display() {
//         System.out.println("Electronic Product");
//         System.out.println("ID : " + id);
//         System.out.println("Name : " + name);
//     }
// }

// class Clothing extends Item implements Product {

//     Clothing(int id, String name) {
//         super(id, name);
//     }

//     public void display() {
//         System.out.println("\nClothing Product");
//         System.out.println("ID : " + id);
//         System.out.println("Name : " + name);
//     }
// }

// class Grocery extends Item implements Product {

//     Grocery(int id, String name) {
//         super(id, name);
//     }

//     public void display() {
//         System.out.println("\nGrocery Product");
//         System.out.println("ID : " + id);
//         System.out.println("Name : " + name);
//     }
// }

// public class Ecommerce {

//     public static void main(String[] args) {

//         Electronic e = new Electronic(101, "Laptop");
//         Clothing c = new Clothing(201, "T-Shirt");
//         Grocery g = new Grocery(301, "Rice");

//         e.display();
//         c.display();
//         g.display();
//     }
// }