<%-- 
    Document   : editChanel
    Created on : Jun 15, 2015, 3:14:52 PM
    Author     : Minh-IT
--%>

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

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
                    $('input#chanelImage').val(name.substr(images.length + 1));
                }
            })
        })
        componentHandler.upgradeAllRegistered();
    })
</script>
<form:form commandName="chanel" action="${pageContext.request.contextPath}/admin/chanelManager/process.html" method="post" enctype="multipart/form-data">
    <form:hidden path="chanelId"/>
    <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
        <form:input path="chanelName" cssClass="mdl-textfield__input" id="sp"  required="true"/>
        <label class="mdl-textfield__label" for="sp">Chanel Name</label>
    </div>
    <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
        <form:input path="chanelPrice"  cssClass="mdl-textfield__input" id="sp" type="number" required="true"/>
        <label class="mdl-textfield__label" for="sp">Chanel Price</label>
    </div>
    <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
        <form:input path="type"  cssClass="mdl-textfield__input" id="sp" type="number" required="true"/>
        <label class="mdl-textfield__label" for="sp">Chanel Type</label>
    </div>
    <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
        <form:input path="chanelImage" readonly="true" cssClass="mdl-textfield__input" readonly="true"/>
        <label class="mdl-textfield__label">Chanel Image</label>
    </div>

    <input type="file" name="upfile" id="upfile"/>
    <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
        <form:textarea path="chanelContent"  cssClass="mdl-textfield__input" id="sp" required="true"/>
        <label class="mdl-textfield__label" for="sp">Chanel Content</label>
    </div>
    <br/>
    <div class="imgChanel"></div>
    <hr/>
    <p>
        <input type="submit" value="Update" name="action" class="mdl-button mdl-js-button mdl-button--raised mdl-button--accent mdl-js-ripple-effect"/>
        <input type="submit" value="Add" name="action"  class="mdl-button mdl-js-button mdl-button--raised mdl-button--accent mdl-js-ripple-effect"/>
        <input type="submit" value="Delete" name="action" class="mdl-button mdl-js-button mdl-button--raised mdl-button--accent mdl-js-ripple-effect" onclick="return confirm('Are you sure?');"/>
    </p>
</form:form>