package hsbc.com;

import java.util.List;

public class ReverseStringMain {
    public static void main(String[] args) throws Exception {
        FileUtil fileUtil = new FileUtil();
        ReverseString reverseString = new ReverseString(fileUtil);
        List<String> reversedString = reverseString.reverseString("input.txt", "src/main/resources/output.txt");
        // Print if you want to see the reverted String in the console
    }
}