<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/join_style.css" />
</head>
<body>
<h3>loginform</h3>
<script>
function checkValue() {
	inputForm=eval("document.logininfo");
	if(!inputForm.id.value){
		alert("아이디없음");
		return false;
	}
	if(!inputForm.password.value){
		alert("패스워드없음");
		return false;
	}	
}
function goJoinFrom() {
	location.href="../joinus/join.jsp";
}
</script>

<div id="wrap">
	<form action="loginproc.do" name="logininfo" method="post" onsubmit="return checkValue()">
		<img src="../img/welcome.jpg" id="wel_img" />
		<br /><br />
		<table>
			<tr>
				<td bgcolor="skyblue" colspan="2">L O G I N</td>	
			</tr>
			<tr>
				<td bgcolor="skyblue">아이디</td>
				<td>
					<input type="text" name="id" maxlength="50" />
				</td>
			</tr>
			<tr>
				<td bgcolor="skyblue">비밀번호</td>
				<td>
					<input type="password" name="password" maxlength="50" />
				</td>
			</tr>
		</table>
		<br />
		<input type="submit" value="login" />
		<input type="button" value="join" onclick="goJoinFrom()" />		
	</form>
	<%
	String msg=request.getParameter("msg");
	if(msg!=null && msg.equals("0")){
		out.println("<br>");
		out.println("<font color='red' size='5'>비밀번호확인</font>");
		
	}else if(msg!=null && msg.equals("-1")){
		out.println("<br>");
		out.println("<font color='red' size='5'>아이디확인</font>");	
	}
	%>
</div>
<!-- 자바스크립트 form 태그의 데이터 전송을 막는 방법에는 아래와 같이 onsubmit 이벤트를 활용하는 것이 있다.
 onsubmit 이벤트는 input 태그의 데이터를 서버에 전송하기 전 동작을 지정하며,
 return false; 를 함으로써 이벤트 처리를 종료하고 action의 처리를 방지하게 된다. -->

</body>
</html>