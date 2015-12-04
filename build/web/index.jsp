<%-- 
    Document   : index
    Created on : Nov 10, 2015, 11:28:33 AM
    Author     : Rinjin
--%>

<%@page import="com.hw14.student.Student"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Collections"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@include file="header.jsp" %>
        <%
            ArrayList<Student> list = new ArrayList<Student>();
            request.setAttribute("liststring", list);
            try {

                Class.forName("com.mysql.jdbc.Driver");
                String connectionUrl = "jdbc:mysql://localhost:8889/students";
                String user = "root";
                String password = "root";
                Connection objConn = DriverManager.getConnection(connectionUrl, user, password);
                Statement objStatement = objConn.createStatement();

                String sql = "select * from Student_table";
                ResultSet objRS = objStatement.executeQuery(sql);

                while (objRS.next()) {
                    Student student = new Student();
                    student.setId(objRS.getInt(1));
                    student.setFirstname(objRS.getString(2));
                    student.setLastname(objRS.getString(3));
                    student.setGPA(objRS.getDouble(4));
                    student.setAutoID(objRS.getInt(5));
                    list.add(student);
                }

                objConn.close();

                for (int i = 0; i < list.size(); i++) {
                    // out.print(list.get(i));
                }

            } catch (SQLException e) {
                out.print(e.toString());
            }


        %>
        
        
        <table class="table col-md-8 display" id="myTable">
         <thead>
             <tr>
            <th>ID</th>
            <th>FirstName</th>
            <th>LastName</th>
            <th>GPA</th>
            <th>Action</th>
            <th>Action</th>
             </tr>
        </thead>
        <tbody>
        <c:forEach var="item" items="${liststring}">
           
         
            <td> ${item.getId()}</td>
            <td> ${item.getFirstname()}</td>
            <td> ${item.getLastname()}</td>
            <td> ${item.getGPA()}</td>
            

            <td><a href="/hw13/EditController?autoID=${item.getAutoID()}"><button class="btn btn-primary">Edit</button></a></td> 
            <td><a href="/hw13/DeleteController?autoID=${item.getAutoID()}"><button class="btn btn-danger">Delete</button></a></td> 
            </tr>
        </tbody> 
    </c:forEach>
        
</table> 
         <a href="/hw13/add.jsp" ><button class="btn btn-primary">Add</button>
<%@include file="footer.jsp" %>