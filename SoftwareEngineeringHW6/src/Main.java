import token.Token;
import token.Tokenizer;
import visitor.CalcVisitor;
import visitor.ParserVisitor;
import visitor.PrintVisitor;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        Tokenizer tokenizer = new Tokenizer(input);
        List<Token> tokens = tokenizer.getTokens();

        ParserVisitor parserVisitor = new ParserVisitor();
        tokens.forEach(token -> token.accept(parserVisitor));

        List<Token> polishTokens = parserVisitor.getPolishTokens();
        PrintVisitor printVisitor = new PrintVisitor(System.out);
        polishTokens.forEach(token -> token.accept(printVisitor));
        System.out.println();

        CalcVisitor calcVisitor = new CalcVisitor();
        polishTokens.forEach(token -> token.accept(calcVisitor));
        System.out.println(calcVisitor.getResult());
    }
}
