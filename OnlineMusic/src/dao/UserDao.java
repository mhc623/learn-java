package dao;

import entity.User;
import util.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    public  User login(User loginUser) {
        User user = null;
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "select * from user where username=? and password=?";
            connection = DBUtils.getConnection();
            ps = connection.prepareStatement(sql);//对SQL语句的预编译
            ps.setString(1,loginUser.getUsername());
            ps.setString(2,loginUser.getPassword());
            //执行sql语句
            rs = ps.executeQuery();
            if(rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setAge(rs.getInt("age"));
                user.setGender(rs.getString("gender"));
                user.setEmail(rs.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.getClose(connection,ps,rs);
        }
        return user;
    }
    public void register(User user) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement("insert into user values(null,?,?,?,?,?)");
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getGender());
            ps.setInt(4, user.getAge());
            ps.setString(5, user.getEmail());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }finally {
            DBUtils.getClose(conn, ps, null);
        }
    }
    public static void main(String[] args) {
      //  User user = new User();
        //user.setUsername("小明");
       // user.setPassword("123");
       // User loginUser = login(user);
       // System.out.println(loginUser);
    }
}
