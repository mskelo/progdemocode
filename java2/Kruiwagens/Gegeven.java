import java.util.Random;

/**
 * Hoeft niet verder ingevuld te worden
 * `final class` betekent: "cannot be extended"
 */
final class Order {
    private int[] orderedVehicles = new int[5]; 
    public Order(int a, int b, int c, int d, int e) {
        this.orderedVehicles[0] = a; // == kruiwagens
        this.orderedVehicles[1] = b; // == fiets met motor
        this.orderedVehicles[2] = c; // == fiets zonder motor
        this.orderedVehicles[3] = d; // == bakfiets met motor
        this.orderedVehicles[4] = e; // == bakfiets zonder motor
    }
    public int[] getOrderedVehicles() {
        return this.orderedVehicles;
    }
}

/**
 * Vul zelf verder in en schrijf afgeleide classes in een apart .java bestand
 */
class Vehicle {
    private int condition;
    private int price;

    public Vehicle() {
        Random random = new Random(-229985452); // Dit staat al voor je ingevuld
        // Genereer ^ hiermee ^ de conditie van het voertuig en sla op in this.condition
    }
    
    // Vul zelf verder in waar nodig na het maken van een klassendiagram
    // ...
}

/**
 * Read-only
 */
class InputValues {
    // Zie VehicleFactory.main();
    public final static Order[] allOrders = {
        new Order(12, 45, 31, 8, 22),
        new Order(6, 18, 40, 11, 49),
        new Order(27, 5, 33, 14, 37),
        new Order(9, 36, 0, 2, 47),
        new Order(3, 29, 25, 42, 10),
        new Order(16, 44, 19, 39, 4),
        new Order(30, 21, 46, 1, 28),
        new Order(34, 15, 23, 38, 20),
        new Order(0, 26, 7, 41, 32),
        new Order(24, 13, 48, 35, 50),
        new Order(42, 18, 37, 9, 26),
        new Order(5, 30, 14, 47, 21),
        new Order(33, 10, 24, 0, 45),
        new Order(19, 6, 50, 29, 12),
        new Order(7, 41, 22, 3, 36),
        new Order(49, 25, 8, 44, 16),
        new Order(27, 1, 35, 0, 48),
        new Order(23, 4, 32, 17, 40),
        new Order(15, 28, 43, 20, 2),
        new Order(34, 13, 31, 46, 39),
    };
}
