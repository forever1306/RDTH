<%-- 
    Document   : changePassword
    Created on : Jul 10, 2015, 7:40:24 AM
    Author     : Minh-IT
--%>
<div class="login">
    <div class="title">
        <p>Customer Login</p>
    </div>
    <div class="bodyLogin">
        <form action="${pageContext.request.contextPath}/customer/changepassword/process.html" method="post">
            <p>Old-Password</p> 
            <input type="password" name="oldpass"/><br/>
            <p>New-Password</p>
            <input type="password" name="newpass"/>
            <p>ReNew-Password</p>
            <input type="password" name="repass"/>
            <br/>
            <br/>
            <input type="submit" value="Change"/>
        </form>
    </div>
</div>
