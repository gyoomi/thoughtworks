/**
 * Copyright © 2019, LeonKeh
 * <p>
 * All Rights Reserved.
 */

package com.gyoomi.test;

import com.gyoomi.Configuration;
import com.gyoomi.InitApplicationRunner;
import com.gyoomi.builder.TownBuilder;
import com.gyoomi.entity.Town;
import com.gyoomi.processor.impl.DistanceOfRouteProcessor;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 *
 *
 * @author Leon
 * @version 2019/5/10 16:17
 */
public class DistanceOfRouteProcessorTest {

    @Before
    public void initTownHolder() throws Exception {
        InitApplicationRunner initRunner = new InitApplicationRunner();
        initRunner.init("data");
    }

    @Test
    public void testTheDistanceOfABC(){
        List<Town> townRouteList = TownBuilder.buildSpecifiedTownRoute(Arrays.asList("A", "B", "C"));
        DistanceOfRouteProcessor distanceOfRouteProcessor = new DistanceOfRouteProcessor(Configuration.townContextHolder, townRouteList);
        String distance = distanceOfRouteProcessor.process();
        Assert.assertEquals(9, Long.parseLong(distance));
    }

    @Test
    public void testTheDistanceOfAD(){
        List<Town> townRouteList = TownBuilder.buildSpecifiedTownRoute(Arrays.asList("A", "D"));
        DistanceOfRouteProcessor distanceOfRouteProcessor = new DistanceOfRouteProcessor(Configuration.townContextHolder, townRouteList);
        String distance = distanceOfRouteProcessor.process();
        Assert.assertEquals(5, Long.parseLong(distance));
    }

    @Test
    public void testTheDistanceOfADC(){
        List<Town> townRouteList = TownBuilder.buildSpecifiedTownRoute(Arrays.asList("A", "D", "C"));
        DistanceOfRouteProcessor distanceOfRouteProcessor = new DistanceOfRouteProcessor(Configuration.townContextHolder, townRouteList);
        String distance = distanceOfRouteProcessor.process();
        Assert.assertEquals(13, Long.parseLong(distance));
    }

    @Test
    public void testTheDistanceOfAEBCD(){
        List<Town> townRouteList = TownBuilder.buildSpecifiedTownRoute(Arrays.asList("A", "E", "B", "C", "D"));
        DistanceOfRouteProcessor distanceOfRouteProcessor = new DistanceOfRouteProcessor(Configuration.townContextHolder, townRouteList);
        String distance = distanceOfRouteProcessor.process();
        Assert.assertEquals(22, Long.parseLong(distance));
    }

    @Test
    public void testTheDistanceOfAED(){
        List<Town> townRouteList = TownBuilder.buildSpecifiedTownRoute(Arrays.asList("A", "E", "D"));
        DistanceOfRouteProcessor distanceOfRouteProcessor = new DistanceOfRouteProcessor(Configuration.townContextHolder, townRouteList);
        String distance = distanceOfRouteProcessor.process();
        Assert.assertEquals("NO SUCH ROUTE", distance);
    }
}
