/**
 * Copyright © 2019, LeonKeh
 * <p>
 * All Rights Reserved.
 */

package com.gyoomi.processor;

import com.gyoomi.entity.Town;
import com.gyoomi.support.TownContextHolder;

/**
 * 类功能描述
 *
 * @author Leon
 * @version 2019/5/10 15:50
 */
public abstract class AbstractProcessor implements Processor {

    private TownContextHolder townContextHolder;

    protected AbstractProcessor(TownContextHolder townContextHolder) {
        this.townContextHolder = townContextHolder;
    }

    protected Integer getIndexByTown(Town town){
        return townContextHolder.getTownIndexCache().get(town);
    }

    protected int[][] getMatrix(){
        return townContextHolder.getMatrix();
    }
}
