package interview.preparation.newjava.java11;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Set;

/*New Features in Java 11*/
public interface IJava11 {
    /* new methods to the String class: isBlank, lines, strip, stripLeading, stripTrailing, and repeat.*/
    public List<String> strOperation(String multilineStr);

    /*new readString and writeString static methods from the Files class*/
    public String readFilesStr(String temp, String text) throws IOException;

    /*Collection to an Array*/
    public String[] collectionToArray(List<String> list);

    /*The Not Predicate Method*/
    public List<String> notPredicate(List<String> list);

    /* Local-Variable Syntax for Lambda*/
    public List<String> localVariable(List<String> list);

    /* HTTP Client*/
    public HttpResponse getHttpResponse(String url) throws IOException, InterruptedException;

    /* Nest Based Access Control*/
    public Set<String> getNestedClassName();

    /*Running Java Files , we don't need to compile the Java source files with javac explicitly anymore:*/

    /*Performance Enhancements,*/
    /* Dynamic Class-File Constants,  Improved Aarch64 Intrinsics, A No-Op Garbage Collector, Flight Recorder*/


}
