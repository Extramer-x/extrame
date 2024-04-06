package top.extrame.common.pojo;

import lombok.Getter;
import lombok.Setter;
import top.extrame.common.model.Result;

/**
 * 响应统一回复类
 *
 * @param <T> 携带数据类型
 */
public class ResponseResult<T> implements Result {

    private final Integer status;
    private final String message;
    @Setter
    @Getter
    private T data;

    public ResponseResult(Integer status, String message) {
        this.status = status;
        this.message = message;
    }

    public ResponseResult(Integer status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    @Override
    public Integer getStatus() {
        return status;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
