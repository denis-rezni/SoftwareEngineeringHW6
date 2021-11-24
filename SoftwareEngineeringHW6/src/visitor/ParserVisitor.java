package visitor;

import token.NumberToken;
import token.Token;
import token.bracket.Bracket;
import token.bracket.LeftBracket;
import token.operation.Operation;

import java.util.*;

public class ParserVisitor implements TokenVisitor {

    private final List<Token> tokens = new ArrayList<>();
    private final Deque<Token> stack = new ArrayDeque<>();

    @Override
    public void visit(NumberToken token) {
        tokens.add(token);
    }

    @Override
    public void visit(Bracket token) {
        if (token instanceof LeftBracket) {
            stack.push(token);
            return;
        }
        //dumping everything until meeting left bracket
        while (!stack.isEmpty() && !(stack.peek() instanceof LeftBracket)) {
            tokens.add(stack.pop());
        }
        if (stack.isEmpty()) throw new RuntimeException("wrong parenthesis");
        stack.pop();
    }

    @Override
    public void visit(Operation token) {
        while (!stack.isEmpty()
                && stack.peek() instanceof Operation
                && ((Operation) stack.peek()).getPriority() >= token.getPriority()) {
            tokens.add(stack.pop());
        }
        stack.push(token);
    }

    public List<Token> getPolishTokens() {
        while (!stack.isEmpty()) {
            Token token = stack.pop();
            if (!(token instanceof Operation)) throw new RuntimeException("wrong parenthesis");
            tokens.add(token);
        }
        return List.copyOf(tokens);
    }
}
