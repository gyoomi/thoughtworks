/**
 * Copyright © 2019, LeonKeh
 * <p>
 * All Rights Reserved.
 */

package com.gyoomi;

import com.gyoomi.entity.Route;
import com.gyoomi.entity.Town;
import com.gyoomi.exception.ParseException;
import com.gyoomi.util.ResourceUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.util.ResourceBundle;

/**
 * Used to complete the initialization of the data
 *
 * @author Leon
 * @version 2019/5/10 14:13
 */
public class InitApplicationRunner {


    public void init(String fileName) throws IOException {
        ResourceBundle props = ResourceUtils.getResourceBundle(fileName);
        if (props == null) {
            throw new ParseException("Can not find any data form 【" + fileName + "】 properties file");
        }
        props.keySet().forEach(key -> buildTown(key, props.getString(key)));
        Configuration.townContextHolder.initMatrix();
    }

    private void buildTown(String townName, String distance) {
        if (StringUtils.isEmpty(townName) || townName.length() != 2) {
            throw new ParseException(townName + "=" + distance + " don't match the specified format.");
        }
        String fromTownName = StringUtils.substring(townName, 0, 1);
        String toTownName = StringUtils.substring(townName, 1, 2);
        Town from = new Town();
        from.setName(fromTownName);
        Town to = new Town();
        to.setName(toTownName);
        Route route = new Route(from, to, Integer.parseInt(distance));
        Configuration.townContextHolder.addTownAndRoute(from, route);
    }


}
