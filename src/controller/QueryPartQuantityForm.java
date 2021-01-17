package controller;

import entity.Data;
import entity.Form;
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

@WebServlet("/evaluateTheme")
public class QueryPartQuantityForm extends HttpServlet {
    private FormService formService = new FormServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String search = req.getParameter("search");
        String searchName = req.getParameter("searchName");
        List<Form> forms = formService.queryPartQuantityForm(search,searchName);
        Data data = new Data();
        data.setStatus(0);
        data.setData(forms);
        data.setMsg("请求成功");
        JSONObject jsonObject = JSONObject.fromObject(data);
        resp.getWriter().write(jsonObject.toString());
    }
}
