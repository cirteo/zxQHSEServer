package service;

import entity.Role;

import java.util.Date;
import java.util.List;

public interface RoleService {
    public int addRole(String name, Date create_time);
    public List<Role> QueryAllRole();
    public Role QuerySingleRole(String name);
        public int UpdateRole(String auth_name,String auth_time,String create_time,String  name,String menus);

}
