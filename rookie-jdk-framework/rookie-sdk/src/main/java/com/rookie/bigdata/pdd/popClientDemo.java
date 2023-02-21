package com.rookie.bigdata.pdd;

import com.pdd.pop.sdk.common.util.JsonUtil;
import com.pdd.pop.sdk.http.PopBaseHttpRequest;
import com.pdd.pop.sdk.http.api.pop.request.PddPopAuthTokenCreateRequest;
import com.pdd.pop.sdk.http.api.pop.response.PddPopAuthTokenCreateResponse;
import com.pdd.pop.sdk.http.PopClient;
import com.pdd.pop.sdk.http.PopHttpClient;
import com.pdd.pop.sdk.http.client.AbstractPopClient;

/**
 * @Classname popClientDemo
 * @Description TODO
 * @Author rookie
 * @Date 2023/2/21 9:53
 * @Version 1.0
 */
public class popClientDemo {

    public static void main(String[] args) throws Exception {

        //签名方法
//        PopBaseHttpRequest.getParamsMap()
//        AbstractPopClient
        //private <T> HttpEntity getEntity(PopBaseHttpRequest<T> request, String accessToken)
        // protected <T extends PopBaseHttpResponse, K extends PopBaseHttpResponse> K syncGet(PopBaseHttpRequest<T> request, String accessToken, String url, Class<K> valueType)
        String clientId = "your clientId";
        String clientSecret = "your clientSecret";
        PopClient client = new PopHttpClient(clientId, clientSecret);

        PddPopAuthTokenCreateRequest request = new PddPopAuthTokenCreateRequest();
        request.setCode("str");
        PddPopAuthTokenCreateResponse response = client.syncInvoke(request);
        System.out.println(JsonUtil.transferToJson(response));
    }
}
