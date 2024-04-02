package hsbc.com;

import java.util.ArrayList;
import java.util.List;

public class ReverseString {
    private FileUtil fileUtil;

    public ReverseString(FileUtil fileUtil) {
        this.fileUtil = fileUtil;
    }

    public List<String> reverseString(String inputFileName, String outputFilePath) throws Exception {
        List<String> reversedStrings = new ArrayList<>();
        List<String> strings = fileUtil.readFileData(inputFileName);
        if(strings == null || strings.isEmpty()) {
            throw new Exception("There is no String to revert");
        }
        for(String str: strings) {
            StringBuilder builder = new StringBuilder(str);
            reversedStrings.add(builder.reverse().toString());
        }
        fileUtil.writeToFile(reversedStrings, outputFilePath);
        return reversedStrings;
    }


    private String reverse(String str) {
        StringBuilder stringBuilder = new StringBuilder(str);
        return stringBuilder.reverse().toString();
    }
}
