<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 5/23/2025
  Time: 12:36 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form method="post" action="/customers/updateCustomers">
    <h2>Customer Infomation</h2>
    <label for="customerId">Id</label>
    <input readonly value="${requestScope.customer.getCustomerId()}" name="customerId" id="customerId"><br>
    <label for="customerName">Name</label>
    <input name="customerName" id="customerName" value="${requestScope.customer.getCustomerName()}"><br>
    <label for="customerEmail">Email</label>
    <input name="customerEmail" id="customerEmail" value="${requestScope.customer.getCustomerEmail()}"><br>
    <label for="customerAddress">Address</label>
    <input name="customerAddress" id="customerAddress" value="${requestScope.customer.getCustomerAddress()}"><br>
    <button type="submit">Update</button>
</form>

