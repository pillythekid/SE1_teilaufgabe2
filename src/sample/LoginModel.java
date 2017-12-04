package sample;

import java.sql.*;

import dbUtil.dbConnection;

/**
 * Created by biropo on 02.12.17.
 */
public class LoginModel {

    Connection connection;

    public LoginModel (){
        try {
            this.connection = dbConnection.getConnection();
        } catch(SQLException e){
            e.printStackTrace();
        } if (this.connection == null) {
            System.exit(1);
        }
    }
    public boolean isDBcon() {
        return this.connection != null;
    } public boolean isDBlogin(String user, String password) throws Exception {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sqlquery = "SELECT * FROM login WHERE mtrnr = ? AND password = ?";
        try {
            stmt = this.connection.prepareStatement(sqlquery);
            stmt.setString(1, user);
            stmt.setString(2, password);
            rs = stmt.executeQuery();
            System.out.println(rs.getInt(1)+", "+rs.getString(2));

            boolean bcheck = false;
            if (rs.next()){
                bcheck = true;
            } return bcheck;
        } catch (SQLException e){
            System.out.println(user+", "+password+": no data found.");
            return false;
        }
        finally {
                try {
                    stmt.close();
                    rs.close();
                } catch (NullPointerException e){
                    e.printStackTrace();
                }
        }
    }
}
