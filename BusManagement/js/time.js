function clock(){
	var myDate=new Date();
	var year=myDate.getFullYear();
	var month=myDate.getMonth();
	var dt=myDate.getDate();
	var weekday=myDate.getDay();
	var hour=myDate.getHours();
	var min=myDate.getMinutes();
	var sec=myDate.getSeconds();
	
	switch (weekday){
		case 0:weekday="星期天";
			   break;
	    case 1:weekday="星期一";
			   break;
	    case 2:weekday="星期二";
			   break;
		case 3:weekday="星期三";
			   break;
		case 4:weekday="星期四";
			   break;
		case 5:weekday="星期五";
			   break;
		case 6:weekday="星期六";
			   break;
		}	   
		document.getElementById("year").innerHTML=year+"年" ;
		document.getElementById("month").innerHTML=month+1+"月";
		document.getElementById("dt").innerHTML=dt+"日";
		document.getElementById("weekday").innerHTML=weekday;
		document.getElementById("time").innerHTML=(hour>=10?hour:"0"+hour)+":"+(min>=10?min:"0"+min)+":"+(sec>=10?sec:"0"+sec);
		window.setTimeout("clock()",1000);
	
	
}
         window.onload=clock; 

