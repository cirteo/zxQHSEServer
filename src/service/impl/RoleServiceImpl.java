package service.impl;

import entity.Role;
import repository.impl.roleRepositoryImpl;
import repository.roleRepository;
import service.RoleService;

import java.util.Date;
import java.util.List;

public class RoleServiceImpl implements RoleService {
    private repository.roleRepository roleRepository = new roleRepositoryImpl();
    @Override
    public int addRole(String name, Date create_time) {
        int count = roleRepository.addRole(name,create_time);
        return count;
    }
    @Override
    public List<Role> QueryAllRole() {
        List<Role> roles = roleRepository.queryAllRole();
        return roles;
    }
    @Override
    public Role QuerySingleRole(String name) {
        Role role = roleRepository.querySingleRole(name);
        return role;
    }
    @Override
    public int UpdateRole(String auth_name,String auth_time,String create_time,String  name,String menus) {
        int count = roleRepository.updateRole(auth_name,auth_time,create_time,name,menus);
        return count;
    }

}
