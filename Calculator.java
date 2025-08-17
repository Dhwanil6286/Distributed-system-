import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Remote interface for calculator stack operations.
 */
public interface Calculator extends Remote {
    String pushValue(int vall) throws RemoteException;
    String pushOperation(String oper) throws RemoteException;
    String pop() throws RemoteException;
    boolean isEmpty() throws RemoteException;
    String delayPop(int milli_seconds) throws RemoteException;
}