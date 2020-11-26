package edu.nf.Users_SysText;

import edu.nf.Users_Sys.dao.UsersDao;
import edu.nf.Users_Sys.entity.Users;
import org.junit.Test;

import java.lang.annotation.Target;
import java.util.List;

public class TestUserDao {
    @Test
    public void  listUsers(){
        UsersDao usersDao=new UsersDao();
        List<Users> list=usersDao.usersList();
        list.forEach(users -> {
            System.out.println(users.getUName());
        });
    }
}
