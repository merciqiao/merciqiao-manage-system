package com.carloan.common.utils;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * Created by zhangyl on 2018/7/25
 */
public class JacksonSerializer {
    private Logger logger = LoggerFactory.getLogger(JacksonSerializer.class);

    private ObjectMapper objectMapper;

    public JacksonSerializer() {
        this.objectMapper = new ObjectMapper();
    }


    public String serializer(Object obj) {
        if(obj==null){
            return null;
        }
        try {
            return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            logger.error("序列化Json失败", e);
        }
        return null;
    }

    public <T> T deserialize(String jsonStr, Class<T> clazz) {
        if (StringUtils.isEmpty(jsonStr)) {
            return null;
        }
        try {
            return objectMapper.readValue(jsonStr, clazz);
        } catch (JsonParseException e) {
            logger.error("反序列化Json失败，转换错误。", e);
        } catch (JsonMappingException e) {
            logger.error("反序列化Json失败，json映射错误。", e);
        } catch (IOException e) {
            logger.error("反序列化Json失败，IO异常。", e);
        }
        return null;
    }

    public <T> T deserialize(String jsonStr, Class<?> collectionClass, Class<?>... elementClasses) {
        if(StringUtils.isEmpty(jsonStr)){
            return null;
        }
        try {
            return objectMapper.readValue(jsonStr, getCollectionType(collectionClass,elementClasses));
        } catch (JsonParseException e) {
            logger.error("反序列化Json失败，转换错误。", e);
        } catch (JsonMappingException e) {
            logger.error("反序列化Json失败，json映射错误。", e);
        } catch (IOException e) {
            logger.error("反序列化Json失败，IO异常。", e);
        }
        return null;
    }

    public JavaType getCollectionType(Class<?> collectionClass, Class<?>... elementClasses) {
        return objectMapper.getTypeFactory().constructParametricType(collectionClass, elementClasses);
    }
}
