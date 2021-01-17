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
import java.util.Enumeration;

@WebServlet("/evaluate/update")
public class UpdateQuantityFormServlet extends HttpServlet {
    private FormService formService = new FormServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] form=new String[12];
        int i = 0;
        Enumeration pNames=req.getParameterNames();
        while(pNames.hasMoreElements()){
            String name=(String)pNames.nextElement();
            String value=req.getParameter(name);
            form[i]=value;
            i++;
        }
        int count = formService.updateQuantityForm(form);
        if (count != 0){
            Data data = new Data();
            data.status = 0;
            JSONObject jsonObject = JSONObject.fromObject(data);
            resp.getWriter().write(jsonObject.toString());
        }
    }
}
