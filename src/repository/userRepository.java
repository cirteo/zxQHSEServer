package repository;

import entity.User;

import java.util.List;

public interface userRepository {
    public User login(String account, String password);
    public List<User> queryAll();
    public List<Object> queryAllDepartment();
    public int add(String account, String password, String type, String username);
    public int update(String account, String password, String type, String username);
    public int delete(String id);
}
