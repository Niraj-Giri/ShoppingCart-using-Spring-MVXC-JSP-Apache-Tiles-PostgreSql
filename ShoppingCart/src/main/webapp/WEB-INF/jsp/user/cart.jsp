
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="cart-wrapper">

    <h2>Your Cart</h2>

    <c:if test="${empty cart}">
        <p class="empty">Your cart is empty</p>
    </c:if>

    <c:forEach items="${cart}" var="item">
        <div class="cart-item">

            <img src="/admin/product-image?id=${item.value.productId}" alt="Product Image" />

            <div class="cart-details">
                <h4>${item.value.productName}</h4>
                <p>Price: Rs ${item.value.productPrice}</p>
                <p>Quantity: ${item.value.quantity}</p>
            </div>

            <a class="remove"
               href="/cart/remove?productId=${item.key}">
                Remove
            </a>
        </div>
    </c:forEach>

    <c:if test="${not empty cart}">
        <a href="/orders/checkout" class="checkout">
            Proceed to Checkout
        </a>
    </c:if>

</div>

<%--</body>--%>
<%--</html>--%>
