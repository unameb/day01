$(document).ready(function(){
	$("#infoTb").bootstrapTable({
		url:"http://127.0.0.1:8080/buses/allinfo.do",
		pagination:true,
		pageSize:4,
		pageNumber:1,
		pageList:[4,6,"ALL"],
		search:true,
		toolbar:"#tools",
		columns:[
		{radio:true},
		{
			title:"编号",
			field:"id"
		},
		{
			title:"姓名",
			field:"name"
		},
		{
			title:"性别",
			field:"sex",
		    formatter:function(value,row,index){
		    	if (value==0) {
		    		return "女";
		    	} else{
		    		return "男";
		    	}
		    }
		},
		{
			title:"年龄",
			field:"age"
		},
		{
			title:"电话",
			field:"tel"
		}
		]
	});
});
function delInfo(){
	var arr=$("#infoTb").bootstrapTable("getSelections");
	if (arr.length!=1) {
		alert("请选择一行");
	} else{
	  if(confirm("是否删除")){
		$.ajax({
			url:"http://127.0.0.1:8080/buses/delinfo.do",
		    data:{"id":arr[0].id},
		    dataType:"json",
		    success:function(rs){
		    	if(rs.isFlag){
		    		//成功，将模态框隐藏，提示信息，并刷新表格
		    	$("#infoTb").bootstrapTable("refresh");
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
	$("#infoTitle").text(title);
}
/*添加*/
function addInfo(){
	//设置目标地址
	 path="http://127.0.0.1:8080/buses/addinfo.do";
	//添加标题
	addTitle("添加人员信息");
	//调用模态框
	$("#infoModal").modal("show");
	//清空表单
	$("#infoForm")[0].reset();
}
//修改
function selectInfo(){
	//设置目标地址
	 path="http://127.0.0.1:8080/buses/upinfo.do";
	//添加标题
	addTitle("修改人员信息");
	var arr=$("#infoTb").bootstrapTable("getSelections");
	if (arr.length!==1) {
		alert("请选择一行！");
		return;
	} else{
		//调用模态框
		$("#infoModal").modal("show");
		$("#id").val(arr[0].id);
		$("#name").val(arr[0].name);
		$("input[value='"+arr[0].sex+"']").attr("checked","checked");
		$("#age").val(arr[0].age);
		$("#tel").val(arr[0].tel);
		
	}
}

function sub(){
	var infoid=document.getElementById("id").value;
	var infoname=document.getElementById("name").value;
	var infosex=document.getElementById("sex").value;
	var infoage=document.getElementById("age").value;
	var infotel=document.getElementById("tel").value;
	if (infoid.length==0) {
		alert("编号不能为空");
	}
	if (infoname.length==0) {
		alert("姓名不能为空");
	}
	if (infosex.length==0) {
		alert("性别不能为空");
	}
	if (infoage.length==0) {
		alert("年龄不能为空");
	}
	if (infotel.length==0) {
		alert("电话不能为空");
	}
	console.info($("#infoForm").serialize());
	$.ajax({
		url:path,
		data:$("#infoForm").serialize(),
	    type:"Post",
	    dataType:"json",
	    success:function(rs){
	    	if(rs.isFlag){
	    		//成功，将模态框隐藏，提示信息，并刷新表格
	    		$('#infoModal').modal("hide");
	    		$("#infoTb").bootstrapTable("refresh");
	    		alert(rs.msg);
	    	}else{
	    		alert(rs.msg);
	    	}
	    }
	});	
	
	
}
