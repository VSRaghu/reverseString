package hsbc.com;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {
    private InputStream getFileInputStream() {
        return this.getClass().getClassLoader().getResourceAsStream("input.txt");
    }

    public List<String> readFileData(String inputFileName) throws Exception {
        if(inputFileName == null || inputFileName.isEmpty()) {
            throw new Exception("Incorrect input file name.");
        }
        List<String> strings = new ArrayList<>();
        InputStream inputStream = getFileInputStream();
        if(inputStream == null) {
            throw new Exception("Incorrect input file stream. Some issue reading inout file");
        }
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.US_ASCII);
        try(BufferedReader br = new BufferedReader(inputStreamReader)) {
            String line;
            while((line = br.readLine()) != null) {
                if(!line.isEmpty()) {
                    strings.add(line);
                }
            }
        } catch (IOException exception) {
            throw new Exception("Issue reading input file.");
        }
        return strings;
    }

    public boolean writeToFile(List<String> reversedStrings, String outputFilePath) throws Exception {
        if(outputFilePath == null || outputFilePath.isEmpty()) {
            throw new Exception("Output file path is incorrect");
        }
        try(FileWriter writer = new FileWriter(outputFilePath)) {
            StringBuilder reversed = new StringBuilder();
            for(String str: reversedStrings) {
                reversed.append(str).append("\n");
            }
            writer.write(reversed.toString());
        } catch (Exception exception) {
            throw new Exception("Exception writing output in the file");
        }
        return true;
    }
}
