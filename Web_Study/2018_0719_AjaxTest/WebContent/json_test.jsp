<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
var p  = {'name' : '일길동','age':30,'tel':'010-111-2222'};

console.log('이름:' + p.name);
console.log('나이:' + p.age);
console.log('전화:' + p['tel']);

var sido_array = ['서울','경기','인천'];
console.log('sido_array length=' + sido_array.length);
for(x in sido_array	){
	console.log(sido_array[x]);
}

var p_array= [
	{name :'일길동','age':31,'tel': '010-111-2222'},
	{'name' :'이길동','age':32,'tel': '010-211-2222'},
	{'name' :'삼길동','age':33,'tel': '010-311-2222'}
];
for(x in p_array	){
	console.log(p_array[x]);
	var pp = p_array[x];
	console.log(pp.name,pp.age,pp.tel);
}

</script>
</head>
<body>

</body>
</html>