<%-- 
    Document   : customerManager
    Created on : Jun 14, 2015, 2:27:48 PM
    Author     : Minh-IT
--%>
<%@taglib prefix="table" uri="/WEB-INF/tlds/table_library" %>
<script>
    $(document).ready(function(){
        $('.bgDiv').hide();
        $('button[pri="true"]').on("click",function (){
            $.ajax({
                url:'${pageContext.request.contextPath}/admin/customerManager/edit/'+$(this).attr('itemid')+'.html',
                type:'get',
                success:function(data){
                    $('.bgDiv').hide().html(data).slideDown(1000);
                }
            })
        })
    })
</script>
<div class="title">
    <p>Customer Manager</p>
</div>
<table:TableTagHandler data="${data}" column="${column}" edit="true"/>
<div class="bgDiv">
    
</div>
