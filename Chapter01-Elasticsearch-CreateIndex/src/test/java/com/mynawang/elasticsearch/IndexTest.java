package com.mynawang.elasticsearch;

import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetResponse;
import org.junit.Test;

import java.net.UnknownHostException;

/**
 * Created by mynawang on 2017/9/12 0012.
 */
public class IndexTest {

    @Test
    public void testCreateIndex() {
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
        CreateIndex createIndexHandler = new CreateIndex();
        createIndexHandler.createIndex(student1, "json");
        createIndexHandler.createIndex(student2, "map");
        createIndexHandler.createIndex(student3, "serialize");
        createIndexHandler.createIndex(student4, "builder");
    }

    @Test
    public void testGetIndex() {
        GetIndex getIndex = new GetIndex();
        try {
            GetResponse response = getIndex.getIndex("estest", "student", "AV51YMiyUV2GMK0ZkvEy");
            System.err.println(response.toString());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetMutliIndex() {
        GetIndex getIndex = new GetIndex();
        try {
            getIndex.getMultiIndex();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void testDeleteIndex() {
        DeleteIndex deleteIndex = new DeleteIndex();
        try {
            DeleteResponse response = deleteIndex.deleteIndex("estest", "student", "AV51YMiyUV2GMK0ZkvEy");
            System.err.println(response.toString());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }


}
