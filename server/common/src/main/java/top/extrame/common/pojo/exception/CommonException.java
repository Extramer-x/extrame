package top.extrame.common.pojo.exception;

import top.extrame.common.model.enums.ResponseEnum;

import java.io.Serial;
import java.io.Serializable;

/**
 * CommonException
 *
 * @author jx
 */
public class CommonException extends BaseException implements Serializable {

    @Serial
    private static final long serialVersionUID = 8218500497563299804L;

    public CommonException(ResponseEnum responseEnum, Object[] args) {
        super(responseEnum, args);
    }

    public CommonException(ResponseEnum responseEnum, Object[] args, Throwable cause) {
        super(responseEnum, args, cause);
    }
}
