/**
 * Copyright © 2019, LeonKeh
 * <p>
 * All Rights Reserved.
 */

package com.gyoomi.test;

import com.gyoomi.InitApplicationRunner;
import org.junit.Test;

import java.io.IOException;

/**
 * 类功能描述
 *
 * @author Leon
 * @version 2019/5/10 15:26
 */
public class TownContextHoldTest {


    @Test
    public void initDataFromProperty() throws IOException {
        InitApplicationRunner initRunner = new InitApplicationRunner();
        initRunner.init("data");
    }
}
