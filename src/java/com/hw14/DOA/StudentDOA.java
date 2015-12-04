/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hw14.DOA;

import com.hw14.student.Student;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Rinjin
 */
public class StudentDOA {

    public static Connection getConnection() throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.jdbc.Driver");
        String connectionUrl = "jdbc:mysql://localhost:8889/students";
        String user = "root";
        String password = "root";
        Connection objConn = (Connection) DriverManager.getConnection(connectionUrl, user, password);
        return objConn;

    }

    public void insert(Student user) throws Exception {

        try {
            Connection objConn = StudentDOA.getConnection();
            Statement objStatement = (Statement) objConn.createStatement();

		     // INSERT INTO `businessApplication`.`user` (`iduser`, `firstname`, `lastname`, `email`, `password`) VALUES ('12', '12', '12', '12@gmail.com', '12');
            String sql = "INSERT INTO Student_table(ID,firstname,lastname,GPA)"
                    + "VALUES('"
                    + user.getId() + "','"
                    + user.getFirstname() + "','"
                    + user.getLastname() + "','"
                    + user.getId() + "')";

            int rowsAffected = objStatement.executeUpdate(sql);
            if (rowsAffected != 1) {
                throw new UnsupportedOperationException("Insert Query Failed");
            }

            objConn.close();

        } catch (Exception objE) {
            throw new Exception("Error in database_Load()method- " + objE.toString());
        }

    }
    
    public static Student edit(int autoid) throws Exception{
    
    try {
        Student student = new Student();
            Connection objConn = StudentDOA.getConnection();
            Statement objStatement = (Statement) objConn.createStatement();

             String sql = "select * from Student_table where AutoID =" + autoid;
                ResultSet objRS = objStatement.executeQuery(sql);

                while (objRS.next()) {
                    
                    student.setId(objRS.getInt(1));
                    student.setFirstname(objRS.getString(2));
                    student.setLastname(objRS.getString(3));
                    student.setGPA(objRS.getDouble(4));
                    student.setAutoID(objRS.getInt(5));
                }

                objConn.close();
            objConn.close();
            
            return student;
        } catch (Exception objE) {
            throw new Exception("Error in database_Load()method- " + objE.toString());
        }
    }
   
   
    public void update(Student user,int autoid) throws Exception {

        try {
            Connection objConn = StudentDOA.getConnection();
            Statement objStatement = (Statement) objConn.createStatement();

		    
            String sql = "Update Student_table set id="+user.getId()+",FirstName='"+user.getFirstname()+"', LastName='"+user.getLastname()+"',GPA="+user.getGPA()+" where autoid="+autoid+"";

            int rowsAffected = objStatement.executeUpdate(sql);
            if (rowsAffected != 1) {
                throw new UnsupportedOperationException("Insert Update Failed");
            }

            objConn.close();

        } catch (Exception objE) {
            throw new Exception("Error in database_Load()method- " + objE.toString());
        }

    }
   
    public static void delete(int autoid) throws Exception {

        try {
            Connection objConn = StudentDOA.getConnection();
            Statement objStatement = (Statement) objConn.createStatement();

		 // delete from student_table where AutoID=17;
            String sql = "Delete from student_table where AutoID="+autoid +"";

            int rowsAffected = objStatement.executeUpdate(sql);
            if (rowsAffected != 1) {
                throw new UnsupportedOperationException("Delete Update Failed");
            }

            objConn.close();

        } catch (Exception objE) {
            throw new Exception("Error in database_Load()method- " + objE.toString());
        }

    }
    

}
