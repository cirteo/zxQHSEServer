package service.impl;

import entity.Form;
import entity.Form2;
import repository.formRepository;
import repository.impl.formRepositoryImpl;
import service.FormService;

import java.util.List;

public class FormServiceImpl implements FormService {
    private formRepository formRepository = new formRepositoryImpl();
    int count = 0;
    List<Form> forms=null;
    @Override
    public int addQuantityForm(String[] form) {
        count = formRepository.addQuantityForm(form);
        return count;
    }

    @Override
    public List<Form> queryAllQuantityForm() {
        forms = formRepository.queryAllQuantityForm();
        return forms;
    }

    @Override
    public int updateQuantityForm(String[] form) {
        count = formRepository.updateQuantityForm(form);
        return count;
    }

    @Override
    public List<Form> queryPartQuantityForm(String search,String searchName) {
        forms = formRepository.queryPartQuantityForm(search,searchName);
        return forms;
    }

    @Override
    public List<Form> queryDeliveryTermInQuantityForm(String id) {
        forms = formRepository.queryDeliveryTermInQuantityForm(id);
        return forms;
    }

    @Override
    public int addDeliveryForm(String[] form) {
        count = formRepository.addDeliveryForm(form);
        return count;
    }

    @Override
    public List<Form2> queryAllDeliveryForm() {
        List<Form2> list2 =null;
        list2 = formRepository.queryAllDeliveryForm();
        return list2;
    }

    @Override
    public String querySingleDeliveryForm(String department) {
        String deliveryTerm = formRepository.querySingleDeliveryForm(department);
        return deliveryTerm;
    }

    @Override
    public List<Form2> querySingleDeliveryForm(String department, String string) {
        List<Form2> list2 =null;
        list2 = formRepository.querySingleDeliveryForm(department,string);
        return list2;
    }

    @Override
    public int uploadDataForm(String account, int deliveryFormID,String detail) {
        count = formRepository.uploadDataForm(account,deliveryFormID,detail);
        return count;
    }
}
