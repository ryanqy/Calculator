package com.ryanqy.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

/**
 * @author laughing.wu
 * created on 2022/11/26
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Constants {

    public static final String ADD_SYMBOL = "+";

    public static final String SUBTRACT_SYMBOL = "-";

    public static final String MULTIPLY_SYMBOL = "*";

    public static final String DIVIDE_SYMBOL = "/";

    public static final String EQUAL_SYMBOL = "=";

    public static final String REDO_SYMBOL = "redo";

    public static final String UNDO_SYMBOL = "undo";

    public static final String CLEAR_SYMBOL = "clear";

    public static boolean isComputeSymbol(String operation) {
        return StringUtils.equalsIgnoreCase(StringUtils.trimToEmpty(operation), ADD_SYMBOL)
                || StringUtils.equalsIgnoreCase(StringUtils.trimToEmpty(operation), SUBTRACT_SYMBOL)
                || StringUtils.equalsIgnoreCase(StringUtils.trimToEmpty(operation), MULTIPLY_SYMBOL)
                || StringUtils.equalsIgnoreCase(StringUtils.trimToEmpty(operation), DIVIDE_SYMBOL);
    }

    public static boolean isRedoOperation(String line) {
        return StringUtils.equalsIgnoreCase(StringUtils.trimToEmpty(line), Constants.REDO_SYMBOL);
    }

    public static boolean isUndoOperation(String line) {
        return StringUtils.equalsIgnoreCase(StringUtils.trimToEmpty(line), Constants.UNDO_SYMBOL);
    }

    public static boolean isClearOperation(String line) {
        return StringUtils.equalsIgnoreCase(StringUtils.trimToEmpty(line), Constants.CLEAR_SYMBOL);
    }

}
