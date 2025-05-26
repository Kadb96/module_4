<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<h1>Calculator</h1>
<form action="/calculators" method="post">
    <input type="number" name="firstNumber">
    <input type="number" name="secondNumber"><br>
    <button type="submit" name="formula" value="addition">Addition(+)</button>
    <button type="submit" name="formula" value="subtraction">Subtraction(-)</button>
    <button type="submit" name="formula" value="multiplication">Multiplication(x)</button>
    <button type="submit" name="formula" value="division">Division(/)</button>
</form>
<p>${message}</p>
</body>
</html>