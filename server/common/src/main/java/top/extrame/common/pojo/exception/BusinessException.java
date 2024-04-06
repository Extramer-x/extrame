package top.extrame.common.pojo.exception;

import top.extrame.common.model.enums.ResponseEnum;

import java.io.Serial;
import java.io.Serializable;

public class BusinessException extends BaseException implements Serializable {

    @Serial
    private static final long serialVersionUID = -2061099045655671517L;

    public BusinessException(ResponseEnum responseEnum, Object[] args) {
        super(responseEnum, args);
    }

    public BusinessException(ResponseEnum responseEnum, Object[] args, Throwable cause) {
        super(responseEnum, args, cause);
    }
}
