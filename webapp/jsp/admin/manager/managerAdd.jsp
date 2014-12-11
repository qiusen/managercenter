<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/jsp/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>管理员 添加</title>
<%@ include file="/jsp/common/meta.jsp"%>
<script charset="utf-8" src="${base}/js/jquery.upload.js" type="text/javascript" ></script>
<script language="javascript">
function checkForm(){
	

	var password = document.getElementById("manager.password").value;
	if(password==null || password==''){
		alert("请输入密码！");
		return false;
	}

	var email = document.getElementById("manager.email").value;
	if(email==null || email==''){
		alert("请输入邮箱！");
		return false;
	}

	var nickname = document.getElementById("manager.nickname").value;
	if(nickname==null || nickname==''){
		alert("请输入昵称！");
		return false;
	}
	var ename = document.getElementById("manager.ename").value;
	if(ename==null || ename==''){
		alert("请输入英文名！");
		return false;
	}
	return true;
}

//图片上传
function doUpload(element) {
	// 上传方法
	$.upload({
			// 上传地址
			url: '${base}/fileUploadServlet', 
			// 文件域名字
			fileName: 'imageFile',
			// 其他表单数据
			params: {
				name: 'pxblog'
			},
			// 上传完成后, 返回json, text
			dataType: 'json',
			// 上传之前回调,return true表示可继续上传
			onSend: function() {
				return true;
			},
			// 上传之后回调
			onComplate: function(data) {
				if(data.message != ''){
					$.ligerDialog.warn(data.message);
					return;
				}
				if(element)
					element.src = data.filePath;
				$('.logo_img_view').attr('src',data.filePath)
				//$("#titleImg").val(data.filePath);
				document.getElementById("manager.logo").value=data.filePath;
				//alert(document.getElementById("article.articleImg").value);
			}
	});
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
<form name="managerForm" id="managerForm" method="post" action="managerAction!addSave.${actionExt}" onsubmit="return checkForm();">
<input type="hidden" name="manager.logo" id="manager.logo"/>
<table cellpadding="0" cellspacing="0" class="l-table-edit" style="margin-top:50px;margin-left:50px;">
	<tr>
    	<td align="right" class="l-table-edit-td">LOGO：</td>
    	<td align="left" class="l-table-edit-td">
    	<img class="logo_img_view" src="${base }/image/noimg.jpg" onclick="doUpload()" style="max-height:150px;height: expression(this.height > 150 ? 150: true);margin:9px;border:0px;cursor：hand;"/>150x150
	    </td>
    	<td align="left"></td>
    </tr>
    <tr>
        <td align="right" class="l-table-edit-td">邮箱：</td>
        <td align="left" class="l-table-edit-td"><input name="manager.email" type="text" id="manager.email" ltype="text" /></td>
        <td align="left"><font color="red">*</font></td>
    </tr>
    <tr>
        <td align="right" class="l-table-edit-td">密码：</td>
        <td align="left" class="l-table-edit-td"><input name="manager.password" type="password" id="manager.password" ltype="text" /></td>
        <td align="left"><font color="red">*</font></td>
    </tr>
    <tr>
        <td align="right" class="l-table-edit-td">姓名：</td>
        <td align="left" class="l-table-edit-td"><input name="manager.nickname" type="text" id="manager.nickname" ltype="text" /></td>
        <td align="left"><font color="red">*</font></td>
    </tr>
    <tr>
        <td align="right" class="l-table-edit-td">英文名：</td>
        <td align="left" class="l-table-edit-td"><input name="manager.ename" type="text" id="manager.ename" ltype="text" maxlength="15"/></td>
        <td align="left"><font color="red">*</font></td>
    </tr>
    <tr>
        <td align="right" class="l-table-edit-td">状态：</td>
        <td align="left" class="l-table-edit-td">
        <select name="manager.status" id="manager.status" >
        <option value="1">有效</option>
        <option value="0">无效</option>
        </select>
        </td>
        <td align="left"></td>
    </tr>
    <tr>
        <td align="right" class="l-table-edit-td">角色：</td>
        <td align="left" class="l-table-edit-td">
        <select name="manager.roleId" id="manager.roleId" >
        <c:forEach items="${roleList }" var="role">
        <option value="${role.id }">${role.rolename }</option>
        </c:forEach>
        </select>
        </td>
        <td align="left"></td>
    </tr>
    <tr>
    	<td align="center" colspan="3">
    	<input type="submit" value="保存" id="Button1" class="l-button l-button-submit" /> 
		<input type="button" value="取消" class="l-button l-button-reset" onclick="javascript: history.back(-1);"/>
    	</td>
    </tr>
</table>
</form>
</body>
</html>