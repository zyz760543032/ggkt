package com.atguigu.ggkt.result;

import com.baomidou.mybatisplus.extension.api.R;
import io.swagger.models.auth.In;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class Result<T> {

    /**
     * 给前端看的code
     */
    private Integer code;
    private String message;
    private T data;

    public static<T> Result<T> ok(){
        return ok(null);
    }

    public Result() {
    }

    public static<T> Result<T> ok(T data){
        Result<T> result = new Result<>();
        result.setCode(20000);
        result.setMessage("成功");
        result.setData(data);
        return result;
    }
    public static<T> Result<T> fail(T data){
        Result<T> result = new Result<>();
        result.setCode(20001);
        result.setMessage("失败");
        result.setData(data);
        return result;
    }
    public static<T> Result<T> fail(){
        return fail(null);
    }

    public Result<T> message(String msg){
        setMessage(msg);
        return this;
    }

    public Result<T> code(Integer code){
        setCode(code);
        return this;
    }

}
