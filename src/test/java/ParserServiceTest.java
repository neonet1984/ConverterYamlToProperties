import com.parser.ParserService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * The ParserServiceTest class testing class ParserService
 */
public class ParserServiceTest {
    private List<String> inputData = getInputData();
    private List<String> expectedData = new ArrayList<>();
    @Autowired
    private ParserService parserService;

    /**
     * The method tests the ParserService class
     */
    @Test
    public void Test() {
        String actual = parserService.getConverterData(inputData).toString();
        String expected = getExpectedData().toString();
        Assert.assertEquals(actual,expected);
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
