package Leecode.contest198;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Prob5466 {
    static class Node {
        int start = -1, end = -1, cnt = 0;
    }
    public List<String> maxNumOfSubstrings(String s) {
        Map<Character, Node> charNodeMap = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            Node node = charNodeMap.getOrDefault(ch, new Node());
            if(node.start == -1) {
                node.start = i;
            }
            node.end = i;
            node.cnt += 1;
            charNodeMap.put(ch, node);
        }

        List<String> result = new ArrayList<>();

        for(Map.Entry<Character, Node> entry: charNodeMap.entrySet()) {
            Node value = entry.getValue();
            if(value.cnt == (value.end - value.start + 1)) {
                char ch = entry.getKey();
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < value.cnt;i++) sb.append(ch);
                result.add(sb.toString());
            }
        }

        


        return result;
    }



    public static void main(String[] args) {
        Prob5466 prob5466 = new Prob5466();
        prob5466.maxNumOfSubstrings("abaabbcaaabbbccd");
    }
}
