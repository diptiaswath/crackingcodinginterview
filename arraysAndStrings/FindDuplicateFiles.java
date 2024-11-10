// https://www.educative.io/courses/grokking-coding-interview/find-duplicate-file-in-system

public class FindDuplicateFile {
    public static List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> map = new HashMap<>();

        for(String path: paths) {
            String[] tokens = path.split(" ");
            String dir = tokens[0];

            for (int i = 1; i < tokens.length; i++) {
                String[] split = tokens[i].split("\\(");
                if (split.length < 2)
                    continue;
                String dirFile = dir + "/" + split[0];
                String content = split[1].substring(0, split[1].length() - 1);

                if (!map.containsKey(content)) {
                    map.put(content, new ArrayList<String>());
                }
                map.get(content).add(dirFile);
            }
        }

        // Replace this placeholder return statement with your code
        List<List<String>> output = new ArrayList<>();
        for (List<String> dirFiles: map.values()) {
            if (dirFiles.size() > 1) {
                output.add(dirFiles);
            }
        }

        return output;
    }

}