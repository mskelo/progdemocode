import java.util.Arrays;

public class VehicleFactory {
    public static void main(String[] args) {
        Order[] allOrders = InputValues.allOrders;
        System.out.println("De eerste bestelling bevat: "+ Arrays.toString(allOrders[0].getOrderedVehicles()));
        
        // Verwerk Orders één voor één volgens de opdracht 
        
        // Tip: schrijf helper-methods om de puzzel in kleinere delen op te knippen,
        //      en kies duidelijke namen om je code leesbaar te houden
    }
}
