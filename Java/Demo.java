// public class Demo {

//     int number;
//     String text;

//     Demo() {
//         number = 100;
//         text = "Java Programming";
//     }

//     void display() {
//         System.out.println("Number : " + number);
//         System.out.println("Text : " + text);
//     }

//     public static void main(String[] args) {
//         Demo obj = new Demo();
//         obj.display();
//     }
// }

// public class Demo {

//     int value;
//     String name;

//     Demo() {
//         value = 10;
//         name = "Default";
//     }

//     Demo(int value, String name) {
//         this.value = value;
//         this.name = name;
//     }

//     Demo(Demo obj) {
//         value = obj.value;
//         name = obj.name;
//     }

//     void display() {
//         System.out.println("Value : " + value);
//         System.out.println("Name : " + name);
//     }

//     public static void main(String[] args) {

//         Demo obj1 = new Demo();
//         Demo obj2 = new Demo(50, "Parameterized");
//         Demo obj3 = new Demo(obj2);

//         obj1.display();
//         System.out.println();

//         obj2.display();
//         System.out.println();

//         obj3.display();
//     }
// }

// 

// public class Demo {

//     public static void main(String[] args) {

//         String a = "25";
//         String b = "15";

//         Integer num1 = Integer.valueOf(a);
//         Integer num2 = Integer.valueOf(b);

//         int sum = num1 + num2;

//         Double value = Double.valueOf("35.75");

//         System.out.println("First Value : " + num1);
//         System.out.println("Second Value : " + num2);
//         System.out.println("Sum : " + sum);
//         System.out.println("Double Value : " + value);
//     }
// }

import java.util.ArrayList;
import java.util.Vector;

public class Demo {

    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<>();

        list.add("One");
        list.add("Two");
        list.add("Three");

        Vector<Integer> vector = new Vector<>();

        vector.add(10);
        vector.add(20);
        vector.add(30);

        StringBuffer buffer = new StringBuffer();

        buffer.append("ArrayList Elements\n");

        for (String item : list) {
            buffer.append(item).append("\n");
        }

        buffer.append("\nVector Elements\n");

        for (Integer value : vector) {
            buffer.append(value).append("\n");
        }

        System.out.println(buffer);
    }
}