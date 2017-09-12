package com.mynawang.elasticsearch;

import com.alibaba.fastjson.JSON;
import org.elasticsearch.action.get.GetResponse;
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

    public void getIndex(String indexName, String typeName, String id) throws UnknownHostException {
        TransportClient client = new PreBuiltTransportClient(Settings.EMPTY)
                .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("115.28.72.24"), 9300));
        GetResponse response = client.prepareGet(indexName, typeName, id)
                .setOperationThreaded(false)
                .get();

        System.out.println(JSON.toJSONString(response));

    }


}




