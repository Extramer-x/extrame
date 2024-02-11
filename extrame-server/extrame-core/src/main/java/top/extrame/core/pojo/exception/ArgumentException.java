package top.extrame.core.pojo.exception;

import top.extrame.core.model.enums.ResponseEnum;

import java.io.Serial;
import java.io.Serializable;

/**
 * ArgumentException
 *
 * @author jx
 */
public class ArgumentException extends BaseException implements Serializable {

    @Serial
    private static final long serialVersionUID = 6449334571737316648L;

    public ArgumentException(ResponseEnum responseEnum, Object[] args) {
        super(responseEnum, args);
    }

    public ArgumentException(ResponseEnum responseEnum, Object[] args, Throwable cause) {
        super(responseEnum, args, cause);
    }
}
