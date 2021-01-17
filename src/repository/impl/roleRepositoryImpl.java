package repository.impl;

import entity.Role;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import repository.roleRepository;
import util.JDBCTools;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class roleRepositoryImpl implements roleRepository {
    int count=0;

    @Override
    public Role querySingleRole(String name) {
        Role role = null;
        String sql = "select * from role where name=?";
        QueryRunner queryHandler = new QueryRunner(JDBCTools.getDataSource());
        try {
            role = queryHandler.query(sql,new BeanHandler<Role>(Role.class),name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return role;
    }

    @Override
    public List<Role> queryAllRole() {
        List<Role> roles = null;
        String sql = "select * from role";
        QueryRunner queryHandler = new QueryRunner(JDBCTools.getDataSource());
        try {
            roles = queryHandler.query(sql,new BeanListHandler<Role>(Role.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return roles;
    }

    @Override
    public int updateRole(String auth_name, String auth_time, String create_time,String  name,String menus) {
        String sql = "update role set auth_name=?,auth_time=?,create_time=?,menus=? where name=?";
        QueryRunner queryHandler = new QueryRunner(JDBCTools.getDataSource());
        try {
            count = queryHandler.update(sql,auth_name,auth_time,create_time,menus,name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public int addRole(String name,Date create_time) {
        String sql = "insert into role(name,create_time,auth_time,auth_name,menus) values(?,?,?,?,?)";
        QueryRunner queryHandler = new QueryRunner(JDBCTools.getDataSource());
        try {
            count = queryHandler.update(sql,name,create_time,null,null,null);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }
}
