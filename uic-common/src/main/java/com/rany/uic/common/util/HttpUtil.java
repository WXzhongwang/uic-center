package com.rany.uic.common.util;

import com.rany.uic.common.Constants;

import java.security.SecureRandom;

/**
 * @description:
 * @author: zhangguowei
 * @create: 2019-05-28 17:51
 **/
public final class HttpUtil {

    private HttpUtil() {
    }

    private static SecureRandom random = new SecureRandom();

    public static String getUserAgent() {
        return Constants.USER_AGENTS[random.nextInt(Constants.USER_AGENTS.length)];
    }
}
