/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
/**
 *
 * @author User
 */
public class MySQL {
     private static Connection connection;

    static {  //static block ekk 1 m ekk parai load wenne jvm ekm 
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/careplus", "root", "277353Hentai@");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    

    public static ResultSet execute(String query) throws Exception {

        Statement statement = connection.createStatement();

        if (query.startsWith("SELECT")) {
            return statement.executeQuery(query);

        } else {
            statement.executeUpdate(query);
            return null;
        }

    }
}
