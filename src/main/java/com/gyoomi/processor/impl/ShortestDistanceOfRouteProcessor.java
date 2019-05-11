package com.gyoomi.processor.impl;

import com.gyoomi.entity.Town;
import com.gyoomi.processor.AbstractProcessor;
import com.gyoomi.support.TownContextHolder;
import org.apache.commons.lang3.StringUtils;

/**
 * The class for calculating the shortest distance of a route
 *
 * @author Leon
 * @version 2019/5/11 0:29
 */
public class ShortestDistanceOfRouteProcessor extends AbstractProcessor {

    private Town start;
    private Town end;
    private String shortestPath;
    private Integer shortestValue = Integer.MAX_VALUE;

    public ShortestDistanceOfRouteProcessor(Town start, Town end, TownContextHolder townContextHolder) {
        super(townContextHolder);
        this.start = start;
        this.end = end;
    }


    @Override
    public Integer process() {
        int startIndex = this.getIndexByTown(start);
        int endIndex =  this.getIndexByTown(end);
        return getShortestDistance(String.valueOf(startIndex), String.valueOf(endIndex), 0);
    }

    private int getShortestDistance(String path, String end, int pathValue) {
        int[][] matrix = getMatrix();
        int rowIndex;
        if (StringUtils.contains(path, ">")) {
            rowIndex = Integer.parseInt(StringUtils.substringAfterLast(path, ">"));
        } else {
            rowIndex = Integer.parseInt(path);
        }
        if (path.endsWith(end) && pathValue < shortestValue && pathValue > 0) {
            shortestPath = path;
            shortestValue = pathValue;
            return pathValue;
        }
        for (int i = 0; i < matrix[rowIndex].length; i++) {
            int value = matrix[rowIndex][i];
            if (value > 0) {
                if (path.indexOf(String.valueOf(i)) > 0) {
                    continue;
                } else {
                    if(pathValue > shortestValue){
                        continue;
                    }
                    getShortestDistance(path + ">" + i, end, pathValue + value);
                }
            }
        }
        return shortestValue;
    }
}
