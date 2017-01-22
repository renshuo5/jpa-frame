

 <#if entity.id??>
    <form  method="post" action="${rc.contextPath}/user/${entity.id}">
        <input type="hidden" name="id" value="${entity.id}" class="ignore"/>
        <input type="hidden"name="_method" value="put" class="ignore"/>
<#else>
    <form action="${rc.contextPath}/user" method="post">
</#if>  
		姓名:<input type="text" value="${entity.name}" name="name"><br>
		账号:<input type="text" value="${entity.account}" name="account"><br>
		密码:<input type="text" value="${entity.password}" name="password"><br>
		手机号:<input type="text" value="${entity.telephone}" name="telephone"><br>
		邮箱:<input type="text" value="${entity.email}" name="email"><br>
		<input type="text" value="${entity.salt}" name="salt"><br>
		<input type="submit" value="确认">
</form>
