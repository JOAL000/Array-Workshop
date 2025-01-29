package se.lexicon;


import java.util.Arrays;

public class App {
    public static void main(String[] args) {

        int size = NameRepository.getSize();
        System.out.println(size);
        NameRepository.setNames(new String[]{"Erik Svensson", "Mehrdad Javan"});
        System.out.println(Arrays.toString(NameRepository.findByFirstName("Mehrdad")));
        System.out.println(Arrays.toString(NameRepository.findByLastName("Javan")));
        System.out.println(NameRepository.getSize());
        NameRepository.remove("Mehrdad Javan");

        // call more methods as needed
    }
}
