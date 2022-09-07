/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.doranco.week11tpfacade;

import com.doranco.week11tpfacade.helper.HelperFacade;
import com.doranco.week11tpfacade.helper.MysqlHelper;
import com.doranco.week11tpfacade.helper.OracleHelper;
import java.sql.Connection;



/**
 *
 * @author JiJi
 */
public class Week11TpFacade {

    public static void main(String[] args) {
       
        
        String table = "Etudiant";
        
        Connection con = MysqlHelper.getMsqlDBConnection();
        MysqlHelper mysqlHelper = new MysqlHelper();
        mysqlHelper.generateMysqlPDFReport(table, con);
        
        Connection con1 = OracleHelper.getOracleDBConnection();
        OracleHelper oracleHelper = new OracleHelper();
        oracleHelper.generateOraclePDFReport(table, con);
        
        HelperFacade.generateReport(HelperFacade.DBtypes.MYSQL, HelperFacade.ReportTypes.HTML, table);
        HelperFacade.generateReport(HelperFacade.DBtypes.ORACLE, HelperFacade.ReportTypes.PDF, table);
    }
}
