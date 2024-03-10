<%@ page import="com.surikov.lesson5.service.ProductService" %>
<%@ page import="com.surikov.lesson5.entity.Product" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="resources/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <title>ProductShop</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
        <div style="display: grid; width: fit-content">
        <%! List<Product> productList;
            ProductService productService = new ProductService();%>
        <%productList = productService.getAll();
        for(Product product: productList) {%>
            <div class="card">
                <div class="card-body">
                    <h5 class="card-title"><%=product.getName()%></h5>
                    <p class="card-text"><%=product.getDescription()%></p>
                    <form action="/cartServlet" method="POST">
                        <input type="number" class="form-control" id="inputCount" min="1" value="1" name="count" placeholder="Количество">
                        <br>
                        <input type="number" name="productId" hidden value="<%=product.getId()%>">
                        <input type="submit" class="btn btn-primary" value="В корзину">

                        <a class="btn btn-secondary"><b><%=product.getPrice()%> РУБ.</b></a>
                    </form>

                </div>
            </div>
        <%}%>
        </div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>