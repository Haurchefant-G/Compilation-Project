import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import parser.CPPLexer;
import parser.CParser;
import util.Parser;

import java.io.IOException;

public class compiler {

    public static void main(String[] args) {
//        args[0] = "src/main/resources/CFiles/testPalindromic.c";
        Parser parser = new Parser();
        CharStream input = null;
        try {
            input = CharStreams.fromFileName(args[0]);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (input != null)
        {
            CPPLexer cpplexer = new CPPLexer(input);
            CommonTokenStream token = new CommonTokenStream(cpplexer);
            CParser cparser = new CParser(token);
            parser.visit(cparser.translationUnit());
        }
    }
}
