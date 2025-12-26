
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!-- ========== PAGE HEADER ========== -->
<div class="admin-header">
    <h2>Products</h2>
    <p>Manage your store inventory</p>
</div>

<!-- ========== PRODUCT GRID ========== -->
<div class="admin-container">
    <div class="admin-grid">

        <c:forEach items="${products}" var="p">
            <a href="/admin/product?id=${p.productId}" class="admin-card">

                <!-- IMAGE -->
                <img
                        src="/admin/product-image?id=${p.productId}"
                        alt="Product Image"
                />

                <!-- CONTENT -->
                <div class="admin-card-body">
                    <h3>${p.productName}</h3>

                    <p class="price"> Rs ${p.productPrice}</p>

                    <p class="desc">
                            ${fn:substring(p.productDescription, 0, 60)}...
                    </p>
                </div>

            </a>
        </c:forEach>

    </div>
</div>

