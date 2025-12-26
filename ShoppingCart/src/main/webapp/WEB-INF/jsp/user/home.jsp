

<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- Navbar -->

<div class="container">

    <c:if test="${not empty sessionScope.msg}">
        <div id="flash-msg" class="flash-msg">
                ${sessionScope.msg}
        </div>
        <c:remove var="msg" scope="session"/>
    </c:if>


    <div class="grid">
        <c:forEach items="${products}" var="p">
            <div class="card">
                <img src="/admin/product-image?id=${p.productId}" alt="Product Image" />
                <h3>${p.productName}</h3>
                <p> Rs ${p.productPrice}</p>

                <a href="/cart/add?productId=${p.productId}" class="btn">
                    Add to Cart
                </a>
            </div>
        </c:forEach>
    </div>

</div>


