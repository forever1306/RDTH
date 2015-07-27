<%-- 
    Document   : distributorManager
    Created on : Jun 18, 2015, 11:27:17 AM
    Author     : Minh-IT
--%>

<%@taglib prefix="table" uri="/WEB-INF/tlds/table_library" %>
<script>
    $(document).ready(function(){
        $('.bgDiv').hide();
        $('button[pri="true"]').on("click",function (){
             $.ajax({
                url:'${pageContext.request.contextPath}/admin/distributorManager/edit/'+$(this).attr('itemid')+'.html',
                type:'get',
                success:function(data){
                    $('.bgDiv').hide().html(data).slideDown(1000);
                }
            })
        })
        $('button.add').on('click' , function () {
            $.ajax({
                url: '${pageContext.request.contextPath}/admin/distributorManager/edit/0.html',
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
    <p>Distributor Manager</p>
</div>
<table:TableTagHandler column="${column}" data="${data}" edit="true"/>
<div class="bgDiv"></div>
<div class="btAdd">
    <button class="mdl-button mdl-js-button mdl-button--fab mdl-js-ripple-effect mdl-button--colored add">
        <i class="material-icons">add</i>
    </button>
</div>

