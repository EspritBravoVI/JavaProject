package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import utils.DataSource;

public class UserService {
  Connection conn = DataSource.getInstance().getCnx();
  Statement sst;



  public boolean userLogin(String id, String password, String hiddenpass) throws SQLException {
    sst = conn.createStatement();
    ResultSet rss=sst.executeQuery("select * from user where id = '" + id + "' and (pass ='" + password + "')");

    if(rss.next()){
      rss.close();
      return true;

    }
    sst.close();
    rss.close();
    return false;
  }

  public void updateUsername(String oldId, String newId) throws SQLException{
    sst = conn.createStatement();
    String sql = "update user set id = '" + newId + "' where id = '" + oldId + "'";
    sst.executeUpdate(sql);
    sst.close();
  }

  public void updatePassword(String newPassword, String username) throws SQLException{
    Statement st = conn.createStatement();
    String sql = "update user set pass = '" + newPassword + "' where id = '" + username + "'";
    st.executeUpdate(sql);
    st.close();
  }

  public void deleteUser(String username) throws SQLException{
    String sql = "delete from user where id = '" + username + "'";
    Statement st = conn.createStatement();
    ResultSet r = st.executeQuery("select COUNT(*) from user where id = '"+username+"'");
    if (r.getInt(1)==0) {
      throw new SQLException("User Not Found!!");
    }
    st.executeUpdate(sql);
    st.close();
    r.close();
  }

  public void addUser(String username, String password) throws SQLException{

    PreparedStatement add = conn.prepareStatement("INSERT INTO user VALUES(NULL,?,?)");
    add.setString(1, username);
    add.setString(2, password);
    add.executeUpdate();
    add.close();
  }
  public static void main(String[] args) throws SQLException {
    UserService userService = new UserService();
    userService.addUser("anas","anas");
  }

}
