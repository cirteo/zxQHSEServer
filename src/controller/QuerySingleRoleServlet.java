package controller;

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

@WebServlet("/querySingleRole")
public class QuerySingleRoleServlet extends HttpServlet {
    private RoleService roleService = new RoleServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        Role role = roleService.QuerySingleRole(name);
        JSONObject jsonObject = JSONObject.fromObject(role);
        resp.getWriter().write(jsonObject.toString());
    }
}
