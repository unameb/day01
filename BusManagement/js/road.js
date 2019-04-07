$(document).ready(function(){
	$("#roadTb").bootstrapTable({
		url:"http://127.0.0.1:8080/buses/allroad.do",
		pagination:true,
		pageSize:5,
		pageNumber:1,
		pageList:[5,6,"ALL"],
		toolbar:"#tools",
		search:true,
		columns:[
		{radio:true},
		{  
			title:"路线编号",
			field:"id"
		},
		{  
			title:"路线名称",
			field:"name"
		},
		{  
			title:"起点站",
			field:"start"
		},
		{  
			title:"终点站",
			field:"end"
		},
		{  
			title:"路线长度",
			field:"length"
		},
		{  
			title:"发车时间",
			field:"stime"
		},
		{  
			title:"结束时间",
			field:"etime"
		},
		{  
			title:"票价",
			field:"sale"
		}
		
		]
	});
});
//全局变量，用来记录提交的目标地址
var path="";

function addTitle(title){
	$("#roadTitle").text(title);
}

function roadAdd(){
	//设置目标地址
	path="http://127.0.0.1:8080/buses/addroad.do";
	//获取模态框
	$("#roadModal").modal("show");
	//添加标题
	addTitle("添加新路线");
	//清空表单
	$("#id").removeAttr("readonly");
	$("#roadForm")[0].reset();
	
}

function roadDel(){
	
	var arr=$("#roadTb").bootstrapTable("getSelections");
	if (arr.length!=1) {
		alert("请选中一行！");
	} else{
		if(confirm("是否删除"))
		{
		$.ajax({
			url:"http://127.0.0.1:8080/buses/delroad.do",
		    data:{"id":arr[0].id},
		    dataType:"json",
		    success:function(rs){
		    	if(rs.isFlag){
		    		//成功，将模态框隐藏，提示信息，并刷新表格
		    			$("#roadTb").bootstrapTable("refresh");
		    		alert(rs.msg);
		    	
		    	}else{
		    		alert(rs.msg);
		    	}
		    }
		});
		}
	}
}

function roadSel(){
	//设置目标地址
	path="http://127.0.0.1:8080/buses/uproad.do";
	//添加标题
	addTitle("修改路线");
	
	var arr=$("#roadTb").bootstrapTable("getSelections");
	
	if (arr.length!=1) {
		alert("请选中一行！");
		return;
	} else{
		//获取模态框
	   $("#roadModal").modal("show");
		$("#id").val(arr[0].id);
		$("#name").val(arr[0].name);
		$("#start").val(arr[0].start);
		$("#end").val(arr[0].end);
		$("#length").val(arr[0].length);
		$("#stime").val(arr[0].stime);
		$("#etime").val(arr[0].etime);
		$("#sale").val(arr[0].sale);
		$("#id").attr("readonly","readonly");
	}
}
/*确定按钮*/
function sub(){
	var roadid=document.getElementById("id").value;
	var roadname=document.getElementById("name").value;
	var roadstart=document.getElementById("start").value;
	var roadend=document.getElementById("end").value;
	var roadlength=document.getElementById("length").value;
	var roadstime=document.getElementById("stime").value;
	var roadetime=document.getElementById("etime").value;
	var roadsale=document.getElementById("sale").value;
	if (roadid.length==0) {
		alert("路线编号不能为空");
	}
	if (roadname.length==0) {
		alert("路线名称不能为空");
	}
	if (roadstart.length==0) {
		alert("起点站不能为空");
	}
	if (roadend.length==0) {
		alert("终点站不能为空");
	}
	if (roadlength.length==0) {
		alert("线路总长不能为空");
	}
	if (roadstime.length==0) {
		alert("发车时间不能为空");
	}
	if (roadetime.length==0) {
		alert("结束时间不能为空");
	}if (roadsale.length==0) {
		alert("票价不能为空");
	}
	console.info($("#roadForm").serialize());
	$.ajax({
		url:path,
		data:$("#roadForm").serialize(),
	    type:"Post",
	    dataType:"json",
	    success:function(rs){
	    	if(rs.isFlag){
	    		//成功，将模态框隐藏，提示信息，并刷新表格
	    		$('#roadModal').modal("hide");
	    		$("#roadTb").bootstrapTable("refresh");
	    		alert(rs.msg);
	    	}else{
	    		alert(rs.msg);
	    	}
	    }
	});	
}
