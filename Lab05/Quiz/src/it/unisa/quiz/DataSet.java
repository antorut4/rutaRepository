package it.unisa.quiz;

public class DataSet {

    private double sum;
    private Measurable minimum;
    private Measurable maximum;
    private int count;

    public DataSet() {
        minimum=null;
        maximum=null;
        count=0;
    }

    public double getAverage() {
        if(count==0)
            return 0;
        else
            return sum/count;
    }

    public Measurable getMaximum() {
        return maximum;
    }

    public Measurable getMinimum() {
        return minimum;
    }

    public void add(Measurable x) {
        sum = sum + x.getMeasure();
        if (count == 0 || minimum.getMeasure() > x.getMeasure())
            minimum = x;
        if (count == 0 || maximum.getMeasure() < x.getMeasure())
            maximum = x;
        count++;
    }
}