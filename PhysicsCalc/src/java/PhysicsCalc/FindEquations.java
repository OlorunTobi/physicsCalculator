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
import static java.lang.Integer.parseInt;
import javax.persistence.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Administrator
 */
public class FindEquations extends HttpServlet {
    
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
        response.setContentType("text/html;charset=UTF-8");
//        PrintWriter out = response.getWriter();
        
        // Get the persistence handler
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        
        // Create a list of Var's from request
        String params[] = request.getParameterValues("varparams");
        Integer numVars = params.length;
        List<Integer> idlist = new LinkedList();
        Var vartemp = new Var();
        Integer inttemp;
        for(Integer i=0; i < numVars; i++) {
                idlist.add(Integer.valueOf(params[i]));
            }

        
        
    
        
        TypedQuery query = entityManager.createQuery("Select ev.fk_equation_id from Eq_Var ev where ev.fk_var_id in :param group by ev.fk_equation_id having (count(ev.fk_equation_id) = ?2)", Integer.class);
        query.setParameter("param", idlist);
        query.setParameter(2, numVars);
        List<Integer> results = query.getResultList();
        List<Equation> eqlist = new LinkedList();
        

        for(int i=0; i < results.size(); i++) {
            TypedQuery tempquery = entityManager.createQuery("Select e from Equation e where e.id= :param", Equation.class);
            tempquery.setParameter("param", results.get(i));
            Equation eqtemp = (Equation) tempquery.getSingleResult();
            try{
                eqlist.add(eqtemp);
            }
            catch(Exception x){
                entityManager.close();
                request.getRequestDispatcher("error2.jsp").forward(request,response);
            }
        }
  
        request.setAttribute("eqlist", eqlist);

        entityManager.close();
        
        // Now display the view
        request.getRequestDispatcher("search_result.jsp").forward(request,response);


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
