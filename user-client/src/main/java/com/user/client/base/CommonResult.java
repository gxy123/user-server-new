package com.user.client.base;
import lombok.Data;
import org.slf4j.MDC;

import java.io.Serializable;

/**
 * @author guoxiaoyu
 * @email ggg_xiaoyu@163.com
 * @date 2020/8/7 10:12
 */
@Data
public class CommonResult<T> implements Serializable {
    private Integer code = 0;
    private boolean success = false;
    private String message;
    private String traceId;
    private T result;
    private Integer total = 0;
    public  static CommonResult Success(){
        return new CommonResult();
    }
    public CommonResult() {
        this.traceId = MDC.get("traceId");
    }

    public CommonResult(T result) {
        this.success = true;
        this.result = result;
        this.traceId = MDC.get("traceId");
    }

    public CommonResult(int code, String message) {
        if (code == 0) {
            this.success = true;
        }

        this.code = code;
        this.message = message;
        this.traceId = MDC.get("traceId");
    }

    public static <T> CommonResult<T> successReturn(T t) {
        return new CommonResult(t);
    }

    public static <T> CommonResult<T> errorReturn(String message) {
        return new CommonResult(CommonCode.CLIENT_ERROR.getCode(), message);
    }

    public static <T> CommonResult<T> errorReturn(int code, String message) {
        return new CommonResult(code, message);
    }

    public static <T> CommonResult<T> errorReturn(CommonCode def) {
        return new CommonResult(def.getCode(), def.getMessage());
    }

}
