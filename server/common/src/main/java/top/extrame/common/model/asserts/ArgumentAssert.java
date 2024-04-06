package top.extrame.common.model.asserts;

import top.extrame.common.pojo.exception.ArgumentException;

/**
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
