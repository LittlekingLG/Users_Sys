package edu.nf.Users_Sys.controller;

import edu.nf.Users_Sys.dao.UsersDao;
import edu.nf.Users_Sys.entity.Users;
import edu.nf.controller.Myanno;
import edu.nf.view.View;
import edu.nf.view.impl.GonsView;

import java.sql.SQLException;
import java.util.List;

public class UsersController {

    @Myanno("/list")
    public View usersList(){
        UsersDao usersDao=new UsersDao();
        List<Users> list=usersDao.usersList();
        return new GonsView(list);
    }

    @Myanno("/add")
    public View addUsers(Users users){
        int vo=500;
        UsersDao usersDao=new UsersDao();
        try{
            usersDao.addUsers(users);
            vo=200;
        }catch(RuntimeException e){
            e.printStackTrace();
        }
        finally {
            return new GonsView(vo);
        }

    }
}
