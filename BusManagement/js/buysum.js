$(document).ready(function(){
	$("#buysumTb").bootstrapTable({
		url:"../datas/buysum.json",
		pagination:true,
		pageSize:4,
		pageNumber:1,
		pageList:[4,6,"ALL"],
		search:true,
		toolbar:"#tools",
		columns:[
		{radio:true},
		{
			title:"配件编号",
			field:"id"
		},
		{
			title:"配件总价",
			field:"sumPrice"
		}
		]
	});
});
function delbuysum(){
	var arr=$("#buysumTb").bootstrapTable("getSelections");
	if (arr.length!=1) {
		alert("请选择一行");
	} else{
		alert(arr[0].id);
	}
}

//全局变量，用来记录提交的目标地址
var path="";

function addTitle(title){
	$("#buysumTitle").text(title);
}
/*添加*/
function addbuysum(){
	//设置目标地址
	 path="addgas";
	//添加标题
	addTitle("添加油卡信息");
	//调用模态框
	$("#buysumModal").modal("show");
	//清空表单
	$("#buysumForm")[0].reset();
}
//修改
function selectbuysum(){
	//设置目标地址
	 path="selectbuysum";
	//添加标题
	addTitle("修改油卡信息");
	var arr=$("#buysumTb").bootstrapTable("getSelections");
	if (arr.length!==1) {
		alert("请选择一行！");
		return;
	} else{
		//调用模态框
		$("#buysumModal").modal("show");
		$("#id").val(arr[0].id);
		$("#sumPrice").val(arr[0].sumPrice);
		
	}
}

function sub(){
	alert(path);
}
