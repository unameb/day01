$(document).ready(function(){
	$.ajax({
		url:"http://127.0.0.1:8080/buses/main.do",
		dataType:"json",
		success:function(rs){
			$.each(rs, function(i,n) {
				$("#menu").append("<div class='panel panel-primary'><div class='panel-heading' data-toggle='collapse'  data-parent='#menu' data-target='#m"+n.id+"'>"+n.title+"<span class='glyphicon glyphicon-triangle-bottom'></span></div><div id='m"+n.id+"' class='panel-body collapse'></div></div>");
			      
			      $("div[data-target='#m"+n.id+"']").click(function(){
			      	$.ajax({
			      	url:"http://127.0.0.1:8080/buses/sub.do",
			      	data:{"pid":n.id},
			      	dataType:"json",
			      	success:function(dt){
			      		$("#m"+n.id).empty();
			      		 $.each(dt,function(j,z){
			      		 	$("#m"+n.id).append("<a href=\"javascript:addPags('"+z.path+"')\"><span class='"+z.icon+"'></span>"+z.title+"</a>")
			      		 });
			      	}
			      });
			      });
			});
		}
	});
	changeImg();
	
});

function sub(){
	$.ajax({
		url:"http://127.0.0.1:8080/buses/change.do",
		data:$("#change").serialize(),
	    type:"Post",
	    dataType:"json",
	    success:function(rs){
	    	if(rs.isFlag){
	    		//成功，将模态框隐藏，提示信息，并刷新表格
	    		$('#adminModal').modal("hide");
	    		alert(rs.msg);
	    	}else{
	    		alert(rs.msg);
	    	}
	    }
	});	
}
var i=1;
function changeImg(){
	if (i==6) {
		i=1;
	}
	$("#right").html("<img src='../img/0"+i+".jpg' width='1100px' height='600px'/>");
	$("#right").append("<a class='left carousel-control' href=\"javascript:changeImg('"+i+"')\"><span class='glyphicon glyphicon-chevron-left' ></span></a>");
	$("#right").append("<a class='right carousel-control' href=\"javascript:changeImg('"+i+"')\"><span class='glyphicon glyphicon-chevron-right' ></span></a>");
	i++;
}

function addPags(path){
	$.ajax({
		url:path,
		dataType:"html",
		success:function(res){
			$("#right").html(res);
		}
	});
}
/*图标变化*/
$(document).on("show.bs.collapse hide.bs.collapse",".collapse",function(event){
	$(this).prev().find(".glyphicon").toggleClass("glyphicon-triangle-bottom glyphicon-triangle-top");
});
/*修改管理员信息*/
function adminSec(){
	$("#adminModal").modal("show");
}
/*退出系统*/
function close(){
	var userAgent = navigator.userAgent;
    if (userAgent.indexOf("Firefox") != -1 || userAgent.indexOf("Chrome") !=-1) {
   window.location.href="about:blank";
    } else {
   window.opener = null;
   window.open("", "_self");
   window.close();
}
}

