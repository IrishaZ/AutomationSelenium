package adapter;


import java.sql.*;

public class DbAdapter {

    // JDBC driver name and database URL
    protected static final String JDBC_DRIVER = "org.mariadb.jdbc.Driver";
    protected static final String DB_URL = "jdbc:mariadb://104.237.13.60/dbkoel";

    //  Database credentials
    protected static final String USER = "dbuser01";
    protected static final String PASS = "pa$$01";
    public static ResultSet makeQuery(String query) {
        ResultSet resultSet = null;
        Connection conn = null;
        Statement stmt = null;
        try {
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);
            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            System.out.println("Connected database successfully...");
            //STEP 4: Execute a query
            stmt = conn.createStatement();
            resultSet = stmt.executeQuery(query);
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (ClassNotFoundException e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null) {
                    conn.close();
                }
            } catch (SQLException se) {}// do nothing

            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try
        System.out.println("Goodbye!");
        return resultSet;
    }
}



