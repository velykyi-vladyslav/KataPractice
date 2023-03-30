package velykyi.vladyslav.level3;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;

@SuppressWarnings("unused")
public class KataApp {

    /**
     * Method to test KATA tasks
     * @param args ignored
     */
    public static void main(String[] args) {
        for (int i : deleteNth2(new int[]{1, 1, 3, 3, 7, 2, 2, 2, 2}, 3)) {
            System.out.println(i);
        }
        System.out.println(deleteNth2(new int[] { 1, 1, 3, 3, 7, 2, 2, 2, 2 }, 3 ));
    }

    /**
     * Given a list and a number, create a new list that contains each number of list at most N times, without reordering.
     * For example if the input number is 2, and the input list is [1,2,3,1,2,1,2,3], you take [1,2,3,1,2],
     * drop the next [1,2] since this would lead to 1 and 2 being in the result 3 times,
     * and then take 3, which leads to [1,2,3,1,2,3].
     * With list [20,37,20,21] and number 1, the result would be [20,37,21].
     *
     * @param elements elements
     * @param maxOccurrences maxOccurrences
     * @return elements in scope of maxOccurrences
     */
    public static int[] deleteNth(int[] elements, int maxOccurrences) {
        List<Integer> elementsList = new ArrayList<>();
        Arrays.stream(elements).forEach(elementsList::add);

        Map<Integer, Integer> elementsToDelete =
                getOccurrencesToDelete(maxOccurrences, getGroupedOccurrences(elementsList));

        removeElements(elementsToDelete, elementsList);

        return elementsList.stream().mapToInt(i -> i).toArray();
    }

    private static void removeElements(Map<Integer, Integer> elementsToDelete, List<Integer> elementsList) {
        ListIterator<Integer> integerIterator = elementsList.listIterator(elementsList.size());

        while (integerIterator.hasPrevious()) {
            Integer integer = integerIterator.previous();

            if (elementsToDelete.containsKey(integer)) {
                integerIterator.remove();

                int count = elementsToDelete.get(integer) - 1;

                if (count == 0) {
                    elementsToDelete.remove(integer);
                } else {
                    elementsToDelete.put(integer, count);
                }
            }
        }
    }

    private static Map<Integer, Integer> getGroupedOccurrences(List<Integer> elements) {
        Map<Integer, Integer> groupedMap = new HashMap<>();
        elements.forEach(el -> groupedMap.merge(el, 1, Integer::sum));

        return groupedMap;
    }

    private static Map<Integer, Integer> getOccurrencesToDelete(int maxOccurrences, Map<Integer, Integer> map) {
        return map.entrySet().stream()
                .filter(entry -> entry.getValue() > maxOccurrences)
                .collect(toMap(Map.Entry::getKey, entry -> entry.getValue() - maxOccurrences));
    }


    /**
     * Not completed - time is up
     */
    public static int[] deleteNth2(int[] elements, int maxOccurrences) {
        // Треба LinkedList - ordered
        // треба створити мапу - [1,2,3,1,2,1,2,3] -> {(1-3), (2-3), (3-2)}
        // Вибрати які елементи видаляти. {(1-3), (2-3), (3-2)} -> {(1-1), (2-1)}
        //зробитиітерейт по лісту видалити елемент з ліста і з мапи.
        // повернути масив від лінкед ліста

        LinkedList<Integer> elementList = new LinkedList<>();
        for (int element : elements) {
            elementList.add(element);
        }

        Map<Integer, Integer> occurrencesMap = new HashMap<>();
        elementList.forEach(el ->
                occurrencesMap.put(el, occurrencesMap.getOrDefault(el, 0) + 1));

        Map<Integer, Integer> occurrencesToRemove = occurrencesMap.entrySet().stream()
                .filter(entry -> entry.getValue() <= maxOccurrences).collect(toMap(Map.Entry::getKey, Map.Entry::getValue));

        //todo remove from elementList -> occurrencesToRemove


        // Вибрати які елементи видаляти. {(1-3), (2-3), (3-2)} -> {(1-1), (2-1)}
        //кожний валює по ключу яке < maxOccurences - видалити або скіпнути
        return Arrays.stream(elements).toArray();
    }

    //todo Failed task Valid Braces https://www.codewars.com/kata/5277c8a221e209d3f6000b56/train/java
    /**
     * Write a function that takes a string of braces, and determines if the order of the braces is valid. It should return true if the string is valid, and false if it's invalid.
     *
     * This Kata is similar to the Valid Parentheses Kata, but introduces new characters: brackets [], and curly braces {}. Thanks to @arnedag for the idea!
     *
     * All input strings will be nonempty, and will only consist of parentheses, brackets and curly braces: ()[]{}.
     */
    public static boolean isValid(String braces) {
        String allBraces = "][{}()";
        Map<String, Integer> bracesProcessor = new HashMap<>();

        Arrays.stream(braces.split(""))
                .forEach(s -> bracesProcessor.compute(s, (key, val) -> val == null ? 1 : val + 1));

        int i = 0;
        while (i < allBraces.length()) {
            String leftBrace = allBraces.substring(i, ++i);
            String rightBrace = allBraces.substring(i, ++i);

            Integer countLeft = bracesProcessor.get(leftBrace);
            Integer countRight = bracesProcessor.get(rightBrace);

            if (!Objects.equals(countLeft, countRight)) {
                return false;
            }
        }

        return true;
    }
}
