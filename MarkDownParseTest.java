import static org.junit.Assert.*;
import org.junit.*;

import java.io.IOException;
import java.nio.file.*;
import java.util.*;

public class MarkdownParseTest {
    // Set command to 4.12
    @Test
    public void addition(){
        assertEquals(2, 1+1);
    }

    @Test
    public void readFiles() throws IOException{
        Path fileName = Path.of("test-file.md");
        String contents = Files.readString(fileName);
        List links = List.of("https://something.com", "some-page.html");
        assertEquals("Check", links, MarkdownParse.getLinks(contents));

        Path fileName2 = Path.of("test2-file.md");
        String contents2 = Files.readString(fileName2);
        List links2 = List.of();
        assertEquals("Check", links2, MarkdownParse.getLinks(contents2));

        Path fileName3 = Path.of("test3-file.md");
        String contents3 = Files.readString(fileName3);
        List links3 = List.of("www.edwin.com");
        assertEquals("Check", links3, MarkdownParse.getLinks(contents3));

        Path fileName4 = Path.of("test4-file.md");
        String contents4 = Files.readString(fileName4);
        List links4 = List.of("https://CSE15L.com");
        assertEquals("Check", links4, MarkdownParse.getLinks(contents4));
    }

}
