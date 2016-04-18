package controller.model.MySqlConnection;

import controller.model.members.Child;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

/**
 * Created by Ilias on 3/15/2016.
 */
public class Connector {
    private static final String url = "jdbc:mysql://localhost:3306/fxdatabase";
    private static final String user = "root";
    private static final String password = "adminroot";

    private static Connection con;
    private static Statement stmt;
    private static ResultSet rs;

    public static boolean tryLogin(String login, String pass){
        String query = "SELECT password from users where user like '" + login + "'";

        try{
            con = DriverManager.getConnection(url, user, password);

            stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery(query);

            if(rs.next())
                return rs.getString(1).equals(pass);

        }catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }finally
        {
            //close connection ,stmt and resultset here
            try { if(con!=null) con.close(); } catch(SQLException se) { /*can't do anything */ }
            try { if(stmt!=null) stmt.close(); } catch(SQLException se) { /*can't do anything */ }
            try { if(rs!=null) rs.close(); } catch(SQLException se) { /*can't do anything */ }
        }
        return false;
    }
    public static ObservableList<Child> getChildList(){
        String query = "SELECT * from members";

        try{
            con = DriverManager.getConnection(url, user, password);

            stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery(query);

            int length = rs.getMetaData().getColumnCount();

            ObservableList<Child> list = FXCollections.observableArrayList();

            while(rs.next()) {

                String name = rs.getString(2);
                String lastName = rs.getString(3);
                String adress = rs.getString(4);
                String phone = rs.getString(5);
                String prCode = rs.getString(6);

                Child tmp = new Child(name, lastName, adress, Integer.parseInt(prCode), phone, phone , "2000-04-19", "1");
                tmp.setadres(adress);
                tmp.setPhoneNumber(phone);
                tmp.setPostalCode(Integer.parseInt(prCode));

                list.add(tmp);
            }
            return list;

        }catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }finally
        {
            //close connection ,stmt and resultset here
            try { if(con!=null) con.close(); } catch(SQLException se) { /*can't do anything */ }
            try { if(stmt!=null) stmt.close(); } catch(SQLException se) { /*can't do anything */ }
            try { if(rs!=null) rs.close(); } catch(SQLException se) { /*can't do anything */ }
        }
        return null;
    }
}
