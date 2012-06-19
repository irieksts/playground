package me.irieksts.playground.jruby.permgen;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.jruby.embed.EmbedEvalUnit;
import org.jruby.embed.LocalContextScope;
import org.jruby.embed.ScriptingContainer;
import org.junit.Test;

public class MyTest {

    @Test
    public void test() throws IOException {
        String script = readFileAsString("src/test/resources/good.rb");
        for (int i = 0; i < 1000 * 100; i++) {
            runScript(script);
        }
    }

    public Object runScript(String script) throws IOException {
        ScriptingContainer rubyContainer = new ScriptingContainer(LocalContextScope.CONCURRENT);
        EmbedEvalUnit embedEvalUnit = rubyContainer.parse(script);
        return rubyContainer.callMethod(embedEvalUnit.run(), "test");
    }

    private static String readFileAsString(String filePath) throws java.io.IOException {
        StringBuffer fileData = new StringBuffer(1000);
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        char[] buf = new char[1024];
        int numRead = 0;
        while ((numRead = reader.read(buf)) != -1) {
            String readData = String.valueOf(buf, 0, numRead);
            fileData.append(readData);
            buf = new char[1024];
        }
        reader.close();
        return fileData.toString();
    }
}
