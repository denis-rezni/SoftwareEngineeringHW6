package token.bracket;

import token.Token;
import visitor.TokenVisitor;

public abstract class Bracket implements Token {

    @Override
    public void accept(TokenVisitor visitor) {
        visitor.visit(this);
    }

}
