package com.gyoomi.test;

import com.gyoomi.Configuration;
import com.gyoomi.InitApplicationRunner;
import com.gyoomi.builder.TownBuilder;
import com.gyoomi.entity.Town;
import com.gyoomi.processor.impl.MaxCountRouteProcessor;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * 类功能描述
 *
 * @author Leon
 * @version 2019/5/11 16:40
 */
public class MaxCountRouteTest {

    @Before
    public void initTownHolder() throws Exception {
        InitApplicationRunner initRunner = new InitApplicationRunner();
        initRunner.init("data");
    }

    @Test
    public void testTheShortestDistanceOfCC(){
        Town start = TownBuilder.buildTown("C");
        Town end = start;
        MaxCountRouteProcessor maxCountRouteProcessor = new MaxCountRouteProcessor(start, end, 30, Configuration.townContextHolder);
        Integer maxCount = maxCountRouteProcessor.process();
        Assert.assertEquals(7, (long) maxCount);
    }
}
