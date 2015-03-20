package ie.gmit.FibonacciProject;

import java.io.Serializable;

public class FibRequest implements Serializable {
	private static final long serialVersionUID = 1L;
	private int jobNumber;
	private int max;
	
	//getters and setters
	public int getJobNumber() {
		return jobNumber;
	}
	public void setJobNumber(int jobNumber) {
		this.jobNumber = jobNumber;
	}
	public int getMax() {
		return max;
	}
	public void setMax(int max) {
		this.max = max;
	} 
	
	public FibRequest(int jobNumber, int max) {
		super();
		this.jobNumber = jobNumber;
		this.max = max;

	}
}