package libretti.com;
//importazione libreria per utilizzare le Stream
import java.sql.ClientInfoStatus;
import java.text.DateFormatSymbols;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        //creazione di uno stream da un Array
        String[] colori={"viola","bianco","marrone","rosso","nero"};
        Stream<String> stream = Arrays.stream(colori);

        //creazione da una  lista di elementi
        stream=Stream.of("grgio","rosa","lilla");

        //creazione di una Stream vuota
        Stream<String> stream1= Stream.empty();

        //creazione di uno Strea con builder
        Stream<String> streamBuilder = Stream.<String>builder().add("bianco").add("rosso").add("giallo").add("blu").add("verde").build();

        //generate di uno Stream random
        Stream<Double> streamRandom = Stream.generate(new Random()::nextDouble).limit(10);


        //generazione Stream interfacce sostitutive tipi primitivi

        IntStream intStream = IntStream.range(1, 10);
        DoubleStream doubleStream= intStream.asDoubleStream();//converte una Stream di interi in una Stream di double
        IntStream charStream= "viola".chars();//utilizzo del metodo chars();


        //patternSplit pe le stringhe

        Stream<String> stringStream= Pattern.compile(",").splitAsStream("mamma,papa,figlio,padre");


        //esempio metodo Fitler
        Stream<String> filterStream= Stream.of("patate","piselli","cipolle","carote");
        filterStream.filter((s) -> s.startsWith("pi")).forEach(System.out::println);


        //esempio Sorted e collect nelle Stream
        List<String> lista=Stream.of("piedi","spalle","ginocchia","testa")
        //ordinamento e raccolta
                .sorted()
                .collect(Collectors.toList());
        System.out.println(lista);


        //esempio mapping
        List<String> listainteri = Stream.iterate(0, n -> n + 1).limit(12)
                .map(numb -> new DateFormatSymbols().getMonths()[numb])
        .collect(Collectors.toList());

        System.out.println(listainteri);

        Persona persona= new Persona("marco",21,true);
        Persona persona2= new Persona("matteo",68,false);
        Persona persona3= new Persona("matteo",68,false);

        Stream<Persona> personaStream= Stream.of(persona,persona2,persona3);
        personaStream.filter(p -> !p.isSposato()).forEach(System.out::println);


    }
}
