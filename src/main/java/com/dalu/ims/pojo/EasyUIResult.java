package com.dalu.ims.pojo;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

public class EasyUIResult {
    public static final ObjectMapper MAPPER = new ObjectMapper();

    private Integer totle;
    private List<?> rows;

    public EasyUIResult() {};
    public EasyUIResult(Integer totle, List<?> rows) {
        this.totle = totle;
        this.rows = rows;
    }
    public EasyUIResult(Long totle, List<?> rows) {
        this.totle = totle.intValue();
        this.rows = rows;
    }

    public Integer getTotle() {
        return totle;
    }

    public void setTotle(Integer totle) {
        this.totle = totle;
    }

    public List<?> getRows() {
        return rows;
    }

    public void setRows(List<?> rows) {
        this.rows = rows;
    }

    /**
     * 集合转换
     * @param jsonData
     * @param clazz
     * @return
     */
    public static EasyUIResult formatToList(String jsonData, Class<?> clazz) {
        try {
            JsonNode jsonNode = MAPPER.readTree(jsonData);
            JsonNode data = jsonNode.get("rows");
            List<?> list = null;
            if (data.isArray() && data.size() > 0) {
                list = MAPPER.readValue(data.traverse(), MAPPER.getTypeFactory().constructCollectionType(List.class, clazz));
            }
            return new EasyUIResult(jsonNode.get("totle").intValue(), list);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
