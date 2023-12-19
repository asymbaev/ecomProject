package ecomProject.src.clothingStore;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBConnection {
    private static final String DB_URL="jdbc:mysql://localhost:3306/clothingdb";
    private static final String DB_USER="root";
    private static final String DB_PASSWORD="1234";

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
