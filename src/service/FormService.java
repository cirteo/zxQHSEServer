package service;

import entity.Form;
import entity.Form2;
import entity.Role;

import java.util.List;

public interface FormService {
    public int addQuantityForm(String[] form);
    public List<Form> queryAllQuantityForm();
    public int updateQuantityForm(String[] form);
    public List<Form> queryPartQuantityForm(String search,String searchName);
    public List<Form> queryDeliveryTermInQuantityForm(String id);
    public int addDeliveryForm(String[] form);
    public List<Form2> queryAllDeliveryForm();
    public String querySingleDeliveryForm(String department);
    public List<Form2> querySingleDeliveryForm(String department,String string);
    public int uploadDataForm(String account,int deliveryFormID,String detail);
}
