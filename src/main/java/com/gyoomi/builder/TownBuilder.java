/**
 * Copyright © 2019, LeonKeh
 * <p>
 * All Rights Reserved.
 */

package com.gyoomi.builder;

import com.gyoomi.entity.Town;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * It is used for building town
 *
 * @author Leon
 * @version 2019/5/10 16:21
 */
public class TownBuilder {

    public static List<Town> buildSpecifiedTownRoute(List<String> townNameList) {
        if (CollectionUtils.isNotEmpty(townNameList)) {
            return townNameList.stream().map(Town::new).collect(Collectors.toList());
        }
        return null;
    }

    public static Town buildTown(String townName){
        if (StringUtils.isNotBlank(townName)) {
            Town town = new Town();
            town.setName(townName);
            return town;
        }
        return null;
    }
}
