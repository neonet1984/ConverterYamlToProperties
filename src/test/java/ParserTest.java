import org.junit.Assert;
import org.junit.Test;
import parser.Parser;

import java.util.ArrayList;
import java.util.List;

/**
 * The ParserTest class testing class Parser
 */
public class ParserTest {
    private List<String> inputData;
    private List<String> expectedData = new ArrayList<>();
    private Parser parser = new Parser();

    /**
     * The method tests the Parser class
     */
    @Test
    public void Test() {
        String actual = parser.getConvertedPropertiesFromYaml(inputData).toString();
        String expected = getExpectedData().toString();
        Assert.assertTrue(actual.equals(expected));
    }

    private List<String> getInputData() {
        List<String> data = new ArrayList<>();
        data.add("people:");
        data.add("  personaldata:");
        data.add("      name: \"Evgeny\"");
        data.add("      age: \"20\"");
        return inputData;
    }

    private List<String> getExpectedData() {
        expectedData.add("people.personaldata.name=Evgeny");
        expectedData.add("people.personaldata.age=20");
        return expectedData;
    }

}
