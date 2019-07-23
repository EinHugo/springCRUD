<%@ page language="java" contentType="text/html; charSet=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
								

<ul class="pagination">
	<c:if test="${param.prev}">
		<li><a href="javascript:goPage(${param.prevPageNo})" >이전</a></li>
	</c:if>
	
		<c:forEach var="i" begin="${param.startPageNo}" end="${param.endPageNo}" step="1">
			<li><a href="javascript:goPage(${i})">${i}</a></li>
			<%-- <c:choose> --%>
				<%-- <li><a href="javascript:goPage(${i})">${i}</a></li> --%>
				<%-- <c:when test="${i eq param.pageNo}">
					<li><a href="javascript:goPage(${i})">${i}</a></li>
				</c:when>
				<c:otherwise>
					<li><a href="javascript:goPage(${i})">${i}</a></li>
				</c:otherwise> --%>
			<%-- </c:choose> --%>
		</c:forEach>
	<c:if test="${param.next}">
		<li><a href="javascript:goPage(${param.nextPageNo})">다음</a></li>
	</c:if>
</ul>