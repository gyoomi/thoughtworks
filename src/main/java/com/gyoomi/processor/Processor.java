/**
 * Copyright © 2019, LeonKeh
 * <p>
 * All Rights Reserved.
 */

package com.gyoomi.processor;

/**
 * The root interface for accessing
 *
 * @author Leon
 * @version 2019/5/10 15:48
 */
public interface Processor {

    /**
     * Return a object for required
     *
     * @return result
     */
    Object process();
}
