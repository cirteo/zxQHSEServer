package controller;

import entity.Data;
import entity.Role;
import net.sf.json.JSONObject;
import service.RoleService;
import service.impl.RoleServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/queryRole")
public class QueryAllRoleServlet extends HttpServlet {

    private RoleService roleService = new RoleServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Data data = new Data();
        List<Role> roles =  roleService.QueryAllRole();
        data.setData(roles);
        data.setStatus(0);
        data.setMsg("请求成功");
        JSONObject jsonObject = JSONObject.fromObject(data);
        resp.getWriter().write(jsonObject.toString());
        System.out.println(jsonObject.toString());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
