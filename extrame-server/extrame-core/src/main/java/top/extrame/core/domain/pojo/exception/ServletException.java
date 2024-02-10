package top.extrame.core.domain.pojo.exception;

import top.extrame.core.domain.module.enums.ResponseEnum;
import top.extrame.core.domain.pojo.exception.base.BaseException;

import java.io.Serial;
import java.io.Serializable;

/**
 * ServletException
 *
 * @author jx
 */
public class ServletException extends BaseException implements Serializable {

    @Serial
    private static final long serialVersionUID = 6362564704155960407L;

    public ServletException(ResponseEnum responseEnum, Object[] args) {
        super(responseEnum, args);
    }

    public ServletException(ResponseEnum responseEnum, Object[] args, Throwable cause) {
        super(responseEnum, args, cause);
    }
}
