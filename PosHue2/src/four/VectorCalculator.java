package four;

public class VectorCalculator extends AbstractCalculator {
    public VectorCalculator() {
        super(
                (x, y) -> new Number(x.getA() + y.getA(), x.getB() + y.getB()),
                (x, y) -> new Number(x.getA() - y.getA(), x.getB() - y.getB()),
                (x, y) -> new Number(
                        (x.getA() * y.getB() - x.getB() * y.getA()),
                        (x.getA() * y.getA() + x.getB() * y.getB())
                ),
                (x, y) -> new Number(
                        x.getA() / y.getA(),
                        x.getB() / y.getB()
                )
        );
    }

    @Override
    public Number add(Number a, Number b) {
        return add.calc(a, b);
    }

    @Override
    public Number subtract(Number a, Number b) {
        return subtract.calc(a, b);
    }

    @Override
    public Number multiply(Number a, Number b) {
        return multiply.calc(a, b);
    }

    @Override
    public Number divide(Number a, Number b) {
        return divide.calc(a, b);
    }
}
