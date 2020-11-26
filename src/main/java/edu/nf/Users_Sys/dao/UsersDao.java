package edu.nf.Users_Sys.dao;

import edu.nf.Users_Sys.entity.Users;
import edu.nf.Users_Sys.util.ConnUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsersDao {
    public List<Users> usersList()
    {
        String sql="select * from userinfo";
        List<Users> list=new ArrayList<>();
        try {
            Connection conn= ConnUtils.getConnection();
            PreparedStatement ps=conn.prepareStatement(sql);
            try {
                ResultSet rs=ps.executeQuery();
                while (rs.next())
                {
                    Users users=new Users();
                    users.setUId(rs.getInt("uId"));
                    users.setUName(rs.getString("uName"));
                    users.setAge(rs.getInt("age"));
                    users.setSex(rs.getString("sex"));
                    list.add(users);
                }
                return list;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("查询一次",e);
        }
        return list;
    }
    public void  addUsers(Users users)
    {
        String sql="insert into userinfo values(?,?,?,?)";
        try {
            Connection conn= ConnUtils.getConnection();
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setInt(1,users.getUId());
            ps.setString(2,users.getUName());
            ps.setString(3,users.getSex());
            ps.setInt(4,users.getAge());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("添加失败",e);
        }
    }
}
