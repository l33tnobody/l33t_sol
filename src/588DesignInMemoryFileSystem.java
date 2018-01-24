class FileSystem {

    class File {
        boolean isFile = false;
        Map<String, File> children = new HashMap<>();
        String content = "";
        String name = "";
    }

    private File root = null;

    public FileSystem() {
        root = new File();
    }

    public List<String> ls(String path) {
        String[] dirs = path.split("/");  // will result in a leading "" if there are other strings following the first /, if split just "/" will result in an empty []
        File node = root;
        List<String> result = new ArrayList<>();
        for (String dir : dirs) {
            if (dir.length() == 0) continue;
            node = node.children.get(dir);
        }

        if (node.isFile) {
            result.add(node.name);
        } else {
            for(String key : node.children.keySet()) {
                result.add(key);
            }
        }

        Collections.sort(result);
        return result;
    }

    public void mkdir(String path) {
        String[] dirs = path.split("/");
        File node = root;
        for (String dir : dirs) {
            if (dir.length() == 0) continue;
            if (!node.children.containsKey(dir)) {
                File file = new File();
                file.name = dir;
                node.children.put(dir, file);
            }
            node = node.children.get(dir);
        }
    }

    public void addContentToFile(String filePath, String content) {
        String[] dirs = filePath.split("/");
        File node = root;
        for (String dir : dirs) {    // try to simplify the node addressing
            if (dir.length() == 0) continue;
            if (!node.children.containsKey(dir)) {
                File file = new File();
                file.name = dir;
                node.children.put(dir, file);
            }
            node = node.children.get(dir);
        }
        node.isFile = true;
        node.content += content;
    }

    public String readContentFromFile(String filePath) {
        String[] dirs = filePath.split("/");
        File node = root;
        for (String dir : dirs) {
            if (dir.length() == 0) continue;
            node = node.children.get(dir);
        }
        return node.content;
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * List<String> param_1 = obj.ls(path);
 * obj.mkdir(path);
 * obj.addContentToFile(filePath,content);
 * String param_4 = obj.readContentFromFile(filePath);
 */
