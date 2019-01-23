package Leecode;

import utils.PrintUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Prob_811 {
    public List<String> subdomainVisits(String[] cpdomains) {
        if(cpdomains == null || cpdomains.length == 0) return Collections.emptyList();

        Map<String, Integer> countMap = new HashMap<>();

        for (String cpd : cpdomains) {
            String[] cnt_cpd = cpd.split(" ");
            int cnt = Integer.valueOf(cnt_cpd[0]);
            String domains = cnt_cpd[1] ;
            int index = -1;
            int fromIndex = 0;

            while(fromIndex < domains.length() && (index = domains.indexOf('.', fromIndex)) != -1 ) {
               String domain = domains.substring(fromIndex) ;


               if(countMap.get(domain) == null) {
                   countMap.put(domain, cnt);
               } else {
                   countMap.put(domain, cnt + countMap.get(domain));
               }
               fromIndex += (index - fromIndex) + 1;
            }

            String domain = domains.substring(fromIndex) ;


            if(countMap.get(domain) == null) {
                countMap.put(domain, cnt);
            } else {
                countMap.put(domain, cnt + countMap.get(domain));
            }

        }

        List<String> result = new ArrayList<>();

        for (Map.Entry entry: countMap.entrySet()) {
            result.add(entry.getValue() + " " + entry.getKey());
        }

        return result;
    }

    public static void main(String[] args) {
        PrintUtils.printStringList(new Prob_811().subdomainVisits(new String[]{"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org" }));


    }
}

