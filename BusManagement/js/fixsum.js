$(document).ready(function(){
	$("#fixsumTb").bootstrapTable({
		url:"../datas/fixsum.json",
		pagination:true,
		pageSize:4,
		pageNumber:1,
		pageList:[4,6,"ALL"],
		search:true,
		toolbar:"#tools",
		columns:[
		{radio:true},
		{
			title:"车俩编号",
			field:"id"
		},
		{
			title:"外部维修花费",
			field:"cost"
		},
		{
			title:"内部维修花费",
			field:"stockCost"
		},
		]
	});
});
function delfixsum(){
	var arr=$("#fixsumTb").bootstrapTable("getSelections");
	if (arr.length!=1) {
		alert("请选择一行");
	} else{
		alert(arr[0].id);
	}
}

//全局变量，用来记录提交的目标地址
var path="";

function addTitle(title){
	$("#fixsumTitle").text(title);
}
/*添加*/
function addfixsum(){
	//设置目标地址
	 path="addfixsum";
	//添加标题
	addTitle("添加油卡信息");
	//调用模态框
	$("#fixsumModal").modal("show");
	//清空表单
	$("#fixsumForm")[0].reset();
}
//修改
function selectfixsum(){
	//设置目标地址
	 path="selectfixsum";
	//添加标题
	addTitle("修改油卡信息");
	var arr=$("#fixsumTb").bootstrapTable("getSelections");
	if (arr.length!==1) {
		alert("请选择一行！");
		return;
	} else{
		//调用模态框
		$("#fixsumModal").modal("show");
		$("#id").val(arr[0].id);
		$("#cost").val(arr[0].cost);
		$("#stockCost").val(arr[0].stockCost);
		
	}
}

function sub(){
	alert(path);
}
