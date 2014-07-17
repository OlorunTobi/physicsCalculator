/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package PhysicsCalc;

import java.util.List;
import java.util.LinkedList;
import java.io.IOException;
import java.io.PrintWriter;
import javax.persistence.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Administrator
 */
public class VarInit extends HttpServlet {

    @PersistenceUnit
    private EntityManagerFactory entityManagerFactory;
    
    
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

        // Get the persistence handler
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        
        List<Integer> varIds = new LinkedList();
        varIds.add(Integer.valueOf("1"));
        varIds.add(Integer.valueOf("2"));
        varIds.add(Integer.valueOf("3"));
        varIds.add(Integer.valueOf("4"));
        varIds.add(Integer.valueOf("5"));
        varIds.add(Integer.valueOf("6"));
        varIds.add(Integer.valueOf("7"));
        varIds.add(Integer.valueOf("8"));
        varIds.add(Integer.valueOf("9"));
        varIds.add(Integer.valueOf("10"));

        List<Var> varlist = new LinkedList();

               // Check if each equation is in database, and add if it isn't
        for (int i=0; i < varIds.size(); i++) {
            Query query = entityManager.createQuery("SELECT v FROM Var v where v.id = :param ", Var.class);
            query.setParameter("param", varIds.get(i));
            Var tempvar = (Var) query.getSingleResult();
            try{
                varlist.add(tempvar);
            }
            catch(Exception x){
                entityManager.close();
                request.getRequestDispatcher("error2.jsp").forward(request,response);
            }
        }
        
        request.setAttribute("varlist", varlist);

        entityManager.close();
        
        // Now display the view
        request.getRequestDispatcher("equation_finder.jsp").forward(request,response);
   
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
