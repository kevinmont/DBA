/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DBA.MySql;

/**
 *
 * @author kevin
 */
import com.DBA.Conector.DBM;
public class Mysql extends DBM {
    private String dba;
    Mysql(String dba){
        this.dba=dba;
    }

    @Override
    public String getHost() {
        return "jdbc:mysql://localhost/"+dba;
    }

    @Override
    public String getUser() {
        return "root";
    }

    @Override
    public String getPassword() {
        return "1234";
    }

    @Override
    public String getDriverManager() {
        return "com.mysql.jdbc.Driver";
    }
    
}
