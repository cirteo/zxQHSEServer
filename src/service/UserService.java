package service;

import entity.User;

import java.util.List;

public interface UserService {
    public Object login(String account,String password);
    public int add(String account,String password,String type,String username);
    public int delete(String id);
    public int update(String account,String password,String type,String username);
    public List<User> QueryAll();
    public List<Object> QueryAllDepartment();
}
