package com.ryanqy.operation;

import com.ryanqy.Calculator;

/**
 * @author laughing.wu
 * created on 2022/11/26
 */
public class ClearOperation implements Operation {

    private final Calculator calculator;

    public ClearOperation(Calculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public void execute() {
        calculator.clear();
    }

    @Override
    public void undo() {
        throw new UnsupportedOperationException();
    }

}
