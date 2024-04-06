package top.extrame.common.pojo.exception;

import top.extrame.common.model.enums.ResponseEnum;

import java.io.Serial;
import java.io.Serializable;

/**
 * ArgumentException
 *
 * @author jx
 */
public class ArgumentException extends BaseException implements Serializable {

    @Serial
    private static final long serialVersionUID = -3029508232604520223L;

    public ArgumentException(ResponseEnum responseEnum, Object[] args) {
        super(responseEnum, args);
    }

    public ArgumentException(ResponseEnum responseEnum, Object[] args, Throwable cause) {
        super(responseEnum, args, cause);
    }
}
