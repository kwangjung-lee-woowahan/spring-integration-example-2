import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;
import java.util.Map;
import lombok.Data;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

public class Main {

  private static final String sampleString = """
      {
        "name": "Sample",
        "payload": {
          "value": 10
        }
      }
      """;

  public static void main(String... args) throws JsonProcessingException {
    ObjectMapper objectMapper = new ObjectMapper()
        .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    Map map = objectMapper.readValue(sampleString, Map.class);
    Sample sample = objectMapper.readValue(sampleString, Sample.class);

    System.out.println(map);
    System.out.println(sample);

    Integer result = JsonPath.parse(sampleString).read("$.payload.value");
    System.out.println(result);
    String updated = JsonPath.parse(sampleString).set("$.payload.value", result + 10).jsonString();
    System.out.println(updated);

    Expression expression = new SpelExpressionParser().parseExpression("payload.value");
    EvaluationContext context = new StandardEvaluationContext(sample);
    Long result1 = (Long) expression.getValue(context);
    System.out.println(result1);
  }

  @Data
  public static class Sample {
    private String name;
    private SamplePayload payload;
  }

  @Data
  public static class SamplePayload {
    private Long value;
  }
}
