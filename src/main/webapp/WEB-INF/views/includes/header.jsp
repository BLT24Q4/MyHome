<%@page import="himedia.kdt.myhome.vo.UserVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="true" %>
<%
UserVo authUser = (UserVo)session.getAttribute("authUser");
%>
	<div id="header">
      <h1>My Homepage</h1>
      <ul>
      	<% if (authUser == null) { %>
      	<li><a href="<%= request.getContextPath() %>/users?a=joinform">회원가입</a><li>
      	<li><a href="<%= request.getContextPath() %>/users?a=loginform">로그인</a></li>
      	<% } else { %>
      	<li><%= authUser.getName() %>님, 안녕하세요 ^^</li>
      	<li><a href="<%= request.getContextPath() %>/users?a=logout">로그아웃</a>
      	<% } %>
      </ul>
    </div> <!-- /header -->