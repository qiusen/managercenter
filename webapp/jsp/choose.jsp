<%@ page contentType="text/html;charset=UTF-8" %><%@ include file="/jsp/common/taglibs.jsp"%><!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/html">
<head>
<meta http-equiv="Content-type" content="text/html; charset=utf-8">
<title><%=Property.SYSTEM_NAME %></title>
<%@ include file="/jsp/common/meta.jsp"%>
<link rel="stylesheet" href="${base }/css/custom.css"/>
    <!--[if IE 6]>
<script src="public/js/DD_belatedPNG_0.0.8a-min.js"></script>
<script type="text/javascript">
    DD_belatedPNG.fix('div');
</script>
<![endif]-->
<script type="text/javascript">
<c:if test="${sessionScope.manager==null}">
window.location="${base}";
</c:if>
</script>
</head>
<body>
    <div class="Box">
        <div class="BoxL">
            <div class="BoxLT">Welcome</div>
            <div class="BoxLA">
            </div>
        </div>
        
        <div class="BoxR">
            <div class="BoxRCon" style="width:500px;">
           
                <div class="fishT">${sessionScope.manager.nickname} 您好，请选择系统 <font style="font-size: 12px;">或 <a href="${base }/login!logOff.${actionExt}">退出</a></font></div>
                <div class="line1 MR5">
                    
                </div>
                <div class="line1 MT30">
                    <a href="${base }/jsp/main.jsp">管理系统</a>
                </div>
                <div class="line1 MT10 mod">
                    <a href="http://localhost:8080/oa/login.${actionExt}?email=${sessionScope.manager.email }&password=${sessionScope.manager.password }" target="_blank">OA办公系统</a>
                </div>
                <div class="line1 MT10 mod">
                    <a href="http://localhost:8080/product/login.${actionExt}?email=${sessionScope.manager.email }&password=${sessionScope.manager.password }" target="_blank">产品库</a>
                </div>
                
                <div class="line1 MT10 mod">
                    <a href="http://localhost:8080/acomp/login.${actionExt}?email=${sessionScope.manager.email }&password=${sessionScope.manager.password }" target="_blank">CMS</a>
                </div>

            </div>
        </div>
    </div>

    <!--遮罩-->
    <div class="mask myHide"></div>
    <div style="margin-left:550px;"><%@ include file="/jsp/common/bottom.jsp"%></div>
</body>
<script>
    $(function(){
        $(".Box").height($(window).height()-35);
    });
</script>
</html>