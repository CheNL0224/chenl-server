package com.social.chenl.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author meyer
 */
public class GsonUtil {

    /**
     * 实现格式化的时间字符串转时间对象
     */
    private static final String DATEFORMAT_default = "yyyy-MM-dd HH:mm:ss";

    /**
     * 使用默认的gson对象进行反序列化
     *
     * @param json
     * @param typeToken
     * @return
     */
    public static <T> T fromJsonDefault(String json, TypeToken<T> typeToken) {
        Gson gson = new Gson();
        return gson.fromJson(json, typeToken.getType());
    }

    /**
     * json字符串转list或者map
     *
     * @param json
     * @param typeToken
     * @return
     */
    public static <T> T fromJson(String json, TypeToken<T> typeToken) {

        Gson gson = new GsonBuilder()
                /**
                 * 重写map的反序列化
                 */
                .registerTypeAdapter(new TypeToken<Map<String, Object>>() {
                }.getType(), new MapTypeAdapter()).create();

        return gson.fromJson(json, typeToken.getType());

    }

    /**
     * json字符串转bean对象
     *
     * @param json
     * @param cls
     * @return
     */
    public static <T> T fromJson(String json, Class<T> cls) {
        if (HashMap.class.isAssignableFrom(cls))
        {
            HashMap sourceMap = fromJson(json, new TypeToken<HashMap>() {});

            try {
                Class<?> clazz = Class.forName(cls.getTypeName());

                HashMap retMap = (HashMap) clazz.newInstance();
                retMap.putAll(sourceMap);
                return (T)retMap;
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        Gson gson = new GsonBuilder().setDateFormat(DATEFORMAT_default)
                .create();

        return gson.fromJson(json, cls);

    }

    /**
     * 对象转json
     *
     * @param obj
     * @param format
     * @return
     */
    public static String toJson(Object obj, boolean format) {

        GsonBuilder gsonBuilder = new GsonBuilder();
        /**
         * 设置默认时间格式
         */
        gsonBuilder.setDateFormat(DATEFORMAT_default);

        /**
         * 添加格式化设置
         */
        if (format) {
            gsonBuilder.setPrettyPrinting();
        }
        /**
         *不处理null值，还要参与序列化
         */
        gsonBuilder.serializeNulls();
        Gson gson = gsonBuilder.disableHtmlEscaping().create();

        return gson.toJson(obj);
    }

    /**
     * HashMap 转 json
     *
     * @param hashMap
     * @return
     */
    public static <T> String toJson(HashMap<?, ?> hashMap, Class<T> cls) {
        return new GsonBuilder().enableComplexMapKeySerialization().create().toJson(hashMap, cls);
    }

    public static class MapTypeAdapter extends TypeAdapter<Object> {

        @Override
        public Object read(JsonReader in) throws IOException {
            JsonToken token = in.peek();
            switch (token) {
                case BEGIN_ARRAY:
                    List<Object> list = new ArrayList<Object>();
                    in.beginArray();
                    while (in.hasNext()) {
                        list.add(read(in));
                    }
                    in.endArray();
                    return list;

                case BEGIN_OBJECT:
                    Map<String, Object> map = new LinkedTreeMap<>();
                    in.beginObject();
                    while (in.hasNext()) {
                        map.put(in.nextName(), read(in));
                    }
                    in.endObject();
                    return map;

                case STRING:
                    return in.nextString();

                case NUMBER:
                    /**
                     * 改写数字的处理逻辑，将数字值分为整型与浮点型。
                     */
                    double dbNum = in.nextDouble();

                    // 数字超过long的最大值，返回浮点类型
                    if (dbNum > Long.MAX_VALUE) {
                        return dbNum;
                    }

                    // 判断数字是否为整数值
                    long lngNum = (long) dbNum;
                    if (dbNum == lngNum) {
                        return lngNum;
                    } else {
                        return dbNum;
                    }

                case BOOLEAN:
                    return in.nextBoolean();

                case NULL:
                    in.nextNull();
                    return null;

                default:
                    throw new IllegalStateException();
            }
        }

        @Override
        public void write(JsonWriter out, Object value) {
            // 序列化无需实现
        }
    }

}
