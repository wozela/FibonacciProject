<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>FIBONACCI CALCULATOR</title>
</head>
<body>
<form action="PageServlet" method="get">			
			Enter the Fibonacci Sequence Length:  <input type="hidden" name="fibLength" value="add"/><input type="text" name="max" size="100px">
			<br><br>
			<input type="submit" value="submit">						
</form>		

</body>
</html>