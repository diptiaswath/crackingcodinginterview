package design;

/*
Karat Wayfair interview

Suppose we have an unsorted log file of accesses to web resources. Each log entry consists of an access time, the ID of the user making the access, and the resource ID.

The access time is represented as seconds since 00:00:00, and all times are assumed to be in the same day.

Example:
logs1 = [
    ["58523", "user_1", "resource_1"],
    ["62314", "user_2", "resource_2"],
    ["54001", "user_1", "resource_3"],
    ["200", "user_6", "resource_5"],
    ["215", "user_6", "resource_4"],
    ["54060", "user_2", "resource_3"],
    ["53760", "user_3", "resource_3"],
    ["58522", "user_22", "resource_1"],
    ["53651", "user_5", "resource_3"],
    ["2", "user_6", "resource_1"],
    ["100", "user_6", "resource_6"],
    ["400", "user_7", "resource_2"],
    ["100", "user_8", "resource_6"],
    ["54359", "user_1", "resource_3"],
]

Example 2:
logs2 = [
    ["300", "user_1", "resource_3"],
    ["599", "user_1", "resource_3"],
    ["900", "user_1", "resource_3"],
    ["1199", "user_1", "resource_3"],
    ["1200", "user_1", "resource_3"],
    ["1201", "user_1", "resource_3"],
    ["1202", "user_1", "resource_3"]
]

Example 3:
logs3 = [
    ["300", "user_10", "resource_5"]
]

Write a function that takes the logs and returns the resource with the highest number of accesses in any 5 minute window, together with how many accesses it saw.

Expected Output:
most_requested_resource(logs1) # => ('resource_3', 3) [resource_3 is accessed at 53760, 54001, and 54060]
most_requested_resource(logs2) # => ('resource_3', 4) [resource_3 is accessed at 1199, 1200, 1201, and 1202]
most_requested_resource(logs3) # => ('resource_5', 1) [resource_5 is accessed at 300]

Complexity analysis variables:

n: number of logs in the input

*/
import java.util.*;

class Resource {
    public String resourceName;
    public int count;

    public String toString() {
        return resourceName + "," + count;
    }
}

public class MaxResourceCount {
    public Resource mostRequestedResource(String[][] logs) {
        Map<String, Set<Integer>> requests = new HashMap<>();

        for (String[] log : logs) {
            requests.computeIfAbsent(log[2], k -> new TreeSet<Integer>()).add(Integer.parseInt(log[0]));
        }

        Resource maxResource = new Resource();
        for (String resource : requests.keySet()) {
            System.out.println("resource = " + resource + " , accessTimes = " + requests.get(resource));
            List<Integer> accessTimes = new ArrayList<Integer>(requests.get(resource));

            for (int i = accessTimes.size() - 1; i >= 1; i--) {
                int count = 0;
                for (int j = i; j >=0 ; j--) {
                    if (accessTimes.get(i) - accessTimes.get(j) <= 300) {
                        System.out.println(i + " ," + j);
                        count++;
                    }
                } // end of for-j
                if (count > maxResource.count) {
                    maxResource.resourceName = resource;
                    maxResource.count = count;
                }
            } // end of for-i
        } // for each resource
        return maxResource;
    }

    public static void main(String[] args) {
        String[][] logs1 = new String[][] {
                { "58523", "user_1", "resource_1" },
                { "62314", "user_2", "resource_2" },
                { "54001", "user_1", "resource_3" },
                { "200", "user_6", "resource_5" },
                { "215", "user_6", "resource_4" },
                { "54060", "user_2", "resource_3" },
                { "53760", "user_3", "resource_3" },
                { "58522", "user_22", "resource_1" },
                { "53651", "user_5", "resource_3" },
                { "2", "user_6", "resource_1" },
                { "100", "user_6", "resource_6" },
                { "400", "user_7", "resource_2" },
                { "100", "user_8", "resource_6" },
                { "54359", "user_1", "resource_3"},
        };

        String[][] logs2 = new String[][] {
                {"300", "user_1", "resource_3"},
                {"599", "user_1", "resource_3"},
                {"900", "user_1", "resource_3"},
                {"1199", "user_1", "resource_3"},
                {"1200", "user_1", "resource_3"},
                {"1201", "user_1", "resource_3"},
                {"1202", "user_1", "resource_3"}
        };

        String[][] logs3 = new String[][] {
                {"300", "user_10", "resource_5"}
        };

        MaxResourceCount s = new MaxResourceCount();
        System.out.println(s.mostRequestedResource(logs2));
        System.out.println(s.mostRequestedResource(logs1));
    }

}
