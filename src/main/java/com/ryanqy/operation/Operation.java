package com.ryanqy.operation;

import java.io.Serializable;

/**
 * @author laughing.wu
 * created on 2022/11/25
 */
public interface Operation extends Serializable {

    void execute();

    void undo();

}
