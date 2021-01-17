package controller;

import entity.Data;
import net.sf.json.JSONObject;
import service.FormService;
import service.impl.FormServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/uploadDataForm")
public class UploadDataFormServlet extends HttpServlet {
    private FormService formService = new FormServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String account = req.getParameter("account");
        String deliveryID=req.getParameter("deliveryID");
        String detail = req.getParameter("detail");

        int count = formService.uploadDataForm(account,Integer.parseInt(deliveryID),detail);
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
