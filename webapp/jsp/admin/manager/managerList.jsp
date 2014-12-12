<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/jsp/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>管理员 列表</title>
<%@ include file="/jsp/common/meta.jsp"%>
<script language="javascript">
var resultListData = {${requestScope.json}} ;

var manager, g;


var pageSize = ${requestScope.pageInfo.pageSize};
var totalPage=${requestScope.pageInfo.totalPage};
var itemCount = resultListData.Total;
var pageNo =${requestScope.pageInfo.page};


$(f_initGrid);
function f_initGrid(){
    g = manager = $("#maingrid").ligerGrid({
    	title:'管理员列表',
        columns: [
        //{ display: '主键', name: 'id', width: 50, type: 'int', frozen: true },
        
        { display: '邮箱', name: 'email', type: 'text', width: '15%' },
        { display: '姓名', name: 'nickname', type: 'text', width: '10%' },
        { display: '英文名', name: 'ename',type: 'text' , width: '15%'},
        { display: '状态', name: 'status', width: '10%',render: function (rowdata, rowindex, value)
        {
        	var h = "-";
            if(rowdata.status==1){
                h = "有效";
            }else{
                h = "无效";
            }
            return h;
        } },
        { display: '部门', name: 'departmentId', width: '20%' ,render: function (rowdata, rowindex, value)
        {
        	var r = "-";
        	<c:forEach items="${departmentList }" var="department">
        	if(rowdata.departmentId==${department.id}){
                r = "${department.name}|${department.code}";
            }
            </c:forEach>
            return r;
        }  },
        { display: '职位', name: 'positionId', width: '20%' ,render: function (rowdata, rowindex, value)
        {
        	var r = "-";
        	<c:forEach items="${positionList }" var="position">
        	if(rowdata.positionId==${position.id}){
                r = "${position.name}|${position.code}";
            }
            </c:forEach>
            return r;
        }  },
        { display: '角色', name: 'roleId', width: '10%' ,render: function (rowdata, rowindex, value)
        {
        	var r = "-";
        	<c:forEach items="${roleList }" var="role">
        	if(rowdata.roleId==${role.id}){
                r = "${role.rolename}";
            }
            </c:forEach>
            return r;
        }  },
        { display: '创建时间', name: 'createtime', type: 'text', width: '20%' },
        { display: '最后登录时间', name: 'logintime', type: 'text', width: '15%' },
        { display: '最后登录IP地址', name: 'loginip', type: 'text', width: '15%' }
        ],
        onSelectRow: function (rowdata, rowindex)
        {
            $("#txtrowindex").val(rowindex);
        },
        enabledEdit: true,clickToEdit:false, isScroll: true,
        rownumbers:true,
        data: resultListData,
        record: resultListData.Total,
        //usePager :false,
        width: '90%',height: '90%',
        pageSize:pageSize,
        pageSizeOptions:[5,10,15,20],
        onReload: function() {
        	search();
        },
        onToFirst: function() {
			if(pageNo != 1) {
				document.getElementById("pageNo").value = 1;
				search();
			}
			return false;
        },
        onToPrev: function() {
        	if(pageNo > 1) {
        		document.getElementById("pageNo").value = pageNo - 1;
        		search();
        	}
			return false;
        },
        onToNext: function() {
        	if(pageNo < totalPage) {
        		document.getElementById("pageNo").value = pageNo +1;
        		search();
        	}
			return false;
        },
        onToLast: function() {
        	if(pageNo != totalPage) {
				document.getElementById("pageNo").value = totalPage;
        		search();
        	}
			return false;
        } ,
        //isScroll: false, 
        
        toolbar: { items: [{ text: '增加', value:'add', click: itemclick, icon: 'add', img: '${base}/ligerUI/skins/icons/add.gif' },
                           { text: '修改', value:'edit', click: itemclick, icon: 'edit', img: '${base}/ligerUI/skins/icons/edit.gif' },
                           { text: '删除', value:'delete', click: itemclick, icon: 'delete', img: '${base}/ligerUI/skins/icons/delete.gif' } ] }

        
                                 
    });

    $(".pcontrol input").val(pageNo);
   	$(".pcontrol input").css("width", ((totalPage + "").length * 7) + "px");
   	$(".pcontrol input").attr("maxlength", (totalPage + "").length);
   	$(".pcontrol input").attr("readonly", "readonly");
       $(".pcontrol span").html(totalPage);
       var start = 0;
       var end = 0;
       if(pageNo>0){
    	   start = (pageSize * (pageNo - 1) + 1);
    	   end = start + resultListData.Rows.length - 1;
       }
       $(".l-bar-text").html("显示记录从" + start + "到" + end + "，总数 " + itemCount + " 条");
       if (!itemCount)
       {
           $(".l-bar-btnfirst span,.l-bar-btnprev span,.l-bar-btnnext span,.l-bar-btnlast span").addClass("l-disabled");
       }
       if (pageNo == 1)
       {
           $(".l-bar-btnfirst span").addClass("l-disabled");
           $(".l-bar-btnprev span").addClass("l-disabled");
       }
       else if (pageNo > 1 && totalPage > 0)
       {
           $(".l-bar-btnfirst span").removeClass("l-disabled");
           $(".l-bar-btnprev span").removeClass("l-disabled");
       }
       if (pageNo == totalPage)
       {
           $(".l-bar-btnlast span").addClass("l-disabled");
           $(".l-bar-btnnext span").addClass("l-disabled");
       }
       else if (pageNo < totalPage && totalPage > 0)
       {
           $(".l-bar-btnlast span").removeClass("l-disabled");
           $(".l-bar-btnnext span").removeClass("l-disabled");
       }
    
    $(".l-bar-selectpagesize select").change(function() {
   		document.getElementById("pageSize").value = $(".l-bar-selectpagesize select").val();
   		document.getElementById("pageNo").value = 1;
   		search();
       }); 
}
function search(){
	document.forms[0].submit();
}
function deleteData(id){
    if (confirm('确定删除?')){
    	window.location="${base}/admin/product/productAction!delete.${actionExt}?id=" + id;
    }
}
function showData(id){
	var dialog=$.ligerDialog.open({ title:'查看', url: '${base}/admin/product/productAction!show.${actionExt}?id=' + id, height: 300, width: null, buttons: [
              { text: '关闭', onclick: function (item, dialog) { dialog.close(); } }
           ], isResize: true
          });                                                                 	
}

