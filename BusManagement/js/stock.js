$(document).ready(function(){
	$("#stockTb").bootstrapTable({
		url:"http://127.0.0.1:8080/buses/allstock.do",
		pagination:true,
		pageSize:5,
		pageNumber:1,
		pageList:[5,6,"ALL"],
		search:true,
		toolbar:"#tools",
		columns:[
		{radio:true},
		{
			title:"库存编号",
			field:"id"
		},
		{
			title:"配件编号",
			field:"pid"
		},
		{
			title:"配件名称",
			field:"partName"
		},
		{
			title:"配件数量",
			field:"sum"
		}
		]
	});
});

var path="";
function stockTitle(title){
	$("#stockTitle").text(title);
}

function addstock(){
	$("#stockForm")[0].reset();
	path="http://127.0.0.1:8080/buses/addstock.do";
	$("#stockModal").modal("show");
	$("#pid").removeAttr("readonly");
	$("#partName").removeAttr("readonly");
	stockTitle("添加配件库存信息");
	
	
}

function delstock(){
	var arr=$("#stockTb").bootstrapTable("getSelections");
	if (arr.length!=1) {
		alert("请选中一行！");
	} else{
		if(confirm("是否删除")){
		$.ajax({
			url:"http://127.0.0.1:8080/buses/delstock.do",
		    data:{"id":arr[0].id},
		    dataType:"json",
		    success:function(rs){
		    	if(rs.isFlag){
		    		//提示信息，并刷新表格
		    		$("#stockTb").bootstrapTable("refresh");
		    		alert(rs.msg);
		    	}else{
		    		alert(rs.msg);
		    	}
		    }
		});
		}
	}
}

function secstock(){
	path="http://127.0.0.1:8080/buses/upstock.do";
	var arr=$("#stockTb").bootstrapTable("getSelections");
	if (arr.length!=1) {
		alert("请选中一行！");
	} else{
		stockTitle("修改配件库存信息");
		$("#stockModal").modal("show");
		$("#id").val(arr[0].id);
		 $("#id").attr("readonly","readonly");
		$("#pid").val(arr[0].pid);
	    $("#pid").attr("readonly","readonly");
		$("#partName").val(arr[0].partName);
		 $("#partName").attr("readonly","readonly");
		$("#sum").val(arr[0].sum);
	}
}
function sub(){
	console.info($("#stockForm").serialize());
	$.ajax({
		url:path,
		data:$("#stockForm").serialize(),
	    dataType:"json",
	    success:function(rs){
	    	console.info(rs);
	    	if(rs.isFlag){
	    		//成功，将模态框隐藏，提示信息，并刷新表格
	    		$("#stockModal").modal("hide");
	    		$("#stockTb").bootstrapTable("refresh");
	    		alert(rs.msg);
	    	}else{
	    		alert(rs.msg);
	    	}
	    }
	});	
}
