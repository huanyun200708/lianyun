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

function endEditing(){
	if (editIndex == undefined){return true}
	if ($('#dg').datagrid('validateRow', editIndex)){
		//var ed = $('#dg').datagrid('getEditor', {index:editIndex,field:'accountid'});
		//var productname = $(ed.target).combobox('getText');
		//$('#dg').datagrid('getRows')[editIndex]['name'] = name;
		$('#dg').datagrid('endEdit', editIndex);
		editIndex = undefined;
		return true;
	} else {
		return false;
	}
}
function onClickRow(index){
	editIndex = index;
}
function append(){
	if (endEditing()){
		$('#dg').datagrid('appendRow',{status:'P'});
		editIndex = $('#dg').datagrid('getRows').length-1;
		$('#dg').datagrid('selectRow', editIndex)
				.datagrid('beginEdit', editIndex);
	}
}
function removeit(cell){
	editIndex = $(cell).parent().parent().parent()[0].rowIndex;
	$('#dg').datagrid('cancelEdit', editIndex)
	.datagrid('deleteRow', editIndex);
	editIndex = undefined;
}
function removeRow(){
	//if (editIndex == undefined){return}
	$('#dg').datagrid('cancelEdit', editIndex)
			.datagrid('deleteRow', editIndex);
	editIndex = undefined;
}
function accept(){
	if (endEditing()){
		$('#dg').datagrid('acceptChanges');
	}
}
function reject(){
	$('#dg').datagrid('rejectChanges');
	editIndex = undefined;
}
function getChanges(){
	var rows = $('#dg').datagrid('getChanges');
	alert(rows.length+' rows are changed!');
}
function formatPrice(val,row,rowIndex){
	var apointhtml =  '<span class="l-btn-left l-btn-icon-left" style="border: 0px solid #95B8E7;cursor: pointer;" onclick="removeit(this)">'+
						'<span class="l-btn-text">预约成功</span>'+
						'<span class="l-btn-icon icon-add"></span>'+
					'</span>';
	var onboardhtml =  '<span class="l-btn-left l-btn-icon-left" style="border: 0px solid #95B8E7;margin-left: 20px;cursor: pointer;" onclick="removeit(this)">'+
						'<span class="l-btn-text">上车成功</span>'+
						'<span class="l-btn-icon icon-ok"></span>'+
					'</span>';
	return apointhtml + onboardhtml;
}
function onClickCell(index, field){
	editIndex = index;
}