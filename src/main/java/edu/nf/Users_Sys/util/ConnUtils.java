package edu.nf.Users_Sys.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnUtils {

    private  static  String driver="com.mysql.jdbc.Driver";
    private  static  String url="jdbc:mysql://localhost:3306/users?useUnicode=true&characterEncoding=utf-8";
    private  static  String user="root";
    private  static  String password="root";

    static{
        try{
            Class.forName(driver);
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        Connection conn=null;

        try {
            conn= DriverManager.getConnection(url,user,password);
            return conn;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return conn;
        }

    }


}
