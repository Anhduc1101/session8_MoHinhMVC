<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: trann
  Date: 11/24/2023
  Time: 3:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="danh-muc?action=add">Add new Category</a>
<table border="1" cellspacing="0">
    <tr>
        <td>STT</td>
        <td>ID</td>
        <td>Name</td>
        <td>Status</td>
        <td colspan="2">Action</td>
    </tr>
    <c:forEach items="${categories}" var="item" varStatus="loop">
        <tr>
            <td>${loop.index+1}</td>
            <td>${item.categoryId}</td>
            <td>${item.categoryName}</td>
            <td>${item.categoryStatus?"Active":"Close"}</td>
            <td><a href="/danh-muc?action=edit&id=${item.categoryId}">Edit</a></td>
            <td><a onclick="return confirm('ban co chac chan muon xoa khong?')"
                   href="/danh-muc?action=delete&id=${item.categoryId}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
