$(document).ready(function(){
	$("#gasTb").bootstrapTable({
		url:"http://127.0.0.1:8080/buses/allgas.do",
		pagination:true,
		pageSize:4,
		pageNumber:1,
		pageList:[4,6,"ALL"],
		search:true,
		toolbar:"#tools",
		columns:[
		{radio:true},
		{
			title:"油卡编号",
			field:"id"
		},
		{
			title:"剩余金额",
			field:"income"
		},
		{
			title:"加油量",
			field:"gas"
		},
		
		{
			title:"加油支出",
			field:"outcome"
		},
		{
			title:"加油时间",
			field:"time"
		}
		]
	});
});
function delgas(){
	var arr=$("#gasTb").bootstrapTable("getSelections");
	if (arr.length!=1) {
		alert("请选择一行");
	} else{
		if(confirm("是否删除")){
		$.ajax({
			url:"http://127.0.0.1:8080/buses/delgas.do",
		    data:{"id":arr[0].id},
		    dataType:"json",
		    success:function(rs){
		    	if(rs.isFlag){
		    		//成功，将模态框隐藏，提示信息，并刷新表格
		    		$("#gasTb").bootstrapTable("refresh");
		    		alert(rs.msg);
		    	}else{
		    		alert(rs.msg);
		    	}
		    }
		});
		}
	}
}

//全局变量，用来记录提交的目标地址
var path="";

function addTitle(title){
	$("#gasTitle").text(title);
}
/*添加*/
function addgas(){
	//设置目标地址
	 path="http://127.0.0.1:8080/buses/addgas.do";
	//添加标题
	addTitle("添加油卡信息");
	$("#id").removeAttr("readonly");
	//调用模态框
	$("#gasModal").modal("show");
	//清空表单
	$("#gasForm")[0].reset();
}
//修改
function selectgas(){
	//设置目标地址
	 path="http://127.0.0.1:8080/buses/upgas.do";
	//添加标题
	addTitle("修改油卡信息");
	var arr=$("#gasTb").bootstrapTable("getSelections");
	if (arr.length!==1) {
		alert("请选择一行！");
		return;
	} else{
		//调用模态框
		$("#gasModal").modal("show");
		$("#id").val(arr[0].id);
		 $("#id").attr("readonly","readonly");
		 $("#in").val(arr[0].income);
		$("#gas").val(arr[0].gas);
		$("#out").val(arr[0].outcome);
		$("#time").val(arr[0].time);
	}
}

function sub(){
	console.info($("#gasForm").serialize());
	$.ajax({
		url:path,
		data:$("#gasForm").serialize(),
	    dataType:"json",
	    success:function(rs){
	    	console.info(rs);
	    	if(rs.isFlag){
	    		//成功，将模态框隐藏，提示信息，并刷新表格
	    		$("#gasModal").modal("hide");
	    		$("#gasTb").bootstrapTable("refresh");
	    		alert(rs.msg);
	    	}else{
	    		alert(rs.msg);
	    	}
	    }
	});	
}
