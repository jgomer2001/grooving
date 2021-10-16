package test;

//Usage of a non JDK class
import org.json.JSONObject;

import java.time.Instant

/**
 * Hello
 */
public class Foo {

    public Foo() {
        
        JSONObject json = new JSONObject();
        json.put("date", Instant.now().toString());
        System.out.println(json);
         
        int sum = java.util.stream.Stream.of(1,2,3,4,5).reduce(
                //Usage of functional interface, ie. supplies an implementation for BiFunction.apply(Object, Object)
                (n1, n2 ) -> {
                    return n1 + n2; 
                }
            ).get();
        System.out.println(sum);
        
    }

}