/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kata5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 *
 * @author usuario
 */
public class Kata5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("oracle.jdbc.driver.OracleDriver"); //DRIVER DE ORACLE
        Connection connect= DriverManager.getConnection("jdbc:oracle:thin:@10.22.143.90:1521:orcl","system","orcl");
        //ACCEDEMOS A LA BASE DE DATOS
        Statement state = connect.createStatement();
        String query="SELECT * FROM PEOPLE";
        
        ResultSet rs= state.executeQuery(query);
        
        while(rs.next()){
            System.out.println(rs.getInt("ID"));
            System.out.println(rs.getString("NAME"));
        }
        rs.close();
        state.close();
        connect.close();
        
    }
    
    
    
    
}
