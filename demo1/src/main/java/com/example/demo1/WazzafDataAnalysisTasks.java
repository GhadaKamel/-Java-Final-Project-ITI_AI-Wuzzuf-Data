/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo1;

import tech.tablesaw.api.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author AsmaaAbdelkader
 */
public class WazzafDataAnalysisTasks {
    private Table data;

    public WazzafDataAnalysisTasks(Table data) {
        this.data = data;
    }

//     Display some from of data set

//      Display the structure of data
    public String getStructureService(){
        return data.structure().toString();
    }


//      Display the summary of data
    public String getSummaryService(){
        return data.summary().toString();
    }

//      Clean the data (null, duplications)
    public void cleanData(){
        // remove duplicates
        data =  data.dropDuplicateRows();

        //remove rows with missing values
        data = data.dropRowsWithMissingValues();

        //replace null string in YearsExp column with a anumeric interval "0-1"
        for (Row row : data) {
            String val = row.getString("YearsExp");
            if(val.contains("null"))
                row.setString("YearsExp", val.replaceFirst("null", "0-1"));
        }
    }

    @Override
    public String toString() {
        return "WazzafDataAnalysisTasks{" + "data=" + data.toString() + '}';
    }

    /**
     * Count the jobs for each company and display that in order
     * @param limit number of rows to display
     */
    public Table showJobsfreqForCompaniesService(int limit){
        return data.countBy("Company").sortDescendingOn("Count").first(limit);

    }

    /**
     *Find out What are it the most popular job titles
     * @param limit number of rows to display
     */
    public Table showMostFreqJobTitlesService(int limit){
        return data.countBy("Title").sortDescendingOn("Count");
    }

    /**
     * Find out the most popular areas
     * @param limit number of rows to display
     */
    public Table showMostFreqAreasService(int limit){
        return data.countBy("Location").sortDescendingOn("Count").first(limit);
    }

    /**
     * Print skills one by one and how many each repeated and order the output to
     * find out the most important skills required
     * @param limit number of rows to display
     */
    public Table showMostImpSkillService(int limit){
        //create a list for all skills in the table
        List<String> skills = new ArrayList<>();
        //get the skills columns from the data table
        StringColumn skillsCol = (StringColumn)data.column("Skills");
        //loop over each skill in each row , add it to the list
        for(String row : skillsCol){
            String[] s = row.split(",");
            skills.addAll(Arrays.asList(s));
        }
        //convert the skills list to a column
        StringColumn allSkills = (StringColumn.create("Skills",skills));
        Table skillCounts = allSkills.countByCategory().sortDescendingOn("Count").first(limit);
        return skillCounts;
    }

    /**
     * Factorize the YearsExp feature and convert it to numbers in new col.
     */
    public void factorizeYearsExp(){
        List<?> years =  data.column("YearsExp").unique()
                .asList()
                .stream()
                .sorted()
                .collect(Collectors.toList());

        StringColumn YearsOfExp= (StringColumn) data.column ("YearsExp");
        List<Number> factorizedValues=new ArrayList<>();

        for(String s : YearsOfExp){
            factorizedValues.add(years.indexOf(s));
        }

        NumberColumn factorizedColumn= DoubleColumn.create("factorized",factorizedValues);
        data.addColumns (factorizedColumn);
    }
}