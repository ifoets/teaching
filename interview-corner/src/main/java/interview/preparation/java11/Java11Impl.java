package interview.preparation.java11;

import interview.preparation.java11.model.MainClass;
import lombok.NonNull;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/*New Features in Java 11*/
public class Java11Impl implements IJava11{

    /* new methods to the String class: isBlank, lines, strip, stripLeading, stripTrailing, and repeat.*/
    @Override
    public List<String> strOperation(String multilineStr){
        return multilineStr.lines().filter( e-> !e.isBlank())
                .map(String::strip)
                .map( s-> {
                    if(s.equals("developers"))
                     return s.repeat(2);
                    else return s;
                })
                .collect(Collectors.toList());
    }

    /*new readString and writeString static methods from the Files class*/
    @Override
    public String readFilesStr(String temp, String text) throws IOException {
        Path path = Paths.get(temp);
        Path filePath = Files.writeString(Files.createTempFile(path,"demo",".txt"),text);
        return Files.readString(filePath);
    }
    /*Collection to an Array*/
    public String[] collectionToArray(List<String> list)
    {
        return list.toArray(String[]::new);
    }
    /*The Not Predicate Method*/
    @Override
    public List<String> notPredicate(List<String> list){
        return  list.stream().filter( Predicate.not(String::isBlank))
                .collect(Collectors.toList());
    }
    /* Local-Variable Syntax for Lambda*/
    public List<String> localVariable(List<String> list)
    {
      return list.stream().filter(Predicate.not(String::isBlank))
                .map((@NonNull var x)-> x.toUpperCase(Locale.ROOT))
              .collect(Collectors.toList());
    }
    /* HTTP Client*/
    @Override
    public HttpResponse getHttpResponse(String url) throws IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .connectTimeout(Duration.ofSeconds(20))
                .build();
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(url))
                .build();
        HttpResponse httpResponse = httpClient.send(httpRequest,HttpResponse.BodyHandlers.ofString());
        return  httpResponse;
    }
    /* Nest Based Access Control*/
    @Override
    public Set<String> getNestedClassName()
    {
        return Arrays.stream(MainClass.NestedClass.Address.class.getNestMembers())
                .map(Class::getName)
                .collect(Collectors.toSet());
    }
}
