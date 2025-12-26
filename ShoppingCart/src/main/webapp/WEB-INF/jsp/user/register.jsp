<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 12/24/2025
  Time: 2:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page contentType="text/html;charset=UTF-8" %>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <title>User Registration</title>--%>
<%--</head>--%>
<%--<body>--%>

<div class="auth-container">
    <div class="auth-card">

        <h2 class="auth-title">Create Your Account</h2>
        <p class="auth-subtitle">Join us and start shopping smarter</p>

        <form action="/register" method="post" class="auth-form">

            <div class="form-group">
                <label>Username</label>
                <input type="text" name="username" placeholder="Enter your username" required>
            </div>

            <div class="form-group">
                <label>Email</label>
                <input type="email" name="email" placeholder="Enter your email" required>
            </div>

            <div class="form-group">
                <label>Password</label>
                <input type="password" name="password" placeholder="Create a password" required>
            </div>

            <div class="form-group">
                <label>Phone</label>
                <input type="text" name="phone" placeholder="Enter phone number">
            </div>

            <div class="form-group">
                <label>Address</label>
                <textarea name="address" placeholder="Enter your address"></textarea>
            </div>

            <button type="submit" class="btn-primary">Register</button>
        </form>

        <!-- Messages -->
        <c:if test="${not empty error}">
            <p class="msg error">${error}</p>
        </c:if>

        <c:if test="${not empty success}">
            <p class="msg success">${success}</p>
        </c:if>

        <p class="auth-footer">
            Already have an account?
            <a href="/login">Login</a>
        </p>

    </div>
</div>


<%--</body>--%>
<%--</html>--%>
