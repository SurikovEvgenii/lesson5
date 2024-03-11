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

    <%!
        List<Cart> cartList;
        CartService cartService = new CartService();
    %>
    <% int sum = 0;%>

    <form method="post" action="/select-show">
    <div class="input-group input-group-sm mb-3">
        <span class="input-group-text" id="inputGroup-sizing-sm">Введите номер заказа: </span>
        <input type="number" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm" name="orderId">
        <input class="btn btn-danger" type="submit" value="Показать">
    </div>
    </form>

    <%
        int id = 0;
        String check = request.getParameter("orderId");

        if(check == null){
            id = 1;
            cartList = cartService.getCart(id);
        } else {
            id = Integer.parseInt(check);
            cartList = cartService.getCart(id);
        }
    %>

    <div>
        <div class="row row-cols-1 row-cols-md-2 g-4">
        <% for(Cart cart: cartList) {%>
            <div class="col">
                 <div class="card">
                    <div class="card-body">
                        <h5 class="card-title"><%=cart.getName()%></h5>
                        <p class="card-text"><%=cart.getDescription()%></p>
                        <p class="card-text"><b>Количество:</b>  <%=cart.getCount()%>шт.</p>
                        <p class="card-text"><b>Цена:</b>  <%=cart.getPrice()%>руб.</p>
                        <h5 class="card-text">Итого:</h5>
                        <a class="btn btn-secondary"><b><%= cart.getCount()*cart.getPrice()%> РУБ.</b></a>
                        <div style="display: inline-grid;">

                            <form action="/delete-product-servlet" method="POST">
                                <label>
                                    <input hidden name="orderId" value="<%=cart.getOrderId()%>">
                                </label>
                                <label>
                                    <input hidden name="productId" value="<%=cart.getProductId()%>">
                                </label>
                                <input class="btn btn-danger" type="submit" value="Удалить">
                            </form>

                            <form action="/select-show" method="GET">
                                <label>
                                    <input hidden name="orderId" value="<%=cart.getOrderId()%>">
                                </label>
                                <label>
                                    <input hidden name="productId" value="<%=cart.getProductId()%>" >
                                </label>
                                <input class="btn btn-danger" type="submit" value="Получить номера заказов">
                            </form>

                        </div>

                        <% sum += cart.getCount()*cart.getPrice(); %>

                    </div>
                </div>
            </div>
        <%}%>
        </div>
    </div>


<hr class="border border-primary border-3 opacity-75">
<h3 style="justify-content: center"><b>Итого: <%=sum%> руб.</b></h3>
<br>
<br>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>

</div>
</body>
</html>
