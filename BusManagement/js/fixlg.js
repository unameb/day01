$(document).ready(function(){
	$("#fixlgTb").bootstrapTable({
		url:"http://127.0.0.1:8080/buses/allfix.do",
		pagination:true,
		pageSize:5,
		pageNumber:1,
		pageList:[5,6,"ALL"],
		search:true,
		toolbar:"#tools",
		columns:[
		{radio:true},
		{
			title:"维修编号",
			field:"id"
		},
		{
			title:"司机",
			field:"name"
		},
		{
			title:"维修车辆",
			field:"bid"
		},
		
		{
			title:"外部维修厂",
			field:"place"
		},
		{
			title:"维修费用",
			field:"cost"
		},
		{
			title:"内部零件名称",
			field:"partName"
		}
		,
		{
			title:"内部零件个数",
			field:"number"
		},
		{
			title:"维修时间",
			field:"time"
		}
		]
	});
});

var path="";
function fixlgTitle(title){
	$("#fixlgTitle").text(title);
}

function addfixlg(){
	$("#fixlgForm")[0].reset();
	path="http://127.0.0.1:8080/buses/addfix.do";
	$("#fixlgModal").modal("show");
	$("#id").attr("readonly","readonly");
	fixlgTitle("添加维修信息");
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
     $.ajax({
    	url:"http://127.0.0.1:8080/buses/allinfo.do",
        dataType:"json",
        success:function(rs){
        	$("#driverid").empty();
        	$.each(rs,function(i,n){
        		$("#driverid").append("<option value='"+n.id+"'>"+n.name+"</option>");
        	});
        }
    });
    $.ajax({
    	url:"http://127.0.0.1:8080/buses/allstock.do",
        dataType:"json",
        success:function(rs){
        	$("#partName").empty();
        	$.each(rs,function(i,n){
        		$("#partName").append("<option value='"+n.partName+"'>"+n.partName+"</option>");
        	});
        }
    });
}

function delfixlg(){
	var arr=$("#fixlgTb").bootstrapTable("getSelections");
	if (arr.length!=1) {
		alert("请选中一行！");
	} else{
		if(confirm("是否删除")){
		$.ajax({
			url:"http://127.0.0.1:8080/buses/delfix.do",
		    data:{"id":arr[0].id},
		    dataType:"json",
		    success:function(rs){
		    	if(rs.isFlag){
		    		//成功，将模态框隐藏，提示信息，并刷新表格
		    		$("#fixlgTb").bootstrapTable("refresh");
		    		alert(rs.msg);
		    	}else{
		    		alert(rs.msg);
		    	}
		    }
		});
		}
	}
}

function secfixlg(){
	path="http://127.0.0.1:8080/buses/upfix.do";
	var arr=$("#fixlgTb").bootstrapTable("getSelections");
	if (arr.length!=1) {
		alert("请选中一行！");
	} else{
		fixlgTitle("修改维修信息");
		$("#fixlgModal").modal("show");
		$("#id").val(arr[0].id);
		$("#id").attr("readonly","readonly");
		$("#bid").val(arr[0].bid);
		$("#driverid").val(arr[0].driverid);
		$("#place").val(arr[0].place);
		$("#cost").val(arr[0].cost);
		$("#partName").val(arr[0].partName);
		$("#number").val(arr[0].number);
		$("#time").val(arr[0].time);
	}$.ajax({
    	url:"http://127.0.0.1:8080/buses/allbus.do",
        dataType:"json",
        success:function(rs){
        	$("#bid").empty();
        	$.each(rs,function(i,n){
        		$("#bid").append("<option value='"+n.id+"'>"+n.id+"</option>");
        	});
        }
    });
     $.ajax({
    	url:"http://127.0.0.1:8080/buses/allinfo.do",
        dataType:"json",
        success:function(rs){
        	$("#driverid").empty();
        	$.each(rs,function(i,n){
        		$("#driverid").append("<option value='"+n.id+"'>"+n.name+"</option>");
        	});
        }
    });
    $.ajax({
    	url:"http://127.0.0.1:8080/buses/allstock.do",
        dataType:"json",
        success:function(rs){
        	$("#partName").empty();
        	$.each(rs,function(i,n){
        		$("#partName").append("<option value='"+n.partName+"'>"+n.partName+"</option>");
        	});
        }
    });
}
function sub(){
	console.info($("#fixlgForm").serialize());
	$.ajax({
		url:path,
		data:$("#fixlgForm").serialize(),
	    dataType:"json",
	    success:function(rs){
	    	console.info(rs);
	    	if(rs.isFlag){
	    		//成功，将模态框隐藏，提示信息，并刷新表格
	    		$("#fixlgModal").modal("hide");
	    		$("#fixlgTb").bootstrapTable("refresh");
	    		alert(rs.msg);
	    	}else{
	    		alert(rs.msg);
	    	}
	    }
	});	
}