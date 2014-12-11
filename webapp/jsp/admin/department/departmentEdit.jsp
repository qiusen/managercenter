<%@ page contentType="text/html;charset=UTF-8"%><%@ include file="/jsp/common/taglibs.jsp"%><!DOCTYPE html>
<html lang="zh-CN">
<head>
<title>部门 修改</title>
<%@ include file="/jsp/common/meta.jsp"%>
<script language="javascript">
function checkForm(){
	return getChecked();
}
function cancleClick(){
	self.location='departmentAction.${actionExt}';    
}

var data = ${requestScope.data};

var treeManager = null;

//调用初始化页面方法
$(document).ready(function(){
	init();
});
//初始化方法
function init(){
    var tree = $("#tree1").ligerTree({  
    checkbox: true,
    single:true,
    data:data, 
     idFieldName :'id',
     slide : false,
     parentIDFieldName :'pid'
     });

     treeManager = $("#tree1").ligerGetTreeManager();
     
     treeManager.expandAll();
    
}

function getChecked() {
	var notes = treeManager.getChecked();
    var pid = "-1";
    
    for (var i = 0; i < notes.length; i++) {
        pid = notes[i].data.id;
        break;
    }
    //alert(pid);
    if(pid!="-1"){
    	document.getElementById("department.superId").value = pid;
    	return true;
    }else{
    	$.ligerDialog.error('请选择上级部门');
    	return false;
    }
    
    //alert('选择的节点数：' + text);
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
<form name="departmentForm" id="departmentForm" method="post" action="departmentAction!editSave.${actionExt}" onsubmit="return checkForm();">
<table cellpadding="0" cellspacing="0" class="l-table-edit" style="margin-top:50px;margin-left:50px;">
    <input type="hidden" id="department.id" name="department.id" value="${requestScope.department.id}"/>
    <input name="department.superId" type="hidden" id="department.superId" />
    <tr>
        <td align="right" class="l-table-edit-td">名称：</td>
        <td align="left" class="l-table-edit-td"><input name="department.name" type="text" id="department.name" ltype="text" value="${requestScope.department.name}"/></td>
        <td align="left"></td>
    </tr>
    <tr>
        <td align="right" class="l-table-edit-td">代号：</td>
        <td align="left" class="l-table-edit-td"><input name="department.code" type="text" id="department.code" ltype="text" value="${requestScope.department.code}"/></td>
        <td align="left"></td>
    </tr>
    <tr>
        <td align="right" class="l-table-edit-td">类型：</td>
        <td align="left" class="l-table-edit-td">
        <select name="department.type" id="department.type">
    	<option value="1" <c:if test="${requestScope.department.type==1}">selected="selected"</c:if>>公司</option>
    	<option value="2" <c:if test="${requestScope.department.type==2}">selected="selected"</c:if>>部门</option>
    	<option value="3" <c:if test="${requestScope.department.type==3}">selected="selected"</c:if>>项目组</option>
    	</select>
    	</td>
        <td align="left"></td>
    </tr>
    <tr>
        <td align="right" class="l-table-edit-td">上级部门：</td>
        <td align="left" class="l-table-edit-td">
        <div style="width:300px; height:300px; margin:10px; float:left; border:1px solid #ccc; overflow:auto;  ">
		<ul id="tree1"></ul>
		</div> 
		</td>
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