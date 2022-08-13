/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
import Clases.Libro;
import Clases.LibroVec;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author Suzzanne Acevedo
 */
@WebServlet(urlPatterns = {"/ServletLibro"})
public class ServletLibro extends HttpServlet {
    Libro libro;
    LibroVec regLibro;
    Libro[] registro;
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
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            libro=new Libro(
            request.getParameter("cod"),
            request.getParameter("name"),
            request.getParameter("type"),
            request.getParameter("edi"),
            request.getParameter("age"));
        if(regLibro==null){regLibro=new LibroVec();}
        regLibro.saveLi(libro);  registro=regLibro.gimmeLi();
          
        
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<link rel='stylesheet' href='https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css' >");
            out.println("<script src='https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js' ></script>"+
            "          <link rel=\"shortcut icon\" href=\"https://raw.githubusercontent.com/Suzzanne20/ResourceNekoStation/main/Neko-icon.ico\" type=\"image/x-icon\"/>");
            out.println("</head>");
            out.println("<body>");
            out.println("<nav class=\"navbar navbar-dark bg-dark\">\n" +
            "          <div class=\"container-fluid row text-center \"> <div class=\"row align-items-center\">\n" +
            "          <a class=\"navbar-brand col\" href=\"index.html\">\n" +
            "          <img src=\"https://static.vecteezy.com/system/resources/previews/001/200/145/non_2x/books-png.png\" alt=\"\" width=\"30\" height=\"30\" class=\"d-inline-block align-text-top\">Biblioteca</a>\n" +
            "          <a class=\"navbar-brand col \" href=\"ServletLibro\">Libros</a>\n" +
            "          <a class=\"navbar-brand col \" href=\"page2.html\">Registro</a>\n" +
            "          </div></div></nav>");
            
            out.println("<main class=\"main \"><div class=\"container text-center \"><br><h1>Clientes Registrados</h1><br><table class=\"table table-dark table-hover\"><thead><tr>\n" +
            "      <th scope=\"col\">COD</th>\n" +
            "      <th scope=\"col\">NOMBRE</th>\n" +
            "      <th scope=\"col\">TIPO</th>\n" +
            "      <th scope=\"col\">EDICION</th>\n" +
            "      <th scope=\"col\">AÑO</th>\n" +
            "      </tr></thead><tbody>");
            for (int i=0; i<registro.length;i++){
                if(!registro[i].getCodigo().isEmpty()){
                out.println("    <tr>\n" +
            "      <th scope=\"row\">"+ registro[i].getCodigo()+"</th>\n" +
            "      <td>"+registro[i].getNombre() +"</td>\n" +
            "      <td>"+registro[i].getTipo() +"</td>\n" +
            "      <td>"+registro[i].getEditorial()+"</td>\n" +
            "      <td>"+registro[i].getAño()+"</td></tr>");
                
                }
            }                     
            out.println("</tbody></table></div>");
            out.println("</main></body></html>");
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
