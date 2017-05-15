var accountid = "u0001";
var isConnectWsSuccess = false;
$(document).ready(
	function() {
		var formHeight = parseInt($("fieldset").height());
		$("#formDiv").css("margin-top",(winHeight-formHeight)/2);
		
		$.ajax({
			async : false,
			cache : false,
			type : "POST",
			url: CTX_PATH + "/hq/getAccountInfo_userMg.do",
			dataType : "json",
			data : {
				'accountId':'u0001'
			},
			success : function(data, textStatus, jqXHR) {
				if (data.success){
					$("#accountname").val(data.account.name);
					$("#phoneNum").val(data.account.phone);
				}
			},
			complete : function(XHR, TS) {
				XHR = null;
			}
		});
		
		$.ajax({
			async : false,
			cache : false,
			type : "POST",
			url: CTX_PATH + "/hq/isAdministator_userMg.do",
			dataType : "json",
			data : {
				'accountId':'u0001'
			},
			success : function(data, textStatus, jqXHR) {
				if (data.success && data.isAdministator){
					alert("管理员")
					connect();
				}
			},
			complete : function(XHR, TS) {
				XHR = null;
			}
		});
});

function submitForm(){
	onboardInfo.accountname = $("#accountname").val();
	onboardInfo.onboardaddress = $("#onboardaddress").val();
	if(onboardInfo.accountname==""||onboardInfo.onboardaddress=="" || $("#phoneNum").val()==""){
		alert("信息填写不完整")
		return;
	}
	var account = {
			"accountid" : "u0001",
			"name" : $("#accountname").val(),
			"phone" : $("#phoneNum").val()
		};
	$.ajax({
		async : false,
		cache : false,
		type : "POST",
		url: CTX_PATH + "/hq/addOnboardInfo_onboard.do",
		dataType : "json",
		data : {
			'onboardInfo':JSON.stringify(onboardInfo),
			'account':JSON.stringify(account)
		},
		success : function(data, textStatus, jqXHR) {
			if (data.success){
				alert(data.message)
			}
		},
		complete : function(XHR, TS) {
			XHR = null;
		}
	});
}
function clearForm(){
	$('#ff').form('clear');
}
function connect() {
	var host;
	if (window.location.protocol == 'http:') {
			host = 'ws://' + window.location.host + '/lianyun/forwardWebSocket?from='+accountid + "_" +new Date().getTime();
		} else {
			host = 'wss://' + window.location.host + '/lianyun/forwardWebSocket?from='+accountid + "_" +new Date().getTime();
		}
		if ('WebSocket' in window) {
			ws = new WebSocket(host);
		} else if ('MozWebSocket' in window) {
			ws = new MozWebSocket(host);
		} else {
			return;
		}
		
		ws.onopen = function() {
			alert("连接成功")
			isConnectWsSuccess = true;
		};

		ws.onclose = function() {
			
		};
		
		ws.onmessage = function(res) {
			var messageInfo = JSON.parse(res.data);
			var id = messageInfo.message.id;
			$.ajax({
				async : false,
				cache : false,
				type : "POST",
				url: CTX_PATH + "/hq/deleteOnboardmesageById_onboard.do",
				dataType : "json",
				data : {
					'id':id
				},
				success : function(data, textStatus, jqXHR) {
					if (data.success){
						alert(data.message)
					}
				},
				complete : function(XHR, TS) {
					XHR = null;
				}
			});
			//收到消息后做出处理的方法
			//handleMsg(JSON.parse(message.data));
			//alert(JSON.parse(message.data).name + " 在 " +  JSON.parse(message.data).address+ " 等待上车");
		};
	}