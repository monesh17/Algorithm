import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

class Input {
    String event;
    String time;

    public Input(String event, String time) {
        this.event = event;
        this.time = time;
    }
}

public class MaxConcurrency {

    public static int maxConcurrency(List<Input> inputArrayList) {
        TreeMap<String, Integer> map = new TreeMap<>();
        int max =0,result=0;
        for (Input input : inputArrayList) {
            if (input.event.equals("start")) {
                map.put(input.time, map.getOrDefault(input.time,0)+1);
            } else {
                map.put(input.time, map.getOrDefault(input.time,0)-1);
                if (map.get(input.time) == 0) {
                    map.remove(input.time);
                }
            }
        }

        for(Map.Entry<String,Integer> entry:map.entrySet()){
            max +=entry.getValue();
            if(max>result){
                result=max;
            }
        }
        return result;
    }


    public static void main(String[] args) {
        List<Input> inputArrayList = List.of(new Input("start", "10:00"), new Input("end", "10:30"), new Input("start", "10:15"), new Input("end", "10:45"), new Input("start", "10:35"), new Input("end", "10:50"));

        System.out.println(maxConcurrency(inputArrayList));

    }
}
