$(document).ready(function(){
	$("#buyTb").bootstrapTable({
		url:"http://127.0.0.1:8080/buses/allbuy.do",
		pagination:true,
		pageSize:5,
		pageNumber:1,
		pageList:[5,6,"ALL"],
		search:true,
		toolbar:"#tools",
		columns:[
		{radio:true},
		{
			title:"配件编号",
			field:"id"
		},
		{
			title:"配件名称",
			field:"partName"
		},
		{
			title:"配件价格",
			field:"partPrice"
		},
		{
			title:"配件数量",
			field:"partNum"
		}
		,
		{
			title:"配件总价",
			field:"sumPrice"
		}
		]
	});
});

var path="";
function buyTitle(title){
	$("#buyTitle").text(title);
}

function addbuy(){
	$("#buyForm")[0].reset();
	path="http://127.0.0.1:8080/buses/addbuy.do";
	$("#buyModal").modal("show");
	$("#id").removeAttr("readonly");
	buyTitle("添加配件采购信息");
}

function delbuy(){
	var arr=$("#buyTb").bootstrapTable("getSelections");
	if (arr.length!=1) {
		alert("请选中一行！");
	} else{
		if(confirm("是否删除"))
		{
		$.ajax({
			url:"http://127.0.0.1:8080/buses/delbuy.do",
		    data:{"id":arr[0].id},
		    dataType:"json",
		    success:function(rs){
		    	if(rs.isFlag){
		    		//成功，将模态框隐藏，提示信息，并刷新表格
		    			$("#buyTb").bootstrapTable("refresh");
		    		alert(rs.msg);
		    	
		    	}else{
		    		alert(rs.msg);
		    	}
		    }
		});
		}
	}
}

function secbuy(){
	path="http://127.0.0.1:8080/buses/upbuy.do";
	var arr=$("#buyTb").bootstrapTable("getSelections");
	if (arr.length!=1) {
		alert("请选中一行！");
	} else{
		buyTitle("修改配件采购信息");
		$("#buyModal").modal("show");
		$("#id").val(arr[0].id);
		$("#partName").val(arr[0].partName);
		$("#partPrice").val(arr[0].partPrice);
		$("#partNum").val(arr[0].partNum);
		$("#sumPrice").val(arr[0].sumPrice);
		$("#id").attr("readonly","readonly");
	}
}
function sub(){
	console.info($("#buyForm").serialize());
	$.ajax({
		url:path,
		data:$("#buyForm").serialize(),
	    type:"Post",
	    dataType:"json",
	    success:function(rs){
	    	if(rs.isFlag){
	    		//成功，将模态框隐藏，提示信息，并刷新表格
	    		$('#buyModal').modal("hide");
	    		$("#buyTb").bootstrapTable("refresh");
	    		alert(rs.msg);
	    	}else{
	    		alert(rs.msg);
	    	}
	    }
	});	
	
	
}