$(document).ready(function(){
	$("#buslgTb").bootstrapTable({
		url:"http://127.0.0.1:8080/buses/allbus.do",
		pagination:true,
		pageSize:5,
		pageNumber:1,
		pageList:[5,6,"ALL"],
		search:true,
		toolbar:"#tools",
		columns:[
		{radio:true},
		{
			title:"车辆编号",
			field:"id"
		},
		{
			title:"所属线路",
			field:"name"
		},
		{
			title:"车辆状态",
			field:"sname"
		},
		{
			title:"车辆单位",
			field:"owner"
		},
		{
			title:"车牌号",
			field:"number"
		},
		{
			title:"保险单号",
			field:"safeid"
		},
		{
			title:"送检时间",
			field:"stime"
		},
		{
			title:"到期提醒",
			field:"etime"
		}
		]
	});
});

var path="";
function buslgTitle(title){
	$("#buslgTitle").text(title);
}

function addbuslg(){
	$("#buslgForm")[0].reset();
	path="http://127.0.0.1:8080/buses/addbus.do";

	buslgTitle("添加车辆信息");
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
    	url:"http://127.0.0.1:8080/buses/allstate.do",
        dataType:"json",
        success:function(rs){
        	$("#sid").empty();
        	$.each(rs,function(i,n){
        		$("#sid").append("<option value='"+n.id+"'>"+n.sname+"</option>");
        	});
        }
       
    });
	
		$("#buslgModal").modal("show");
}

function delbuslg(){
	var arr=$("#buslgTb").bootstrapTable("getSelections");
	if (arr.length!=1) {
		alert("请选中一行！");
	} else{
		if(confirm("是否删除")){
		$.ajax({
			url:"http://127.0.0.1:8080/buses/delbus.do",
		    data:{"id":arr[0].id},
		    dataType:"json",
		    success:function(rs){
		    	if(rs.isFlag){
		    		//成功，将模态框隐藏，提示信息，并刷新表格
		    		alert(rs.msg);
		    		$("#buslgTb").bootstrapTable("refresh");
		    	}else{
		    		alert(rs.msg);
		    	}
		    }
		});
		}
	}
}

function secbuslg(){
	path="http://127.0.0.1:8080/buses/upbus.do";
	var arr=$("#buslgTb").bootstrapTable("getSelections");
	if (arr.length!=1) {
		alert("请选中一行！");
	} else{
		buslgTitle("修改车辆信息");
		$("#buslgModal").modal("show");
		$("#id").val(arr[0].id);
		$("#id").attr("readonly","readonly");
		$("#rid").val(arr[0].rid);
		$("#owner").val(arr[0].owner);
		$("#sid").val(arr[0].sid);
		$("#number").val(arr[0].number);
		$("#safeid").val(arr[0].safeid);
		$("#stime").val(arr[0].stime);
		$("#etime").val(arr[0].etime);
		$("#number").val(arr[0].number);
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
    	url:"http://127.0.0.1:8080/buses/allstate.do",
        dataType:"json",
        success:function(rs){
        	$("#sid").empty();
        	$.each(rs,function(i,n){
        		$("#sid").append("<option value='"+n.id+"'>"+n.sname+"</option>");
        	});
        }
       
    });
	
}
function sub(){
    /*var arr=$("#buslgForm").serialize();
    console.info(arr[0].stime);
    if (arr[0].stime  ||arr[0].etime=='') {
    	alert("ads");
    } else{
    	alert("sd");
    }*/
    
	$.ajax({
		url:path,
		data:$("#buslgForm").serialize(),
	    /*type:"Post",*/
	    dataType:"json",
	    success:function(rs){
	    	console.info(rs);
	    	if(rs.isFlag){
	    		//成功，将模态框隐藏，提示信息，并刷新表格
	    		$("#buslgModal").modal("hide");
	    		$("#buslgTb").bootstrapTable("refresh");
	    		alert(rs.msg);
	    	}else{
	    		alert(rs.msg);
	    	}
	    }
	});	
}