function itemclick(item)
{
	if(item.value=='add'){
		window.location="${base}/admin/manager/managerAction!add.${actionExt}";
	}
	if(item.value=='edit'){
        var row = manager.getSelectedRow();
        if (!row) { alert('请选择行'); return; }
            //alert(row.id);
		window.location="${base}/admin/manager/managerAction!edit.${actionExt}?id=" + row.id;
	}
	if(item.value=='delete'){
		var row = manager.getSelectedRow();
        if (!row) { alert('请选择行'); return; }
		$.ligerDialog.confirm('确认删除管理员 ' + row.nickname + ' 的信息？', function (yes) {
            if(yes==true){
            	window.location="${base}/admin/manager/managerAction!delete.${actionExt}?id=" + row.id;
            }
        });
	}
    
}

</script>
<style type="text/css">
        .l-case-title{font-weight:bold; margin-top:20px;margin-bottom:20px;}
     </style>
</head>
<body style="padding:6px; overflow:hidden;">
<form name="managerForm" id="managerForm" method="post" action="managerAction.${actionExt}" >
<input type="hidden" name="pageNo" id="pageNo" value="${requestScope.pageInfo.page}" />
<input type="hidden" name="pageSize" id="pageSize" value="${requestScope.pageInfo.pageSize}" />
<div id="searchbar">
    邮箱：<input id="manager.email" type="text" name="manager.email" value="${manager.email }"/>
    <input id="btnOK" type="submit" value="查询"/>
</div>
    <div id="maingrid" style="margin:0; padding:0"></div>
   

  <div style="display:none;">
</div>
 
</form>
</body>
</html>