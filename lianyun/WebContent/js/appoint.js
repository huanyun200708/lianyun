var editIndex = undefined;

function submitForm(){
	onboardInfo.accountname = $("#accountname").val();
	onboardInfo.onboardaddress = $("#onboardaddress").val();
	$('#ff').form('submit',
		{
			url: CTX_PATH + "/hq/addOnboardInfo_onboard.do",
			dataType : "json",
			onSubmit: function(param){
				var isValid = $(this).form('validate');
				if (!isValid){
					$.messager.progress('close');	// hide progress bar
				}
				param.onboardInfo=JSON.stringify(onboardInfo);
				return isValid;	// return false will stop the form
								// submission
			},
			success: function(data){
				$.messager.progress('close');	// hide progress bar
												// while submit
												// successfully
				var data = eval('(' + data + ')'); // change the JSON
													// string to
													// javascript object
				if (data.success){
					alert(data.message)
				}
			}
	});
}
function clearForm(){
	$('#ff').form('clear');
}
