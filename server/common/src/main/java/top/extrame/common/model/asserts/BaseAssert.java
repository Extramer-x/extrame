package top.extrame.common.model.asserts;

import top.extrame.common.pojo.exception.BaseException;

import java.util.Collection;

/**
 * The interface Base assert.
 *
 * @param <E> the type parameter
 * @author Jx -zou
 */
public interface BaseAssert<E extends BaseException> {

    /**
     * New exception e.
     *
     * @param args the args
     * @return the e
     */
    E newException(Object... args);

    /**
     * New exception e.
     *
     * @param t    the t
     * @param args the args
     * @return the e
     */
    E newException(Throwable t, Object... args);

    /**
     * Is null.
     *
     * @param obj the obj
     * @throws E the e
     */
    default void isNull(Object obj) throws E {
        if (obj == null) {
            throw this.newException();
        }
    }

    /**
     * Is null.
     *
     * @param obj the obj
     * @param t   the t
     * @throws E the e
     */
    default void isNull(Object obj, Throwable t) throws E {
        if (obj == null) {
            throw this.newException(t);
        }
    }

    /**
     * Not null.
     *
     * @param obj the obj
     * @throws E the e
     */
    default void notNull(Object obj) throws E {
        if (obj != null) {
            throw this.newException();
        }
    }

    /**
     * Not null.
     *
     * @param obj the obj
     * @param t   the t
     * @throws E the e
     */
    default void notNull(Object obj, Throwable t) throws E {
        if (obj != null) {
            throw this.newException(t);
        }
    }

    /**
     * Is empty.
     *
     * @param str the str
     * @throws E the e
     */
    default void isEmpty(String str) throws E {
        if (str == null || str.isEmpty()) {
            throw this.newException();
        }
    }

    /**
     * Is empty.
     *
     * @param str the str
     * @param t   the t
     * @throws E the e
     */
    default void isEmpty(String str, Throwable t) throws E {
        if (str == null || str.isEmpty()) {
            throw this.newException(t);
        }
    }

    /**
     * Not empty.
     *
     * @param str the str
     * @param t   the t
     * @throws E the e
     */
    default void notEmpty(String str, Throwable t) throws E {
        if (str == null || str.isEmpty()) {
            throw this.newException(t);
        }
    }

    /**
     * Is blank.
     *
     * @param str the str
     * @throws E the e
     */
    default void isBlank(String str) throws E {
        if (str == null || str.trim().isEmpty()) {
            throw this.newException();
        }
    }

    /**
     * Is blank.
     *
     * @param str the str
     * @param t   the t
     * @throws E the e
     */
    default void isBlank(String str, Throwable t) throws E {
        if (str == null || str.trim().isEmpty()) {
            throw this.newException(t);
        }
    }

    /**
     * Not blank.
     *
     * @param str the str
     * @throws E the e
     */
    default void notBlank(String str) throws E {
        if (str != null && !str.trim().isEmpty()) {
            throw this.newException();
        }
    }

    /**
     * Not blank.
     *
     * @param str the str
     * @param t   the t
     * @throws E the e
     */
    default void notBlank(String str, Throwable t) throws E {
        if (str != null && !str.trim().isEmpty()) {
            throw this.newException(t);
        }
    }

    /**
     * Is empty.
     *
     * @param array the array
     * @throws E the e
     */
    default void isEmpty(Object[] array) throws E {
        if (array == null || array.length == 0) {
            throw this.newException();
        }
    }

    /**
     * Is empty.
     *
     * @param array the array
     * @param t     the t
     * @throws E the e
     */
    default void isEmpty(Object[] array, Throwable t) throws E {
        if (array == null || array.length == 0) {
            throw this.newException(t);
        }
    }

    /**
     * Not empty.
     *
     * @param array the array
     * @throws E the e
     */
    default void notEmpty(Object[] array) throws E {
        if (array != null && array.length > 0) {
            throw this.newException();
        }
    }

    /**
     * Not empty.
     *
     * @param array the array
     * @param t     the t
     * @throws E the e
     */
    default void notEmpty(Object[] array, Throwable t) throws E {
        if (array != null && array.length > 0) {
            throw this.newException(t);
        }
    }

    /**
     * Is empty.
     *
     * @param collection the collection
     * @throws E the e
     */
    default void isEmpty(Collection<?> collection) throws E {
        if (collection == null || collection.size() == 0) {
            throw this.newException();
        }
    }

