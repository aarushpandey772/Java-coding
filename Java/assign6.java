// interface Action {
//     void perform();
// }

// class Vehicle {

//     String brand = "Toyota";
//     String model = "Fortuner";

//     class VehicleDetails {
//         void display() {
//             System.out.println("Brand : " + brand);
//             System.out.println("Model : " + model);
//         }
//     }

//     public static void main(String[] args) {

//         Vehicle v = new Vehicle();

//         Vehicle.VehicleDetails obj = v.new VehicleDetails();
//         obj.display();

//         Action a = new Action() {
//             public void perform() {
//                 System.out.println("Vehicle Started");
//             }
//         };

//         a.perform();
//     }
// }

interface DeliveryStatus {
    void status();
}

class FoodDelivery {

    String orderId = "FD101";
    String item = "Pizza";

    class Order {

        void display() {
            System.out.println("Order ID : " + orderId);
            System.out.println("Food Item : " + item);
        }
    }

    public static void main(String[] args) {

        FoodDelivery f = new FoodDelivery();

        FoodDelivery.Order o = f.new Order();
        o.display();

        DeliveryStatus preparing = new DeliveryStatus() {
            public void status() {
                System.out.println("Status : Preparing");
            }
        };

        DeliveryStatus delivered = new DeliveryStatus() {
            public void status() {
                System.out.println("Status : Delivered");
            }
        };

        preparing.status();
        delivered.status();
    }
}