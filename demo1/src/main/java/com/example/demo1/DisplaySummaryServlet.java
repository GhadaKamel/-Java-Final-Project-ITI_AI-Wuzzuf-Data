package com.example.demo1;

import tech.tablesaw.api.Table;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "displaySummary", value = "/display-summary")
public class DisplaySummaryServlet extends HttpServlet {
    private String message;
    WazzafDataAnalysisTasks dataSet ;

    public void init() {
//        message = "Summary!";
        Table data = new WazzafDAO().readUsingTableSaw("C:\\Users\\Afnaan\\IdeaProjects\\demo2\\Data\\Wuzzuf_Jobs.csv");
        dataSet = new WazzafDataAnalysisTasks(data);
        message = String.valueOf(dataSet.getStructureService());
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + "Summary!" + "</h1>");
        out.println(message);
        out.println("</body></html>");
    }

    public void destroy() {
    }
}