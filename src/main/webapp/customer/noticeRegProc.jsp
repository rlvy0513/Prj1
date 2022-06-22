
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
/* String title=request.getParameter("title");
String content=request.getParameter("content"); */
%>

<%
/* Notice n=new Notice();
n.setTitle(title);
n.setContent(content);


NoticeDao dao=new NoticeDao();
dao.insert(n); */

//insert후 notice.jsp로 이동
response.sendRedirect("notice.jsp");

%>
<%

%>
