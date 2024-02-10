package top.extrame.core.domain.module.asserts;

import top.extrame.common.model.Result;
import top.extrame.core.domain.module.asserts.base.BaseAssert;
import top.extrame.core.domain.pojo.exception.CommonException;

/**
 * CommonAssert
 *
 * @author jx
 */
public interface CommonAssert extends BaseAssert<CommonException>, Result {

    @Override
    CommonException newException(Object... args);

    @Override
    CommonException newException(Throwable t, Object... args);

    default void isInsertFailed(int insert) throws CommonException {
        if (insert <= 0) {
            throw this.newException();
        }
    }
}
