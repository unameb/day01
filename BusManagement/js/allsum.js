$(document).ready(function(){
	$("#allsumTb").bootstrapTable({
		url:"../datas/allsum.json",
		pagination:true,
		pageSize:4,
		pageNumber:1,
		pageList:[4,6,"ALL"],
		search:true,
		toolbar:"#tools",
		columns:[
		{radio:true},
		{
			title:"配件支出",
			field:"buysum"
		},
		{
			title:"维修支出",
			field:"fixsum"
		},
		{
			title:"加油支出",
			field:"gassum"
		},
		{
			title:"总支出",
			field:"all"
		}
		
		]
	});
});
function delallsum(){
	var arr=$("#allsumTb").bootstrapTable("getSelections");
	if (arr.length!=1) {
		alert("请选择一行");
	} else{
		alert(arr[0].id);
	}
}

//全局变量，用来记录提交的目标地址
var path="";

function addTitle(title){
	$("#allsumTitle").text(title);
}
/*添加*/
function addallsum(){
	//设置目标地址
	 path="addallsum";
	//添加标题
	addTitle("添加应付信息");
	//调用模态框
	$("#allsumModal").modal("show");
	//清空表单
	$("#allsumForm")[0].reset();
}
//修改
function selectallsum(){
	//设置目标地址
	 path="selectallsum";
	//添加标题
	addTitle("修改应付信息");
	var arr=$("#allsumTb").bootstrapTable("getSelections");
	if (arr.length!==1) {
		alert("请选择一行！");
		return;
	} else{
		//调用模态框
		$("#allsumModal").modal("show");
		$("#buysum").val(arr[0].buysum);
		$("#fixsum").val(arr[0].fixsum);
		$("#gassum").val(arr[0].gassum);
		
	}
}

function sub(){
	alert(path);
}
