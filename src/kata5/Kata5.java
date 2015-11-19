/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kata5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
     * @throws java.lang.ClassNotFoundException
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
        Class.forName("org.sqlite.JDBC"); //DRIVER DE SQLITE
        Connection connect= DriverManager.getConnection("jdbc:sqlite:Kata5.db");//Nombre de la db
        //ACCEDEMOS A LA BASE DE DATOS
        Statement state = connect.createStatement();
        String query="SELECT * FROM PEOPLE";
        ResultSet rs= state.executeQuery(query);
        
        while(rs.next()){
            System.out.print(rs.getInt("ID")+" ");
            System.out.println(rs.getString("NAME"));
        }
        
        
        
        String nameFile="emailsfilev1.txt";
        BufferedReader reader=new BufferedReader(new FileReader(new File(nameFile)));
        
        String mail;
        while((mail=reader.readLine())!=null){
            query= "INSERT INTO MAILS(MAIL) VALUES ('"+mail+"')";
            state.executeUpdate(query);//Para actualizar la tabla
        }
        
        rs.close();
        state.close();
        connect.close();
        
    }
    
    
    
    
}
