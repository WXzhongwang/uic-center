package com.rany.uic.common.util;

import cn.hutool.core.util.RandomUtil;
import com.rany.uic.common.Constants;
import org.apache.commons.lang3.StringUtils;

import java.security.MessageDigest;

/**
 * TODO
 *
 * @author zhongshengwang
 * @description TODO
 * @date 2022/12/29 22:14
 * @email 18668485565163.com
 */
public final class AccountUtil {


    public static String md5(String content) {
        StringBuilder sb = new StringBuilder();
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            byte[] bs = digest.digest(content.getBytes());
            for (byte b : bs) {
                int x = b & 255;
                String s = Integer.toHexString(x);
                if (x > 0 && x < 16) {
                    sb.append("0");
                    sb.append(s);
                } else {
                    sb.append(s);
                }
            }

        } catch (Exception ignore) {
        }
        return sb.toString();
    }

    public static String buildAccountLoginName(String name, String tenantShortName) {
        if (StringUtils.endsWith(name, tenantShortName)) {
            return name;
        }
        return String.format("%s@%s", name, tenantShortName);
    }

    public static String buildRandomAccountLoginPwd() {
        return RandomUtil.randomString(16);
    }

    /**
     * 生成默认租户管理员登录账号名
     *
     * @param shortName
     * @return
     */
    public static String buildDefaultAccountLoginName(String shortName) {
        return String.format(Constants.INITIAL_TENANT_ADMIN_LOGIN_NAME, shortName);
    }

    /**
     * 生成默认租户管理员账号
     * eg. znby 租户管理员
     *
     * @param shortName
     * @return
     */
    public static String buildDefaultAccountChineseName(String shortName) {
        return String.format(Constants.INITIAL_TENANT_ADMIN_NAME, shortName);
    }
}
