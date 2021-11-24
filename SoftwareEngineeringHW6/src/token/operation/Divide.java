package token.operation;

public class Divide extends Operation {

    @Override
    public String toString() {
        return "/";
    }

    @Override
    public int getPriority() {
        return 1;
    }

    @Override
    public int calculate(int left, int right) {
        if (right == 0) throw new ArithmeticException("division by zero");
        return left / right;
    }
}
