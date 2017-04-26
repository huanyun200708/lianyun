<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<base href="<%=basePath%>">
	<title>临沂联运</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta charset="UTF-8">
	
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/appoint.css">
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/lib/jquery.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/lib/jquery-1.10.2.min.js"></script>
	<%-- <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/EasyUI/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/EasyUI/themes/icon.css">
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/EasyUI/jquery.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/appoint.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/EasyUI/jquery.easyui.min.js"></script> --%>
	<script type="text/javascript">
		var name = "${myname}";
		var onboardInfo = {
				"accountid" : "u0001",
				"accountname" : "n1",
				"onboardaddress" : "d1"
			};
		var CTX_PATH = '<%=request.getContextPath()%>';
		(function($){
		})(jQuery);
	</script>
	<style type="text/css">
		input {
			-webkit-appearance: textfield;
			background-color: white;
			-webkit-rtl-ordering: logical;
			user-select: text;
			cursor: auto;
			padding: 1px;
			border-width: 2px;
			border-style: inset;
			border-color: initial;
			border-image: initial;
		}
		
		user agent stylesheet
		input, textarea, keygen, select, button {
			text-rendering: auto;
			color: initial;
			letter-spacing: normal;
			word-spacing: normal;
			text-transform: none;
			text-indent: 0px;
			text-shadow: none;
			display: inline-block;
			text-align: start;
			margin: 0em 0em 0em 0em;
			font: 13.3333px Arial;
		}
		
		user agent stylesheet
		input, textarea, keygen, select, button, meter, progress {
			-webkit-writing-mode: horizontal-tb;
		}
</style>
</head>

<body style="text-align: center;width:100%;height:100%;">
	<div style="text-align: center;margin:0 auto;width: 80%;margin-top:10%">
		<!-- <div class="easyui-panel" title="预约上车" 
			style="text-align:center;margin:0 auto;width:100%;max-width:800px;padding:30px 60px;font-size: 20px;font-weight:bold;">
			<form id="ff" class="easyui-form" method="post" data-options="novalidate:true">
				<div style="margin-bottom:20px;">
					<input class="easyui-textbox" name="accountname" id='accountname' style="width:100%;" data-options="label:'姓名:',required:true">
				</div>
				<div style="margin-bottom:20px; ">
					<input class="easyui-textbox" name="onboardaddress" id='onboardaddress' style="width:100%" data-options="label:'上车地点:',required:true">
				</div>
			</form>
			<div style="text-align:center;padding:5px 0;">
				<a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()" style="width:100px;font-size: 22px;">我要上车</a>
			</div>
		</div> -->
		<form>
			<!-- / Fieldset Alpha -->
			<fieldset class="alpha">
				<legend>
					<b>预约上车</b>
				</legend>
				<div class="frow">
					<input class="item" placeholder="姓名" type="text">
				</div>
				<div class="frow">
					<input class="item" placeholder="地点" type="email">
				</div>
				<div class="frow">
					<a class="next-step" href="#">我要上车</a>
				</div>
			</fieldset>
		</form>
	</div>
</body>
</html>
