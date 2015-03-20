package ie.gmit.FibonacciProject;

import java.io.IOException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.registry.LocateRegistry;

import ie.gmit.FibonacciProject.Fibonacci;
import ie.gmit.FibonacciProject.RemoteFibonacci;
import ie.gmit.FibonacciProject.FibService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PageServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	FibService fibService;
	int jobNumber;
	
	//binding registry
	public void init() {
		fibService = new FibService();
		try {
			RemoteFibonacci fibonacci = new Fibonacci(1099);
			LocateRegistry.createRegistry(1099);
			Naming.rebind("fibRegistry", fibonacci);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//get fibonacci length from user input
		String type = req.getParameter("fibLength");
		
		if (type.equals("add")) {
			System.out.println("Fibonacci Sequence is calculating.");
			int max = Integer.parseInt(req.getParameter("max"));
			jobNumber = fibService.add(max);
			
			//Remote method
			try {
				RemoteFibonacci remoteFibInterface = (RemoteFibonacci) Naming.lookup("rmi://localhost:1099/fibRegistry");
				String result = remoteFibInterface.getFibonacciSequence(max);
				fibService.putResult(jobNumber, result);
				System.out.println("Job number is:" + jobNumber);
				req.setAttribute("jobNumber", jobNumber);
				req.setAttribute("result", result);
				req.getRequestDispatcher("JobNumber.jsp").forward(req,resp);
			} catch (NotBoundException e) {
				System.out.println("NotBoundException");
				e.printStackTrace();
			}
		
		//get fibonacci from fibService and send to page
		} else if (type.equals("send")) {
			System.out.println("Sending Fibonacci Sequence.");
			String returnType = fibService.getResult(jobNumber);
			
			if (returnType != null) {
				resp.sendRedirect("FibonacciSequence.jsp?result=" + returnType);
				System.out.println("Calculated Fibonacci Sequence is :"+ returnType);
			} else {
				resp.sendRedirect("JobNumber.jsp");
			}
		}
	}
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		super.doPost(req, resp);
	}
	
	
}
