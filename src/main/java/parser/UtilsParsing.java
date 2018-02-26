package parser;

/**
 * Utils class for Prarser class
 */
public class UtilsParsing {
    /**
     * The method checks the count of attributes in the yaml line
     *
     * @param line line containing yaml attributes
     */
    public static boolean checkYamlLine(String line) {
        int countYamlAttribure = line.trim().split(":").length;
        return (countYamlAttribure > 1);
    }

    /**
     * The method is used to calculate the number of spaces
     * in at the beginning of the yaml line
     *
     * @param line line containing yaml attributes
     * @return number of spaces
     */
    public static int getCountSpace(String line) {
        int countSpace = 0;
        for (char symbol : line.toCharArray()) {
            if (symbol != ' ') {
                return countSpace;
            }
            countSpace++;
        }
        return countSpace;
    }

    /**
     * The method is used to get the yaml attribute
     *
     * @param line line containing yaml attributes
     * @return yaml key from a yaml line
     */
    public static String getYamlKey(String line) {
        return line.replace(":", "").trim();
    }

    /**
     * The method is uses to get key: value from yaml line
     *
     * @param line line containing yaml attributes
     * @return format value: "key: value"
     */
    public static String getKeyValue(String line) {
        return line.replace(":", "=").
                replace(" ", "").replace("\"", "");
    }
}
