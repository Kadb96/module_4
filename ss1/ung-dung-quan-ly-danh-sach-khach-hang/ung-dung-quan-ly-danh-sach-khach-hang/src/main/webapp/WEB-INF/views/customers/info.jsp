<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 5/23/2025
  Time: 12:36 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form>
    <h2>Customer Infomation</h2>
    <label>Id</label>
    <input readonly value="requestScope.customer.getCustomerId()">
</form>

