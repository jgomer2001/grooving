A small demonstration of Java scripting using the Groovy library.

Advantages:

- Project maintenance guaranteed
- Good docs
- Small footprint ~8MB. Apparently no dependencies
- Supports Java 8 syntax (probably 8+ too)
- Easy to handle

Usage hints:

- This is a maven project 
- Check class [test](./src/main/java/io/jans/groovypoc/test.java) 
- Uncomment lines in `main` method
- See source files in [resources](./src/main/resources) directory

Some useful pointers:

- [Integrating Groovy in a Java application](https://docs.groovy-lang.org/latest/html/documentation/guide-integrating.html)
- https://docs.groovy-lang.org/latest/html/api/groovy/lang/GroovyClassLoader.html
- https://stackoverflow.com/questions/10198026/groovy-vs-java-syntax-discrepancy
- https://stackoverflow.com/questions/4272068/is-groovy-syntax-an-exact-superset-of-java-syntax

About the "Integrating Groovy into applications" page:

`GroovyScriptEngine` is the way to go to in order to support scripts that depend on other scripts; also 
reloading is handled automatically. Plain `GroovyClassLoader` is fine when using a single standalone script. In this case reloading can be done by using `parseClass`.

A couple of lessons learned:
 
- Dependant scripts must follow the convention of classes and directory naming of Java so they can be `import`ed. As an example, class `Hello` of package `there` should be stored in a file named `Hello.groovy` inside `There` directory which should be under the root of the engine instance obtained. It does not have to be written in idiomatic Groovy, classic Java is OK.

- The (main) script to run (via `GroovyScriptEngine#run`) can use the `.java` extension and does not need to follow the naming conventions. For practical purposes the script should return something, as in the example given in the doc page.

- Both `.groovy` and `.java` extensions can be used for dependant scripts. However, this requires calling `CompilerConfiguration#setScriptExtensions` on the compiler configuration associated to the script engine. Otherwise, it will only work with `.groovy` files.
