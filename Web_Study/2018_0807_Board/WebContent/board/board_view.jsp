<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<HTML>
<HEAD>
<link rel="stylesheet" href="../css/style.css" type="text/css">
<script src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js"></script>
<script>
	function del(f) {
		if (confirm("삭제 하시겠습니까?")) {

			f.action = 'delete.do?page=${param.page}';
			alert(f.idx.value);
			f.submit();

		}
	}
	function modify(f) {

		f.action = "modify_form.do?page=${param.page}";

		f.submit();

	}
	function reply() {

		location.href = "reply_form.do?idx=${param.idx}&page=${(empty param.page)?1:param.page}";

	}
	function comment_send() {
		if ('${empty user}' == 'true') {

			if (confirm('댓글은 로그인 하신후에 사용가능합니다\n로그인 하시겠습니까?')) {
				location.href = '../member/login_form.do?url='
						+ encodeURIComponent(location.href);
				return;
			}

		}
		var id = '${user.id}';
		var b_idx = '${vo.idx}';
		var name = '${user.name}';
		var content = $('#content').val();
		if (content == '') {
			alert("댓글 내용을 입력하세요");
			$('#content').focus();
			return;
		}

		$.ajax({
			url : 'comment_insert.do',
			data : {
				'b_idx' : b_idx,
				'id' : id,
				'name' : name,
				'content' : content
			},
			success : function(data) {
				data = eval(data);
				alert(data[0].result);

				comment_list(1);
			}
		})

	}

	function comment_list(page) {
		var b_idx = '${vo.idx}';

		$.ajax({
			url : 'comment_list.do',
			data : {
				'b_idx' : '${vo.idx}',
				'page' : page
			},
			success : function(data) {
				$('#disp').html(data);
			}
		})

	}
	function login() {
		location.href = '../member/login_form.do?url='
				+ encodeURIComponent(location.href);
		return;
	}
	function del_re(idx) {
		if (confirm("정말 삭제하시겠습니까?") == false) {
			return;
		}

		$.ajax({
			url : 'comment_delete.do',
			data : {
				'idx' : idx
			},
			success : function(data) {
				alert(data);
				data = eval(data);

				if (data[0].result == "fail")
					alert("삭제실패");
				if (data[0].result == "success")
					alert("삭제성공");
				comment_list(1);
			}
		});

	}
	function search_text(f) {
		f.action = "list.do";
		f.submit();
	}
	$(document).ready(
			function() {
				comment_list(1);
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
					for (var i = 0; i < views.length; i++) {
						var href = views.eq(i).attr("href");
						views.eq(i).attr(
								"href",
								href + "&search=" + search_param + "&text="
										+ text_param);
					}
				}
			});
</script>
<style>
#comment_box, #comment_box * {
	margin: 0
}

#comment_box {
	clear: both;
	width: 700px;
	height: 100px;
	left: 600px;
	width: 700px;
}

#comment_input_box {
	width: 100%;
	height: 100px;
}

#comment_input_box>textarea {
	width: 80%;
	height: 100%;
	background-color: yellow;
	box-sizing: border-box;
	resize: none;
	color: black;
	font-weight: bold;
}

#comment_btn {
	box-sizing: border-box;
	height: 100%;
	float: right;
	width: 20%;
}

body {
	width: 50%;
	clear: both;
	margin: 0 auto;
}

footer {
	height: 500px;
}

.list {
	float: left;
}

.selected td .view {
	color: red;
	font-weight: bold;
}
</style>

</HEAD>

<BODY>


	<div style="width: 700px; margin: auto; text-align: right;">

		<c:if test="${empty user }">
			<input type="button" value="로그인" onclick="login()">
		</c:if>

		<c:if test="${not empty user}">
${user.name}(${user.id})님 환영합니다.
			<input type="button" value="로그아웃"
				onclick="location.href ='${pageContext.request.contextPath}/member/logout.do?page=${param.page }';">
		</c:if>

	</div>
	<table width="690" height="50" border="0" cellpadding="0"
		cellspacing="0">
		<tr>
			<td><input type="image" src="../img/title_04.gif"
				onclick="location.href ='list.do'"></td>
		</tr>
	</table>

	<form method="post">
		<input type="hidden" name="idx" value="${vo.idx}"> <input
			type="hidden" name="id" value="${vo.id}">
		<table width="690" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td width="120" height="25" class="td_d">제목</td>
				<td class="td_d_1">${vo.subject }</td>
			</tr>
			<tr>
				<td width="120" height="25" class="td_d_4">작성자</td>
				<td class="td_d_2">${vo.name }(${vo.id})</td>
			</tr>
			<tr>
				<td width="120" height="25" class="td_d_4">작성일</td>
				<td class="td_d_2">${vo.viewdate}</td>
			</tr>
			<tr>
				<td width="120" class="td_d_4">내용</td>
				<td class="td_d_3" width="570"
					style="word-wrap: break-word; word-break: break-all"><pre>${vo.content}</pre>
				</td>
			</tr>
		</table>

		<table width="690" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td height="5"></td>
			</tr>
			<tr>
				<td><input type="image" src="../img/btn_list.gif"
					onClick="location.href='list.do?page=${(empty param.page)?1:param.page}';return false;"
					style="cursor: pointer;"> <c:if test="${not empty user}">
						<input type="image" src="../img/btn_reply.gif"
							onClick="reply(); return false;" style="cursor: pointer">
					</c:if> <c:if test="${vo.id eq user.id}">
						<input type="image" src="../img/btn_modify.gif"
							onClick="modify(this.form); return false;"
							style="cursor: pointer">
						<input type="image" src='../img/btn_delete.gif'
							onClick='del(this.form); return false;' style='cursor: pointer'>
					</c:if></td>
			</tr>
		</table>
	</form>


	<div id="disp"></div>
	<div id="comment_box">
		<p>
			<c:if test="${not empty user.id}">작성자: ${user.name}(${user.id})</c:if>
			<br>
		</p>

		<div id="comment_input_box">
			<textarea id="content" rows="" cols=""><c:if
					test="${empty user.id}">로그인 한후 이용하세요.</c:if></textarea>
			<input id="comment_btn" type="button" onclick="comment_send()"
				value="댓글쓰기">
		</div>
	</div>

	<div class="list">
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
											<td width="2" class="td_b"><img
												src="../img/td_bg_01.gif"></td>
											<td class="td_b" width="300">제목</td>
											<td width="2" class="td_b"><img
												src="../img/td_bg_01.gif"></td>
											<td width="90" class="td_b">작성자</td>
											<td width="2" class="td_b"><img
												src="../img/td_bg_01.gif"></td>

											<td width="90" class="td_b">작성일</td>
											<td width="2" class="td_b"><img
												src="../img/td_bg_01.gif"></td>
											<td width="60" class="td_c">조회수</td>
										</tr>
										<c:forEach var="b" items="${list}">
											<tr
												<c:if test = "${vo.idx eq b.idx}">class = "selected"</c:if>>
												<td align="center" class="td_a_1">${b.idx }</td>
												<td class="td_b_1"><img src="../img/td_bg_02.gif"></td>
												<c:choose>
													<c:when test="${ b.del eq 0}">
														<td class="td_b_1 left">
															<!-- 들여쓰기 --> <c:forEach begin="1" end="${b.depth}">
										&nbsp;
										</c:forEach> <c:if test="${b.depth != 0}">
										ㄴ</c:if> <a class="view"
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
	</div>

	<footer></footer>
</BODY>
</HTML>