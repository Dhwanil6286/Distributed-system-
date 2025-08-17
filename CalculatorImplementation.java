import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.util.Stack;

/**
 * Implementation of the Calculator interface.
 */
public class CalculatorImplementation extends UnicastRemoteObject implements Calculator {
    private Stack<Integer> stack;

    public CalculatorImplementation() throws RemoteException {
        stack = new Stack<>();
    }

    @Override
    public synchronized String pushValue(int vall) throws RemoteException {
        stack.push(vall);
        return "[Server] Value pushed into the Stack : " + vall;
    }

    @Override
    public synchronized String pushOperation(String oper) throws RemoteException {
        if (stack.isEmpty()) {
            return "[Server] Stack is empty. Cannot perform operation. Please push values into the stack and then try again";
        }
        int res = stack.pop();
        while (!stack.isEmpty()) {
            int nextVal = stack.pop();
            switch (oper.toLowerCase()) {
                case "lcm": res = lcm(res, nextVal); break;
                case "gcd": res = gcd(res, nextVal); break;
                case "max": res = Math.max(res, nextVal); break;
                case "min": res = Math.min(res, nextVal); break;
                default: return "[Server] Unknown operation: " + oper;
            }
        }
        stack.push(res);
        return "[Server] Operation '" + oper + "' result pushed: " + res;
    }

    @Override
    public synchronized String pop() throws RemoteException {
        if (stack.isEmpty()) {
            return "[Server] Stack is empty, cannot pop.";
        }
        int vall = stack.pop();
        return "[Server] Value popped successfully , here is the value popped :- : " + vall;
    }

    @Override
    public synchronized boolean isEmpty() throws RemoteException {
        return stack.isEmpty();
    }

    @Override
    public synchronized String delayPop(int milli_seconds) throws RemoteException {
        try {
            Thread.sleep(milli_seconds);
        } catch (InterruptedException e) {
            return "[Server] Delay interrupted.";
        }
        return pop();
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    private int lcm(int a, int b) {
        return Math.abs(a * b) / gcd(a, b);
    }
}