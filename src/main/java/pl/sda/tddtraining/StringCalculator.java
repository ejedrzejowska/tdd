package pl.sda.tddtraining;

import org.apache.commons.lang3.StringUtils;

public class StringCalculator {


    public static int adding(String testString) {
        if (StringUtils.isBlank(testString)) {
            return 0;
        }
        return tokenizeAndSum(testString);
    }

    private static int tokenizeAndSum(String testString) {
        String delimiter = "[,\n]";
        if(testString.startsWith("//")){
            delimiter = String.valueOf(testString.charAt(2));
            testString = testString.split("\n")[1];
        }
        String[] splitted = testString.split(delimiter);
        int sum = 0;
        for (String s : splitted) {
            if (StringUtils.isNotBlank(s)) {
                sum += Integer.parseInt(s.trim());
            }
        }
        return sum;
    }
}
