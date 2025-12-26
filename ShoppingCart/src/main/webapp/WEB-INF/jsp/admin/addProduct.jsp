
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- ========== ADD PRODUCT FORM ========== -->
<div class="admin-add-container">

    <div class="admin-form-card">
        <h2>Add New Product</h2>
        <p class="subtitle">Fill in product details carefully</p>

        <form action="/admin/save-product"
              method="post"
              enctype="multipart/form-data">

            <div class="form-group">
                <label>Product Name</label>
                <input type="text"
                       name="productName"
                       placeholder="Enter product name"
                       required/>
            </div>

            <div class="form-group">
                <label>Description</label>
                <textarea name="productDescription"
                          rows="4"
                          placeholder="Enter product description"></textarea>
            </div>

            <div class="form-group">
                <label>Price</label>
                <input type="number"
                       step="0.01"
                       name="productPrice"
                       placeholder="Enter product price"
                       required/>
            </div>

            <div class="form-group">
                <label>Product Image</label>
                <input type="file"
                       name="image"
                       accept="image/*"
                       required/>
            </div>

            <div class="actions">
                <button type="submit" class="btn-primary">
                    Save Product
                </button>
            </div>

        </form>
    </div>

</div>
