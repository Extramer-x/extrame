package top.extrame.common.pojo.exception;

import top.extrame.common.model.enums.ResponseEnum;

import java.io.Serial;
import java.io.Serializable;

/**
 * ServletException
 *
 * @author jx
 */
public class ServletException extends BaseException implements Serializable {

    @Serial
    private static final long serialVersionUID = -7101667433741799656L;

    public ServletException(ResponseEnum responseEnum, Object[] args) {
        super(responseEnum, args);
    }

    public ServletException(ResponseEnum responseEnum, Object[] args, Throwable cause) {
        super(responseEnum, args, cause);
    }
}
