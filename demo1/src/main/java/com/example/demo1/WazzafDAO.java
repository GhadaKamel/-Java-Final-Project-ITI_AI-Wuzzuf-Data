/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo1;


import joinery.DataFrame;
import tech.tablesaw.api.Table;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AsmaaAbdelkader
 */
public class WazzafDAO {
    /**
     * reading data from csv file into a dataframe using joinary
     * @param file 
     */
    
    public void readUsingJoinary(String file){
        
        try {
            DataFrame<Object> df = DataFrame.readCsv("data/Wuzzuf_Jobs.csv");
        } catch (IOException ex) {
            Logger.getLogger(WazzafDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      
    /**
     * a function that take csv and convert it into a tablesaw table
     * @param file csv file that contain datat
     * @return table
     */
    public Table readUsingTableSaw(String file){
        Table data = Table.create(); 
        try {
            data = Table.read().csv(file);
           
        } catch (IOException ex) {
            Logger.getLogger(WazzafDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return data;

    }
}
    

