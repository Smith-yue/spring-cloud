package com.bob.springcloud.ribbon.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.apache.http.HttpHeaders;
import org.springframework.cloud.netflix.feign.support.SpringEncoder;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Ribbon借助SpringMVC的{@link MappingJackson2HttpMessageConverter} 能够对复杂类型的对象转换为Json,不需要显式指定Content-Type = application/json
 * Ribbon在{@link SpringEncoder} 里编码RequestBody里的数据
 * 在 {@link AbstractHttpMessageConverter#addDefaultHeaders(org.springframework.http.HttpHeaders, Object, MediaType)}这一步向Header添加ContentType和Charset
 *
 * @author Administrator
 */
//@Component
public class ContentTypeRequestInterceptor implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate template) {
        if (RequestMethod.POST.name().equalsIgnoreCase(template.method())) {
            template.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_UTF8_VALUE);
        }
    }
}
