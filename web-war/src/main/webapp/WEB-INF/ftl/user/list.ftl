<table>
	<#list list as em>
		<tr>
			<td>${em.name}</td>
			<td>${em.account}</td>
			<td>${em.telephone}</td>
			<td>${em.email}</td>
			<td><a href="${rc.contextPath}/user/form?id=${em.id}">修改</a></td>
		</tr>
	</#list>
</table>
<a href="${rc.contextPath}/user/form">新增</a>
