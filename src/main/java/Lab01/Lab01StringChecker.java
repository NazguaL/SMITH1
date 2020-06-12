package Lab01;

import java.util.ArrayList;

public class Lab01StringChecker {

    public String[] findLessThanAverage(String[] strArray){

        int avg = findAverage(strArray);

        ArrayList<String> strList = new ArrayList<>();

        for (String s : strArray) {
            if(s.length() < avg){
                strList.add(s);
            }
        }

        String[] result = strList.toArray(new String[0]);

        return result;
    }

    public int findAverage(String[] strArray) {
        int sum = 0;

        for (String s: strArray) {
            sum += s.length();
        }

        int avr = sum / strArray.length;

        return avr;
    }

}