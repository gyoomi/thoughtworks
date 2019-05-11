package com.gyoomi.processor.impl;

import com.gyoomi.entity.Town;
import com.gyoomi.processor.AbstractProcessor;
import com.gyoomi.support.TownContextHolder;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * The class for calculating the count of route with specified steps
 *
 * @author Leon
 * @version 2019/5/11 16:58
 */
public class CountRouteWithinSpecifiedStepProcessor extends AbstractProcessor {

    private Town start;
    private Town end;
    private Integer maxStep;

    public CountRouteWithinSpecifiedStepProcessor(Town start, Town end, Integer maxStep, TownContextHolder townContextHolder) {
        super(townContextHolder);
        this.start = start;
        this.end = end;
        this.maxStep = maxStep;
    }

    @Override
    public Integer process() {
        Integer startIndex = getIndexByTown(start);
        Integer endIndex = getIndexByTown(end);
        List<String> pathList = new ArrayList<>();
        pathList = execute(String.valueOf(startIndex), String.valueOf(endIndex), maxStep, pathList);
        return CollectionUtils.isEmpty(pathList) ? 0 : pathList.size();
    }

    private List<String> execute(String path, String end, int maxStep, List<String> pathList) {
        int[][] matrix = getMatrix();
        int rowIndex;
        if (StringUtils.contains(path, ">")) {
            rowIndex = Integer.parseInt(StringUtils.substringAfterLast(path, ">"));
        } else {
            rowIndex = Integer.parseInt(path);
        }

        String[] pathArray = StringUtils.split(path, ">");
        if (pathArray.length - 1 > maxStep) {
            return pathList;
        }

        if (pathArray.length > 1 && path.endsWith(end)) {
            pathList.add(path);
        }

        for (int i = 0; i < matrix.length; i++) {
            int value = matrix[rowIndex][i];
            if (value > 0) {
                execute(path + ">" + i, end, maxStep, pathList);
            }
        }
        return pathList;
    }
}
