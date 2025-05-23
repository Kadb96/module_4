<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 5/23/2025
  Time: 6:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Ung Dung Chuyen Doi Tien Te</title>
</head>
<body>
  <form>
    <label for="vnd">Nhap VND</label>
    <input type="number" name="vnd" id="vnd" value="${requestScope.vnd}">
    <span> Quy đổi: ${requestScope.usd} USD</span>
    <button type="submit">Submit</button>
  </form>
</body>
</html>
