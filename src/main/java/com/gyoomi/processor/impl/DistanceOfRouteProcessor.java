/**
 * Copyright © 2019, LeonKeh
 * <p>
 * All Rights Reserved.
 */

package com.gyoomi.processor.impl;

import com.gyoomi.entity.Town;
import com.gyoomi.processor.AbstractProcessor;
import com.gyoomi.support.TownContextHolder;
import org.apache.commons.collections4.CollectionUtils;

import java.util.List;

/**
 * The class for calculating the distance of two towns
 *
 * @author Leon
 * @version 2019/5/10 16:00
 */
public class DistanceOfRouteProcessor extends AbstractProcessor {

    private List<Town> townRoutes;

    public DistanceOfRouteProcessor(TownContextHolder townContextHolder, List<Town> townRoutes) {
        super(townContextHolder);
        this.townRoutes = townRoutes;
    }

    @Override
    public String process() {
        int result = 0;
        int[][] matrix = this.getMatrix();
        if (CollectionUtils.isNotEmpty(townRoutes)) {
            for (int i = 0; i < townRoutes.size() - 1; i++) {
                Integer rowIndex = getIndexByTown(townRoutes.get(i));
                Integer columnIndex = getIndexByTown(townRoutes.get(i + 1));
                int value = matrix[rowIndex][columnIndex];
                if (value > 0) {
                    result += value;
                } else {
                    result = 0;
                    break;
                }
            }
        }
        return result > 0 ? String.valueOf(result) : "NO SUCH ROUTE";
    }
}
