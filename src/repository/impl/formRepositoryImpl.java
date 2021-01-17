package repository.impl;

import entity.Form;
import entity.Form2;
import entity.Role;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import repository.formRepository;
import util.JDBCTools;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class formRepositoryImpl implements formRepository {
    int count = 0;
    List<Form> forms = null;

    @Override
    public int addQuantityForm(String[]  form) {
        Object[] form1 = (Object[]) form;
        String sql = "insert into quantityform(theme,project,content,requirement,explains,term,method,score,formula,havescore,description) values(?,?,?,?,?,?,?,?,?,?,?)";
        QueryRunner queryHandler = new QueryRunner(JDBCTools.getDataSource());
        try {
            count = queryHandler.update(sql,form1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public List<Form> queryAllQuantityForm() {
        String sql = "select * from quantityForm";
        QueryRunner queryHandler = new QueryRunner(JDBCTools.getDataSource());
        try {
            forms = queryHandler.query(sql, new BeanListHandler<Form>(Form.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return forms;
    }

    @Override
    public int updateQuantityForm(String[] form) {
        Object[] form1 = (Object[]) form;
        String sql = "update quantityForm set theme=?,project=?,content=?,requirement=?," +
                "explains=?,term=?,method=?,score=?,formula=?,haveScore=?,description=? where id = ?";
        QueryRunner queryHandler = new QueryRunner(JDBCTools.getDataSource());
        try {
            count = queryHandler.update(sql,form1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public List<Form> queryPartQuantityForm(String search,String searchName) {
        String sql = "select * from quantityForm where " +search+" like '%"+searchName+"%'";
        QueryRunner queryHandler = new QueryRunner(JDBCTools.getDataSource());
        try {
            forms = queryHandler.query(sql,new BeanListHandler<Form>(Form.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return forms;
    }

    @Override
    public List<Form> queryDeliveryTermInQuantityForm(String id) {
        String sql = "SELECT * FROM quantityform WHERE id IN ("+id+")";
        QueryRunner queryHandler = new QueryRunner(JDBCTools.getDataSource());
        try {
            forms = queryHandler.query(sql,new BeanListHandler<Form>(Form.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return forms;
    }

    @Override
    public int addDeliveryForm(String[] form) {
        Object[] form1 = (Object[]) form;
        String sql = "insert into deliveryform2(auth,auth_time,department,deliveryTerm,deliveryFormName) values(?,?,?,?,?)";
        QueryRunner queryHandler = new QueryRunner(JDBCTools.getDataSource());
        try {
            count = queryHandler.update(sql,form1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public List<Form2> queryAllDeliveryForm() {
        List<Form2> list2 = null;
        String sql = "select * from deliveryForm2";
        QueryRunner queryHandler = new QueryRunner(JDBCTools.getDataSource());
        try {
            list2 = queryHandler.query(sql, new BeanListHandler<Form2>(Form2.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list2;
    }

    @Override
    public String querySingleDeliveryForm(String department) {
        String deliveryTerm = null;
        List<String> list = null;
        String sql = "select deliveryTerm from deliveryform2 where department=?";
        QueryRunner queryHandler = new QueryRunner(JDBCTools.getDataSource());
        try {
            list = queryHandler.query(sql, new ColumnListHandler<String>("deliveryTerm"),department);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        deliveryTerm = list.toString();
        return deliveryTerm;
    }
    @Override
    public List<Form2> querySingleDeliveryForm(String department,String string) {
        List<Form2> list = null;
        String sql = "select * from deliveryform2 where department=? and deliveryTerm=?";
        QueryRunner queryHandler = new QueryRunner(JDBCTools.getDataSource());
        try {
            list = queryHandler.query(sql, new BeanListHandler<Form2>(Form2.class),department,string);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public int uploadDataForm(String account,int deliveryFormID,String detail) {
        String sql = "insert into dataform(account,deliveryFormID,detail) values(?,?,?)";
        QueryRunner queryHandler = new QueryRunner(JDBCTools.getDataSource());
        try {
            count = queryHandler.update(sql,account,deliveryFormID,detail);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }
}
