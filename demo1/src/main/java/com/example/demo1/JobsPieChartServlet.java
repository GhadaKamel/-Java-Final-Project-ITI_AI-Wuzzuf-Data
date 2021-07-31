package com.example.demo1;

import tech.tablesaw.api.Table;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@WebServlet(name = "jobsPieChartServlet", value = "/jobs-pie-chart-servlet")
public class JobsPieChartServlet extends HttpServlet {
    private String message;
    WazzafDataAnalysisTasks dataSet ;
    Table data;
    Graph gg = new Graph();

    public void init() {
        message = "Structure!";
        data = new WazzafDAO().readUsingTableSaw("C:\\Users\\Afnaan\\IdeaProjects\\demo2\\Data\\Wuzzuf_Jobs.csv");
        dataSet = new WazzafDataAnalysisTasks(data);
    }

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        ServletContext cntx = req.getServletContext();
        // Get the absolute path of the image
        String filename = cntx.getRealPath("E:\\ITI\\7 - Java and UML_Amr Elshafey\\demo1\\src\\main\\resources\\DsJ-6QHXoAI-sCX.jpg");
        // retrieve mimeType dynamically
        String mime = cntx.getMimeType(filename);
        if (mime == null) {
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return;
        }
        resp.setContentType(mime);
        File file = new File(filename);
        resp.setContentLength((int)file.length());

        FileInputStream in = new FileInputStream(file);
        OutputStream out = resp.getOutputStream();

        // Copy the contents of the file to the output stream
        byte[] buf = new byte[1024];
        int count = 0;
        while ((count = in.read(buf)) >= 0) {
            out.write(buf, 0, count);
        }
        out.close();
        in.close();

    }

    public void destroy() {
    }
}