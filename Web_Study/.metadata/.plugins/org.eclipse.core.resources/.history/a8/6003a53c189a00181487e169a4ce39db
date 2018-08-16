<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<HTML>
<HEAD>
<link rel="stylesheet" href="../css/style.css" type="text/css">
<script language="JavaScript">
	function del(){
		if(confirm("삭제 하시겠습니까?")){
			
            document.f.action = "board_del.jsp";

            document.f.submit();

        }
	}
	function modify(){
		
        document.f.action = "board_modify.jsp";

        document.f.submit();

    }
	function reply(){

        document.f.action = "board_reply.jsp";

        document.f.submit();

    }
</script>
</HEAD>

<BODY>
<table width="690" height="50" border="0" cellpadding="0" cellspacing="0">
	<tr>
		<td><img src="../img/title_04.gif"></td>
	</tr>
</table>

<form name="f" method="post">
<table width="690" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td width="120" height="25" class="td_d">제목</td>
		<td class="td_d_1">${vo.subject }</td>
	</tr>
	<tr>
		<td width="120" height="25" class="td_d_4">작성자</td>
		<td class="td_d_2">${vo.name }</td>
	</tr>
	<tr>
		<td width="120" height="25" class="td_d_4">작성일</td>
		<td class="td_d_2">${vo.regdate }</td>
	</tr>
	<tr>
		<td width="120" class="td_d_4">내용</td>
		<td class="td_d_3" width="570" 
style="word-wrap:break-word;word-break:break-all">
			<pre>${vo.content}</pre>
		</td>
	</tr>
</table>

<table width="690" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td height="5"></td>
	</tr>
	<tr>
		<td><img src="../img/btn_list.gif" onClick="javaScript:location.href='list.do'" style="cursor:pointer;">
		<img src="../img/btn_reply.gif" onClick="reply()" style="cursor:hand">

		<img src="../img/btn_modify.gif" onClick="modify()" style="cursor:hand">

		<img src="../img/btn_delete.gif" alt="답변 또는 댓글이 있을 경우 삭제가 되지 않습니다.">
<img src='../img/btn_delete.gif' onClick='del()' style='cursor:hand'>
		</td>
	</tr>
</table>
</form>

<p><br>


</BODY>
</HTML>