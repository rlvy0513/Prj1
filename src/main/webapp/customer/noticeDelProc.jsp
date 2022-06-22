<%-- <%@page import="notice.vo.Notice"%>
<%@page import="notice.dao.NoticeDao"%> --%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
/* String seq=request.getParameter("c"); */
%>
<%
/* Notice n=new Notice();//없어도됨
n.setSeq(seq);
NoticeDao dao=new NoticeDao();
//int af=dao.delete(n);
int af=dao.delete(seq); */

/* if(af>0){
	//
	response.sendRedirect("notice.jsp");
}else{
	//
	out.write("삭제오류");
} */

%>  

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>noticeDelProc</h3>

</body>
</html>