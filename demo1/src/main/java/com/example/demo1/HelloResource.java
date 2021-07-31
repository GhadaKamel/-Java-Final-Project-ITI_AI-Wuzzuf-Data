package com.example.demo1;

import tech.tablesaw.api.Table;

import javax.activation.MimetypesFileTypeMap;
import javax.annotation.Resource;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

@Path("/hello-world")
public class HelloResource {
    WazzafDataAnalysisTasks dataSet ;
    Table data;
    @Resource
    int companiesLimit = 5;
    Graph gg = new Graph();
    public HelloResource() {
        data = new WazzafDAO().readUsingTableSaw("C:\\Users\\Afnaan\\IdeaProjects\\demo2\\Data\\Wuzzuf_Jobs.csv");
        dataSet = new WazzafDataAnalysisTasks(data);
    }

    @GET
    @Path("/structure")
    @Produces("text/plain")
    public String getStructure()
    {
        return String.valueOf(dataSet.getStructureService());
    }

    @GET
    @Path("/summary")
    @Produces("text/plain")
    public String getSummary()
    {
        return String.valueOf(dataSet.getSummaryService());
    }

    @GET
    @Path("/clean-data")
    @Produces("text/plain")
    public String  cleanData() {
        dataSet.cleanData();
        return "Done";
    }

    @GET
    @Path("/jobs-freq-for-companies/{limit}")
    @Produces("text/plain")
    public String getJobsfreqForCompanies(@PathParam("limit") @DefaultValue("5") int limit) {
        return String.valueOf(dataSet.showJobsfreqForCompaniesService(limit));
    }

    @GET
    @Path("/jobs-pie-chart")
    @Produces("image/*")
    public Response getJobsPieChartImage() {
        File f = new File("E:\\ITI\\7 - Java and UML_Amr Elshafey\\demo1\\src\\main\\resources\\most-demanding-copanies-for-jobs.jpeg");
        if (!f.exists()) {
            throw new WebApplicationException(404);
        }
        String mt = new MimetypesFileTypeMap().getContentType(f);
        return Response.ok(f, mt).build();
    }

    @GET
    @Path("/most-freq-job-titles/{limit}")
    @Produces("text/plain")
    public String getMostFreqJobTitles(@PathParam("limit") @DefaultValue("5") int limit) {
        return String.valueOf(dataSet.showMostFreqJobTitlesService(limit));
    }

    @GET
    @Path("/jobs-titels-bar-chart")
    @Produces("image/*")
    public Response getJobsTitelsBarChartImage() {
        File f = new File("E:\\ITI\\7 - Java and UML_Amr Elshafey\\demo1\\src\\main\\resources\\most-popular-job-titels.jpeg");
        if (!f.exists()) {
            throw new WebApplicationException(404);
        }
        String mt = new MimetypesFileTypeMap().getContentType(f);
        return Response.ok(f, mt).build();
    }

    @GET
    @Path("/most-freq-areas/{limit}")
    @Produces("text/plain")
    public String getMostFreqAreasService(@PathParam("limit") @DefaultValue("5") int limit) {
        return String.valueOf(dataSet.showMostFreqAreasService(limit));
    }

    @GET
    @Path("/most-freq-areas-bar-chart")
    @Produces("image/*")
    public Response getMostFreqAreasBarChartImage() {
        File f = new File("E:\\ITI\\7 - Java and UML_Amr Elshafey\\demo1\\src\\main\\resources\\most-popular- areas.jpeg");
        if (!f.exists()) {
            throw new WebApplicationException(404);
        }
        String mt = new MimetypesFileTypeMap().getContentType(f);
        return Response.ok(f, mt).build();
    }

    @GET
    @Path("/most-imp-skill/{limit}")
    @Produces("text/plain")
    public String getMostImpSkill(@PathParam("limit") @DefaultValue("5") int limit) {
        return String.valueOf(dataSet.showMostImpSkillService(limit));
    }

    @GET
    @Path("/factorize-years-exp")
    @Produces("text/plain")
    public String  getFactorizeYearsExp() {
        dataSet.factorizeYearsExp();
        return "Done";
    }
}