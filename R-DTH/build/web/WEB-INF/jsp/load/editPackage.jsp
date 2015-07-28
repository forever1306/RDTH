<%-- 
    Document   : editPackage
    Created on : Jun 15, 2015, 11:51:28 PM
    Author     : Minh-IT
--%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>

    $(document).ready(function () {
        $('#upfile').on('change', function () {
            var dataImg = new FormData();
            dataImg.append("file", upfile.files[0]);
            $.ajax({
                url: '${pageContext.request.contextPath}/upload.html',
                data: dataImg,
                type: 'post',
                dataType: 'text',
                processData: false,
                contentType: false,
                success: function (data) {
                    $('.imgChanel').html(data).hide().show('clip', 1000);
                    var name = $(data).attr('src');
                    var images = 'images';
                    $('input#packageImage').val(name.substr(images.length + 1));
                }
            })
        })
        componentHandler.upgradeAllRegistered();
    })
</script>
<style>
    .inline{
        display: inline-block;
        margin-left: 10%;
    }
</style>
<form:form action="${pageContext.request.contextPath}/admin/packageManager/process.html" method="post" commandName="packages">
    <form:hidden path="packageId" />
    <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
        <form:input path="packageName" cssClass="mdl-textfield__input" required="true"/>
        <label class="mdl-textfield__label">Package Name</label>
    </div>
    <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
        <form:input path="packageMonth" cssClass="mdl-textfield__input" required="true"/>
        <label class="mdl-textfield__label">Month</label>
    </div>
    <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
        <form:input path="packageImage" cssClass="mdl-textfield__input" readonly="true"/>
        <label class="mdl-textfield__label">Package Image</label>
        <input type="file" name="upfile" id="upfile"/>
    </div>
    <form:hidden path="packagePrice"/>
    <form:hidden path="type"/>
    <p>Package Status</p>
    <label class="mdl-radio mdl-js-radio mdl-js-ripple-effect" for="sttActive">
        <form:radiobutton path="status" id="sttActive" cssClass="mdl-radio__button" value="1" />
        <span class="mdl-radio__label">Active</span>
    </label>
    <label class="mdl-radio mdl-js-radio mdl-js-ripple-effect" for="sttNonActive">
        <form:radiobutton path="status" id="sttNonActive" cssClass="mdl-radio__button" value="0" />
        <span class="mdl-radio__label">Non-Active</span>
    </label>
    <br/>
    <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
        <form:textarea path="packageContent" cssClass="mdl-textfield__input"  required="true"/>
        <label class="mdl-textfield__label">Package Content</label>
    </div>
    <p>Chanel</p>
    <div class="scroll">
        <c:set var="ck" value="true"/>
        <c:forEach items="${listChanel}" var="chanel">
            <c:set var="ck" value="true"/>
            <c:forEach items="${packages.chanels}" var="chanelInPack" varStatus="stt">
                <c:if test="${chanel.chanelId==chanelInPack.chanelId && ck}">
                    <div class="inline">
                        <label class="mdl-switch mdl-js-switch mdl-js-ripple-effect" for="cid${chanel.chanelId}">
                            <input type="checkbox" id="cid${chanel.chanelId}" class="mdl-switch__input" value="${chanel.chanelId}" checked name="arrChanel"/>
                            <span class="mdl-switch__label">${chanel.chanelName}</span>
                        </label>
                    </div>
                    <c:set var="ck" value="false"/>
                </c:if>
            </c:forEach>
            <c:if test="${ck}">
                <div class="inline">
                    <label class="mdl-switch mdl-js-switch mdl-js-ripple-effect" for="cid${chanel.chanelId}">
                        <input type="checkbox" id="cid${chanel.chanelId}" class="mdl-switch__input" value="${chanel.chanelId}" name="arrChanel"/>
                        <span class="mdl-switch__label">${chanel.chanelName}</span>
                    </label>
                </div>
            </c:if>
        </c:forEach>
    </div>
    <hr/>
    <p>
        <input type="submit" value="Update" name="action" class="mdl-button mdl-js-button mdl-button--raised mdl-button--colored"/>
        <input type="submit" value="Add" name="action" class="mdl-button mdl-js-button mdl-button--raised mdl-button--colored"/>
        <input type="submit" value="Delete" name="action"  class="mdl-button mdl-js-button mdl-button--raised mdl-button--colored"  onclick="return confirm('Are you sure?');"/>
    </p>
</form:form>