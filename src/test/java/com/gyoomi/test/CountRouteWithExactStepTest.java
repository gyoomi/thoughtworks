package com.gyoomi.test;

import com.gyoomi.Configuration;
import com.gyoomi.InitApplicationRunner;
import com.gyoomi.builder.TownBuilder;
import com.gyoomi.entity.Town;
import com.gyoomi.processor.impl.CountRouteWithExactStepProcessor;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;



/**
 * 类功能描述
 *
 * @author Leon
 * @version 2019/5/11 17:09
 */
public class CountRouteWithExactStepTest {

    @Before
    public void initTownHolder() throws Exception {
        InitApplicationRunner initRunner = new InitApplicationRunner();
        initRunner.init("data");
    }

    @Test
    public void testCountRouteWithinSpecifiedStepOfAC(){
        Town start = TownBuilder.buildTown("A");
        Town end = TownBuilder.buildTown("C");
        CountRouteWithExactStepProcessor countRouteWithExactStepProcessor = new CountRouteWithExactStepProcessor(start, end, 4, Configuration.townContextHolder);
        Integer count = countRouteWithExactStepProcessor.process();
        Assert.assertEquals(3, (long) count);
    }
}
