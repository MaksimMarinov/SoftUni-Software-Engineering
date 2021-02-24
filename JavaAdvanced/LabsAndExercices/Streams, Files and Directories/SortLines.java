import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class SortLines {
    public static void main(String[] args) throws IOException {
       List<String> collection = Files.readAllLines(Path.of("C:\\Users\\Maksim\\Desktop\\input.txt"))
               .stream().sorted(String::compareTo).collect(Collectors.toList());
        Files.write(Path.of("C:\\Users\\Maksim\\Desktop\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams\\output.txt"),collection, Charset.defaultCharset());

    }
}
