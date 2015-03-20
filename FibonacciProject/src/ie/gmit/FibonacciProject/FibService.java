package ie.gmit.FibonacciProject;

import java.util.*;

public class FibService {
	private LinkedList<FibRequest> inqueue = new LinkedList <FibRequest>();
	private Map<Integer,String> outqueue = new HashMap<Integer, String>();
	
	public int add (int max){
		//generate random number 
		int random = (int) ((int) Math.random() * max + System.currentTimeMillis() * Math.random());
		inqueue.addLast(new FibRequest(random, max));
	return random; 
	}
	
	public String getResult(int jobNumber){
		if(outqueue.containsKey(jobNumber)){
			String result = outqueue.get(jobNumber);
			outqueue.remove(jobNumber);
			return result;
		} else {
			return null;
		}
	}
	
	public void putResult(int jobNumber,String fibNumber){
		outqueue.put(jobNumber, fibNumber);
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
	

}
