import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Temp {
    public static void main(String[] args) {
        Stream<String> streamBuilder = Stream.<String>builder().add("a").add("b").add("c").build();
        streamBuilder.forEach(System.out::println);

        Stream<String> streamGenerated = Stream.generate(() -> "Element").limit(10);
        streamGenerated.forEach(System.out::println);

        List<Integer> ashlok__ = Stream.iterate(10, x -> x + 1).limit(20).collect(Collectors.toList());
        System.out.println(ashlok__);

        Stream.of("ABCD", "EFGH", "IJKL").skip(1).forEach(System.out::println);

        System.out.println("Ashlok Was Here !");
    }
}
