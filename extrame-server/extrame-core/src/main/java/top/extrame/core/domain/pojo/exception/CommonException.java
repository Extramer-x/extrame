package top.extrame.core.domain.pojo.exception;

import top.extrame.core.domain.module.enums.ResponseEnum;
import top.extrame.core.domain.pojo.exception.base.BaseException;

import java.io.Serial;
import java.io.Serializable;

/**
 * CommonException
 *
 * @author jx
 */
public class CommonException extends BaseException implements Serializable {

    @Serial
    private static final long serialVersionUID = -7089426630610760987L;

    public CommonException(ResponseEnum responseEnum, Object[] args) {
        super(responseEnum, args);
    }

    public CommonException(ResponseEnum responseEnum, Object[] args, Throwable cause) {
        super(responseEnum, args, cause);
    }
}
