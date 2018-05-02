<!--  
	@Author Junmin Seong (chicolivia@gmail.com)
-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	session.invalidate(); 
	response.sendRedirect("/index.jsp");
%>