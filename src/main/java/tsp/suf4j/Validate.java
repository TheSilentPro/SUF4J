package tsp.suf4j;

public final class Validate {

    private Validate() {}

    public static <T> void notNull(T t, String message) {
        if (t == null) {
            throw new NullPointerException(message);
        }
    }

    public static <T> void notNull(T t) {
        notNull(t, "Object can not be null!");
    }

    public static void isTrue(boolean expression, String message) {
        if (!expression) {
            throw new IllegalStateException(message);
        }
    }

    public static void isTrue(boolean expression) {
        isTrue(expression, "Expression can not be false!");
    }

}