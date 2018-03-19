import com.config.AppConfig;
import com.config.TestConfig;
import com.service.IParser;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * The ParserServiceTest class testing class ParserService
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ComponentScan(basePackages = {"com.service"})
@ContextConfiguration(classes = TestConfig.class)
public class ParserServiceTest {
    @Autowired
    private IParser parserService;
    private List<String> inputData = getInputData();
    private List<String> expectedData = new ArrayList<>();

    /**
     * The method tests the ParserService class
     */
    @Test
    public void test() {
        String actual = parserService.getConverterData(inputData).toString();
        String expected = getExpectedData().toString();
        Assert.assertEquals(actual, expected);
    }

    private List<String> getInputData() {
        List<String> data = new ArrayList<>();
        data.add("people:");
        data.add("  personaldata:");
        data.add("      name: \"Evgeny\"");
        data.add("      age: \"20\"");
        return data;
    }

    private List<String> getExpectedData() {
        expectedData.add("people.personaldata.name=Evgeny");
        expectedData.add("people.personaldata.age=20");
        return expectedData;
    }
}
