$(document).ready(function(){
	$("#turnTb").bootstrapTable({
		url:"http://127.0.0.1:8080/buses/allturn.do",
		pagination:true,
		pageSize:5,
		pageNumber:1,
		pageList:[5,6,"ALL"],
		search:true,
		toolbar:"#tools",
		columns:[
		{radio:true},
		{
			title:"排班编号",
			field:"id"
		},
		{
			title:"司机",
			field:"driver"
		},
		{
			title:"排班时间",
			field:"time"
		},
		{
			title:"站台",
			field:"station"
		},
		{
			title:"排班线路",
			field:"road"
		}
		]
	});
});

var path="";
function turnTitle(title){
	$("#turnTitle").text(title);
}

/*添加*/
function addTurn(){
	//设置目标地址
	 path="http://127.0.0.1:8080/buses/addturn.do";
	//添加标题
	turnTitle("添加排班信息");
	//调用模态框
	$("#turnModal").modal("show");
	//清空表单
	$("#turnForm")[0].reset();
	$("#id").removeAttr("readonly");
	 $.ajax({
    	url:"http://127.0.0.1:8080/buses/allroad.do",
        dataType:"json",
        success:function(rs){
        	$("#rid").empty();
        	$.each(rs,function(i,n){
        		$("#rid").append("<option value='"+n.id+"'>"+n.name+"</option>");
        	});
        }
       
    });
    $.ajax({
    	url:"http://127.0.0.1:8080/buses/allinfo.do",
        dataType:"json",
        success:function(rs){
        	$("#driver").empty();
        	$.each(rs,function(i,n){
        		$("#driver").append("<option value='"+n.id+"'>"+n.name+"</option>");
        	});
        }
       
    });
	
}

function delTurn(){
	var arr=$("#turnTb").bootstrapTable("getSelections");
	if (arr.length!=1) {
		alert("请选中一行！");
	} else{
		if(confirm("是否删除")){
		$.ajax({
			url:"http://127.0.0.1:8080/buses/delturn.do",
		    data:{"id":arr[0].id},
		    dataType:"json",
		    success:function(rs){
		    	if(rs.isFlag){
		    		//成功，将模态框隐藏，提示信息，并刷新表格
		    		$("#stockModal").modal("hide"); 
		    		$("#turnTb").bootstrapTable("refresh");
		    		alert(rs.msg);
		    	}else{
		    		alert(rs.msg);
		    	}
		    }
		});
		}
	}
}

function secTurn(){
	path="http://127.0.0.1:8080/buses/upturn.do";
	var arr=$("#turnTb").bootstrapTable("getSelections");
	if (arr.length!=1) {
		alert("请选中一行！");
	} else{
		turnTitle("修改排班信息");
		$("#turnModal").modal("show");
		$("#id").val(arr[0].id);
	    $("#id").attr("readonly","readonly");
		$("#driver").val(arr[0].driver);
		$("#rid").val(arr[0].rid);
		$("#time").val(arr[0].time);
		$("#station").val(arr[0].station);
	}
	 $.ajax({
    	url:"http://127.0.0.1:8080/buses/allroad.do",
        dataType:"json",
        success:function(rs){
        	$("#rid").empty();
        	$.each(rs,function(i,n){
        		$("#rid").append("<option value='"+n.id+"'>"+n.name+"</option>");
        	});
        }
       
    });
    $.ajax({
    	url:"http://127.0.0.1:8080/buses/allinfo.do",
        dataType:"json",
        success:function(rs){
        	$("#driver").empty();
        	$.each(rs,function(i,n){
        		$("#driver").append("<option value='"+n.id+"'>"+n.name+"</option>");
        	});
        }
       
    });
	
}
function sub(){
	var turnid=document.getElementById("id").value;
	var turndriver=document.getElementById("driver").value;
	var turntime=document.getElementById("time").value;
	var turnstation=document.getElementById("station").value;
	var road=document.getElementById("rid").value;
	if (turnid.length==0) {
		alert("车辆编号不能为空");
	}
	if (turndriver.length==0) {
		alert("司机姓名不能为空");
	}
	if (turntime.length==0) {
		alert("排班时间不能为空");
	}
	if (turnstation.length==0) {
		alert("站台不能为空");
	}
	if (road.length==0) {
		alert("线路不能为空");
	}
	console.info($("#turnForm").serialize());
	$.ajax({
		url:path,
		data:$("#turnForm").serialize(),
	    dataType:"json",
	    success:function(rs){
	    	console.info(rs);
	    	if(rs.isFlag){
	    		//成功，将模态框隐藏，提示信息，并刷新表格
	    		$("#turnModal").modal("hide");
	    		$("#turnTb").bootstrapTable("refresh");
	    		alert(rs.msg);
	    	}else{
	    		alert(rs.msg);
	    	}
	    }
	});	
}
