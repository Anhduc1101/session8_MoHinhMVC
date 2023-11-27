<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: trann
  Date: 11/24/2023
  Time: 8:28 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        /*table, th, tr, td {*/

        /*    border-collapse: collapse;*/
        /*}*/
        table {
            padding: 8px;
            width: 80%;
            border-collapse: collapse;
        }

        th, td {
            padding: 5px;
            border: 1px solid #ddd;
            text-align: center; /* Căn giữa theo chiều ngang */
        }
        td {
            vertical-align: middle; /* Căn giữa theo chiều dọc */
        }
        a {
            margin: 5px;
            text-decoration: none;
        }
    </style>
</head>
<body>
<a href="customer-management?action=create">Add new customer</a>
<form action="customer-management">
    <input type="text" name="search" value="${searchName}">
    <button value="search" name="action">Search</button>
</form>

<%--cách 1: dùng button--%>
<form action="customer-management" method="GET">
    <button type="submit" name="action" value="sort">Sort</button>
</form>

<%--cách 2: dùng thẻ <a></a>--%>
<%--    <a href="customer-management?action=sort">Sort</a>--%>
<table>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Address</th>
        <th>Email</th>
        <th colspan="2">Action</th>
    </tr>
   <c:forEach items="${customers}" var="c" varStatus="loop">
       <tr>
           <td>${loop.index+1}</td>
           <td>${c.name}</td>
           <td>${c.address}</td>
           <td>${c.email}</td>
           <td><a href="customer-management?action=edit&id=${c.getId()}">Edit</a></td>
           <td><a href="customer-management?action=delete&id=${c.getId()}" onclick="return confirm('Bạn có chắc chắn muốn xóa không?')">Delete</a></td>
       </tr>
   </c:forEach>
</table>
</body>
</html>
