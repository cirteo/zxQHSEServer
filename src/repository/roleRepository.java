package repository;

import entity.Role;

import java.util.Date;
import java.util.List;

public interface roleRepository {
    public List<Role> queryAllRole();
    public int updateRole(String auth_name, String auth_time, String create_time, String name, String menus);
    public int addRole(String name, Date create_time);
    public Role querySingleRole(String name);
}
