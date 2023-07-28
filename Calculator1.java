

public class Calculator1 {
    /**
     *
     * @param a
     * @param b
     * @return
     */
    public int add(Integer a, int b) {
        if (a < 0 || b < 0) {
            throw new IllegalArgumentException("Input parameters must be non-negative.");
        }
        if (a > Integer.MAX_VALUE - b) {
            throw new IllegalArgumentException("Input parameters will cause integer overflow.");
        }
        if (a==null)
            throw new NullPointerException("not null");
        
        return a + b;
    }
    private int value;

    public void setValue(int value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public void increment() {
        value++;
    }

    public boolean isPositive() {
        return value > 0;
    }

    public boolean isZero() {
        return value == 0;
    }
}