package top.extrame.core.handler;

import jakarta.validation.ValidationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.validation.BindException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.async.AsyncRequestTimeoutException;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import top.extrame.common.pojo.ResponseResult;
import top.extrame.common.enums.response.CommonResponse;
import top.extrame.common.model.enums.ResponseEnum;
import top.extrame.common.pojo.exception.*;
import top.extrame.core.pojo.UnifiedMessageSource;

import java.util.Locale;

/**
 * GlobalExceptionHandler
 *
 * @author jx
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final String ENV_PROD = "prod";

    private final UnifiedMessageSource unifiedMessageSource;

    @Value("${spring.profiles.active}")
    private String profile;

    @Autowired
    public GlobalExceptionHandler(UnifiedMessageSource unifiedMessageSource) {
        this.unifiedMessageSource = unifiedMessageSource;
    }

    private final boolean isProd = ENV_PROD.equals(profile);

    /**
     * 根据是否为prod发行版返回状态码
     *
     * @param e            BaseException异常
     * @param responseEnum 常用错误码
     * @return ResponseResult<Void>
     */
    private ResponseResult<Void> getResponseResult(Exception e, ResponseEnum responseEnum) {
        if (isProd) {
            if (Locale.getDefault().equals(Locale.CHINA)) {
                return responseEnum.getResult();
            }
            return responseEnum.getResult(unifiedMessageSource.getMessage(responseEnum.getStatus()));
        }
        return new ResponseResult<>(responseEnum.getStatus(), e.getMessage());
    }

    /**
     * Argument类型异常统一处理
     *
     * @param e ArgumentException
     * @return ResponseResult<Void>
     */
    @ExceptionHandler(ArgumentException.class)
    public ResponseResult<Void> handleArgumentException(ArgumentException e) {
        log.error(e.getMessage(), e);
        return this.getResponseResult(e, CommonResponse.ERROR);
    }

    /**
     * Common类型异常统一处理
     *
     * @param e CommonException
     * @return ResponseResult<Void>
     */
    @ExceptionHandler(CommonException.class)
    public ResponseResult<Void> handleCommonException(CommonException e) {
        log.error(e.getMessage(), e);
        return this.getResponseResult(e, CommonResponse.NETWORK_ERROR);
    }

    /**
     * Servlet类型异常统一处理
     *
     * @param e ServletException
     * @return ResponseResult<Void>
     */
    @ExceptionHandler(ServletException.class)
    public ResponseResult<Void> handleServletException(ServletException e) {
        log.error(e.getMessage(), e);
        return this.getResponseResult(e, CommonResponse.SERVER_ERROR);
    }

    /**
     * Business类型异常统一处理
     *
     * @param e BusinessException
     * @return ResponseResult<Void>
     */
    @ExceptionHandler(BusinessException.class)
    public ResponseResult<Void> handleBusinessException(BusinessException e) {
        log.error(e.getMessage(), e);
        return this.getResponseResult(e, CommonResponse.SERVER_ERROR);
    }

    /**
     * Base类型异常统一处理
     *
     * @param e BaseException
     * @return ResponseResult<Void>
     */
    @ExceptionHandler(BaseException.class)
    public ResponseResult<Void> handleBaseException(BaseException e) {
        log.error(e.getMessage(), e);
        return this.getResponseResult(e, CommonResponse.SERVER_ERROR);
    }

    /**
     * Handle base exception response result.
     *
     * @param e the e
     * @return the response result
     */
    @ExceptionHandler(ValidationException.class)
    public ResponseResult<Void> handleValidationException(ValidationException e) {
        log.error(e.getMessage(), e);
        return CommonResponse.ERROR.getResult();
    }

    /**
     * 聚合异常统一处理
     *
     * @param e Exception
     * @return ResponseResult<Void>
     */
    @ExceptionHandler({
            HttpRequestMethodNotSupportedException.class,
            HttpMediaTypeNotSupportedException.class,
            HttpMediaTypeNotAcceptableException.class,
            HttpMessageNotReadableException.class,
            HttpMessageNotWritableException.class,
            MissingPathVariableException.class,
            MissingServletRequestParameterException.class,
            TypeMismatchException.class,
            BindException.class,
            MethodArgumentNotValidException.class,
            ServletRequestBindingException.class,
            ConversionNotSupportedException.class,
            MissingServletRequestPartException.class,
            AsyncRequestTimeoutException.class
    })
    public ResponseResult<Void> handleServletException(Exception e) {
        log.error(e.getMessage(), e);
        return this.getResponseResult(e, CommonResponse.SERVER_ERROR);
    }

    /**
     * 最终异常统一处理
     *
     * @param e Exception
     * @return ResponseResult<Void>
     */
    @ExceptionHandler(Exception.class)
    public ResponseResult<Void> handleException(Exception e) {
        log.error(e.getMessage(), e);
        return CommonResponse.ERROR.getResult();
    }
}
