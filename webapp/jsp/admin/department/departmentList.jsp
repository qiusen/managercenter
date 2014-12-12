<%@ page contentType="text/html;charset=UTF-8"%><%@ include file="/jsp/common/taglibs.jsp"%><!DOCTYPE html>
<html lang="zh-CN">
<head>
<title>部门 列表</title>
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
    	title:'部门列表',
        columns: [
        //{ display: '主键', name: 'id', width: 50, type: 'int', frozen: true },
		
		{ display: '名称', name: 'name',type: 'text' , width: '15%'},
		{ display: '代号', name: 'code',type: 'text' , width: '15%'},
		{ display: '类型', name: 'type',type: 'text' , width: '10%',render: function (rowdata, rowindex, value)
        {
        	var h = "-";
            if(rowdata.type==1){
                h = "公司";
            }
            if(rowdata.type==2){
                h = "部门";
            }
            if(rowdata.type==3){
                h = "项目组";
            }
            return h;
        } },
        { display: '主管', name: 'leaderEmail',type: 'text' , width: '25%',render: function (rowdata, rowindex, value) {
        	var r = "-";
        	<c:forEach items="${managerList}" var="manager">
        	if(rowdata.leaderEmail == '${manager.email}'){
        		r = "${manager.nickname}|${manager.ename}|${manager.email}";
        	}
        	</c:forEach>
            return r;
        }  },
		{ display: '上级部门', name: 'superId',type: 'text' , width: '15%',render: function (rowdata, rowindex, value) {
        	var r = "<%=Property.COMP_NAME%>";
        	<c:forEach items="${departmentList}" var="department">
        	if(rowdata.superId == ${department.id}){
        		r = "${department.name}";
        	}
        	</c:forEach>
            return r;
        }  },
		{ display: '创建人', name: 'creator',type: 'text' , width: '15%'},
		{ display: '创建时间', name: 'createtime',type: 'text' , width: '15%'},
		{ display: '修改人', name: 'updator',type: 'text' , width: '15%'},
		{ display: '修改时间', name: 'updatetime',type: 'text' , width: '15%'}
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
                           { text: '主管', value:'leader', click: itemclick, icon: 'leader', img: '${base}/ligerUI/skins/icons/memeber.gif' },
                           { text: '职位', value:'position', click: itemclick, icon: 'position', img: '${base}/ligerUI/skins/icons/customers.gif' } 
                           ] }

        
                                 
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
    	window.location="${base}/admin/department/departmentAction!delete.${actionExt}?id=" + id;
    }
}
function showData(id){
	var dialog=$.ligerDialog.open({ title:'查看', url: '${base}/admin//department/departmentAction!show.${actionExt}?id=' + id, height: 300, width: null, buttons: [
              { text: '关闭', onclick: function (item, dialog) { dialog.close(); } }
           ], isResize: true
          });                                                                 	
}

function itemclick(item){
	if(item.value=='add'){
		window.location="${base}/admin/department/departmentAction!add.${actionExt}";
	}
	if(item.value=='edit'){
        var row = manager.getSelectedRow();
        if (!row) { $.ligerDialog.warn('请选择行'); return; }
            //alert(row.id);
		window.location="${base}/admin/department/departmentAction!edit.${actionExt}?id=" + row.id;
	}
	if(item.value=='leader'){
        var row = manager.getSelectedRow();
        if (!row) { $.ligerDialog.warn('请选择行'); return; }
            //alert(row.id);
		window.location="${base}/admin/department/departmentAction!editLeader.${actionExt}?id=" + row.id;
	}
	if(item.value=='position'){
        var row = manager.getSelectedRow();
        if (!row) { $.ligerDialog.warn('请选择行'); return; }
            //alert(row.id);
		window.location="${base}/admin/department/departmentAction!editPosition.${actionExt}?id=" + row.id;
	}
	
	if(item.value=='delete'){
		var row = manager.getSelectedRow();
        if (!row) {$.ligerDialog.warn('请选择行'); return; }
		$.ligerDialog.confirm('确认删除模块 ' + row.name + ' 的信息？', function (yes) {
            if(yes==true){
            	window.location="${base}/admin/department/departmentAction!delete.${actionExt}?id=" + row.id;
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
<form name="departmentForm" id="departmentForm" method="post" action="departmentAction.${actionExt}" >
<input type="hidden" name="pageNo" id="pageNo" value="${requestScope.pageInfo.page}" />
<input type="hidden" name="pageSize" id="pageSize" value="${requestScope.pageInfo.pageSize}" />
<div id="searchbar">
名称：<input id="department.name" type="text" name="department.name" value="${department.name }"/>
    <input id="btnOK" type="submit" value="查询"/>
</div>
    <div id="maingrid" style="margin:0; padding:0"></div>
   

  <div style="display:none;">
</div>
 
</form>
</body>
</html>