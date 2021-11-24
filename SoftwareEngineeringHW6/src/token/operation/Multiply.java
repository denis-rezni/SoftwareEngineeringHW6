package token.operation;

public class Multiply extends Operation{

    @Override
    public String toString() {
        return "*";
    }

    @Override
    public int getPriority() {
        return 1;
    }

    @Override
    public int calculate(int left, int right) {
        return left * right;
    }
}
