package top.extrame.core.domain.module.asserts;

import top.extrame.core.domain.module.asserts.base.BaseAssert;
import top.extrame.core.domain.pojo.exception.ArgumentException;

/**
 * 参数维护
 * The interface Argument assert.
 *
 * @author Jx-zou
 */
public interface ArgumentAssert extends BaseAssert<ArgumentException> {

    @Override
    ArgumentException newException(Object... args);

    @Override
    ArgumentException newException(Throwable t, Object... args);
}
