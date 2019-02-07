import java.util.ArrayList;
import java.util.List;

public class CalculatorPrepared {

    public static void main(String[] args) {
        System.out.println("Main called");
    }

    private List<Integer> numbers;

    public List<Integer> getNumbers() {
        return numbers;
    }

    public CalculatorPrepared(List<Integer> initialValues){
        numbers = initialValues;
    }

    public Integer getSum (){
        Integer sum = 0;
        for (Integer number : numbers) {
            sum += number;
        }

        return sum;
    }

    public void addNumber(int number){
        numbers.add(number);
    }

    public Boolean isPositive (int index){
        return numbers.get(index) >= 0;
    }

    public Integer getMaximumOccurence() {
        if (numbers.isEmpty()) {
            return null;
        }

        int maximumOccurence = 0;
        int mostCommonNUmber = 0;

        for (int i = 0; i < numbers.size(); i++) {
            int actual = numbers.get(i);
            int actualsOccurrences = 0;
            for (int j = 0; j < numbers.size(); j++) {
                if (numbers.get(j) == actual)
                {
                    actualsOccurrences ++;
                }
            }
            if (actualsOccurrences > maximumOccurence){
                maximumOccurence = actualsOccurrences;
                mostCommonNUmber = actual;
            }
        }

        return mostCommonNUmber;
    }

    public Integer getMaximumOccurenceFixed() {
        if (numbers.isEmpty()) {
            return null;
        }

        int maximumOccurence = 0;
        ArrayList<Integer> mostCommonNUmbers = new ArrayList<>();

        for (int i = 0; i < numbers.size(); i++) {
            int actual = numbers.get(i);
            int actualsOccurrences = 0;
            for (int j = 0; j < numbers.size(); j++) {
                if (numbers.get(j) == actual)
                {
                    actualsOccurrences ++;
                }
            }
            if (actualsOccurrences > maximumOccurence){
                maximumOccurence = actualsOccurrences;
                mostCommonNUmbers.clear();
                mostCommonNUmbers.add(actual);
            } else if (actualsOccurrences == maximumOccurence && !mostCommonNUmbers.contains(actual)){
                maximumOccurence = actualsOccurrences;
                mostCommonNUmbers.add(actual);
            }
        }

        return mostCommonNUmbers.size() == 1 ? mostCommonNUmbers.get(0) : null;
    }
}