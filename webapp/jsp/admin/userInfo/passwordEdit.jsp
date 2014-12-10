<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/jsp/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>密码 修改</title>
<%@ include file="/jsp/common/meta.jsp"%>
<script language="javascript">
function checkForm(){
	var newpwd = document.getElementById("newPassword").value;
	var cfmpwd = document.getElementById("confirmPassword").value;
	//alert(newpwd + "  " + cfmpwd);
	if(newpwd!=cfmpwd){
		alert('两次密码输入不一致，请重新输入！');
		return false;
	}else{
		return true;
	}
}
<c:if test="${requestScope.edit==1}">
alert('修改成功，重新登录后生效！');
</c:if>
<c:if test="${requestScope.edit==2}">
alert('修改失败');
</c:if>
<c:if test="${requestScope.edit==3}">
alert('修改失败，原密码输入错误');
</c:if>
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
<form name="userForm" id="userForm" method="post" action="userInfo!editSavePassword.${actionExt}" onsubmit="return checkForm();">
<input type="hidden" id="manager.id" name="manager.id" value="${sessionScope.manager.id}"/>
<table cellpadding="0" cellspacing="0" class="l-table-edit" style="margin-top:50px;margin-left:50px;">
    <tr>
        <td align="right" class="l-table-edit-td">原密码：</td>
        <td align="left" class="l-table-edit-td"><input name="manager.password" type="password" id="manager.password" ltype="text" /></td>
        <td align="left"></td>
    </tr>
    <tr>
        <td align="right" class="l-table-edit-td">新密码：</td>
        <td align="left" class="l-table-edit-td"><input name="newPassword" type="password" id="newPassword" ltype="text"/></td>
        <td align="left"></td>
    </tr>
    <tr>
        <td align="right" class="l-table-edit-td">再次输入新密码：</td>
        <td align="left" class="l-table-edit-td"><input name="confirmPassword" type="password" id="confirmPassword" ltype="text" /></td>
        <td align="left"></td>
    </tr>
    <tr>
    	<td align="right" colspan="3">
    	<input type="submit" value="保存" id="Button1" class="l-button l-button-submit" /> 
    	</td>
    </tr>
</table>
</form>
</body>
</html>