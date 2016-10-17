import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class SimpleSparkTests {
    private static final List<String> data = new ArrayList<>();

    @BeforeClass
    public static void ReadDataFromFile() {
        try {
            data.addAll(Files.readAllLines(Paths.get("src/test/resources/Hamlet Entire Play.html")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testReadLinesFromFile() {
        assertTrue(data.size() > 0);
    }


}
