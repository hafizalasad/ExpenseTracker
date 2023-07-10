package com.hafiz.expensetracker.util;

public class BooleanUtils {
    public static boolean isTrue(final Boolean bool) {
        return Boolean.TRUE.equals(bool);
    }

    public static boolean isNotTrue(final Boolean bool) {
        return !isTrue(bool);
    }

    public static boolean isFalse(final Boolean bool) {
        return Boolean.FALSE.equals(bool);
    }

    public static boolean isNotFalse(final Boolean bool) {
        return !isFalse(bool);
    }

    public static Boolean negate(final Boolean bool) {
        if (bool == null) {
            return null;
        }
        return bool.booleanValue() ? Boolean.FALSE : Boolean.TRUE;
    }
}
