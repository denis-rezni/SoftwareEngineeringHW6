package token.operation;

import token.Token;
import visitor.TokenVisitor;

public abstract class Operation implements Token {

    public abstract int getPriority();

    public abstract int calculate(int left, int right);

    @Override
    public void accept(TokenVisitor visitor) {
        visitor.visit(this);
    }
}
