package com.DBA.Postgre;
import com.DBA.Conector.DBM;
public class Postgre extends DBM{
    private String dba;
    Postgre(String dba){
        this.dba=dba;
    }

    @Override
    public String getDriverManager() {
        return "org.postgresql.Driver";
    }

    @Override
    public String getHost() {
        return "jdbc:postgresql://127.0.0.1/"+dba;
    }

    @Override
    public String getUser() {
        return "postgres";
    }

    @Override
    public String getPassword() {
        return "1234";
    }
    
}
