<%@ page contentType="text/html;charset=UTF-8"%><%@ include file="/jsp/common/taglibs.jsp"%><!DOCTYPE html>
<html lang="zh-CN">
<head>
<title>管理员详细信息 修改</title>
<%@ include file="/jsp/common/meta.jsp"%>
<script language="javascript">
function checkForm(){
	return true;
}
function cancleClick(){
	self.location='managerInfoAction.${actionExt}';    
}
<c:if test="${requestScope.edit==1}">
$(function() {
$.ligerDialog.success('修改成功');
});
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
<form name="managerInfoForm" id="managerInfoForm" method="post" action="managerInfoAction!editSave.${actionExt}" onsubmit="return checkForm();">
<table cellpadding="0" cellspacing="0" class="l-table-edit" style="margin-top:50px;margin-left:50px;">
    <tr>
        <td align="right" class="l-table-edit-td">邮箱：</td>
        <td align="left" class="l-table-edit-td">${sessionScope.manager.email}</td>
        <td align="left"></td>
    </tr>
    <tr>
        <td align="right" class="l-table-edit-td">座机：</td>
        <td align="left" class="l-table-edit-td"><input name="managerInfo.tel" type="text" id="managerInfo.tel" ltype="text" value="${requestScope.managerInfo.tel}"/></td>
        <td align="left"></td>
    </tr>
    <tr>
        <td align="right" class="l-table-edit-td">手机：</td>
        <td align="left" class="l-table-edit-td"><input name="managerInfo.mobile" type="text" id="managerInfo.mobile" ltype="text" value="${requestScope.managerInfo.mobile}"/></td>
        <td align="left"></td>
    </tr>
    <tr>
        <td align="right" class="l-table-edit-td">性别：</td>
        <td align="left" class="l-table-edit-td">
        <input type="radio" name="managerInfo.sex" id="managerInfo.sex" <c:if test="${requestScope.managerInfo.sex==1}">checked="checked"</c:if> value="1">男&nbsp;&nbsp;
        <input type="radio" name="managerInfo.sex" id="managerInfo.sex" <c:if test="${requestScope.managerInfo.sex==2}">checked="checked"</c:if> value="2">女
        </td>
        <td align="left"></td>
    </tr>
    <tr>
        <td align="right" class="l-table-edit-td">联系地址：</td>
        <td align="left" class="l-table-edit-td"><input name="managerInfo.address" type="text" id="managerInfo.address" ltype="text" value="${requestScope.managerInfo.address}" style="width:300px;"/></td>
        <td align="left"></td>
    </tr>
    <tr>
        <td align="right" class="l-table-edit-td">QQ：</td>
        <td align="left" class="l-table-edit-td"><input name="managerInfo.qq" type="text" id="managerInfo.qq" ltype="text" value="${requestScope.managerInfo.qq}"/></td>
        <td align="left"></td>
    </tr>
    <tr>
    	<td align="center" colspan="3">
    	<input type="submit" value="保存" id="Button1" class="l-button l-button-submit" /> 
    	</td>
    </tr>
</table>
</form>
</body>
</html>