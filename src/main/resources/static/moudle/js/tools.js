//获取时间函数
function time1(){
    var today = new Date();
    var year = today.getFullYear();
    var month = today.getMonth()+1;
    var day = today.getDay();
    var hour = today.getHours();
    var minute = today.getMinutes();
    var second = today.getSeconds();

    minute = checkTime(minute);
    second = checkTime(second);

    document.getElementById("time").innerHTML =
        year+"年"+month+"月"+day+"日 "+hour+":"+minute+":"+second;
    t = setTimeout("time1()",500);
}
//调整时间格式
function checkTime(i) {
    if(i<10){
        i="0"+i;
    }
    return i;
}


//获取时间函数
function getTime(){
  var today = new Date();
  var year = today.getFullYear();
  var month = today.getMonth()+1;
  var day = today.getDay();
  var hour = today.getHours();
  var minute = today.getMinutes();
  var second = today.getSeconds();

  minute = checkTime(minute);
  second = checkTime(second);

  return year+"年"+month+"月"+day+"日 "+hour+":"+minute+":"+second;
}
//取随机数
function getX(){
	return Math.floor(Math.random()*20+1);
}