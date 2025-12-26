<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">

    <!-- ===== Page Title ===== -->
    <title>
        <tiles:getAsString name="title" ignore="true"/>
    </title>

    <!-- ===== Global CSS (Navbar, Footer, Common styles) ===== -->
    <link rel="stylesheet" href="/css/style.css">

    <!-- ===== Page Specific CSS ===== -->
    <tiles:insertAttribute name="css" ignore="true"/>

</head>

<body>

<!-- ===== HEADER / NAVBAR ===== -->
<!-- Injects userNavbar.jsp OR adminNavbar.jsp OR guestNavbar.jsp -->
<tiles:insertAttribute name="header" ignore="true"/>

<!-- ===== MAIN CONTENT ===== -->
<main class="main-content">
    <tiles:insertAttribute name="body"/>
</main>

<!-- ===== FOOTER (COMMON FOR ALL PAGES) ===== -->
<tiles:insertAttribute name="footer" ignore="true"/>

<!-- ===== GLOBAL JS (USED EVERYWHERE) ===== -->
<script src="/js/main.js"></script>

<!-- ===== PAGE SPECIFIC JS (ADMIN ETC.) ===== -->
<tiles:insertAttribute name="js" ignore="true"/>

</body>
</html>
