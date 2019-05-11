package com.gyoomi.test;

import com.gyoomi.Configuration;
import com.gyoomi.InitApplicationRunner;
import com.gyoomi.builder.TownBuilder;
import com.gyoomi.entity.Town;
import com.gyoomi.processor.impl.CountRouteWithinSpecifiedStepProcessor;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * 类功能描述
 *
 * @author Leon
 * @version 2019/5/11 17:09
 */
public class CountRouteMaxStepRouteTest {

    @Before
    public void initTownHolder() throws Exception {
        InitApplicationRunner initRunner = new InitApplicationRunner();
        initRunner.init("data");
    }

    @Test
    public void testCountRouteWithinSpecifiedStepOfCC(){
        Town start = TownBuilder.buildTown("C");
        Town end = start;
        CountRouteWithinSpecifiedStepProcessor countRouteWithinSpecifiedStepProcessor = new CountRouteWithinSpecifiedStepProcessor(start, end, 3, Configuration.townContextHolder);
        Integer maxCount = countRouteWithinSpecifiedStepProcessor.process();
        Assert.assertEquals(2, (long) maxCount);
    }
}
