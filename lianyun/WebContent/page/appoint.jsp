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
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/appoint.js"></script>
	<script type="text/javascript">
		var name = "${myname}";
		var onboardInfo = {
				"accountid" : "u0001",
				"accountname" : "n1",
				"onboardaddress" : "d1"
			};
		var winHeight = window.innerHeight; 
		var winWidth = window.innerWidth;
		var CTX_PATH = '<%=request.getContextPath()%>';
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
	<div id='formDiv' style="text-align: center;margin:0 auto;width: 95%;height:200px;min-height:200px;height:auto;display:table- cell;">
		<form>
			<fieldset class="alpha">
				<legend>
					<b>预约上车</b>
				</legend>
				<div class="frow">
					<input class="item" name="accountname" id='accountname' placeholder="姓名" type="text">
				</div>
				<div class="frow">
					<input class="item" name="onboardaddress" id='onboardaddress' placeholder="上车地点" type="email">
				</div>
				<div class="frow">
					<input class="item" name="phoneNum" id='phoneNum' placeholder="电话号码" type="email">
				</div>
				<div class="frow">
					<a class="next-step" onclick="submitForm()" href="#">我要上车</a>
				</div>
			</fieldset>
		</form>
	</div>
</body>
</html>
