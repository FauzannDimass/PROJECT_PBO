class FileHandler {
    public static void saveData(String filePath, String data) {
        try (java.io.FileWriter writer = new java.io.FileWriter(filePath)) {
            writer.write(data);
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }

    public static String readData(String filePath) {
        StringBuilder data = new StringBuilder();
        try (java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                data.append(line).append("\n");
            }
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        return data.toString();
    }
}