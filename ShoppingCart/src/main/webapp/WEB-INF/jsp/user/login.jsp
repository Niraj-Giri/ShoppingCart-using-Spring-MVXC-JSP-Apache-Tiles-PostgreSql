
<div class="auth-container">
    <div class="auth-card">

        <h2 class="auth-title">Welcome Back</h2>
        <p class="auth-subtitle">Login to continue shopping</p>

        <form action="/login" method="post" class="auth-form">

            <div class="form-group">
                <label>Email</label>
                <input type="email" name="email" placeholder="Enter your email" required>
            </div>

            <div class="form-group">
                <label>Password</label>
                <input type="password" name="password" placeholder="Enter your password" required>
            </div>

            <button type="submit" class="btn-primary">Login</button>
        </form>

        <!-- Error message -->
        <c:if test="${not empty error}">
            <p class="msg error">${error}</p>
        </c:if>

        <p class="auth-footer">
            Dont an account ?
            <a href="/register">Register</a>
        </p>

    </div>
</div>


