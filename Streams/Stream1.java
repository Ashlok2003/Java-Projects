import java.util.*;
import java.util.stream.Collectors;

public class Stream1 {
	public static void main(String[] args) {
		List<Integer> x = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

    List<Integer> odd = x.stream()
                          .filter(n -> n % 2 != 0)
  	                      .collect(Collectors.toList());

    System.out.println("Odd Numbers: " + odd);

    List<Integer> squared = x.stream()
                                  .map(a -> a * a)
                                  .collect(Collectors.toList());

    System.out.println("Squared Numbers: " + squared);


    List<Integer> Distinct = x.stream().distinct()
                              .collect(Collectors.toList());

    System.out.println("Distinct Numbers: " + Distinct);

    List<Integer> sorted = x.stream().sorted()
                            .collect(Collectors.toList());

    System.out.println("Sorted Numbers: " + sorted);


    x.stream().forEach(System.out::println);

    Optional<Integer> reduced_sum = x.stream().reduce((a, b) -> a + b);

    reduced_sum.ifPresent(value -> System.out.println("Sum: " + value));


    Long count = x.stream().count();
    System.out.println("Count: " + count);


    boolean anyMatch = x.stream().anyMatch(a -> a > 5);
    System.out.println("Any Match: " + anyMatch);
    
    boolean allMatch = x.stream().allMatch(a -> a > 5);
    System.out.println("All Match: " + allMatch);
    
    boolean noneMatch = x.stream().noneMatch(n -> n == 0);
    System.out.println("None Match: " + noneMatch);

    Optional<Integer> min = x.stream().min(Integer::compareTo);
    Optional<Integer> max = x.stream().max(Integer::compareTo);
    min.ifPresent(value -> System.out.println("Minimum: " + value));
    max.ifPresent(value -> System.out.println("Maximum: " + value));
    
	}
}
