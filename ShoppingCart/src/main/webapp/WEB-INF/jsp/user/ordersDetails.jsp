<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<div class="order-details-container">

    <!-- Order Header -->
    <div class="order-summary-card">
        <div class="order-summary-left">
            <h2>Order #${order.orderId}</h2>
            <p class="order-date">Placed on ${order.orderDate}</p>
        </div>

        <div class="order-summary-right">
            <span class="order-status ${order.status}">
                ${order.status}
            </span>
            <p class="order-total">
                RS ${order.totalAmount}
            </p>
        </div>
    </div>

    <!-- Order Items -->
    <div class="order-items">
        <c:forEach items="${items}" var="item">
            <div class="order-item-card">

                <img
                        src="/admin/product-image?id=${item.product.productId}"
                        class="product-image"
                        alt="Product Image"
                />

                <div class="product-info">
                    <h4>${item.product.productName}</h4>
                    <p>Price: Rs ${item.price}</p>
                    <p>Quantity: ${item.quantity}</p>
                </div>

                <div class="item-total">
                    Rs ${item.price * item.quantity}
                </div>

            </div>
        </c:forEach>
    </div>

    <div class="order-footer">
        <a href="/orders" class="back-link">Back to My Orders</a>
    </div>

</div>
