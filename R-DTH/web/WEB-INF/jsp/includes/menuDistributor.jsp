<%-- 
    Document   : menuAdmin
    Created on : Jun 14, 2015, 12:23:18 AM
    Author     : Minh-IT
--%>
<span class="mdl-layout-title">Welcome ${pageContext.request.userPrincipal.name}</span>
<nav class="mdl-navigation">
    <a class="mdl-navigation__link" href="${pageContext.request.contextPath}/distributor/productManager.html">Product Manager</a>
    <a class="mdl-navigation__link" href="${pageContext.request.contextPath}/distributor/orderProduct.html">Order Product</a>
    <a class="mdl-navigation__link" href="${pageContext.request.contextPath}/distributor/logout">Logout</a>
</nav>

