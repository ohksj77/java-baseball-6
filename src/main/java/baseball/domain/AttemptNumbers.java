package baseball.domain;

import baseball.constant.StrikeBall;

import java.util.List;
import java.util.stream.IntStream;

public final class AttemptNumbers {

    private static final int START_INDEX = 0;
    private static final int INTERATION_TIME = 3;
    private final Numbers numbers;

    public AttemptNumbers(final List<Integer> numbers) {
        this.numbers = new Numbers(numbers);
    }

    public BallCount checkAnswer(final AnswerNumbers answerNumbers) {
        final List<StrikeBall> strikeBalls =
                IntStream.range(START_INDEX, INTERATION_TIME)
                        .mapToObj(
                                index ->
                                        answerNumbers.checkStrikeBall(
                                                numbers.getByIndex(index), index))
                        .toList();

        return new BallCount(strikeBalls);
    }
}
