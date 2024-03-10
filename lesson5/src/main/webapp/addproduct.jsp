<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="resources/header.jsp"%>
<html>
<head>
    <title>Add product</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

</head>
<body>
<br>
<h2>Добавить продукт в базу: </h2>
<br>
<form action="/add-product-servlet" method="post">
<div class="form-floating">
    <input type="text" class="form-control" id="inputname" name="Name" placeholder="Product name">
    <label for="inputname">Наименование продукта</label>
</div>
<div class="form-floating">
    <input type="text" class="form-control" id="inputdescription" name="Description" placeholder="Product Description">
    <label for="inputdescription">Описание</label>
</div>
<div class="form-floating">
    <input type="number" class="form-control" id="inputprice" name="Price" placeholder="Product Description">
    <label for="inputprice">Цена</label>
</div>
    <br>
    <input type="submit" class="btn btn-primary" value="Добавить">
</form>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>

</body>
</html>
