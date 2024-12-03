package controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

// Implementamos el path o anotación
@WebServlet("/cabeceros")
public class cabecero extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // Configuración de la respuesta
        resp.setContentType("text/html;charset=UTF-8");

        // Obtener información de la petición
        String metodoHttp = req.getMethod();
        String requestURI = req.getRequestURI();
        String requestURL = req.getRequestURL().toString();
        String contextPath = req.getContextPath();
        String servletPath = req.getServletPath();
        String pathInfo = req.getPathInfo();
        String esquema = req.getScheme();
        String host = req.getServerName();
        int puerto = req.getServerPort();
        String ipCliente = req.getRemoteAddr();

        // Construir URLs dinámicas
        String url1 = esquema + "://" + host + contextPath + servletPath;
        String url2 = esquema + "://" + req.getLocalAddr() + ":" + puerto + contextPath + servletPath;

        // Obtener los nombres de los encabezados
        Enumeration<String> headerNames = req.getHeaderNames();

        // Generar la respuesta HTML
        PrintWriter out = resp.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset=\"utf-8\">");
        out.println("<title>Cabeceros</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Peticiones Http Request</h1>");
        out.println("<ul>");
        out.println("<li>Método HTTP: " + metodoHttp + "</li>");
        out.println("<li>URI: " + requestURI + "</li>");
        out.println("<li>URL: " + requestURL + "</li>");
        out.println("<li>Context Path: " + contextPath + "</li>");
        out.println("<li>Servlet Path: " + servletPath + "</li>");
        out.println("<li>Path Info: " + pathInfo + "</li>");
        out.println("<li>Esquema: " + esquema + "</li>");
        out.println("<li>Host: " + host + "</li>");
        out.println("<li>Puerto: " + puerto + "</li>");
        out.println("<li>IP del Cliente: " + ipCliente + "</li>");
        out.println("</ul>");

        out.println("<h2>URLs Dinámicas</h2>");
        out.println("<ul>");
        out.println("<li>URL1: " + url1 + "</li>");
        out.println("<li>URL2: " + url2 + "</li>");
        out.println("</ul>");

        out.println("<h2>Encabezados HTTP</h2>");
        out.println("<ul>");
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            String headerValue = req.getHeader(headerName);
            out.println("<li>" + headerName + ": " + headerValue + "</li>");
        }
        out.println("</ul>");
        out.println("</body>");
        out.println("</html>");
    }
}