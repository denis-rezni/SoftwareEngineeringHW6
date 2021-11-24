package token.state;

import token.Token;
import token.Tokenizer;
import token.bracket.LeftBracket;
import token.bracket.RightBracket;
import token.operation.Divide;
import token.operation.Minus;
import token.operation.Multiply;
import token.operation.Plus;

import java.util.Map;
import java.util.function.Supplier;

public class Start extends State {

    public Start(Tokenizer tokenizer) {
        super(tokenizer);
    }

    @Override
    public Token getToken() {
        char c = tokenizer.getCurChar();
        tokenizer.nextChar();
        return switch (c) {
            case '*' -> new Multiply();
            case '/' -> new Divide();
            case '-' -> new Minus();
            case '+' -> new Plus();
            case '(' -> new LeftBracket();
            case ')' -> new RightBracket();
            default -> throw new RuntimeException("Unexpected token: " + c);
        };
    }

    @Override
    public State getNextState() {
        if (tokenizer.isEnd()) return new End(tokenizer);
        if (tokenizer.isBracket() || tokenizer.isOperation()) return this;
        if (tokenizer.isDigit()) return new Number(tokenizer);
        return new Error(tokenizer);
    }
}
