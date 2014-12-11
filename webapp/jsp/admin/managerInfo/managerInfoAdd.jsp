<%@ page contentType="text/html;charset=UTF-8"%><%@ include file="/jsp/common/taglibs.jsp"%><!DOCTYPE html>
<html lang="zh-CN">
<head>
<title>管理员详细信息 添加</title>
<%@ include file="/jsp/common/meta.jsp"%>
<script language="javascript">
function checkForm(){
	return true;
}
function cancleClick(){
	self.location='managerInfoAction.${actionExt}';    
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
<form name="managerInfoForm" id="managerInfoForm" method="post" action="managerInfoAction!addSave.${actionExt}" onsubmit="return checkForm();">
<table cellpadding="0" cellspacing="0" class="l-table-edit" style="margin-top:50px;margin-left:50px;">
    <tr>
    	<td align="right" class="l-table-edit-td">邮箱：</td>
    	<td align="left" class="l-table-edit-td"><input name="managerInfo.email" type="text" id="managerInfo.email" ltype="text" /></td>
    	<td align="left"></td>
    </tr>
    <tr>
    	<td align="right" class="l-table-edit-td">座机：</td>
    	<td align="left" class="l-table-edit-td"><input name="managerInfo.tel" type="text" id="managerInfo.tel" ltype="text" /></td>
    	<td align="left"></td>
    </tr>
    <tr>
    	<td align="right" class="l-table-edit-td">手机：</td>
    	<td align="left" class="l-table-edit-td"><input name="managerInfo.mobel" type="text" id="managerInfo.mobel" ltype="text" /></td>
    	<td align="left"></td>
    </tr>
    <tr>
    	<td align="right" class="l-table-edit-td">性别：0、保密；1、男；2、女：</td>
    	<td align="left" class="l-table-edit-td"><input name="managerInfo.sex" type="text" id="managerInfo.sex" ltype="text" /></td>
    	<td align="left"></td>
    </tr>
    <tr>
    	<td align="right" class="l-table-edit-td">联系地址：</td>
    	<td align="left" class="l-table-edit-td"><input name="managerInfo.address" type="text" id="managerInfo.address" ltype="text" /></td>
    	<td align="left"></td>
    </tr>
    <tr>
    	<td align="right" class="l-table-edit-td">QQ：</td>
    	<td align="left" class="l-table-edit-td"><input name="managerInfo.qq" type="text" id="managerInfo.qq" ltype="text" /></td>
    	<td align="left"></td>
    </tr>
    <tr>
    	<td align="right" class="l-table-edit-td">创建人：</td>
    	<td align="left" class="l-table-edit-td"><input name="managerInfo.creator" type="text" id="managerInfo.creator" ltype="text" /></td>
    	<td align="left"></td>
    </tr>
    <tr>
    	<td align="right" class="l-table-edit-td">创建时间：</td>
    	<td align="left" class="l-table-edit-td"><input name="managerInfo.createtime" type="text" id="managerInfo.createtime" ltype="text" /></td>
    	<td align="left"></td>
    </tr>
    <tr>
    	<td align="right" class="l-table-edit-td">修改人：</td>
    	<td align="left" class="l-table-edit-td"><input name="managerInfo.updator" type="text" id="managerInfo.updator" ltype="text" /></td>
    	<td align="left"></td>
    </tr>
    <tr>
    	<td align="right" class="l-table-edit-td">修改时间：</td>
    	<td align="left" class="l-table-edit-td"><input name="managerInfo.updatetime" type="text" id="managerInfo.updatetime" ltype="text" /></td>
    	<td align="left"></td>
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