import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import parser.Parser;
import java.util.ArrayList;
import java.util.List;


public class ParserTest {
    private List<String> inputData = new ArrayList<>();;
    private List<String> expectedData = new ArrayList<>();
    private Parser parser = new Parser();

    @Before
    public void init() {
        inputData = getInputData();
    }

    @Test
    public void Test() {
        String actual = parser.yamlToProperties(inputData).toString();
        String expected = getExpectedData().toString();
        Assert.assertTrue(actual.equals(expected));
    }

    private List<String> getInputData() {
        inputData.add("people:");
        inputData.add("  personaldata:");
        inputData.add("      name: \"Evgeny\"");
        inputData.add("      age: \"20\"");
        return inputData;
    }
    private List<String> getExpectedData(){
        expectedData.add("people.personaldata.name=Evgeny");
        expectedData.add("people.personaldata.age=20");
        return expectedData;
    }

}
