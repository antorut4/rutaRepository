package it.unisa.quiz;

public class Quiz implements Measurable {

    private final double score;

    public Quiz(double s){
        this.score=s;
    }

    @Override
    public double getMeasure() {
        return score;
    }
}
