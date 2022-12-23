package com.rany.uic.common.mdc;

import java.util.UUID;

/**
 * @author zhongshengwang
 */
public class TraceIdUtil {

    public static String getTraceId() {
        return UUID.randomUUID().toString().replaceAll("-", "").toLowerCase();
    }
}
