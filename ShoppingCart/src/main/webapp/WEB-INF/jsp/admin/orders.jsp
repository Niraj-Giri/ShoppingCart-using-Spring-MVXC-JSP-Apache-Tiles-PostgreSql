<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<div class="orders-container">
    <h2 class="page-title">All Orders</h2>

    <c:if test="${empty orders}">
        <div class="empty">No orders found</div>
    </c:if>

    <c:if test="${not empty orders}">
        <div class="admin-orders-list">
            <c:forEach items="${orders}" var="o">
                <div class="admin-order-card">

                    <div class="order-left">
                        <h4>Order #${o.orderId}</h4>
                        <p class="order-price"> Rs ${o.totalAmount}</p>
                    </div>

                    <div class="order-right">
                        <span class="order-status ${o.status}">
                                ${o.status}
                        </span>
                    </div>

                </div>
            </c:forEach>
        </div>
    </c:if>
</div>
