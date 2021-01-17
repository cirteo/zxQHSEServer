package entity;

import java.util.List;

public class Data {
    public int status;
    public String msg;
    public Object data;
    public Object data2;
    public String name;
    public String create_time;
    public Object department;

    public Object getData2() {
        return data2;
    }

    public void setData2(Object data2) {
        this.data2 = data2;
    }

    public Object getDepartment() {
        return department;
    }

    public void setDepartment(Object department) {
        this.department = department;
    }

    public String  getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String  create_time) {
        this.create_time = create_time;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
