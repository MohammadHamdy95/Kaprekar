import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class KaprekarSolver {
    public static int solve(int number){
        // 1 we are given a 4 digit number with at least 2 different digits
        // 2 the number must be rearranged in ascending order.
        // 3 then that number is subracted from the same number in the oppositve order.
        // 4 repeat this process until you reach 6174
        int counter = 0;
        int answer = 0;
        ArrayList<Integer> answers = new ArrayList<>();
        for(int i =0;i<10;i++){
            String numtoString = String.valueOf(number);
            ArrayList<Integer> list = new ArrayList<>();
            int first = Integer.parseInt(String.valueOf(numtoString.charAt(0)));
            int second = Integer.parseInt(String.valueOf(numtoString.charAt(1)));
            int third = Integer.parseInt(String.valueOf(numtoString.charAt(2)));
            int fourth = Integer.parseInt(String.valueOf(numtoString.charAt(3)));
            list.add(first);
            list.add(second);
            list.add(third);
            list.add(fourth);
            Collections.sort(list);
            ArrayList<Integer> smallList = new ArrayList<>(list);
            Collections.reverse(list);
            int bigNumber = converIntegerListToOneNumber(list);
            int smallNumber = converIntegerListToOneNumber(smallList);
            answer = bigNumber - smallNumber;
            answers.add(answer);
            number = answer;
            counter++;
            System.out.println("On try "+counter+" we got "+bigNumber+"-"+smallNumber+"="+answer);
            if (answer == 6174){
                System.out.println("Yay we got 6174 on try "+counter);
                return counter;
            }
        }
        return counter;
    }
    public static int converIntegerListToOneNumber(ArrayList<Integer> numList){
        int answer = 0;
        answer += numList.get(0) * 1000;
        answer += numList.get(1) * 100;
        answer += numList.get(2) * 10;
        answer += numList.get(3);
        return answer;
    }
}
