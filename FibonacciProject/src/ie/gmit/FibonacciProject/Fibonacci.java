package ie.gmit.FibonacciProject;

import ie.gmit.FibonacciProject.RemoteFibonacci;

import java.math.BigInteger;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Fibonacci extends UnicastRemoteObject implements RemoteFibonacci {
	private static final long serialVersionUID = 1L;
	private RemoteFibonacci remFibInterface; 
	protected Fibonacci(int port) throws RemoteException {
		super(port);
		// TODO Auto-generated constructor stub
	}
	
	public Fibonacci(RemoteFibonacci remoteFib) throws RemoteException {
		super();
		this.remFibInterface = remoteFib;
	}
	
	public String getFibonacciSequence (int max) throws RemoteException {

		//Fib computational (use stringbuffer)
			switch(max){
			case 0:
				return "1";
			case 1:
				return "1, 1,";
				
			default:
				BigInteger fib1 = BigInteger.ONE;
				BigInteger fib2 = BigInteger.ONE;
				BigInteger fib = BigInteger.ZERO;
				StringBuffer fibBuffer = new StringBuffer("1, 1, ");
				for (int i = 0; i < max-2; i++) {
					fib = fib1.add(fib2);
					fibBuffer.append(fib).append(", ");
					fib1 = fib2;
					fib2 = fib;
				}
				return fibBuffer.toString();	}
	}
	
	public RemoteFibonacci getRemote() {
		return remFibInterface;
	}
}

