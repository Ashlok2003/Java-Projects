import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Stream2 {
    public static void main(String[] args) {
        List<Integer> x = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> y = Arrays.asList(6, 7, 8, 9, 0);

        List<Integer> a = Stream.concat(x.stream(), y.stream())
                .collect(Collectors.toList());

        System.out.println("Concatenated: " + a);

        List<Integer> unordered = x.stream().unordered()
                .collect(Collectors.toList());

        System.out.println("Unordered: " + unordered);

        x.parallelStream().forEach(System.out::println);

        List<Double> doubles = Arrays.asList(1.1, 2.2, 3.3);
        doubles.stream()
                .mapToDouble(Double::doubleValue)
                .forEach(System.out::println);

        List<List<Integer>> nestedList = Arrays.asList(Arrays.asList(1, 2), Arrays.asList(3, 4), Arrays.asList(5, 6));
        int[] flattened = nestedList.stream()
                .flatMapToInt(list -> list.stream().mapToInt(Integer::intValue))
                .toArray();

        System.out.println("Flattened Array: " + Arrays.toString(flattened));

        List<Integer> iterated = Stream.iterate(1, n -> n * 2)
                .limit(5)
                .collect(Collectors.toList());
        System.out.println("Iterated: " + iterated);

        IntSummaryStatistics stats = x.stream()
                .mapToInt(Integer::intValue)
                .summaryStatistics();
        System.out.println("Summary Statistics: " + stats);

        x.stream()
                .forEachOrdered(System.out::println);

        List<String> words = Arrays.asList("apple", "banana", "cherry", "date", "elderberry");

        List<String> letters = words.stream()
                .flatMap(word -> word.chars().mapToObj(c -> String.valueOf((char) c)))
                .collect(Collectors.toList());

        System.out.println("Letters: " + letters);

        Map<Integer, List<String>> lengthToWords = words.stream()
                .collect(Collectors.groupingBy(String::length));

        System.out.println("Words Grouped bt Length: " + lengthToWords);

        Optional<String> ashlok__ = words.stream().reduce((p, q) -> p + "-" + q);
        ashlok__.ifPresent(o -> System.out.println(o));

        List<String> modifiedWords = words.stream()
                .peek(word -> System.out.println("Before: " + word))
                .map(String::toUpperCase)
                .peek(word -> System.out.println("After: " + word))
                .collect(Collectors.toList());

        System.out.println("ModifiedList: " + modifiedWords);

        List<String> upperCaseWords = words.stream()
                .map(String::toUpperCase)
                .onClose(() -> System.out.println("Stream is closed."))
                .collect(Collectors.toList());

        System.out.println(upperCaseWords);

    }
}
