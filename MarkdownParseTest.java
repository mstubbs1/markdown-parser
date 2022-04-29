
import static org.junit.Assert.*;

import java.beans.Transient;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import org.junit.*;
public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void testGetLinks() throws IOException {
        ArrayList<String>  l1 = new ArrayList<String>();
        l1.add("test.com");
        l1.add("test(help).com");
        l1.add("help.com");
        
        //l2 = new ArrayList<>();
        Path fileName = Path.of("test-file9.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        
        //assertEquals(l1,MarkdownParse.getLinks(Files.readString(Path.of("test-file.md"))));
        assertEquals(l1,links);
        //TEST
    }
}