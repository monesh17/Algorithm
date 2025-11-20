import java.util.*;

public class YamlOutput {

    private static Map<String, String> generateYaml(Map<String, String> input, Map<String, String> ruleSet) {
        LinkedHashMap<String,String> result = new LinkedHashMap<>();
        List<String> orders  = List.of("c","b","f","e");
        for(String order : orders) {
            String originalKey = order;
            String key = ruleSet.getOrDefault(originalKey, originalKey);
            result.put(originalKey, input.getOrDefault(key, input.get(originalKey)));
        }

        return result;
    }

    public static void main(String[] args) {

        Map<String, String> input = new HashMap<>();
        input.put("a","a1");
        input.put("b","b1");
        input.put("c","c1");
        input.put("f","f1");
        input.put("e","d1");

        Map<String,String> ruleSet = new HashMap<>();
        ruleSet.put("a","b");
        ruleSet.put("b","a");
        ruleSet.put("c","b");
        ruleSet.put("e","g");

        Map<String,String> output = generateYaml(input,ruleSet);
        System.out.println(output);

    }
}
