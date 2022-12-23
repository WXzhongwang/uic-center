package com.rany.uic.common.mdc;

import com.rany.uic.common.Constants;
import org.slf4j.MDC;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;

/**
 * RestTemplate添加 traceId拦截器
 *
 * @author zhongshengwang
 */
public class RestTemplateTraceIdInterceptor implements ClientHttpRequestInterceptor {

    @Override
    public ClientHttpResponse intercept(HttpRequest httpRequest, byte[] bytes, ClientHttpRequestExecution clientHttpRequestExecution) throws IOException {
        String traceId = MDC.get(Constants.TRACE_ID);
        if (traceId != null) {
            httpRequest.getHeaders().add(Constants.TRACE_ID, traceId);
        }
        return clientHttpRequestExecution.execute(httpRequest, bytes);
    }
}