    /**
     * Is empty.
     *
     * @param collection the collection
     * @param t          the t
     * @throws E the e
     */
    default void isEmpty(Collection<?> collection, Throwable t) throws E {
        if (collection == null || collection.size() == 0) {
            throw this.newException(t);
        }
    }

    /**
     * Not empty.
     *
     * @param collection the collection
     * @throws E the e
     */
    default void notEmpty(Collection<?> collection) throws E {
        if (collection != null && !collection.isEmpty()) {
            throw this.newException();
        }
    }

    /**
     * Not empty.
     *
     * @param collection the collection
     * @param t          the t
     * @throws E the e
     */
    default void notEmpty(Collection<?> collection, Throwable t) throws E {
        if (collection != null && !collection.isEmpty()) {
            throw this.newException(t);
        }
    }

    /**
     * Equals ignore case.
     *
     * @param str1 the str 1
     * @param str2 the str 2
     * @throws E the e
     */
    default void equalsIgnoreCase(String str1, String str2) throws E {
        if (null == str1 || str1.trim().isEmpty() || null == str2 || str2.trim().isEmpty() || !str1.equalsIgnoreCase(str2)) {
            throw this.newException();
        }
    }

    /**
     * Equals ignore case.
     *
     * @param str1 the str 1
     * @param str2 the str 2
     * @param t    the t
     * @throws E the e
     */
    default void equalsIgnoreCase(String str1, String str2, Throwable t) throws E {
        if (null == str1 || str1.trim().isEmpty() || null == str2 || str2.trim().isEmpty() || !str1.equalsIgnoreCase(str2)) {
            throw this.newException(t);
        }
    }

    /**
     * Equals.
     *
     * @param str1 the str 1
     * @param str2 the str 2
     * @throws E the e
     */
    default void equals(String str1, String str2) throws E {
        if (null == str1 || str1.trim().isEmpty() || null == str2 || str2.trim().isEmpty() || !str1.equals(str2)) {
            throw this.newException();
        }
    }

    /**
     * Equals.
     *
     * @param str1 the str 1
     * @param str2 the str 2
     * @param t    the t
     * @throws E the e
     */
    default void equals(String str1, String str2, Throwable t) throws E {
        if (null == str1 || str1.trim().isEmpty() || null == str2 || str2.trim().isEmpty() || !str1.equals(str2)) {
            throw this.newException(t);
        }
    }

    /**
     * Equals.
     *
     * @param obj1 the obj 1
     * @param obj2 the obj 2
     * @throws E the e
     */
    default void equals(Object obj1, Object obj2) throws E {
        if (null == obj1 || !obj1.equals(obj2)) {
            throw this.newException();
        }
    }

    /**
     * Equals.
     *
     * @param obj1 the obj 1
     * @param obj2 the obj 2
     * @param t    the t
     * @throws E the e
     */
    default void equals(Object obj1, Object obj2, Throwable t) throws E {
        if (null == obj1 || !obj1.equals(obj2)) {
            throw this.newException(t);
        }
    }

    /**
     * Is instance of.
     *
     * @param type the type
     * @param obj  the obj
     * @throws E the e
     */
    default void isInstanceOf(Class<?> type, Object obj) throws E {
        if (null == obj || type.isInstance(obj)) {
            throw this.newException();
        }
    }

    /**
     * Is instance of.
     *
     * @param type the type
     * @param obj  the obj
     * @param t    the t
     * @throws E the e
     */
    default void isInstanceOf(Class<?> type, Object obj, Throwable t) throws E {
        if (obj == null || type.isInstance(obj)) {
            throw this.newException(t);
        }
    }

    /**
     * Not instance of.
     *
     * @param type the type
     * @param obj  the obj
     * @throws E the e
     */
    default void notInstanceOf(Class<?> type, Object obj) throws E {
        if (!type.isInstance(obj)) {
            throw this.newException();
        }
    }

    /**
     * Not instance of.
     *
     * @param type the type
     * @param obj  the obj
     * @param t    the t
     * @throws E the e
     */
    default void notInstanceOf(Class<?> type, Object obj, Throwable t) throws E {
        if (!type.isInstance(obj)) {
            throw this.newException(t);
        }
    }


}
