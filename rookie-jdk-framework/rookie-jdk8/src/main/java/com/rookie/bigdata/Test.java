package com.rookie.bigdata;

/**
 * @Classname Test
 * @Description TODO
 * @Author rookie
 * @Date 2022/12/21 14:42
 * @Version 1.0
 */
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tinet.clink.core.client.Client;
import com.tinet.clink.core.client.ClientConfiguration;
import com.tinet.clink.core.exceptions.ClientException;
import com.tinet.clink.core.exceptions.ServerException;
import com.tinet.clink.cc.request.queue.ListQueuesRequest;
import com.tinet.clink.cc.response.queue.ListQueuesResponse;

public class Test {
    public static void main(String[] args) {
        // 创建访问服务的client实例并初始化
        ClientConfiguration configuration = new ClientConfiguration(
                "<your-access-key-id>",          // AccessKeyId
                "<your-access-key-secret>");     // AccessKeySecret
        /*
            设置请求平台：
                北京平台：api-bj.clink.cn
                上海平台：api-sh.clink.cn
            默认为北京平台
        */
        configuration.setHost("api-bj.clink.cn");

        Client client = new Client(configuration);

        // 创建API请求并设置参数
        ListQueuesRequest request = new ListQueuesRequest();
        // 签名的有效时间（秒），最小值为 1，最大值为 86400（24 小时），默认为 5
        request.expires(5);
        request.setLimit(10);
        request.setOffset(0);

        // 发起请求并处理应答或异常
        ListQueuesResponse response;
        ObjectMapper mapper = new ObjectMapper();

        try {
            response = client.getResponseModel(request);
            try {
                System.out.println(mapper.writeValueAsString(response.getQueues()));
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        } catch (ClientException e) {
            e.printStackTrace();
        } catch (ServerException e) {
            e.printStackTrace();
        }
    }
}