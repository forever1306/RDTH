<%-- 
    Document   : FAQManager
    Created on : Jun 19, 2015, 2:24:28 PM
    Author     : Minh-IT
--%>
<%@taglib prefix="table" uri="/WEB-INF/tlds/table_library" %>
<script>
    $(document).ready(function(){
        $('.bgDiv').hide();
        $('button[pri="true"]').on("click",function (){
             $.ajax({
                url:'${pageContext.request.contextPath}/admin/feedbackManager/edit/'+$(this).attr('itemid')+'.html',
                type:'get',
                success:function(data){
                    $('.bgDiv').hide().html(data).slideDown(1000);
                }
            })
        })
    })
</script>
<div class="title">
    <p>Feedback Manager</p>
</div>
<table:TableTagHandler column="${column}" data="${data}" edit="true"/>
<div class="bgDiv"></div>
