package com.mynawang.elasticsearch;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.elasticsearch.common.xcontent.XContentBuilder;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.elasticsearch.common.xcontent.XContentFactory.jsonBuilder;

/**
 * Created by mynawang on 2017/9/12 0012.
 */
public class Student {
    private Long studentNo;
    private String studentName;
    private String studentClass;
    private Integer age;

    public Long getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(Long studentNo) {
        this.studentNo = studentNo;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String toJson() {
        String jsonStr = "{" +
                "\"studentNo\":" + studentNo +"," +
                "\"studentName\":\""+ studentName +"\"," +
                "\"studentClass\":\"" + studentClass +"\"," +
                "\"age\":" + age + "}";
        return jsonStr;
    }

    public Map<String, Object> toMap() {
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        jsonMap.put("studentNo", studentNo);
        jsonMap.put("studentName", studentName);
        jsonMap.put("studentClass", studentClass);
        jsonMap.put("age", age);
        return jsonMap;
    }


    public byte[] toSerialize(Student student) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        byte[] jsonSerialize = mapper.writeValueAsBytes(student);
        return jsonSerialize;
    }

    public String toElasticsearchBuilder() throws IOException {
        XContentBuilder builder = jsonBuilder()
                .startObject()
                    .field("studentNo", studentNo)
                    .field("studentName", studentName)
                    .field("studentClass", studentClass)
                    .field("age", age)
                .endObject();
        return builder.string();
    }
}
