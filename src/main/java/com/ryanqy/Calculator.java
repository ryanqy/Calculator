package com.ryanqy;

import com.ryanqy.operation.Operation;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author laughing.wu
 * created on 2022/11/25
 */
@Slf4j
public class Calculator implements Serializable {

    @Setter
    @Getter
    private BigDecimal result = BigDecimal.ZERO;

    private final List<Operation> operations = new ArrayList<>();

    public void calculate(Operation operation) {
        operation.execute();
    }

    public void clear() {
        result = BigDecimal.ZERO;
        operations.clear();
    }

    public void addOperation(Operation operation) {
        operations.add(operation);
    }

    public Optional<Operation> getLatestOperation() {
        if (CollectionUtils.isNotEmpty(operations)) {
            return Optional.of(operations.get(CollectionUtils.size(operations) - 1));
        }

        return Optional.empty();
    }

    public Optional<Operation> removeLatestOperation() {
        if (CollectionUtils.isNotEmpty(operations)) {
            return Optional.of(operations.remove(CollectionUtils.size(operations) - 1));
        }

        return Optional.empty();
    }

}
