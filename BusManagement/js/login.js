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
function login(){
	 $.ajax({
	 	url:"http://127.0.0.1:8080/buses/lg.do",
	 	data:$("#lg").serialize(),
	 	dataType:"json",
	 	success:function(rs){
	 		if(rs.isFlag){
	 			window.location="main.html";
	 		}else{
	 			alert(rs.msg);
	 		}
	 	}
	 	
	 });
}
