package token.operation;

public class Minus extends Operation{

    @Override
    public String toString() {
        return "-";
    }

    @Override
    public int getPriority() {
        return 0;
    }

    @Override
    public int calculate(int left, int right) {
        return left - right;
    }
}
