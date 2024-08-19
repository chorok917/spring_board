<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- header.jsp  -->
<%@ include file="/WEB-INF/view/layout/header.jsp"%>

<a href="/board/list">게시글 목록 보러가기</a>

<div class="form-wrapper">
<form action="/board/create" method="post">
	<div class="form-head">
	<div class="title-box">
	<label for="title">제목 :</label>
	<input id="title" name="title" maxlength="20" required>
	</div>
	<div class="writer-box">
	<label for="writer">작성자 :</label>
	<input id="writer" name="writer" maxlength="20" required>
	</div>
	</div>
	<label for="content">내용</label>
	<input id="content" name="content" maxlength="20" class="content" required>
	<button class="submit-btn">작성완료</button>
</form>
</div>

<!-- footer.jsp  -->
<%@ include file="/WEB-INF/view/layout/footer.jsp"%>