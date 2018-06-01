import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamExample {
    public static void main(String[] args) {

        List<Person> people = new ArrayList<>();
        people.add(new Person("Anders", "Andersen", 10));
        people.add(new Person("Søren", "Sørensen", 20));
        people.add(new Person("John", "Johnson", 30));
        people.add(new Person("Jan", "Jansen", 40));
        people.add(new Person("Adolf", "Hitler", 50));

        // Stream 1
        System.out.println("Stream 1: ");
        people.stream()
                .filter(isBad().negate())
                .forEach(System.out::println);

        // Stream 2
        System.out.println("\nStream 2: ");
        System.out.println("Average age: " +
            people.stream()
                .map(p -> p.getAge())
                .reduce(0, Integer::sum) / people.size());

        // Stream 3
        System.out.println("\nStream 3: ");
        people = people.stream()
                .sorted(Comparator.comparingInt(Person::getAge).reversed())
                .collect(Collectors.toList());

        people.stream()
                .forEach(System.out::println);

    }
    public static Predicate<Person> isBad(){
        return p -> p.getLastName().equals("Hitler");
    }
}
