package com.mynawang.elasticsearch;

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
        CreateIndexHandler createIndexHandler = new CreateIndexHandler();
        createIndexHandler.createIndex(student1, "json");
        createIndexHandler.createIndex(student2, "map");
        createIndexHandler.createIndex(student3, "serialize");
        createIndexHandler.createIndex(student4, "builder");
    }

    @Test
    public void testGetIndex() {
        GetIndex getIndex = new GetIndex();
        try {
            getIndex.getIndex("estest", "student", "AV51YMiyUV2GMK0ZkvEy");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

}
