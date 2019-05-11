package com.gyoomi.processor.impl;

import com.gyoomi.entity.Town;
import com.gyoomi.processor.AbstractProcessor;
import com.gyoomi.support.TownContextHolder;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * The class for calculating the count of route with exact steps
 *
 * @author Leon
 * @version 2019/5/11 16:58
 */
public class CountRouteWithExactStepProcessor extends AbstractProcessor {

    private Town start;
    private Town end;
    private Integer exactStep;

    public CountRouteWithExactStepProcessor(Town start, Town end, Integer exactStep, TownContextHolder townContextHolder) {
        super(townContextHolder);
        this.start = start;
        this.end = end;
        this.exactStep = exactStep;
    }

    @Override
    public Integer process() {
        Integer startIndex = getIndexByTown(start);
        Integer endIndex = getIndexByTown(end);
        List<String> pathList = execute(String.valueOf(startIndex), String.valueOf(endIndex), exactStep, new ArrayList<>());
        return CollectionUtils.isEmpty(pathList) ? 0 : pathList.size();
    }

    private List<String> execute(String path, String end, int exactStep, List<String> pathList) {
        int[][] matrix = getMatrix();
        int rowIndex;
        if (StringUtils.contains(path, ">")) {
            rowIndex = Integer.parseInt(StringUtils.substringAfterLast(path, ">"));
        } else {
            rowIndex = Integer.parseInt(path);
        }

        String[] pathArray = StringUtils.split(path, ">");
        if (pathArray.length - 1 > exactStep) {
            return pathList;
        }

        if (pathArray.length -1 == exactStep && path.endsWith(end)) {
            pathList.add(path);
        }

        for (int i = 0; i < matrix.length; i++) {
            int value = matrix[rowIndex][i];
            if (value > 0) {
                execute(path + ">" + i, end, exactStep, pathList);
            }
        }
        return pathList;
    }
}
