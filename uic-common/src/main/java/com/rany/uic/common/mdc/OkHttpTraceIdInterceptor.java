package com.rany.uic.common.mdc;

import com.rany.uic.common.Constants;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.slf4j.MDC;

import java.io.IOException;

/**
 * OKHttp 添加traceId 拦截器
 *
 * @author zhongshengwang
 */
public class OkHttpTraceIdInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        String traceId = MDC.get(Constants.TRACE_ID);
        Request request = null;
        if (traceId != null) {
            // 添加请求体
            request = chain.request().newBuilder().addHeader(Constants.TRACE_ID, traceId).build();
        } else {
            return chain.proceed(chain.request());
        }
        return chain.proceed(request);
    }
}
