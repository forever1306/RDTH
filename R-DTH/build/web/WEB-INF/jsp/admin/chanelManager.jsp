<%-- 
    Document   : chanelManager
    Created on : Jun 15, 2015, 2:47:04 PM
    Author     : Minh-IT
--%>
<%@taglib prefix="table" uri="/WEB-INF/tlds/table_library" %>
<script>
    $(document).ready(function () {
        $('.bgDiv').hide();
        $('button[pri="true"]').on('click' , function () {
            $.ajax({
                url: '${pageContext.request.contextPath}/admin/chanelManager/edit/' + $(this).attr('itemid') + '.html',
                type: 'get',
                success: function (data) {
                    $('.bgDiv').hide().html(data).slideDown(500);
                }
            })
        })
        $('button.add').on('click' , function () {
            $.ajax({
                url: '${pageContext.request.contextPath}/admin/chanelManager/edit/0.html',
                type: 'get',
                success: function (data) {
                    $('.bgDiv').hide().html(data).slideDown(500);
                    $('input[type=submit][value=Update]').css('display','none');
                    $('input[type=submit][value=Delete]').css('display','none');
                }
            })
        })

    })
</script>
<div class="title">
    <p>Chanel Manager</p>
</div>
<table:TableTagHandler  column="${column}" data="${data}" edit="true"/>
<div class="bgDiv">
</div>
<div class="btAdd">
    <button class="mdl-button mdl-js-button mdl-button--fab mdl-js-ripple-effect mdl-button--colored add">
        <i class="material-icons">add</i>
    </button>
</div>