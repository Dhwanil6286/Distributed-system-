import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

/**
 * Interactive RMI client for the calculator stack.
 */
public class CalculatorClient {
    public static void main(String[] args) {
        System.out.println("[Client] Client has successfully established connection with the server");
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            Calculator cal_cu = (Calculator) registry.lookup("CalculatorService");

            Scanner sc = new Scanner(System.in);
            boolean running = true;

            while (running) {
                System.out.println("\n=== Calculator Menu ===");
                System.out.println("1. Push Value");
                System.out.println("2. Push Operation (lcm , gcd , max , min)");
                System.out.println("3. Pop");
                System.out.println("4. Delay Pop");
                System.out.println("5. Check if Empty");
                System.out.println("6. Exit");
                System.out.print("Choose an option: ");

                int choice = sc.nextInt();
                sc.nextLine(); // consume newline

                String res;
                switch (choice) {
                    case 1:
                        System.out.print("Enter integer value: ");
                        int vall = sc.nextInt();
                        res = cal_cu.pushValue(vall);
                        System.out.println(res);
                        break;

                    case 2:
                        System.out.print("Enter operation (lcm/gcd/max/min): ");
                        String op = sc.nextLine();
                        res = cal_cu.pushOperation(op);
                        System.out.println(res);
                        break;

                    case 3:
                        res = cal_cu.pop();
                        System.out.println(res);
                        break;

                    case 4:
                        System.out.print("Enter delay in milliseconds: ");
                        int ms = sc.nextInt();
                        res = cal_cu.delayPop(ms);
                        System.out.println(res);
                        break;

                    case 5:
                        boolean empty = cal_cu.isEmpty();
                        System.out.println("[Server] Stack empty? " + empty);
                        break;

                    case 6:
                        running = false;
                        break;

                    default:
                        System.out.println("Invalid choice.");
                }
            }
            sc.close();
            System.out.println("[Client] Disconnected.");
        } catch (Exception e) {
            System.err.println("[Client] Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}