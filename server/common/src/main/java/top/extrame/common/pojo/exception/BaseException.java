package top.extrame.common.pojo.exception;

import lombok.Getter;
import top.extrame.common.model.Result;

import java.io.Serial;

/**
 * BaseException
 *
 * @author jx
 */
@Getter
public class BaseException extends Exception {

    @Serial
    private static final long serialVersionUID = -3010450468565743931L;

    private final Result result;
    private Object[] args;

    public BaseException(Result result) {
        super(result.getMessage());
        this.result = result;
    }

    public BaseException(Result result, Object[] args) {
        super(result.getMessage());
        this.result = result;
        this.args = args;
    }

    public BaseException(Result result, Throwable cause) {
        super(result.getMessage(), cause);
        this.result = result;
    }

    public BaseException(Result result, Object[] args, Throwable cause) {
        super(result.getMessage(), cause);
        this.result = result;
        this.args = args;
    }

}
