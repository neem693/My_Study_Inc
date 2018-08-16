/**
 * 
 */

var ball_x, ball_y, ball_radius;
var ctx;
var count = 5;
var interval_timer, timer;
var WIDTH;
var HEIGHT;
var bRight = true, bDown = true;
var radgrad;
var pan_x,pan_y,pan_length=150;
var is_mouse_move_evt_work = false;
var x_speed=5,y_speed=5;
var COUNT =100, count=COUNT;
var round1=[],round2=[];
var ball_img = new Image();
ball_img.src = "image/images.png";



function Block(x,y,w,h,show,color)
{
	this.x =x;
	this.y= y;
	this.w =w;
	this.h = h;
	this.show = show;
	this.color = color;

}
// Block 클래스의 멤버함수 등록 : prototype 방식으로 처리
Block.prototype.call = function(){
	alert('call:' + this.color);
}

var block = new Block(0,0,1,2,true,"red");
block.call();

var block_array = new Array();


	var myfunc = {
		kor : function() {
			alert('안녕하세요');
		},
		eng : function() {
			alert('Hi! Everyone!!');
		}
	};
	

	
	// 마우스 이벤트
	window.onmousedown = function(event){
		// 클릭된 좌표
		var x = event.offsetX;
		var y = event.offsetY;
		
		// console.log("(" + x + "," + y + ")");
		
		/*
		 * var row = parseInt(y/block_h);//행 var col = parseInt(x/block_w); //열
		 * console.log(row + " " + col);
		 * 
		 * var block = block_array[row][col]; block.show =false;
		 */
	}

	
	window.onload = function init() {
		alert("load완료");

		var canvas = document.getElementById("my_canvas");
		WIDTH = canvas.width;
		HEIGHT = canvas.height;

		ball_x = WIDTH / 2;
		ball_y = HEIGHT / 2;
		ball_radius = 10;
		pan_x = WIDTH/2 - pan_length;
		pan_y = parseInt(HEIGHT * 5/6);

		ctx = canvas.getContext("2d");
		ctx.fillStyle = "black";
		ctx.fillRect(0, 0, WIDTH, HEIGHT);
		draw_ball();
		draw_pan();
		// timer = setTimeout("process();",100); //회만 호출한다.
		
		init_block();
		
	};
	
	var block_w =100, block_h =40;
	
	function init_block(){
		make_round();
		var colors = [ "red" ,"green","blue","yellow","cyan","magenta","pink"];
		var index =0;
		for(var i =0;i<4;i++){
			var block_arr = new Array();// 1차원배열
			for(var k=0;k<10;k++){
				var block = new Block(k*block_w,i*block_h,block_w,block_h,true,colors[index]);
				if(round1[i][k]=='*'){
					block.show = false;
				}
				block_arr[k] = block;
				index ++;
				if(index>6)index =0;
			}
			block_array[i] = block_arr;
		}
	}
	
	
	
	window.onkeydown= function(e){
		console.log(e.keyCode);
	};
	
	
	
	function process() {
		// console.log("냠냠");
		/*
		 * count--; if (count < 0) clearInterval(interval_timer);
		 */
		if(is_mouse_move_evt_work==false){
			window.onmousemove = function(event){
				pan_x = event.offsetX;
				if(pan_x<0 )
					pan_x = 0;
				else if((pan_x + pan_length)>WIDTH)
					pan_x = WIDTH-pan_length;
				console.log(pan_x);
				
				
			}
			is_mouse_move_evt_work = true;
		}
		move_ball();
		check_block();
		check_pan();
		draw();
	};
	 
	function check_pan(){
		var down = ball_y + ball_radius;
		var x = ball_x;
		
		if(pan_y<=down && x>= pan_x &&x<=(pan_x + pan_length*1/3)){
			bDown = false;
			bRight = false;
			x_speed = 10;
			console.log("왼쪽");
		}
		if(pan_y<=down && x>= (pan_x + pan_length*(1/3)) &&x<=(pan_x + pan_length*2/3)){
			bDown = false;
			x_speed = 0;
			y_speed = 8;

			console.log("중간");
		}
		if(pan_y<=down && x>= (pan_x + pan_length*(2/3)) &&x<=(pan_x + pan_length)){
			bDown = false;
			bRight = true;
			x_speed = 10;
			console.log("오른쪽");
		}
		
		
		
		
		
		
	}
	function check_block(){
		if((ball_y-ball_radius) >= (block_array.length*block_h))
			return;
		// 공기 윗쪽으로 이동시
		collision_ball_top();
		collision_ball_left();
		collision_ball_right();
		collision_ball_down();

		} 
	
	function collision_ball_top(){
		
		var top = ball_y-ball_radius;
		var col = parseInt(ball_x/block_w);
		var row = parseInt(top/block_h);
		
		if(row<0 || row>= block_array.length) return;
		if(col<0 || col >= block_array[0].length) return;
		
		var block = block_array[row][col];
		
		if(block.show == false) return;
		
		block.show = false;
		bDown = true;
	}
	
	function collision_ball_left(){
		var left = ball_x - ball_radius;
		var col = parseInt(left/block_w);
		var row = parseInt(ball_y/block_h);
		
		if(row<0 || row>= block_array.length) return;
		if(col<0 || col >= block_array[0].length) return;
		
		var block = block_array[row][col];
		
		if(block.show == false) return;
		
		block.show = false;
		bRight = true;
	}
	
	function collision_ball_right(){
		var right = ball_x + ball_radius;
		var col = parseInt(right/block_w);
		var row = parseInt(ball_y/block_h);
		
		if(row<0 || row>= block_array.length) return;
		if(col<0 || col >= block_array[0].length) return;
		
		var block = block_array[row][col];
		
		if(block.show == false) return;
		
		block.show = false;
		bRight = false;
	}
	function collision_ball_down(){
		
		var down = ball_y + ball_radius;
		var col = parseInt(ball_x/block_w);
		var row = parseInt(down/block_h);
		
		if(row<0 || row>= block_array.length) return;
		if(col<0 || col >= block_array[0].length) return;
		
		var block = block_array[row][col];
		
		if(block.show == false) return;
		
		block.show = false;
		bDown = false;
	}
		
	
	
	function move_ball() {
		
		if (bRight)
			ball_x += x_speed;
		else
			ball_x -= x_speed;

		if (bDown)
			ball_y += y_speed;
		else
			ball_y -= y_speed;

		if ((ball_x - ball_radius) < 0) {
			bRight = true;
		}
		if ((ball_x + ball_radius) > WIDTH) {
			bRight = false;
		}

		if ((ball_y - ball_radius) < 0) {
			bDown = true;
		}
		if ((ball_y + ball_radius) > HEIGHT) {
			bDown = false;
		}
		
		if(x_speed>5 && count ==0){
			x_speed--;
		}
		if(y_speed>5 && count ==0){
			y_speed--;
		}
		if(x_speed<5 && count ==0){
			x_speed++;
		}
		if(count<0){
			count =COUNT;
		}else
			count--;

	}
	function draw() {
		// ctx.clearRect(0,0,WIDTH,HEIGHT);
		ctx.fillStyle = "black";
		ctx.fillRect(0, 0, WIDTH, HEIGHT);
		draw_ball();
		draw_block();
		draw_pan();
	}
	function draw_pan(){
		ctx.fillStyle = 'yellow';
		ctx.fillRect(pan_x,pan_y,pan_length,3);
	}
	
	function draw_block(){
		for(var i=0;i<block_array.length;i++){	
			for(var k =0;k<block_array[i].length;k++){
				var block = block_array[i][k];
				if(block.show == true){
					// 블록그리기
					ctx.fillStyle = block.color;
					ctx.fillRect(block.x,block.y,block.w,block.h);
				}
			}
		}
	}
	function draw_ball() {
//		radgrad = ctx.createRadialGradient(ball_x, ball_y, ball_radius* 1/ 10,
//				ball_x - 5, ball_y - 5, ball_radius);
//		radgrad.addColorStop(0, 'white');
//		radgrad.addColorStop(1, 'red');
//		ctx.fillStyle = radgrad;
		// ctx.fillStyle = "red";//그리기 (채우기)속성
		ctx.beginPath();
		ctx.drawImage(ball_img,ball_x-ball_radius,ball_y-ball_radius,ball_radius*2,ball_radius*2);
//		ctx.arc(ball_x, ball_y, ball_radius, 0, Math.PI / 180 * 360, true);
//		ctx.fill();
//		ctx.fillStyle = 'black';
/*
 * ctx.beginPath(); ctx.arc(ball_x, ball_y, 1, 0, Math.PI / 180 * 360, true);
 * ctx.fill(); ctx.arc(ball_x,ball_y-ball_radius,1,0,Math.PI / 180 * 360, true);
 * ctx.fill();
 */
	};
	function start_stop(button) {
		if (interval_timer == null) {
			interval_timer = setInterval("process();", 10);
			button.value = "Stop";
		} else {
			button.value = "Start";
			clearInterval(interval_timer);
			interval_timer = null;
		}
	}
	function change_direction(button) {
		switch (button.value) {
		case "Left":
			bRight = false;
			break;
		case "Right":
			bRight = true;
			break;
		case "Up":
			bDown = false;
			break;
		case "Down":
			bDown = true;
			break;
		case "Plus":
			ball_radius += 5;
			break;
		case "Minus":
			ball_radius -= 5;
			break;
		}
};


function make_round(){

	for(var k =0; k<4;k++){
		var block = [];
	for(var i =0; i<10;i++){
		if(i==0||i==4||i==5||i==9)
			block.push('*');
		else
			block.push('-');
		}
	round1[k] = block;
	}
};
	