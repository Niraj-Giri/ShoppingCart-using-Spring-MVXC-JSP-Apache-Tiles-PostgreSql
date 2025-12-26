
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!-- ========== PRODUCT DETAILS ========== -->
<div class="admin-product-container">

    <!-- IMAGE SECTION -->
    <div class="product-image-box">
        <img src="/admin/product-image?id=${product.productId}"
             alt="Product Image"/>
    </div>

    <!-- FORM SECTION -->
    <div class="product-form-box">

        <h2>Edit Product</h2>
        <p class="subtitle">Update product information carefully</p>

        <form action="/admin/update-product"
              method="post"
              enctype="multipart/form-data">

            <input type="hidden"
                   name="productId"
                   value="${product.productId}" />

            <div class="form-group">
                <label>Product Name</label>
                <input type="text"
                       name="productName"
                       value="${product.productName}"
                       required />
            </div>

            <div class="form-group">
                <label>Price</label>
                <input type="number"
                       step="0.01"
                       name="productPrice"
                       value="${product.productPrice}"
                       required />
            </div>

            <div class="form-group">
                <label>Description</label>
                <textarea name="productDescription"
                          rows="4">${product.productDescription}</textarea>
            </div>

            <div class="form-group">
                <label>Change Image (optional)</label>
                <input type="file"
                       name="image"
                       accept="image/*" />
            </div>

            <div class="actions">
                <button type="submit"
                        class="btn update"
                        onclick="return confirmUpdate();">
                    Update Product
                </button>

                <a href="/admin/delete-product?id=${product.productId}"
                   class="btn delete"
                   onclick="return confirm('Are you sure you want to delete this product?')">
                    Delete Product
                </a>
            </div>

        </form>

    </div>
</div>


