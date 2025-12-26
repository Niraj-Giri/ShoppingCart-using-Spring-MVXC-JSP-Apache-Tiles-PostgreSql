\
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- ========== PRODUCT DETAILS (USER) ========== -->
<div class="admin-product-container">

    <!-- IMAGE SECTION -->
    <div class="product-image-box">
        <img src="/product/image?id=${product.productId}"
             alt="Product Image" />
    </div>

    <!-- DETAILS SECTION -->
    <div class="product-form-box">

        <h2>${product.productName}</h2>
        <p class="subtitle">Product details</p>

        <p class="price" style="font-size:20px;">
            ₹ ${product.productPrice}
        </p>

        <p class="desc" style="margin-top:12px;">
            ${product.productDescription}
        </p>

        <!-- ADD TO CART FORM -->
        <form action="/cart/add"
              method="post"
              style="margin-top:25px;">

            <input type="hidden"
                   name="productId"
                   value="${product.productId}" />

            <!-- Quantity (optional but recommended) -->
            <div class="form-group" style="max-width:120px;">
                <label>Quantity</label>
                <input type="number"
                       name="quantity"
                       value="1"
                       min="1" />
            </div>

            <div class="actions">
                <button type="submit" class="btn update">
                    Add to Cart
                </button>
            </div>

        </form>

    </div>

</div>
