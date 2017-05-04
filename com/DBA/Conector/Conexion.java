package com.DBA.Conector;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.ResultSetMetaData;

public class Conexion {
    
    public static final String HOST="jdbc:postgresql://127.0.0.1/empresa"; /**
     JDBC para conexion con postgre y su host 127.0.0.1  y nuestra base de datos
     */
    
    public static void main(String ah[]){
        Connection conexion=null;
        Statement declaracion=null;
        ResultSet resul=null;
        ResultSetMetaData meta;
        try{
            Class.forName("org.postgresql.Driver"); //  driver manager de postgre
            conexion=DriverManager.getConnection(HOST, "postgres", "1234"); // realiza la conexion 
            declaracion=conexion.createStatement();
            resul=declaracion.executeQuery("insert into compañia (rfc, nombre, no_socu,direccion ,telefono) values ('ARP-671A','AutoSur S.A de C.V','125','Benito #789','9907864565')");
            //resul=declaracion.executeQuery("select * from compañia");
            System.out.println("conectado::");
            /*while(resul.next()){
                System.out.println(resul.getString("no_socu")+" "+resul.getString("nombre")+" "+resul.getString("rfc")+" "+resul.getString("direccion")+" "+resul.getString("telefono"));
            }*/
        }catch(SQLException ex){
            ex.printStackTrace();
        }catch(ClassNotFoundException ex){
            ex.printStackTrace();
        }
        finally{
            try{
                declaracion.close();
                conexion.close();
                System.out.println("::cerrando conexion::");
            }catch(SQLException ez){
                ez.printStackTrace();
            }
        }
            
    }
    
}
