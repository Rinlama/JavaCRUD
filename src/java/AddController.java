/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.hw14.DOA.StudentDOA;
import com.hw14.student.Student;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
/**
 *
 * @author Rinjin
 */
@WebServlet(urlPatterns = {"/AddController"})
public class AddController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
              String id=request.getParameter("ID");
              String firstName=request.getParameter("FirstName");
              String lastName=request.getParameter("LastName");
              String GPA=request.getParameter("GPA");
              String autoid= request.getParameter("AutoID");
             
              Student obj= new Student();
              obj.setId(Integer.parseInt(id));
              obj.setFirstname(firstName);
              obj.setLastname(lastName);
              obj.setGPA(Double.parseDouble(GPA));
              
              StudentDOA objDOA= new StudentDOA();
             
              
        try {
            if (autoid.equalsIgnoreCase("")) {
                  objDOA.insert(obj);
            }else{
                objDOA.update(obj, Integer.parseInt(autoid));                
            }
          
             RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
             rd.forward(request, response);
              
        } catch (Exception ex) {
            response.getWriter().append(ex.toString());
        }
              
        }
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
