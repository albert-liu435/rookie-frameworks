package com.rookie.bigdata.pdd;

import com.pdd.pop.sdk.common.util.JsonUtil;
import com.pdd.pop.sdk.http.api.pop.request.PddErpOrderSyncRequest;
import com.pdd.pop.sdk.http.api.pop.response.PddErpOrderSyncResponse;
import com.pdd.pop.sdk.http.PopClient;
import com.pdd.pop.sdk.http.PopHttpClient;

/**
 * @Classname popClientDemo
 * @Description TODO
 * @Author rookie
 * @Date 2023/2/21 9:53
 * @Version 1.0
 */
public class popClientDemo1 {

    public static void main(String[] args) throws Exception {

        String clientId = "your clientId";
        String clientSecret = "your clientSecret";
        String accessToken = "your accessToken";
        PopClient client = new PopHttpClient(clientId, clientSecret);

        PddErpOrderSyncRequest request = new PddErpOrderSyncRequest();
        request.setLogisticsId(0L);
        request.setOrderSn("str");
        request.setOrderState(0);
        request.setWaybillNo("str");
        PddErpOrderSyncResponse response = client.syncInvoke(request, accessToken);
        System.out.println(JsonUtil.transferToJson(response));
    }
}
