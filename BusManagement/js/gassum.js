$(document).ready(function(){
	$("#gassumTb").bootstrapTable({
		url:"../datas/gassum.json",
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
			title:"加油总支出",
			field:"gasCost"
		}
		]
	});
});
function delgassum(){
	var arr=$("#gassumTb").bootstrapTable("getSelections");
	if (arr.length!=1) {
		alert("请选择一行");
	} else{
		alert(arr[0].id);
	}
}

//全局变量，用来记录提交的目标地址
var path="";

function addTitle(title){
	$("#gassumTitle").text(title);
}
/*添加*/
function addgassum(){
	//设置目标地址
	 path="addgassum";
	//添加标题
	addTitle("添加油卡信息");
	//调用模态框
	$("#gassumModal").modal("show");
	//清空表单
	$("#gassumForm")[0].reset();
}
//修改
function selectgassum(){
	//设置目标地址
	 path="selectgassum";
	//添加标题
	addTitle("修改油卡信息");
	var arr=$("#gassumTb").bootstrapTable("getSelections");
	if (arr.length!==1) {
		alert("请选择一行！");
		return;
	} else{
		//调用模态框
		$("#gassumModal").modal("show");
		$("#id").val(arr[0].id);
		$("#gasCost").val(arr[0].sumPrice);
		
	}
}

function sub(){
	alert(path);
}
