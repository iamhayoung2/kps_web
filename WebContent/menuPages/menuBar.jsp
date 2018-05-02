<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
   <!-- Header -->
   <header id="header">
      <!-- Logo -->
      <div class="logo">
         <a href="/index.jsp"><strong>KPS</strong> by 바늘토</a>
      </div>

      <!-- Nav -->
      <nav id="nav">
         <ul>
            <li><a href="/index.jsp">Home</a></li>
            <li><a
               href="/menuPages/intro.jsp">소개</a></li>
            <li><a
               href="/menuPages/predict.jsp">예측</a></li>
            <li><a
               href="/menuPages/alarm.jsp">알람</a></li>
         
            <li>
               <%
                  if(session.getAttribute("memberInfo")== null){
                  %> <a
               href="/loginPages/signup.jsp"
               class="button alt small"><font color="#3f3c3c" size=3>Sign Up</font></a> <%
                  }else{
                  %> <a
                  href="/loginPages/mypage.jsp"
                  class="button alt small"><font color=#3f3c3c size=3>My Page</font><%
                  }%>
               </a>
            </li>
      
            <li>
               <%if(session.getAttribute("memberInfo") ==null){%> <a
               href="/loginPages/login.jsp"
               class="button alt small" id="lowerButton"><font color=#3f3c3c size=3>Log In</font></a><%
                  }else{%><a
                  href="/biz/logout.jsp"
                  class="button small" id="lowerButton"><font color=#3f3c3c size=3>Log Out</font><%
                  }%>
               </a>
            </li>
         
         </ul>
      </nav>

   </header>