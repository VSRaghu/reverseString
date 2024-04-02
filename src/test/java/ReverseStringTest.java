import hsbc.com.FileUtil;
import hsbc.com.ReverseString;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class ReverseStringTest {

    @Test(expected = Exception.class)
    public void testIncorrectInputFilePath() throws Exception {
        String outputFilePath = "src/main/resources/output.txt";
        List<String> testData = getTestData();
        FileUtil fileUtil = Mockito.mock(FileUtil.class);
        Mockito.when(fileUtil.readFileData(null)).thenThrow(Exception.class);
        Mockito.when(fileUtil.writeToFile(testData, outputFilePath)).thenReturn(true);
        ReverseString reverseString = new ReverseString(fileUtil);
        reverseString.reverseString(null, outputFilePath);
    }

    @Test(expected = Exception.class)
    public void testIncorrectOutputFilePath() throws Exception {
        String inputFile = "input.txt";
        FileUtil fileUtil = Mockito.mock(FileUtil.class);
        Mockito.when(fileUtil.readFileData(inputFile)).thenReturn(getTestData());
        Mockito.when(fileUtil.writeToFile(Mockito.anyList(), null)).thenThrow(Exception.class);
        ReverseString reverseString = new ReverseString(fileUtil);
        reverseString.reverseString(inputFile, null);
    }

    @Test(expected = Exception.class)
    public void testReverseStringWithNullList() throws Exception {
        FileUtil fileUtil = Mockito.mock(FileUtil.class);
        Mockito.when(fileUtil.readFileData(Mockito.anyString())).thenReturn(null);
        ReverseString reverseString = new ReverseString(fileUtil);
        reverseString.reverseString(Mockito.anyString(), Mockito.anyString());
    }

    @Test
    public void testReverseString() throws Exception {
        String inputFile = "input.txt";
        String outputFilePath = "src/main/resources/output.txt";
        List<String> testData = getTestData();
        FileUtil fileUtil = Mockito.mock(FileUtil.class);
        Mockito.when(fileUtil.readFileData(inputFile)).thenReturn(testData);
        Mockito.when(fileUtil.writeToFile(Mockito.anyList(), Mockito.anyString())).thenReturn(true);
        ReverseString reverseString = new ReverseString(fileUtil);
        List<String> reversedStrings = reverseString.reverseString(inputFile, outputFilePath);
        Assert.assertNotNull(reversedStrings);
        Assert.assertEquals(reversedStrings.size(), testData.size());
        Assert.assertEquals(reversedStrings.get(0), "CBA");
    }

    @Test(expected = Exception.class)
    public void testReverseStringWithEmptyList() throws Exception {
        String inputFile = "input.txt";
        String outputFilePath = "src/main/resources/output.txt";
        List<String> testData = new ArrayList<>();
        FileUtil fileUtil = Mockito.mock(FileUtil.class);
        Mockito.when(fileUtil.readFileData(inputFile)).thenReturn(testData);
        Mockito.when(fileUtil.writeToFile(Mockito.anyList(), Mockito.anyString())).thenReturn(true);
        ReverseString reverseString = new ReverseString(fileUtil);
        reverseString.reverseString(inputFile, outputFilePath);
    }

    public List<String> getTestData() {
        List<String> strings = new ArrayList<>();
        strings.add("ABC");
        strings.add("DEF");
        strings.add("PQR");
        return strings;
    }
}
