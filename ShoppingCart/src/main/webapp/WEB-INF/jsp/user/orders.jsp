
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="orders-container">

    <h2 class="page-title">My Orders</h2>

    <c:if test="${empty orders}">
        <div class="empty-state">
            <p>No orders found</p>
        </div>
    </c:if>

    <div class="orders-list">
        <c:forEach items="${orders}" var="o">
            <div class="order-card">

                <div class="order-header">
                    <span class="order-id">Order #${o.orderId}</span>
                    <span class="order-status ${o.status}">
                            ${o.status}
                    </span>
                </div>

                <div class="order-body">
                    <p><strong>Total:</strong> Rs ${o.totalAmount}</p>
                    <p><strong>Date:</strong> ${o.orderDate}</p>
                </div>

                <div class="order-footer">
                    <a href="/orders/${o.orderId}" class="btn-outline">
                        View Details
                    </a>
                </div>

            </div>
        </c:forEach>
    </div>

</div>
