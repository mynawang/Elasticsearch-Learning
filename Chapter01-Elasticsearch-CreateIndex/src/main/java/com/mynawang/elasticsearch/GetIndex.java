package com.mynawang.elasticsearch;

import com.alibaba.fastjson.JSON;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.get.MultiGetItemResponse;
import org.elasticsearch.action.get.MultiGetResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by mynawang on 2017/9/12 0012.
 */
public class GetIndex {

    public GetResponse getIndex(String indexName, String typeName, String id) throws UnknownHostException {
        TransportClient client = new PreBuiltTransportClient(Settings.EMPTY)
                .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("115.28.72.24"), 9300));
        GetResponse response = client.prepareGet(indexName, typeName, id)
                .setOperationThreaded(false)
                .get();
        return response;
    }

    public void getMultiIndex() throws UnknownHostException {
        TransportClient client = new PreBuiltTransportClient(Settings.EMPTY)
                .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("115.28.72.24"), 9300));
        MultiGetResponse multiGetItemResponses = client.prepareMultiGet()
                .add("estest", "student", "AV51YMiyUV2GMK0ZkvEy")
                .add("blog", "article", "AV51BZPRUV2GMK0ZkvEp")
                .add("estest", "student", "AV51YMosUV2GMK0ZkvEz", "AV51gLv1UV2GMK0ZkvE5")
                .get();

        for (MultiGetItemResponse itemResponse : multiGetItemResponses) {
            GetResponse response = itemResponse.getResponse();
            if (response.isExists()) {
                String json = response.getSourceAsString();
                System.out.println(json);
            }
        }
    }


}




