package top.extrame.core.pojo.exception;


import top.extrame.core.model.enums.ResponseEnum;

import java.io.Serial;
import java.io.Serializable;

public class BusinessException extends BaseException implements Serializable {

    @Serial
    private static final long serialVersionUID = 7373277090924206609L;

    public BusinessException(ResponseEnum responseEnum, Object[] args) {
        super(responseEnum, args);
    }

    public BusinessException(ResponseEnum responseEnum, Object[] args, Throwable cause) {
        super(responseEnum, args, cause);
    }
}
