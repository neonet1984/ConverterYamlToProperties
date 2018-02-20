import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import parser.Parser;
import java.util.ArrayList;
import java.util.List;


public class ParserTest {
    private List<String> inputData;
    private Parser parser;

    @Before
    public void init() {
        parser = new Parser();
        inputData = new ArrayList<>();
        inputData = getInputData();
    }

    @Test
    public void Test() {
        String resultParser = parser.yamlToProperties(inputData).toString();
        String trueResult = getInputData().toString();
        Assert.assertTrue(resultParser.equals(trueResult.toString()));
    }

    private List<String> getInputData() {
        inputData.add("people:");
        inputData.add("  personaldata:");
        inputData.add("      name: \"Evgeny\"");
        inputData.add("      age: \"20\"");
        return inputData;
    }

}
