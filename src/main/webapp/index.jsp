<%@page import="java.util.Date"%>
<%@page import="com.dao.*"%>
<%@page import="com.db.*"%>
<%@page import="com.entity.*"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Attendance sheet</title>

<%@include file="component/all_css.jsp" %>

</head>
<body>



<%@include file="component/navbar.jsp" %>
<%-- 
<%
Connection conn= DBConnect.getConn();
out.print(conn);
%>
 --%>
 <br>
<h1 class="text-center" style="color: #FF2D00; 
font-family: 'Lora', serif; text-shadow: 2px 2px 2px #888888;  " ><i class="fa-solid fa-building-columns" style="color: #9f0013;"></i> Private college of engineering and technology  </h1>
<hr style="width:100%;text-align:left;margin-left:0;  border-color: #333;">
<br><h4 class="text-center" style="color: #EBA300;"><i class="fa-solid fa-clipboard-user" style="color:#9f0013;"></i> ATTENDANCE SHEET</h4><br>

<pre style="color: #461fe8; font-family: Arial, sans-serif; font-size: 18px;">            		        <i class="fa-solid fa-calendar-days" style="color: #9f0013;"></i>   Today's date: <%=(new java.util.Date()).toLocaleString()%> </pre>





<%

String sucMsg=(String)session.getAttribute("sucMsg");
if(sucMsg!=null)
{%>

<div class="alert alert-success" role="alert">
<%=sucMsg  %>
</div>
	
<%
session.removeAttribute("sucMsg");
}
%>


<%

String failedMsg=(String)session.getAttribute("failedMsg");
if(failedMsg!=null)
{%>

<div class="alert alert-danger" role="alert">
<%=failedMsg  %>
</div>
	
<%
session.removeAttribute("failedMsg");
}
%>

<div class="container">
<table class="table table-striped" border="1px">
  <thead class="bg-success text-white">
    <tr style="border: 2px solid black;">
      <th scope="col">ID</th>
        <th scope="col">Name</th>
      <th scope="col">Status</th>
      <th scope="col">Action</th>
    </tr>
  </thead>
  <tbody>
  <%
  AttendanceDAO dao=new  AttendanceDAO(DBConnect.getConn());
  List<AttendanceDetails> todo=dao.getAttendance();
  
  
  for(AttendanceDetails t:todo)
  {
  %>
	   <tr>
      <th scope="row"><%=t.getId()%></th>
      <th scope="col"><%=t.getName()%></th>
      <td><%=t.getStatus() %></td>
      <td><a href="edit.jsp?id=<%=t.getId()%>" class="btn btn-sm btn-success">Edit</a>
      <a href="delete?id=<%=t.getId()%>" class="btn btn-sm btn-danger">Delete</a></td>
    </tr>
  <%
  }
  %>
   
  </tbody>
</table>



</div>
</body>
</html>