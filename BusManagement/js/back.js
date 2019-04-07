$(document).ready(function(){
	$("#backTb").bootstrapTable({
		url:"http://127.0.0.1:8080/buses/allback.do",
		pagination:true,
		pageSize:5,
		pageNumber:1,
		pageList:[5,6,"ALL"],
		search:true,
		toolbar:"#tools",
		columns:[
		{radio:true},
		{
			title:"登记编号",
			field:"id"
		},
		{
			title:"车辆编号",
			field:"bid"
		},
		{
			title:"司机",
			field:"driver"
		},
		{
			title:"收入",
			field:"income"
		},
		{
			title:"耗油量",
			field:"consumption"
		},
		{
			title:"当日里程",
			field:"run"
		},
		{
			title:"登记时间",
			field:"time"
		}
		]
	});
});

var path="";
function backTitle(title){
	$("#backTitle").text(title);
}

function addback(){
	$("#backForm")[0].reset();
	path="http://127.0.0.1:8080/buses/addback.do";
	$("#backModal").modal("show");
	backTitle("添加回车登记信息");
	 $.ajax({
    	url:"http://127.0.0.1:8080/buses/allinfo.do",
        dataType:"json",
        success:function(rs){
        	$("#did").empty();
        	$.each(rs,function(i,n){
        		$("#did").append("<option value='"+n.id+"'>"+n.name+"</option>");
        	});
        }
       
    });
     $.ajax({
    	url:"http://127.0.0.1:8080/buses/allbus.do",
        dataType:"json",
        success:function(rs){
        	$("#bid").empty();
        	$.each(rs,function(i,n){
        		$("#bid").append("<option value='"+n.id+"'>"+n.id+"</option>");
        	});
        }
       
    });
    
}

function delback(){
	var arr=$("#backTb").bootstrapTable("getSelections");
	if (arr.length!=1) {
		alert("请选中一行！");
	} else{
		if(confirm("是否删除")){
		$.ajax({
			url:"http://127.0.0.1:8080/buses/delback.do",
		    data:{"id":arr[0].id},
		    dataType:"json",
		    success:function(rs){
		    	if(rs.isFlag){
		    		//成功，将模态框隐藏，提示信息，并刷新表格
		    		$("#backTb").bootstrapTable("refresh");
		    		alert(rs.msg);
		    	}else{
		    		alert(rs.msg);
		    	}
		    }
		});
		}
		
	}
}

function secback(){
	path="http://127.0.0.1:8080/buses/upback.do";
	var arr=$("#backTb").bootstrapTable("getSelections");
	if (arr.length!=1) {
		alert("请选中一行！");
	} else{
		backTitle("修改回车登记信息");
		$("#backModal").modal("show");
		$("#id").val(arr[0].id);
		 $("#id").attr("readonly","readonly");
		$("#bid").val(arr[0].bid);
		$("#did").val(arr[0].did);
		$("#income").val(arr[0].income);
		$("#consumption").val(arr[0].consumption);
		$("#run").val(arr[0].run);
		$("#time").val(arr[0].time);
	}
	$.ajax({
    	url:"http://127.0.0.1:8080/buses/allinfo.do",
        dataType:"json",
        success:function(rs){
        	$("#did").empty();
        	$.each(rs,function(i,n){
        		$("#did").append("<option value='"+n.id+"'>"+n.name+"</option>");
        	});
        }
       
    });
     $.ajax({
    	url:"http://127.0.0.1:8080/buses/allbus.do",
        dataType:"json",
        success:function(rs){
        	$("#bid").empty();
        	$.each(rs,function(i,n){
        		$("#bid").append("<option value='"+n.id+"'>"+n.id+"</option>");
        	});
        }
       
    });
	
}

function sub(){
	var backid=document.getElementById("id").value;
	var backincome=document.getElementById("income").value;
	var backconsumption=document.getElementById("consumption").value;
	var backrun=document.getElementById("run").value;
	if (backid.length==0) {
		alert("车辆编号不能为空")
	}
	if (backincome.length==0) {
		alert("收入不能为空")
	}
	if (backconsumption.length==0) {
		alert("耗油量不能为空")
	}
	if (backrun.length==0) {
		alert("当日里程不能为空")
	}
	console.info($("#backForm").serialize());
	$.ajax({
		url:path,
		data:$("#backForm").serialize(),
	    dataType:"json",
	    success:function(rs){
	    	console.info(rs);
	    	if(rs.isFlag){
	    		//成功，将模态框隐藏，提示信息，并刷新表格
	    		$("#backModal").modal("hide");
	    		$("#backTb").bootstrapTable("refresh");
	    		alert(rs.msg);
	    	}else{
	    		alert(rs.msg);
	    	}
	    }
	});	
	
}