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
			'account':JSON.stringify(account),
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
