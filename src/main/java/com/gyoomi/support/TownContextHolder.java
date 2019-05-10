/**
 * Copyright © 2019, LeonKeh
 * <p>
 * All Rights Reserved.
 */

package com.gyoomi.support;

import com.gyoomi.entity.Route;
import com.gyoomi.entity.Town;
import org.apache.commons.collections4.CollectionUtils;

import java.util.*;
/**
 * 类功能描述
 *
 * @author Leon
 * @version 2019/5/10 13:49
 */
public class TownContextHolder {

    private Set<Town> towns = new TreeSet<>();

    private Map<Town, List<Route>> routeMap = new HashMap<>();

    private Map<Town, Integer> townIndexCache = new HashMap<>();

    private Map<Integer, Town> indexTownCache = new HashMap<>();

    private int[][] matrix = null;

    public void addTownAndRoute(Town town, Route route) {
        towns.add(town);
        if (routeMap.get(town) == null) {
            List<Route> routeList = new ArrayList<>();
            routeList.add(route);
            routeMap.put(town, routeList);
        } else {
            routeMap.get(town).add(route);
        }
    }

    public void initMatrix() {
        int townIndex = 0;
        int townSize = towns.size();
        matrix = new int[townSize][townSize];
        for (Town town : towns) {
            townIndexCache.put(town, townIndex);
            indexTownCache.put(townIndex, town);
            townIndex++;
        }

        int rowIdx = 0;
        for (Town currentTown : towns) {
            List<Route> routeListForCurrentTown = routeMap.get(currentTown);
            if (CollectionUtils.isNotEmpty(routeListForCurrentTown)) {
                for (Route route : routeListForCurrentTown) {
                    Integer idx = townIndexCache.get(route.getTo());
                    if (idx != null) {
                        matrix[rowIdx][idx] = route.getDistance();
                    }
                }
            }
            rowIdx++;
        }
    }


    public Set<Town> getTowns() {
        return towns;
    }

    public Map<Town, List<Route>> getRouteMap() {
        return routeMap;
    }

    public Map<Town, Integer> getTownIndexCache() {
        return townIndexCache;
    }

    public Map<Integer, Town> getIndexTownCache() {
        return indexTownCache;
    }

    public int[][] getMatrix() {
        return matrix;
    }
}
