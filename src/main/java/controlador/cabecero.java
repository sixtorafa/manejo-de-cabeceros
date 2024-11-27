package controlador;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

//Implementamos el path o anotacion
@WebServlet ("/cabeceros")
public class cabecero extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        resp.setContentType("text/html;charset=UTF-8");
        //Obtenemos el metodo que esta realizando la peticion
        String metodoHttp=req.getMethod();
        //Obtenemos la Uri contextpath+servletpath
        String requestURI=req.getRequestURI();
        //Obtenemos la url completa
        String requestURL=req.getRequestURL().toString();
        //Obtenemos el nombre del proyecto
        String contextPath=req.getContextPath();
        //obtenemos el path del servlet
        String servletPath=req.getServletPath();
        String pathInfo=req.getPathInfo();
                PrintWriter out = resp.getWriter();
                //Creo la plantilla html
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<meta charset=\"utf-8\">");
                out.println("<title>Cabeceros</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Peticiones Http Request</h1>");
                out.println("<ul>");
                out.println("<li>Metodo: "+metodoHttp+"</li>");
                out.println("<li>Uri: "+requestURI+"</li>");
        out.println("<li>URL: "+requestURL+"</li>");
        out.println("<li>contextPath: "+contextPath+"</li>");
        out.println("<li>servletPath: "+servletPath+"</li>");
                out.println("</ul>");
                out.println("</body>");
                out.println("</html>");
                //Obtener el puerto por donde esta ejecutando la aplicacion
                //Obtener la ip de donde se esta ejecutando la aplicacion
        //Obtener el esquema
        //construir una url que contenga la siguiente informacion
        // schema+host+contextPath+servlet
        //construir url2= schema+ip+port+contextPath+sefrvletPath
        //mostrar de que ip esta siendo ejecutada mi aplicacion
        //Obtener los headernames

    }
}
