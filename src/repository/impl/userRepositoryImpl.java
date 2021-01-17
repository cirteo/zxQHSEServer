package repository.impl;

import entity.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import repository.userRepository;
import util.JDBCTools;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class userRepositoryImpl implements userRepository {
    User user = null;
    int count = 0;

    @Override
    public User login(String account, String password){
        String sql = "select * from user where account=? and password=?";
        QueryRunner queryHandler = new QueryRunner(JDBCTools.getDataSource());
        try {
            user = queryHandler.query(sql,new BeanHandler<User>(User.class),account,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public List<User> queryAll() {
        List<User> users = null;
        String sql = "select * from user";
        QueryRunner queryHandler = new QueryRunner(JDBCTools.getDataSource());
        try {
            users = queryHandler.query(sql,new BeanListHandler<User>(User.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public List<Object> queryAllDepartment() {
        List<Object> list = null;
        String sql = "select DISTINCT left(ACCOUNT,4) from user ORDER BY left(ACCOUNT,4)";
        QueryRunner queryHandler = new QueryRunner(JDBCTools.getDataSource());
        try {
            list = queryHandler.query(sql,new ColumnListHandler<Object>());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public int add(String account, String password, String type, String username) {
        String sql = "insert into user(account,password,type,username) values(?,?,?,?)";
        QueryRunner queryHandler = new QueryRunner(JDBCTools.getDataSource());
        try {
            count = queryHandler.update(sql,account,password,type,username);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public int update(String account, String password, String type, String username) {
        String sql = "update user set password=?,type=?,username=? where account=?";
        QueryRunner queryHandler = new QueryRunner(JDBCTools.getDataSource());
        try {
            count = queryHandler.update(sql,password,type,username,account);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public int delete(String id) {
        String sql = "delete from user where id=?";
        QueryRunner queryHandler = new QueryRunner(JDBCTools.getDataSource());
        try {
            count = queryHandler.update(sql,id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }
}

