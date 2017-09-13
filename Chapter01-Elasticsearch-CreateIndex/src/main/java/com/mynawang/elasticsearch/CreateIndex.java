package com.mynawang.elasticsearch;

import com.alibaba.fastjson.JSON;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mynawang on 2017/9/12 0012.
 */
public class CreateIndex {

    public static void main(String[] args) {

        Student student1 = new Student();
        student1.setStudentNo(100000000001L);
        student1.setStudentName("mynawang");
        student1.setStudentClass("一班");
        student1.setAge(18);

        Student student2 = new Student();
        student2.setStudentNo(200000000001L);
        student2.setStudentName("张三");
        student2.setStudentClass("二班");
        student2.setAge(18);

        Student student3 = new Student();
        student3.setStudentNo(300000000001L);
        student3.setStudentName("李四");
        student3.setStudentClass("三班");
        student3.setAge(18);

        Student student4 = new Student();
        student4.setStudentNo(400000000001L);
        student4.setStudentName("王五");
        student4.setStudentClass("四班");
        student4.setAge(18);

        try {
            TransportClient client = new PreBuiltTransportClient(Settings.EMPTY)
                    .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("115.28.72.24"), 9300));


            // 索引（数据库名）   类型（表名）
            IndexResponse response1 = client.prepareIndex("estest", "student").
                    setSource(student1.toJson()).get();
            IndexResponse response2 = client.prepareIndex("estest", "student").
                    setSource(student2.toMap()).get();
            IndexResponse response3 = client.prepareIndex("estest", "student").
                    setSource(student3.toSerialize(student3)).get();
            IndexResponse response4 = client.prepareIndex("estest", "student").
                    setSource(student4.toElasticsearchBuilder()).get();


            System.out.println(JSON.toJSONString(response1.status()));
            System.out.println(JSON.toJSONString(response2.status()));
            System.out.println(JSON.toJSONString(response3.status()));
            System.out.println(JSON.toJSONString(response4.status()));

            client.close();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }


    public void createIndex(Student student, String jsonType) {
        try {
            TransportClient client = new PreBuiltTransportClient(Settings.EMPTY)
                    .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("115.28.72.24"), 9300));
            IndexResponse response = null;
            // 索引（数据库名）   类型（表名）
            if ("json".equals(jsonType)) {
                response = client.prepareIndex("estest", "student").setSource(student.toJson()).get();
            } else if ("map".equals(jsonType)) {
                response = client.prepareIndex("estest", "student").setSource(student.toMap()).get();
            } else if ("serialize".equals(jsonType)) {
                response = client.prepareIndex("estest", "student").setSource(student.toSerialize(student)).get();
            } else if ("builder".equals(jsonType)) {
                response = client.prepareIndex("estest", "student").setSource(student.toElasticsearchBuilder()).get();
            }
            client.close();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
