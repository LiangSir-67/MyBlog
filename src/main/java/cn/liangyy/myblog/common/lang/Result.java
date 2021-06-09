package cn.liangyy.myblog.common.lang;

import lombok.Data;

import java.io.Serializable;

/**
 * 统一结果封装
 * code 200为正常，100为失败
 */

@Data
public class Result implements Serializable {
    public final static String SUCCESS = "200";
    public final static String FAIL = "100";

    private String code;
    private String msg;
    private Object data;

    public static Result succ(Object data) {
        Result m = new Result();
        m.setCode(SUCCESS);
        m.setMsg("操作成功");
        m.setData(data);
        return m;
    }
    public static Result succ(String mess, Object data) {
        Result m = new Result();
        m.setCode(SUCCESS);
        m.setMsg(mess);
        m.setData(data);
        return m;
    }
    public static Result fail(String mess) {
        Result m = new Result();
        m.setCode(FAIL);
        m.setMsg(mess);
        m.setData(null);
        return m;
    }
    public static Result fail(String mess, Object data) {
         Result m = new Result();
         m.setCode(FAIL);
         m.setMsg(mess);
         m.setData(data);
         return m;
    }
}