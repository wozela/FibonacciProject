package ie.gmit.FibonacciProject;

import java.rmi.*;

// java remote interface
public interface RemoteFibonacci extends Remote {
	public String getFibonacciSequence(int max) throws RemoteException;
}
