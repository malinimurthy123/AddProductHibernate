<%--
  Created by IntelliJ IDEA.
  User: krmal
  Date: 4/3/2021
  Time: 5:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Product</title>
    <script src="addproduct.js"></script>
</head>
<body>


<form action="pets" method="POST" name="form_name" id="form_id" class="form_class">
    <label for="ProductName">Name:</label><br>
    <input type="text" id="ProductName" name="ProductName"><br>

    <label for="Colour">Color:</label><br>
    <input type="text" id="Colour" name="Colour"><br>

    <label for="price">Price:</label><br>
    <input type="number" placeholder="0.00" step="0.01" min="0" id="price" name="price"><br><br>

    <input type="submit" value="Submit" onclick="addpet_onclick()">
</form>

</body>
</html>