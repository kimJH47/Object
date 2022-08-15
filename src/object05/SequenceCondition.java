package object05;

public class SequenceCondition {
    private int sequence;

    public SequenceCondition(int sequence) {
        this.sequence = sequence;
    }
    public boolean isSatisfiedBy(Screening screening) {
        return screening.getSequence()==this.sequence;
    }
}
