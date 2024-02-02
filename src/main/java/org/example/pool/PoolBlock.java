package org.example.pool;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;

abstract public class PoolBlock {

  public static Integer getValue(String target, Object payload) throws JsonProcessingException {
    ObjectMapper objectMapper = new ObjectMapper();

    String payloadJson = objectMapper.writeValueAsString(payload);

    return JsonPath.parse(payloadJson)
        .read(target);
  }

  public static Object newPayload(Integer newValue, String target, Object payload)
      throws JsonProcessingException {
    ObjectMapper objectMapper = new ObjectMapper();

    String payloadJson = objectMapper.writeValueAsString(payload);
    String newPayloadJson = JsonPath.parse(payloadJson)
        .set(target, newValue)
        .jsonString();

    return objectMapper.readValue(newPayloadJson, Object.class);
  }
}
