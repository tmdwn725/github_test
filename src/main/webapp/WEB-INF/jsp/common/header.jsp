<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
  <!-- Begin Wrapper -->
   <div id="wrapper">
   
         <!-- Begin Header -->
         <div id="header">
		     상단 메뉴	<br/><br/>
<a href="<%= request.getContextPath() %>/user/user_insert_form.jsp">01회원가입</a>
<a href="<%= request.getContextPath() %>/user/user_list.jsp">02회원리스트</a>

<form action="<%=request.getContextPath()%>/login/login_pro.jsp" method="post">
아이디 : <input type = "text" name = "id">
비 번 : <input type = "text" name = "pw">
<input type ="submit" value = "로그인">
</form>

			   
		 </div>
		 <!-- End Header -->