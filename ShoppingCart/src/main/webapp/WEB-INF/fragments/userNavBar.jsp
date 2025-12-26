<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 12/25/2025
  Time: 3:06 PM
  To change this template use File | Settings | File Templates.
--%>
<nav class="navbar">
    <div class="nav-container">

        <div class="logo">
            <span>My</span>Shop
        </div>

        <div class="nav-links">
            <a href="/home">Home</a>

            <a href="/cart" class="cart-link">
                Cart
                <span class="cart-badge">${cartCount}</span>
            </a>

            <a href="/orders">Orders</a>

            <a href="/logout" class="logout-btn">Logout</a>
        </div>

    </div>
</nav>

