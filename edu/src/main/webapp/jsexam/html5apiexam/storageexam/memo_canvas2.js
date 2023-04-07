var device;
var drawing = false;
var canvas;
var context;
var rect;
var drawColor="black";
function setColor(color) {
	drawColor = color;	
}
function initialize() {/*초기 상태*/
    context.clearRect(0,0,580,450);
    context.beginPath();
    context.rect(0,0,580,450);
    context.strokeStyle = "silver";
    context.fillStyle = "LightGoldenrodYellow";
    context.fill();
    context.lineWidth = 0.5;
    for(i=1;i<=8;i++) {
        context.moveTo(5,i*50);
        context.lineTo(575, i*50);
    }
    context.stroke();
}
function startDrawing(e) {
    drawing = true;
    context.beginPath();
    context.strokeStyle = drawColor;
    context.lineWidth = 1;
    context.arc(e.clientX - rect.left, e.clientY - rect.top, 3, 0, 2*Math.PI)
    context.stroke();
    context.fillStyle = drawColor;
    context.fill();
    context.closePath();

    context.beginPath();
    context.moveTo(e.clientX - rect.left, e.clientY - rect.top);
    context.lineCap = "round";
    context.lineWidth = 6;
}

function keepDrawing(e) {
    if (drawing) {
        var x,y;
        if (device == "mobileDevice") {
            x = e.targetTouches[0].pageX;
            y = e.targetTouches[0].pageY;
        }
        else {
            x = e.clientX;
            y = e.clientY;
        }
        context.lineTo(x - rect.left, y - rect.top);
        context.stroke();
    }
}

function stopDrawing() {
    if (drawing) {
        context.stroke();
        drawing = false;
    }
}

function save() {/*저장*/
   	alert(canvas.toDataURL());
   	window.localStorage.setItem("memocanvas", canvas.toDataURL());
}

function restore() {/*저장된 값 불러오기?*/
   const img = new Image();/*비어있는 이미지 객체 만들고*/
   img.src = window.localStorage.memocanvas;/*src에 */
   img.onload = function() {/* 이미지 객체에 로드이벤트 끝난 후에 데이터 uri 형식을 draw하겠다 */
        context.drawImage(img, 0, 0);
   }    
}

function getDeviceType() {
    const str = navigator.userAgent;
    if (str.match(/(ipad)|(iphone)|(ipod)|(android)|(webos)/i))
        device = "mobileDevice";
    else
        device = "desktopPC";
}

function startMemo() {
    canvas = document.getElementById("myCanvas");
    context = canvas.getContext("2d"); 
    rect = canvas.getBoundingClientRect();
    initialize();
}

getDeviceType();
document.body.onload = startMemo;

dom = document.getElementById("myCanvas");

//for mobile devices
if (device == "mobileDevice") {
	dom.ontouchstart = startDrawing;
	dom.ontouchmove = keepDrawing;
	dom.ontouchend = stopDrawing;
} else {
	// for desktop PC
	dom.onmousedown = startDrawing;
	dom.onmousemove = keepDrawing;
	dom.onmouseup = stopDrawing;
}



