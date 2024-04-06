package top.extrame.common.model.asserts;

import org.apache.commons.lang3.StringUtils;
import top.extrame.common.model.Result;
import top.extrame.common.pojo.exception.ServletException;

/**
 * ServletAssert
 *
 * @author jx
 */
public interface ServletAssert extends BaseAssert<ServletException>, Result {
    @Override
    ServletException newException(Object... args);

    @Override
    ServletException newException(Throwable t, Object... args);

    default void validateClientId(String cid) throws ServletException {
        if (null == cid || cid.length() != 24) {
            throw this.newException();
        }
    }

    default void validateToken(String token) throws ServletException {
        if (StringUtils.isEmpty(token) || !token.startsWith("Bearer ")) {
            throw this.newException();
        }
    }
}
