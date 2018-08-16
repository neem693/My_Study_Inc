<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<title>목록보기</title>
<link rel="stylesheet" href="../css/style.css" type="text/css">

<meta http-equiv="Content-Type" content="text/html;">
<style type="text/css">
.title {
	cursor: pointer;
}
</style>
<script src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
	function insert_form() {

		if ('${empty user}' == 'true') {
			if (confirm('글쓰기는 로그인 하신후에 가능합니다.\n 로그인 하시겠습니까?') == false)
				return;

			location.href = '../member/login_form.do';
			return;
		}

		//로그인 상태면.. 글쓰기 폼 띄우기
		location.href = 'insert_form.do';
	};

	$(document).ready(function() {

		var fail = '${param.fail}';
		if (fail == null) {
			return;
		} else if (fail == 'empty user') {
			alert("잘못된 접근: 로그인이 잘못됨");
			return;
		} else if (fail == 'deleted') {
			alert("잘못된 접근: 삭제된 게시물입니다.");
		}
		var search = $("#search");
		var text = $("#text");
		var search_param = '${param.search}';
		var text_param = '${param.text}';

		if (search_param != '') {
			search.val(search_param);
			text.val(text_param);
			var views = $(".view");
			for(var i =0; i<views.length;i++){
				var href = views.eq(i).attr("href");
				views.eq(i).attr("href",href + "&search="+search_param + "&text=" + text_param);
			}
		}
	});
	function search_text(f) {
		f.action = "list.do";
		f.submit();
	}
</script>


</head>

<body>

	<div style="width: 700px; margin: auto; text-align: right;">

		<c:if test="${empty user }">
			<input type="button" value="로그인"
				onclick="location.href ='${pageContext.request.contextPath}/member/login_form.do?page=${(empty param.page)?1:param.page}'">
		</c:if>

		<c:if test="${not empty user}">
${user.name}(${user.id})님 환영합니다.
			<input type="button" value="로그아웃"
				onclick="location.href ='${pageContext.request.contextPath}/member/logout.do?page=${param.page }'">
		</c:if>

	</div>

	<!--로케이션 & 로그인끝-->
	<!--타이틀 영역-->
	<form>
		<table width="700" align="center">
			<tr>
				<td>
					<table width="690" height="50" border="0" cellpadding="0"
						cellspacing="0">
						<tr>
							<td><img src="../img/title_04.gif" class="title"
								onclick="location.href = 'list.do'"></td>
						</tr>
					</table> <!--타이틀 영역--끝-->
				</td>
			</tr>
			<tr>
				<td>
					<!--LIST START-->
					<table width="690" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td>
								<table width="690" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td width="50" class="td_a">번호</td>
										<td width="2" class="td_b"><img src="../img/td_bg_01.gif"></td>
										<td class="td_b" width="300">제목</td>
										<td width="2" class="td_b"><img src="../img/td_bg_01.gif"></td>
										<td width="90" class="td_b">작성자</td>
										<td width="2" class="td_b"><img src="../img/td_bg_01.gif"></td>

										<td width="90" class="td_b">작성일</td>
										<td width="2" class="td_b"><img src="../img/td_bg_01.gif"></td>
										<td width="60" class="td_c">조회수</td>
									</tr>
									<c:forEach var="b" items="${list}">
										<tr>
											<td align="center" class="td_a_1">${b.idx }</td>
											<td class="td_b_1"><img src="../img/td_bg_02.gif"></td>
											<c:choose>
												<c:when test="${ b.del eq 0}">
													<td class="td_b_1 left">
														<!-- 들여쓰기 --> <c:forEach begin="1" end="${b.depth}">
										&nbsp;
										</c:forEach> <c:if test="${b.depth != 0}">
										ㄴ</c:if> <a class = "view"
														href="board_view.do?idx=${b.idx}&page=${(empty param.page)?1:param.page}"
														title="${b.subject}" class="num">${b.subject }<c:if
																test="${not (b.c_count eq 0)}">(${b.c_count})</c:if></a>
													</td>


													<td class="td_b_1"><img src="../img/td_bg_02.gif"></td>

													<td align="center" class="td_b_1">${b.name }</td>
												</c:when>
												<c:when test="${ b.del eq 1}">
													<td colspan="3" class="td_b_1 left">
														<!-- 들여쓰기 --> <c:forEach begin="1" end="${b.depth}">&nbsp;</c:forEach>
														<c:if test="${b.depth != 0}">ㄴ</c:if> 이 글은 작성자에 의해
														삭제되었습니다.
													</td>
												</c:when>
											</c:choose>
											<td class="td_b_1"><img src="../img/td_bg_02.gif"></td>

											<td align="center" class="td_b_1">${b.regdate}</td>

											<td class="td_b_1"><img src="../img/td_bg_02.gif"></td>

											<td align="center" class="td_c_1">${b.readhit }</td>
										</tr>
									</c:forEach>
									<c:if test="${empty list }">

										<tr>
											<td align="center" colspan="11" width="100%" height="50"
												style="border: 1 solid #efefef">현재 등록된 글이 없습니다.</td>
										</tr>
									</c:if>
								</table>
							</td>
						</tr>
						<tr>
							<td height="8"></td>
						</tr>
						<tr>
							<td>

								<table width="690" border="0" cellpadding="0" cellspacing="0"
									bgcolor="#F1F5F4">
									<tr>
										<td width="7"><img src="../img/search_bg_01.gif"></td>
										<td class="f11" align="center">${pageMenu}<%-- <c:forEach var="c" items="${count}"></c:forEach>
									<a href ="?page=1">1</a>&nbsp; --%>
										</td>
									</tr>
									<tr>
										<td width="7"><img src="../img/search_bg_01.gif"></td>

										<td class="f11" align="center"><select id="search"
											name="search">
												<option selected="selected" value="name">이름</option>
												<option value="subject">제목</option>
												<option value="content">내용</option>
												<option value="name_subject_content">이름+제목 +내용</option>
										</select> <input name="text" id="text"> <input type="button"
											value="검색" onclick="search_text(this.form)"></td>

									</tr>
								</table>

							</td>
						</tr>
						<tr>
							<td height="5"></td>
						</tr>
						<tr>
							<td><img src="../img/btn_reg.gif" onClick="insert_form()"
								style="cursor: pointer;"></td>
						</tr>

					</table> <!--WRITE,MODIFY,REPLY END-->
				</td>
			</tr>
		</table>
	</form>
</body>

</html>