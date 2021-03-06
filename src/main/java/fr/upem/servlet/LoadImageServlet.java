/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.upem.servlet;

import fr.upem.controller.ImageController;
import fr.upem.entity.Image;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Denis
 */
@WebServlet(name = "LoadImageServlet", urlPatterns = {"/LoadImageServlet"})
public class LoadImageServlet extends HttpServlet {

    @Inject
    ImageController imageController;
    
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
        
        Long image_id = Long.parseLong(request.getParameter("img_id"));
        Image image = imageController.getImageById(image_id);
        List<Image> images = imageController.getTimeRangeImages(image.getTime(), 20);

        JsonArrayBuilder jsonArrayBuilder = Json.createArrayBuilder();
        for(Image i : images) {
            jsonArrayBuilder.add(Json.createObjectBuilder()
                                    .add("id", i.getId())
                                    .add("title", i.getTitle())
                                    .add("filename", i.getFilename())
                                );
        }
        JsonObject jsonData = Json.createObjectBuilder().add("images", jsonArrayBuilder).build();

        response.setContentType("application/json");
        response.setCharacterEncoding( "UTF-8" );
        PrintWriter out = response.getWriter();
        
        JsonWriter writer = Json.createWriter(out);
        writer.writeObject(jsonData);
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
