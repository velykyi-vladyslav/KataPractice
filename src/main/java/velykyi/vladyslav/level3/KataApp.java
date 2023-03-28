package velykyi.vladyslav.level3;

import java.util.*;

import static java.util.stream.Collectors.toMap;

@SuppressWarnings("unused")
public class KataApp {

    /**
     * Method to test KATA tasks
     * @param args ignored
     */
    public static void main(String[] args) {

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
}
