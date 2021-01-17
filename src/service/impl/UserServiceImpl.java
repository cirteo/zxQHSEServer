package service.impl;

import entity.User;
import repository.impl.userRepositoryImpl;
import repository.userRepository;
import service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    private repository.userRepository userRepository = new userRepositoryImpl();

    @Override
    public Object login(String account, String password) {
        Object object = userRepository.login(account,password);
        return object;
    }
    @Override
    public int add(String account, String password, String type, String username) {
        int count = userRepository.add(account, password, type, username);
        return count;
    }
    @Override
    public int delete(String id) {
        int count = userRepository.delete(id);
        return count;
    }
    @Override
    public int update(String account, String password, String type, String username) {
        int count = userRepository.update(account, password, type, username);
        return count;
    }
    @Override
    public List<User> QueryAll() {
        List<User> users = userRepository.queryAll();
        return users;
    }

    @Override
    public List<Object> QueryAllDepartment() {
        List<Object> list = userRepository.queryAllDepartment();
        return list;
    }
}
