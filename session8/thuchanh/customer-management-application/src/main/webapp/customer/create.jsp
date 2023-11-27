<%--
  Created by IntelliJ IDEA.
  User: trann
  Date: 11/24/2023
  Time: 8:27 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form style="max-width: 400px; margin: 0 auto;" method="post">
    <h1>Create new customer</h1>
    <div>
        <label for="cusName">Cus. Name:</label>
        <input type="text" id="cusName" name="cusName" style="width: 100%; padding: 6px; border: 1px solid #ddd; border-radius: 4px;">
    </div>
    <div>
        <label for="address">Address:</label>
        <input type="text" id="address" name="address" style="width: 100%; padding: 6px; border: 1px solid #ddd; border-radius: 4px;">
    </div>
    <div>
        <label for="email">Email:</label>
        <input type="text" id="email" name="email" style="width: 100%; padding: 6px; border: 1px solid #ddd; border-radius: 4px;">
    </div>
    <div>
        <button type="submit" style="padding: 8px 16px; background-color: #4CAF50; color: white; border: none; border-radius: 4px; cursor: pointer;">Add</button>
    </div>
    <div>
        <button  style="padding: 8px 16px; background-color: #1357ea;  border: none; border-radius: 4px; cursor: pointer;"><a href="customer-management" style="color: white; text-decoration: none" >Back</a></button>
    </div>
</form>
</body>
</html>
