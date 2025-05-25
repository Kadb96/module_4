<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 5/22/2025
  Time: 11:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
    table {
        border: 1px solid #000;
    }

    th, td {
        border: 1px dotted #555;
    }
</style>
There are ${requestScope.customers.size()} customer(s) in list.
<table>
    <caption>Customers List</caption>
    <thead>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Email</th>
        <th>Address</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="c" items="${requestScope.customers}">
        <tr>
            <td>
                <c:out value="${c.getCustomerId()}"/>
            </td>
            <td>
                <a href="/customers/${c.getCustomerId()}">${c.getCustomerName()}</a>
            </td>
            <td>
                <c:out value="${c.getCustomerEmail()}"/>
            </td>
            <td>
                <c:out value="${c.getCustomerAddress()}"/>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
