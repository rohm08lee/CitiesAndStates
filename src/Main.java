import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(new FileReader("citystate.in"));
        PrintWriter pw = new PrintWriter("citystate.out");

        int n = sc.nextInt();
        Map<String, Long> count = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String city = sc.next().substring(0, 2);
            String state = sc.next();

            if (!city.equals(state)) {
                String key = city+state;
                if (!count.containsKey(key)) {
                    count.put(key, 0L);
                }
                count.put(key, count.get(key) + 1);
            }
        }
        long ret = 0;
        for(String key: count.keySet()) {
            String otherKey = key.substring(2) + key.substring(0, 2);
            if(count.containsKey(otherKey)) {
                ret += count.get(key) * count.get(otherKey);
            }
        }


        pw.println(ret/2);
        pw.close();
    }
}
