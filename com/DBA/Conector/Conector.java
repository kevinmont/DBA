package com.DBA.Conector;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conector {
    private Connection conect;
    private DBM databases;
    private boolean conected=false;
   
    Conector(DBM dbm){
        databases=dbm;
        connection();
    }
    
    public void connection(){
        try {
            Class.forName(databases.getDriverManager());
            conect= DriverManager.getConnection(databases.getHost(),databases.getUser(),databases.getPassword());
            conected=true;
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
    }
    public Connection getConection() throws SQLException{
        if(conect!=null)
            return conect;
        throw new SQLException("no se pudo establecer la conexion");
    }
    /*
    retornara true en caso de la conexion se finaliza con exito
    re lo contrario false
    **/
    public boolean deathConnection(){
        try{
            if(conected){
                conect.close();
	        return true;
            }
        } catch (SQLException ex) {
            return false;
        }
    }
}
