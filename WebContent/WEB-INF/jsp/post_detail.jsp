<%@page import="org.springframework.ui.Model"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<style type="text/css">
			.disabled {
 				pointer-events: none;
 				cursor: default;
 				opacity: 0.6;
			}
		</style>

		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
		
		<form:form action="${change_action}.do" method="get" >
			<table>
				<tr>
					<th><form:label path="date" >Date:</form:label></th>
					<td><form:input path="date" /> </td>
				</tr>
				<tr>
					<th><form:label path="comment">Comment:</form:label></th>
					<td><form:input path="comment"/> </td>
				</tr>
				<tr>
					<td><input type="submit" value="${button_text}"/></td>
					<td><input type="reset" value="Clear" /></td>
				</tr>
			</table>
		</form:form>
		<h2>Comment Submit Detail...</h2>
 			<table border="1" width="70%" >
 				<tr>
 					<th>Date</th>
 					<th>Comment</th>
 					<th>Edit</th>
 					<th>Delete</th>
 					<th>Conform</th>
 				</tr>
				 <c:if test="${not empty list}">
					 <c:set var="number" value="-1"/>

 					<c:forEach var="detail" items="${list}">
 						<tr>
 							<c:set var="number" value="${number +1}"/>
 
 							<td>${detail.date}</td>
 							<td>${detail.comment}</td>
 							<c:choose>
 								 <c:when test="${not empty dis and dis eq number}">
	 								 <%System.out.println("pakistan.........."); %>
	 								 <td><a href="edit.do?edt=${number }" class="disabled">Edit</a></td>
									 <td><a href="delete.do?det=${number }" class="disabled">Delete</a></td>

							 	</c:when>
							    <c:otherwise>
									<td><a href="edit.do?edt=${number }" >Edit</a></td>
 									<td><a href="delete.do?det=${number }">Delete</a></td>
 								</c:otherwise>
 
 							</c:choose>
 								   <td><a href="disable.do?dis=${number }">Disable</a></td>
 						</tr>
 					</c:forEach>
 				</c:if>
 		</table>
	</body>
</html>