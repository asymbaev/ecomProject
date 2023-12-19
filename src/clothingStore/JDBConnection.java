package ecomProject.src.clothingStore;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBConnection {
    private static final String DB_URL="";
    private static final String DB_USER="";
    private static final String DB_PASSWORD="";

    public static Connection getConnection(){
        Connection conn =null;
        try {
            conn = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
            System.out.println("Connected Successfully");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return conn;
    }
}
