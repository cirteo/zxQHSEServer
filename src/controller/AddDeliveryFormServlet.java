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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;

@WebServlet("/addDeliveryForm")
public class AddDeliveryFormServlet extends HttpServlet {
    private FormService formService = new FormServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[][] form = null;
        int i = 0;
        int count = 0;

        Enumeration paramNames = req.getParameterNames();
        while(paramNames.hasMoreElements()) {
            String paramName = (String)paramNames.nextElement();
            String[] paramValues =
                    req.getParameterValues(paramName);
            if (form == null){
                form = new String[paramValues.length][11];
            }
            if (form.length != 0) {
                for(int j=0; j < paramValues.length; j++) {
                    form[j][i] = paramValues[j];
                }
                i++;
            }
        }

        for (int x = 0;x<form.length;x++){
            count = formService.addDeliveryForm(form[x]);
        }

        if (count != 0){
            Data data = new Data();
            data.status = 0;
            JSONObject jsonObject = JSONObject.fromObject(data);
            resp.getWriter().write(jsonObject.toString());
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] form=new String[5];
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String auth_time = formatter.format(new Date());
        form[0] = req.getParameter("auth");
        form[1] = auth_time;
        form[2] = req.getParameter("department");
        form[3] = req.getParameter("deliveryTerm");
        form[4] = req.getParameter("deliveryFormName");
        int count = formService.addDeliveryForm(form);
        if (count != 0){
            Data data = new Data();
            data.status = 0;
            JSONObject jsonObject = JSONObject.fromObject(data);
            resp.getWriter().write(jsonObject.toString());
        }
    }
}
