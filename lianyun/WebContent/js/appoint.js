$(document).ready(
	function() {
		var formHeight = parseInt($("fieldset").height());
		$("#formDiv").css("margin-top",(winHeight-formHeight)/2);
});

function submitForm(){
	onboardInfo.accountname = $("#accountname").val();
	onboardInfo.onboardaddress = $("#onboardaddress").val();
	if(onboardInfo.accountname==""||onboardInfo.onboardaddress==""){
		alert("信息填写不完整")
	}
	$.ajax({
		async : false,
		cache : false,
		type : "POST",
		url: CTX_PATH + "/hq/addOnboardInfo_onboard.do",
		dataType : "json",
		data : {
			'onboardInfo':JSON.stringify(onboardInfo)
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
