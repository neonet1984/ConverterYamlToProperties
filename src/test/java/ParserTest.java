import file.ReadFile;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import parser.Parser;
import java.util.ArrayList;
import java.util.List;


public class ParserTest {
    private List<String> inputData;
    private List<String> trueResultList;
    private Parser parser;

    @Before
    public void init() {
        parser = new Parser();
        inputData = new ArrayList<>();
        inputData = getInputData();
        trueResultList = new ArrayList<>();
    }

    @Test
    public void Test() {

        String resultParser = parser.yamlToProperties(inputData).toString();
        String trueResult = getTrueResult().toString();
        Assert.assertTrue(resultParser.equals(trueResult));
    }

    private List<String> getInputData() {

        inputData.add("people:");
        inputData.add("  personaldata:");
        inputData.add("      name: \"Evgeny\"");
        inputData.add("      age: \"20\"");
        return inputData;
    }
    private List<String> getTrueResult(){
        trueResultList.add("people.personaldata.name=Evgeny");
        trueResultList.add("people.personaldata.age=20");
        return trueResultList;
    }

}
