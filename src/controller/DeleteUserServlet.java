package controller;

import entity.Data;
import net.sf.json.JSONObject;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete")
public class DeleteUserServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        int count = userService.delete(id);
        if (count != 0){
            Data data = new Data();
            data.status=0;
            JSONObject jsonObject = JSONObject.fromObject(data);
            resp.getWriter().write(jsonObject.toString());
            System.out.println(jsonObject.toString());
        }else{
            resp.getWriter().write("error");
        }
    }
}
