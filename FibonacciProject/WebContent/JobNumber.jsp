<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Calculating Fibonacci</title>
</head>
<body>

<form action="">
      Job number is :<%=request.getAttribute("jobNumber") %> <br>
	  <%response.addHeader("Refresh","10;http://localhost:8080/FibonacciProject/PageServlet?fibLength=send&fib="+request.getAttribute("result")); %>
  	  <br><br>
  	  Page refresh in 10 seconds ...
 </form>

</body>
</html>