package com.jozeflang.mapstructexample.springboot;

import org.apache.commons.lang3.StringUtils;

public final class Utils {

    public static String join(String... fields) {
        return StringUtils.join(fields, ".");
    }

}
