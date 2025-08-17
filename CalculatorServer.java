import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Now we will write the code to start the RMI server and bind it with the calculator implementation.
 */
public class CalculatorServer {
    public static void main(String[] args) {
        try {
            CalculatorImplementation cal_cu = new CalculatorImplementation();
            Registry reg_i = LocateRegistry.createRegistry(1099);
            reg_i.rebind("CalculatorService", cal_cu);
            System.out.println("[Server] Calc RMI Server is running...");
            System.out.println("[Server] Now you need to run the client file to connect client with the Server, Thankyou");
        } catch (Exception e) {
            System.err.println("[Server] Error! Server not responding , please try again!: " + e.getMessage());
            e.printStackTrace();
        }
    }
}