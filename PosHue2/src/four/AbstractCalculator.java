package four;

public abstract class AbstractCalculator {

    protected CalculationOperation add;
    protected CalculationOperation subtract;
    protected CalculationOperation multiply;
    protected CalculationOperation divide;

    public AbstractCalculator(CalculationOperation add,
                              CalculationOperation subtract,
                              CalculationOperation multiply,
                              CalculationOperation divide) {
        this.add = add;
        this.subtract = subtract;
        this.multiply = multiply;
        this.divide = divide;

    }

    public abstract four.Number add(four.Number a, four.Number b);
    public abstract four.Number subtract(four.Number a, four.Number b);
    public abstract four.Number multiply(four.Number a, four.Number b);
    public abstract four.Number divide(four.Number a, Number b);
}
