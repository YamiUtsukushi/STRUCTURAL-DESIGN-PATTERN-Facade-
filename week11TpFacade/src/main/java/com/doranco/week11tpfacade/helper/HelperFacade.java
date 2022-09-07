/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.doranco.week11tpfacade.helper;

import java.sql.Connection;

/**
 *
 * @author JiJi
 */
public class HelperFacade {
    
    public static void generateReport(DBTypes dBTypes, ReportTypes reportTypes, String table){
    
        Connection con = null;
        
        switch (dBTypes) {
            case MYSQL:
                con = MysqlHelper.getMsqlDBConnection();
                MysqlHelper mysqlHelper = new MysqlHelper();
                
                switch (reportTypes) {
                    case HTML: mysqlHelper.generateMysqlHTMLReport(table, con);    
                        break;
                        
                    case PDF: mysqlHelper.generateMysqlPDFReport(table, con);
                        break;
                }
                
                break;
                
            case ORACLE:
                con = OracleHelper.getOracleDBConnection();
                OracleHelper oracleHelper = new OracleHelper();
                
                switch (reportTypes) {
                    case HTML: oracleHelper.generateOracleHTMLReport(table, con);                       
                        break;
                        
                    case PDF: oracleHelper.generateOraclePDFReport(table, con);
                        break;
                       
                } 
                break;
        }
    }
    
    public static enum DBtypes{
    
        MYSQL,ORACLE
    }
    
    public static enum ReportTypes{
    
        HTML,PDF
    }
    
}
