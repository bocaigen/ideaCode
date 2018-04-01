import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        Map<String,Integer> map = new HashMap<>();
        map.put("A",1);
        map.put("B",2);
        map.put("C",3);
        map.put("a",1);
        map.put("b",2);

        switch (map.get("B")){
            case 1:
                if (map.get("a")==1){
                    System.out.println("A==1-------a==1");
                }
            break;
            case 2:
                if (map.get("a")==1){
                    System.out.println("A==2-------a==1");
                }
            break;
            default:
                System.out.println("其他的");

        }
    }
}
