package com.mynawang.elasticsearch.helloworld;

import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

/**
 * Created by mynawang on 2017/9/12 0012.
 */
public class ElasticSearchHandler {

    public static void main(String[] args) {
        try {
            TransportClient client = new PreBuiltTransportClient(Settings.EMPTY)
                    .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("115.28.72.24"), 9300));

            List<String> jsonData = DataFactory.getInitJsonData();
            for (int i = 0; i < jsonData.size(); i++) {
                IndexResponse response = client.prepareIndex("blog", "article").
                        setSource(jsonData.get(i)).get();
            }
            client.close();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
