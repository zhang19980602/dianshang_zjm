package com.example.zjm.model.vo;

public class ReponseData {
    private Integer code;

    private String  message;

    private Object data;


    public static ReponseData success(Object data) {
        ReponseData rs=new ReponseData();
        rs.setMessage("处理成功");
        rs.setCode(200);
        rs.setData(data);
        return  rs;
    }

    public static ReponseData error(String message,Integer code) {
        ReponseData rs=new ReponseData();
        rs.setMessage(message);
        rs.setCode(code);
        return  rs;
    }




    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
