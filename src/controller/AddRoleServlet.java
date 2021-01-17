package controller;

import entity.Data;
import entity.Role;
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
import java.util.Date;

@WebServlet("/addRole")
public class AddRoleServlet extends HttpServlet {
    private RoleService roleService = new RoleServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        Date create_time = new Date();
        //SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        int count = roleService.addRole(name,create_time);
        Role role = roleService.QuerySingleRole(name);
        if(count != 0){
            Data data = new Data();
            data.status = 0;
            data.name = name;
            data.data = role;
            //data.create_time = formatter.format(create_time);
            JSONObject jsonObject = JSONObject.fromObject(data);
            resp.getWriter().write(jsonObject.toString());
            System.out.println(jsonObject.toString());
        }else{
            resp.getWriter().write("error");
        }
    }
}
