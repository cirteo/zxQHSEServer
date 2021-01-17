package controller;

import entity.Data;
import entity.Role;
import entity.User;
import net.sf.json.JSONObject;
import service.RoleService;
import service.UserService;
import service.impl.RoleServiceImpl;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginUserServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();
    private RoleService roleService = new RoleServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String account = req.getParameter("account");
        String password = req.getParameter("password");
        User user = (User) userService.login(account,password);
        Role role = roleService.QuerySingleRole(user.getType());
        if (role.getMenus() == null){
            role.setMenus("/home");
        }
        user.setMenus(role.getMenus().split(","));
        Data data1 = new Data();
        System.out.println("登录");
        if(user != null){
            data1.status = 0;
            data1.msg = "用户名和密码正确!";
            data1.data = user;
            JSONObject jsonObject = JSONObject.fromObject(data1);
            resp.getWriter().write(jsonObject.toString());
            System.out.println("Login返回参数："+jsonObject.toString());
        }else{
            data1.status = 1;
            data1.msg = "用户名或密码不正确!";
            data1.data = null;
            JSONObject jsonObject = JSONObject.fromObject(data1);
            resp.getWriter().write(jsonObject.toString());
            System.out.println(jsonObject.toString());
        }
    }
}
