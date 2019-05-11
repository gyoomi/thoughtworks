package com.gyoomi.processor.impl;

import com.gyoomi.entity.Town;
import com.gyoomi.processor.AbstractProcessor;
import com.gyoomi.support.TownContextHolder;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * The class for calculating the count of a route
 *
 * @author Leon
 * @version 2019/5/11 16:28
 */
public class MaxCountRouteProcessor extends AbstractProcessor {

    private Town start;
    private Town end;
    private Integer maxDistance;

    public MaxCountRouteProcessor(Town start, Town end, Integer maxDistance, TownContextHolder townContextHolder) {
        super(townContextHolder);
        this.start = start;
        this.end = end;
        this.maxDistance = maxDistance;
    }

    @Override
    public Integer process() {
        int startIndex = getIndexByTown(start);
        int endIndex = getIndexByTown(end);
        List<String> path = new ArrayList<>();
        path = execute(String.valueOf(startIndex), String.valueOf(endIndex), maxDistance, 0, path);
        return CollectionUtils.isEmpty(path) ? 0 : path.size();
    }

    private List<String> execute(String path, String end, int maxDistance, int pathValue, List<String> pathList) {
        int[][] matrix = getMatrix();
        int rowIndex;
        if (StringUtils.contains(path, ">")) {
            rowIndex = Integer.parseInt(StringUtils.substringAfterLast(path, ">"));
        } else {
            rowIndex = Integer.parseInt(path);
        }

        if (pathValue >= maxDistance) {
            return pathList;
        }

        if (pathValue > 0 && path.endsWith(end)) {
            pathList.add(path);
        }

        for (int i = 0; i < matrix.length; i++) {
            int value = matrix[rowIndex][i];
            if (value > 0) {
                execute(path + ">" + i, end, maxDistance, pathValue + value, pathList);
            }
        }
        return pathList;
    }


}
