<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- header.jsp  -->
<%@ include file="/WEB-INF/view/layout/header.jsp"%>

<p>제목 : ${board.title}</p>
<p>내용 :  ${board.content}</p>
<p>작성자 : ${board.writer}</p>
<p>작성일 :  ${board.timestampToStringDetail(board.createdAt)}</p>

<!-- footer.jsp  -->
<%@ include file="/WEB-INF/view/layout/footer.jsp"%>