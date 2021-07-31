package com.example.demo1;

import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.ws.rs.Produces;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    @Produces("image/jpeg")
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ServletContext cntx = request.getServletContext();
        // Get the absolute path of the image
        String filename = cntx.getRealPath("E:\\ITI\\7 - Java and UML_Amr Elshafey\\demo1\\src\\main\\resources\\DsJ-6QHXoAI-sCX.jpg");
        // retrieve mimeType dynamically
        String mime = cntx.getMimeType(filename);
        if (mime == null) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return;
        }
        response.setContentType(mime);
        File file = new File(filename);
        response.setContentLength((int)file.length());

        FileInputStream in = new FileInputStream(file);
        BufferedImage image = ImageIO.read(in);
//        return ImageIO.write(image, "jpeg", file);

//        response.setContentType("text/html");
//        // Hello
//        PrintWriter out = response.getWriter();
//        out.println("<html><body>");
//        out.println("<h1>" + message + "</h1>");
//        out.println("</body></html>");
    }



    public void destroy() {
    }
}