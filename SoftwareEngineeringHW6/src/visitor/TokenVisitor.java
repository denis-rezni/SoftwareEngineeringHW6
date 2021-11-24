package visitor;

import token.bracket.Bracket;
import token.NumberToken;
import token.operation.Operation;

public interface TokenVisitor {
    void visit(NumberToken token);

    void visit(Bracket token);

    void visit(Operation token);
}