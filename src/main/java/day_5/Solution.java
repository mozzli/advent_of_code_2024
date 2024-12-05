package day_5;

import java.util.ArrayList;
import java.util.HashMap;

public class Solution {

    HashMap<Integer, ArrayList<Integer>> rulebook;

    public Solution(HashMap<Integer, ArrayList<Integer>> rulebook){
        this.rulebook = rulebook;
    }

    public int getCentralSum(ArrayList<ArrayList<Integer>> numberList, boolean isCorrect) {
        ArrayList<Integer> centralNumbers = new ArrayList<>();
        for (ArrayList<Integer> numbers : numberList){
            if (isCorrect && areNumbersCorrect(numbers)) centralNumbers.add(numbers.get((numbers.size()/2)));
            else if (!isCorrect && !areNumbersCorrect(numbers))centralNumbers.add(updateFalseNumbers(numbers).get((numbers.size()/2)));
        }
        return centralNumbers.stream().mapToInt(i -> i).sum();
    }

    private boolean areNumbersCorrect(ArrayList<Integer> numbers){
        for (int i = 0; i< numbers.size() -1; i++){
            for (int j = i + 1; j< numbers.size(); j++){
                if(rulebook.containsKey(numbers.get(i)) && rulebook.get(numbers.get(i)).contains(numbers.get(j))) return false;
            }
        }
        return true;
    }

    public ArrayList<Integer> updateFalseNumbers(ArrayList<Integer> numbers){
        for (int i = 0; i< numbers.size() -1; i++){
            for (int j = i + 1; j< numbers.size(); j++){
                if(rulebook.containsKey(numbers.get(i)) && rulebook.get(numbers.get(i)).contains(numbers.get(j))) {
                    int removed2 = numbers.remove(j);
                    int removed = numbers.remove(i);
                    numbers.add(i, removed2);
                    numbers.add(j, removed);
                    return updateFalseNumbers(numbers);
                }
            }
        }
        return numbers;
    }
}
