<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- header.jsp  -->
<%@ include file="/WEB-INF/view/layout/header.jsp"%>

<form action="/board/update" method="post">
	<label for="title">제목</label>
	<input id="title" name="title" maxlength="20" value="${board.title}">
	<label for="content">내용</label>
	<input id="content" name="content" maxlength="20" value="${board.content}">
	<label for="writer">작성자</label>
	<input id="writer" name="writer" value="${board.writer}">
	<input type="hidden" value="${board.id}" name = "id">
	<button>수정하기</button>
</form>

<!-- footer.jsp  -->
<%@ include file="/WEB-INF/view/layout/footer.jsp"%>