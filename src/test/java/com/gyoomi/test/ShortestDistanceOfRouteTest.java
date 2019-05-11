package com.gyoomi.test;

import com.gyoomi.Configuration;
import com.gyoomi.InitApplicationRunner;
import com.gyoomi.builder.TownBuilder;
import com.gyoomi.entity.Town;
import com.gyoomi.processor.impl.ShortestDistanceOfRouteProcessor;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * 类功能描述
 *
 * @author Leon
 * @version 2019/5/11 0:40
 */
public class ShortestDistanceOfRouteTest {

    @Before
    public void initTownHolder() throws Exception {
        InitApplicationRunner initRunner = new InitApplicationRunner();
        initRunner.init("data");
    }

    @Test
    public void testTheShortestDistanceOfAC(){
        Town start = TownBuilder.buildTown("A");
        Town end = TownBuilder.buildTown("C");
        ShortestDistanceOfRouteProcessor shortestDistanceOfRouteProcessor = new ShortestDistanceOfRouteProcessor(start, end, Configuration.townContextHolder);
        Integer shortDistance = shortestDistanceOfRouteProcessor.process();
        Assert.assertEquals(9, (long) shortDistance);
    }

    @Test
    public void testTheShortestDistanceOfBB(){
        Town start = TownBuilder.buildTown("B");
        Town end = start;
        ShortestDistanceOfRouteProcessor shortestDistanceOfRouteProcessor = new ShortestDistanceOfRouteProcessor(start, end, Configuration.townContextHolder);
        Integer shortDistance = shortestDistanceOfRouteProcessor.process();
        Assert.assertEquals(9, (long) shortDistance);
    }
}
