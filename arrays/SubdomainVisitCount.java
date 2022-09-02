package arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/subdomain-visit-count/solution/
public class SubdomainVisitCount {

    Map<String, Integer> domainCounter = new HashMap<>();

    public List<String> subdomainVisits(String[] cpdomains) {
        List<String> results = new ArrayList<>();

        for (String cpdomain : cpdomains) {
            String[] split = cpdomain.split("\\s+");
            Integer count = Integer.parseInt(split[0]);
            String[] domains = split[1].split("\\.");

            String cur = "";
            for (int i = domains.length - 1; i >= 0; i--) {
                System.out.println("Cur before : " + cur);
                cur = domains[i] + (i < domains.length - 1 ? ".": "") + cur;
                System.out.println("Cur after : " + cur);
                domainCounter.put(cur, domainCounter.getOrDefault(cur, 0) + count);
            }
        }

        for (String domain : domainCounter.keySet()) {
            results.add(domainCounter.get(domain) + " " + domain);
        }
        return results;
    }

}
