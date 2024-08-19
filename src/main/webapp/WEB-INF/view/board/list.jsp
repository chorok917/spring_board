<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- header.jsp  -->
<%@ include file="/WEB-INF/view/layout/header.jsp"%>

<a href="/board/create" class="btn">게시글 작성하러 가기</a>

<div class="wrapper">
<c:choose>
<c:when test="${boardList != null}">
<table>
<thead>
  <tr>
    <th>번호</th>
    <th>제목</th>
    <th>내용</th>
    <th>작성자</th>
  </tr>
</thead>
<tbody>
	<c:forEach var="board" items="${boardList}" > 
  <tr>
    <td><a href="/board/view/${board.id}"> ${board.id} </a></td>
    <td><a href="/board/view/${board.id}"> ${board.title} </a></td>
    <td><a href="/board/view/${board.id}"> ${board.content}</a></td>
    <td><a href="/board/view/${board.id}"> ${board.writer}</a></td>
    <td><a href="/board/delete/${board.id}" class="btn">삭제</a></td>
    <td><a href="/board/update/${board.id}" class="btn">수정</a></td>
  </tr>
	</c:forEach>
</tbody>
</table>
</c:when>
<c:otherwise>
	<h5>게시글이 없습니다.</h5>
</c:otherwise>
</c:choose>

<!-- pagination -->
<ul class="pagination">
<li>
	<a href="?page=${currentPage - 1}&size=${size}" >prev</a>
</li>
<c:forEach begin="1" end="${totalPages}" var="page">
<li>
	<a href="?page=${page}&size=${size}">${page}</a>
</li>
</c:forEach>
<li>
	<a href="?page=${currentPage + 1}&size=${size}">next</a>
</li>
</ul>
</div>

<!-- footer.jsp  -->
<%@ include file="/WEB-INF/view/layout/footer.jsp"%>