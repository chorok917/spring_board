<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- header.jsp  -->
<%@ include file="/WEB-INF/view/layout/header.jsp"%>

<form action="/board/create" method="post">
	<label for="title">제목</label>
	<input id="title" name="title" maxlength="20">
	<label for="content">내용</label>
	<input id="content" name="content" maxlength="20">
	<label for="writer">작성자</label>
	<input id="writer" name="writer">
	<button>작성완료</button>
</form>

<!-- footer.jsp  -->
<%@ include file="/WEB-INF/view/layout/footer.jsp"%>