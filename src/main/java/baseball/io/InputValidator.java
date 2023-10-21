package baseball.io;

public class InputValidator {

    private static final char MIN_NUMBER = '0';
    private static final char MAX_NUMBER = '9';
    private static final int COMMAND_LENGTH = 1;

    public void validateNumber(final String input) {
        if (hasNonNumeric(input)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean hasNonNumeric(final String input) {
        return input.chars().allMatch(this::isNotNumeric);
    }

    private boolean isNotNumeric(final int c) {
        return MIN_NUMBER > c || c > MAX_NUMBER;
    }

    public void validateRetryCommand(final String input) {
        if (isProperCommand(input)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isProperCommand(final String input) {
        return input.length() != COMMAND_LENGTH || hasNonNumeric(input);
    }
}
