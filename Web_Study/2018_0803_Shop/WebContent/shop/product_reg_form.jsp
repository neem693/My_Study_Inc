<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="${pageContext.request.contextPath}/js/reg_exp.js"></script>
<script type="text/javascript">

function checkdata(f)
{
   category = f.category.value;
   p_num = f.p_num.value;
   p_name = f.p_name.value;
   p_company = f.p_company.value;
   p_price = f.p_price.value;
   p_saleprice = f.p_saleprice.value;
   p_content = f.p_content.value;
   p_image_s = f.p_image_s.value;
   p_image_l = f.p_image_l.value;
   if(category == ""){
	   alert("카테고리를 선택하라");
	   p.category.focus;
	   return;
   }
  if(p_num == ""){
	  alert("제품번호를 입력하세요.");
	  f.p_num.focus();
	  return;
  }

  if(p_name == ""){
	  alert("제품이름을 입력하세요.");
	  f.p_name.focus();
	  return;
  }

  if(p_company == ""){
	  alert("제품번호를 입력하세요.");
	  f.p_company.focus();
	  return;
  }

  if(p_price == ""||!reg_num.test(p_price)){
	  alert("제품 가격은 오직 3자리 숫자이상만 입력할 수 있습니다. 다시입력해 주세요.");
	  f.p_price.focus();
	  return;
  }

  if(p_saleprice == ""||!reg_num.test(p_saleprice)){
	  alert("제품 세일가격은 오직3자리 숫자이상만 입력할 수 있습니다. 다시 입력해 주세요.");
	  f.p_saleprice.focus();
	  return;
  }

  if(p_content == ""){
	  alert("제품설명을 입력하세요.");
	  f.p_content.focus();
	  return;
  }

  if(p_image_s == ""){
	  alert("제품 작은사진의 파일을 입력하세요");
	  return;
  }

  if(p_image_l == ""){
	  alert("제품 큰 사진의 파일을 입력하세요");
	  return;
  }
   f.submit();
   
}
</script>
</head>
<body>

<!-- title -->
<jsp:include page="index.jsp"/>
<form name="f" method="post" action="insert.do" 
      enctype="multipart/form-data"> 
<table align="center" width="600" border="1" 
    style="border-collapse:collapse;font-size:8pt" bordercolor="navy"
    cellpadding="2" cellspacing="0">
    <tr>
        <td>제품Category</td>
        <td><select name="category">
        		<option value="">카테고리 선택</option>
        		<option value="com001">컴퓨터</option>
        		<option value="ele002">가전제품</option>
        		<option value="sp003">스포츠</option>
        </select></td>
    </tr>
    <tr>
        <td>제품번호</td>
        <td><input name="p_num" type="text" ></td>
    </tr>
    <tr>
        <td>제품이름</td>
        <td><input name="p_name" type="text" ></td>
    </tr>
    <tr>
        <td>제품 판매사</td>
        <td><input name="p_company" type="text" ></td>
    </tr>
    <tr>
        <td>제품가격</td>
        <td><input name="p_price" type="text" ></td>
    </tr>
    <tr>
        <td>제품할인가격</td>
        <td><input name="p_saleprice" type="text" ></td>
    </tr>    
    <tr>
        <td>제품설명</td>
        <td><TEXTAREA name="p_content" rows="5" cols="50"></TEXTAREA></td>
    </tr>
    <tr>
        <td>제품사진(작은사진)</td>
        <td><input type="file" name="p_image_s">
    </tr>
    <tr>
        <td>제품사진(큰사진)</td>
        <td><input type="file" name="p_image_l">
    </tr>
    <tr>
        <td colspan="2" align="center">
            <input type="button" value="등록" 
            onclick="javascript:checkdata(this.form);" >
            <input type="reset" value="Clear" >
        </td>
    </tr>    
</table>
</form>
</body>
</html>