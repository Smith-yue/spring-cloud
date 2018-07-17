package com.bob.springcloud.eureka.config;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.ClientRequest;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.filter.ClientFilter;

/**
 * @author wb-jjb318191
 * @create 2018-07-03 14:07
 */
public class DefaultClientFilter extends ClientFilter {

    private static final String KEY = "eureka-access-key";

    @Override
    public ClientResponse handle(ClientRequest cr) throws ClientHandlerException {
        List<Object> keys = cr.getHeaders().get(KEY);
        boolean accessed = false;
        for (Object key : keys) {
            if ("lanboal".equals(key)) {
                accessed = true;
                break;
            }
        }
        if (!accessed) {
            InputStream is = new ByteArrayInputStream("权限校验未通过".getBytes());
            return new ClientResponse(401, null, is, null);
        }
        return getNext().handle(cr);
    }
}
