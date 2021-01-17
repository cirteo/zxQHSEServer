package controller;

import entity.Data;
import entity.User;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/queryAll")
public class QueryAllUserServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> users =  userService.QueryAll();
        Data data = new Data();
        data.setData(users);
        data.setStatus(0);
        data.setMsg("请求成功");
        JSONObject jsonObject = JSONObject.fromObject(data);
        resp.getWriter().write(jsonObject.toString());
        System.out.println(jsonObject.toString());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> users =  userService.QueryAll();
        Data data = new Data();
        data.setData(users);
        data.setStatus(0);
        data.setMsg("请求成功");
        JSONArray jsonArray = JSONArray.fromObject(data);
        resp.getWriter().write(jsonArray.toString());
        System.out.println(jsonArray.toString());
    }
}
