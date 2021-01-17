package controller;

import entity.Data;
import entity.Form;
import entity.Form2;
import net.sf.json.JSONObject;
import service.FormService;
import service.impl.FormServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/queryAllDeliveryForm")
public class QueryAllDeliveryFormServlet extends HttpServlet {
    private FormService formService = new FormServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Form2> forms = formService.queryAllDeliveryForm();
        Data data = new Data();
        data.setData(forms);
        data.setStatus(0);
        data.setMsg("请求成功");
        JSONObject jsonObject = JSONObject.fromObject(data);
        resp.getWriter().write(jsonObject.toString());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}
