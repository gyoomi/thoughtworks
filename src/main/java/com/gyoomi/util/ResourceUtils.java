/**
 * Copyright © 2019, LeonKeh
 * <p>
 * All Rights Reserved.
 */

package com.gyoomi.util;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Tool for loading resources
 *
 * @author Leon
 * @version 2019/5/10 14:02
 */
public class ResourceUtils {

    private static Locale defaultLocale = Locale.getDefault();

    public static String getKey(String fileName, String key){
        return ResourceBundle.getBundle(fileName, defaultLocale).getString(key);
    }

    public static ResourceBundle getResourceBundle(String fileName) {
        return ResourceBundle.getBundle(fileName, defaultLocale);
    }

    public static void setDefaultLocale(Locale defaultLocale) {
        ResourceUtils.defaultLocale = defaultLocale;
    }
}
