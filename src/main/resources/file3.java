// This is a class in java syntax

package test.nested;

import java.nio.file.Files;
import java.util.concurrent.Callable;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//Commented imports are added by Groovy by default
/*
import java.lang.*
import java.util.*
import java.io.*
import java.net.*
import groovy.lang.*
import groovy.util.*
import java.math.BigInteger
import java.math.BigDecimal
*/

//Usage of Callable does not entail anything special, just wanted to use a parameterizable interface :)

public class Foos implements Callable<Void> {
    
    private List<String> names = Stream.of("Mike", "Madhu", "Yuriy").collect(Collectors.toCollection(LinkedList::new));
    private PrintStream out = System.out;
    
    public Void call() {
        long yers = names.stream().filter(n -> n.toUpperCase().startsWith("Y")).count();
        out.println(names.size() + " names");
        out.println(String.format("%d Y-ers found", yers));
        out.println();
        
        addRandomName();
        return null;
    }
    
    private void addRandomName() {
        
        double d = Math.random();
        String suffix = Double.toString(d).substring(2);
        if (d < 0.5) {
            names.add("y" + suffix);
        } else {
            names.add(suffix);
        }
        
    }

}