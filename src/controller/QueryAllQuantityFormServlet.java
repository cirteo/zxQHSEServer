package controller;

import entity.Data;
import entity.Form;
import net.sf.json.JSONObject;
import service.FormService;
import service.UserService;
import service.impl.FormServiceImpl;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/evaluate")
public class QueryAllQuantityFormServlet extends HttpServlet {
    private FormService formService = new FormServiceImpl();
    private UserService userService = new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Form> forms = formService.queryAllQuantityForm();
        List<Object> list = userService.QueryAllDepartment();
        Data data = new Data();
        data.setData(forms);
        data.setStatus(0);
        data.setDepartment(list);
        data.setMsg("请求成功");
        JSONObject jsonObject = JSONObject.fromObject(data);
        resp.getWriter().write(jsonObject.toString());
    }
}
