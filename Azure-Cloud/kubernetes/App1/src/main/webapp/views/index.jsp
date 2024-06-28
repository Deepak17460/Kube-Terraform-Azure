<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Calculator</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body style="background-color: #f0f0f0;">
    	<div class="container mt-5">
		<form action="calculate" method="post">
			<div class="form-group">
		        <input type="number" class="form-control" name="num1" placeholder="Enter number 1" required><br><br>
			</div>
			<div class="form-group">
		        <input type="number" class="form-control" name="num2" placeholder="Enter number 2" required><br><br>
			</div>
	        <button type="submit" class = "btn btn-primary mr-2" name="operation" value="add">Add</button>
	        <button type="submit" class = "btn btn-primary mr-2" name="operation" value="subtract">Subtract</button>
	        <button type="submit" class = "btn btn-primary mr-2" name="operation" value="multiply">Multiply</button>
	        <button type="submit" class = "btn btn-primary" name="operation" value="divide">Divide</button>
    </form>
	</div>
</body>
</html>