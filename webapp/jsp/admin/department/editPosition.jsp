<%@ page contentType="text/html;charset=UTF-8"%><%@ include file="/jsp/common/taglibs.jsp"%><!DOCTYPE html>
<html lang="zh-CN">
<head>
<title>部门对应职位 修改</title>
<%@ include file="/jsp/common/meta.jsp"%>
<script language="javascript">
function checkForm(){
	return getChecked();
}
function cancleClick(){
	self.location='departmentAction.${actionExt}';    
}


</script>
<style type="text/css">
    body{ font-size:12px;}
    .l-table-edit {}
    .l-table-edit-td{ padding:4px;}
    .l-button-submit,.l-button-reset{width:80px; float:left; margin-left:10px; padding-bottom:2px;}
    .l-verify-tip{ left:230px; top:120px;}
</style>
</head>
<body>
<form name="departmentForm" id="departmentForm" method="post" action="departmentAction!editSavePosition.${actionExt}" onsubmit="return checkForm();">
<table cellpadding="0" cellspacing="0" class="l-table-edit" style="margin-top:50px;margin-left:50px;">
    <input type="hidden" id="depId" name="depId" value="${requestScope.department.id}"/>
    <tr>
        <td align="right" class="l-table-edit-td">名称：</td>
        <td align="left" class="l-table-edit-td">${requestScope.department.name}</td>
        <td align="left"></td>
    </tr>
    <tr>
        <td align="right" class="l-table-edit-td">代号：</td>
        <td align="left" class="l-table-edit-td">${requestScope.department.code}</td>
        <td align="left"></td>
    </tr>
     <tr>
    	<td align="center" colspan="3">
    	<br /><br />
    	</td>
    </tr>
    <tr>
    	<td align="right" class="l-table-edit-td"></td>
    	<td align="left" colspan="2">
    	<c:forEach items="${positionList}" var="position" varStatus="i">
    	<c:if test="${i.index!=0 && i.index%5==0 }"><br/><br/></c:if>
    	<input type="checkbox" id="posId" name="posId" value="${position.id}" <c:if test="${position.isChecked==1 }">checked="checked"</c:if>/>${position.name} &nbsp;&nbsp;
    	</c:forEach>
    	</td>
    </tr>
    <tr>
    	<td align="center" colspan="3">
    	<br /><br />
    	</td>
    </tr>
    <tr>
    	<td align="center" colspan="3">
    	<input type="submit" value="保存" id="Button1" class="l-button l-button-submit" /> 
	<input type="button" value="取消" class="l-button l-button-reset" onclick="javascript:cancleClick();"/>
    	</td>
    </tr>
</table>
</form>
</body>
</html>