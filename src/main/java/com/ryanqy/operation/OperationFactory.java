package com.ryanqy.operation;

import com.ryanqy.Calculator;
import com.ryanqy.util.Constants;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author laughing.wu
 * created on 2022/11/26
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class OperationFactory {

    public static Operation createOperation(Calculator calculator, String operation, BigDecimal operand) {
        if (StringUtils.equalsIgnoreCase(operation, Constants.ADD_SYMBOL)) {
            return new AddOperation(calculator, operand);
        } else if (StringUtils.equalsIgnoreCase(operation, Constants.SUBTRACT_SYMBOL)) {
            return new SubtractOperation(calculator, operand);
        } else if (StringUtils.equalsIgnoreCase(operation, Constants.MULTIPLY_SYMBOL)) {
            return new MultiplyOperation(calculator, operand);
        } else if (StringUtils.equalsIgnoreCase(operation, Constants.DIVIDE_SYMBOL)) {
            return new DivideOperation(calculator, operand);
        } else if (StringUtils.equalsIgnoreCase(operation, Constants.REDO_SYMBOL)) {
            return new RedoOperation(calculator);
        } else if (StringUtils.equalsIgnoreCase(operation, Constants.UNDO_SYMBOL)) {
            return new UndoOperation(calculator);
        } else if (StringUtils.equalsIgnoreCase(operation, Constants.CLEAR_SYMBOL)) {
            return new ClearOperation(calculator);
        }

        throw new UnsupportedOperationException("unsupported operation");
    }

    private static boolean isLegalExpression(List<String> elements) {
        if (CollectionUtils.size(elements) < 2) {
            return false;
        }

        int startIndex = 0;
        boolean result = true;
        if (BooleanUtils.isFalse(Constants.isComputeSymbol(elements.get(0)))) {
            result = NumberUtils.isParsable(elements.get(startIndex++));
        }

        result = result && CollectionUtils.size(elements) % 2 == startIndex;

        if (BooleanUtils.isFalse(result)) {
            return result;
        }

        while (startIndex < elements.size()) {
            String operation = elements.get(startIndex++);
            String operand = elements.get(startIndex++);

            result = result && NumberUtils.isParsable(operand) && Constants.isComputeSymbol(operation);
            // 排除除以0的情况
            if (StringUtils.equalsIgnoreCase(Constants.DIVIDE_SYMBOL, operation) && BigDecimal.ZERO.equals(new BigDecimal(operand))) {
                result = false;
            }
        }

        return result;
    }

    private static String removeEndEqualSymbolIfExist(String line) {
        if (StringUtils.endsWith(line, Constants.EQUAL_SYMBOL)) {
            return StringUtils.trimToEmpty(line.substring(0, StringUtils.length(line) - 1));
        }

        return line;
    }

    public static List<Operation> parseInputLine(Calculator calculator, String line) {
        if (Constants.isRedoOperation(line) || Constants.isUndoOperation(line) || Constants.isClearOperation(line)) {
            return Collections.singletonList(OperationFactory.createOperation(calculator, StringUtils.trimToEmpty(line), null));
        }

        line = removeEndEqualSymbolIfExist(line);

        List<String> elements = Arrays.stream(StringUtils.split(line)).collect(Collectors.toList());
        if (BooleanUtils.isFalse(isLegalExpression(elements))) {
            System.out.println("illegal expression");
            return Collections.emptyList();
        }

        String firstElement = elements.get(0);
        if (BooleanUtils.isFalse(Constants.isComputeSymbol(firstElement))) {
            elements.remove(0);
            calculator.setResult(new BigDecimal(firstElement));
        }

        List<Operation> operations = new ArrayList<>();
        while (CollectionUtils.isNotEmpty(elements)) {
            String operation = elements.remove(0);
            String operand = elements.remove(0);

            operations.add(OperationFactory.createOperation(calculator, operation, new BigDecimal(operand)));
        }

        return operations;
    }

}
