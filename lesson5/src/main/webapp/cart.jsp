<%@ page import="com.surikov.lesson5.service.ProductOrderService" %>
<%@ page import="com.surikov.lesson5.service.ProductService" %>
<%@ page import="com.surikov.lesson5.entity.Cart" %>
<%@ page import="com.surikov.lesson5.service.CartService" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="resources/header.jsp"%>
<html>
<head>
    <title>Your Cart</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

</head>
<body>
<br>
<br>

    <%! List<Cart> cartList;
        CartService cartService = new CartService();
        %>
    <% cartList = cartService.getCart(1); %>

    <div style="display: grid; width: fit-content">

    <% for(Cart cart: cartList) {%>

    <div class="card">
        <div class="card-body">
            <h5 class="card-title"><%=cart.getName()%></h5>
            <p class="card-text"><%=cart.getDescription()%></p>
            <p class="card-text"><%=cart.getCount()%></p
            <a class="btn btn-secondary"><b><%=cart.getCount()*cart.getPrice()%> РУБ.</b></a>
        </div>
    </div>
    <%}%>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>

</div>
</body>
</html>
