package com.example.xpdayone.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Database {
    static final String DB_URL = "jdbc:mysql://examdb.cstgrhacqgbj.eu-central-1.rds.amazonaws.com:3306/examdb";
    static final String USER = "examuser";
    static final String PASS = "study2018";
    private Connection conn = null;
    public Database(){
        try {
            createConnection();
            System.out.println("created connection to db");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void createConnection() throws SQLException {
        System.out.println("Connecting to database..."); //STEP 1: Open a connection
        try {
            Class.forName("com.mysql.jdbc.Driver");

            conn = DriverManager.getConnection(DB_URL,USER,PASS);// automatically
            System.out.println(conn.getCatalog());//gets name of current database
            DatabaseMetaData metadata=conn.getMetaData(); // Here you can get info on the connection
            System.out.println(metadata.getUserName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public List<User> getAllUsers(){
        List<User> list = new ArrayList<>();
        Statement statement = null;
        try{
            statement = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE); //very cool: now we can update
            //direectly from any row in the resultset. Otherwise just create one without args.
            String sql = "SELECT * FROM customers"; // select primary key, if need to update resultSet
            ResultSet resultSet = statement.executeQuery(sql); //STEP 3: execute query, assign result to a ResultSet object

            while(resultSet.next()) //STEP 4: Extract data from result set
            {
                String username = resultSet.getString("name");
                double amount = resultSet.getDouble("amount");
                int id = resultSet.getInt("id");
                User user = new User(id, username, amount);
                list.add(user);
            }
            resultSet.close(); //STEP 5: Clean-up environment
            statement.close();
        }catch(SQLException se){
            System.out.println("Error connecting to MySQL Server");
            se.printStackTrace();
        }
        return list;
    }

    public void insert(User user){
        System.out.println("insert kaldt med " + user.getName() + " " + user.getAmount());
        try
        {
            String insertTableSQL = "INSERT INTO customers" + " VALUES" + "(null,?,?)";
            PreparedStatement preparedStatement = conn.prepareStatement(insertTableSQL);
            preparedStatement.setString(1, user.getName() );
            preparedStatement.setDouble(2, user.getAmount());
            System.out.println("prepared statement:  " + preparedStatement.toString());
            // execute insert SQL stetement
            int rowcount = preparedStatement.executeUpdate();
            System.out.println("Inserted: " + rowcount + " rows.");
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }



}
