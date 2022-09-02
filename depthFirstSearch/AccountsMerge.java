package depthFirstSearch;

import java.util.*;

//https://leetcode.com/problems/accounts-merge/solution/
public class AccountsMerge {


    // all emails that have been seen/visited
    private HashSet<String> seen = new HashSet<String>();

    // construct an adjacency list of each email in account connect to other emails in that account
    private Map<String, List<String>> adjacencyList = new HashMap<String, List<String>>();

    private void DFS(List<String> mergedAccount, String email) {
        mergedAccount.add(email);
        seen.add(email);

        if (!adjacencyList.containsKey(email)) {
            return;
        }

        for (String neighbor : adjacencyList.get(email)) {
            if (!seen.contains(neighbor)) {
                DFS(mergedAccount, neighbor);
            }
        }

    }

    // main function
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        if (accounts == null || accounts.size() == 0) {
            return new ArrayList<>();
        }

        // Build adjacency list.
        // For each account add an edge between the first email (accountFirstEmail) and each of the other emails in the account.
        for (List<String> emailsForAccount : accounts) {
            String firstEmailForAccount = emailsForAccount.get(1);

            for (int i = 2; i < emailsForAccount.size(); i++) {
                String accountEmail = emailsForAccount.get(i);
                if (!adjacencyList.containsKey(firstEmailForAccount)) {
                    adjacencyList.put(firstEmailForAccount, new ArrayList<String>());
                }
                adjacencyList.get(firstEmailForAccount).add(accountEmail);
                if (!adjacencyList.containsKey(accountEmail)) {
                    adjacencyList.put(accountEmail, new ArrayList<String>());
                }
                adjacencyList.get(accountEmail).add(firstEmailForAccount);
            }
        }

        // Traverse other the email accounts.
        // For each account, check if first email in account was already seen. If so, do not start a new DFS. If not, start a DFS using first email as source node

        // After DFS is over, sort the mergedAccount list starting from its emails
        // Store the result mergedAccount into mergedAccounts
        List<List<String>> mergedAccounts = new ArrayList<>();
        for (List<String> account: accounts) {
            String accountName = account.get(0);
            String accountFirstEmail = account.get(1);

            if (!seen.contains(accountFirstEmail)) {
                List<String> mergedAccount = new ArrayList<>();
                mergedAccount.add(accountName);

                DFS(mergedAccount, accountFirstEmail);

                Collections.sort(mergedAccount.subList(1, mergedAccount.size()));

                mergedAccounts.add(mergedAccount);
            }
        }
        return mergedAccounts;
    }

}
