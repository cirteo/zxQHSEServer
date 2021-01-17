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
import java.util.ArrayList;
import java.util.List;

@WebServlet("/querySingleDeliveryForm")
public class QuerySingleDeliveryFormServlet extends HttpServlet {
    private FormService formService = new FormServiceImpl();
    private Data data = new Data();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String account = req.getParameter("account");
        String department = account.substring(0,4);
        String deliveryTerm = formService.querySingleDeliveryForm(department);
        String deliveryTerm1 = deliveryTerm.substring(1);
        String reverse = new StringBuffer(deliveryTerm1).reverse().toString();
        String reverse1 = reverse.substring(1);
        String string = new StringBuffer(reverse1).reverse().toString();

        //String[] valueArr = string.split(",");

        List<Form> forms = formService.queryDeliveryTermInQuantityForm(string);
        List<Form2> form2s = formService.querySingleDeliveryForm(department,string);
        data.setData(forms);
        data.setData2(form2s);
        data.setStatus(0);
        data.setMsg("请求成功");
        JSONObject jsonObject = JSONObject.fromObject(data);
        resp.getWriter().write(jsonObject.toString());
    }
}
