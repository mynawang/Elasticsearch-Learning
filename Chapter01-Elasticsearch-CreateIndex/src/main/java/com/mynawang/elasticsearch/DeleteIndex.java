package com.mynawang.elasticsearch;

import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by mynawang on 2017/9/13 0013.
 */
public class DeleteIndex {

    public DeleteResponse deleteIndex(String indexName, String typeName, String id) throws UnknownHostException {
        TransportClient client = new PreBuiltTransportClient(Settings.EMPTY)
                .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("115.28.72.24"), 9300));
        DeleteResponse response = client.prepareDelete(indexName, typeName, id).get();
        return response;
    }


}
