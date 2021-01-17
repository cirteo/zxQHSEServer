package controller;

import entity.Data;
import net.sf.json.JSONObject;
import service.RoleService;
import service.impl.RoleServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updateRole")
public class UpdateRoleServlet extends HttpServlet {
    private RoleService roleService = new RoleServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String auth_name = req.getParameter("auth_name");
        String auth_time = req.getParameter("auth_time");
        String create_time=req.getParameter("create_time");
        String name=req.getParameter("name");
        String id = req.getParameter("id");
        String menus = req.getParameter("menus");
        int count = roleService.UpdateRole(auth_name,auth_time,create_time,name,menus);
        if(count != 0){
            Data data = new Data();
            data.status = 0;
            JSONObject jsonObject = JSONObject.fromObject(data);
            resp.getWriter().write(jsonObject.toString());
            System.out.println(jsonObject.toString());
        }else{
            resp.getWriter().write("error");
        }
    }
}
