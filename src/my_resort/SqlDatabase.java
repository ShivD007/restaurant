package my_resort;


import java.sql.Connection;
import java.sql.DriverManager;


public class SqlDatabase {
   
    public static Connection dbconnet()
    {  Connection conn = null;
           try {
               Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:database\\resort.sqlite");
           System.out.println("Connection to SQLite has been established.");
           return conn;
           } catch (Exception e) {  
            System.out.println(e.getMessage());  
            return null;
        }
    }
}
