package mx.deepdivedylan.aeromexico;

import java.util.Objects;

public class MultiplePlan {
    protected Integer annualPoints;
    protected Double discount;
    protected Integer monthlyPoints;
    protected Integer monthlyRate;

    public MultiplePlan() {
        this.annualPoints = 0;
        this.discount = 0.0;
        this.monthlyPoints = 0;
        this.monthlyRate = 0;
    }

    public MultiplePlan(Integer annualPoints, Double discount, Integer monthlyPoints, Integer monthlyRate) {
        this.annualPoints = annualPoints;
        this.discount = discount;
        this.monthlyPoints = monthlyPoints;
        this.monthlyRate = monthlyRate;
    }

    public Integer getAnnualPoints() {
        return annualPoints;
    }

    public void setAnnualPoints(Integer annualPoints) {
        this.annualPoints = annualPoints;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Integer getMonthlyPoints() {
        return monthlyPoints;
    }

    public void setMonthlyPoints(Integer monthlyPoints) {
        this.monthlyPoints = monthlyPoints;
    }

    public Integer getMonthlyRate() {
        return monthlyRate;
    }

    public void setMonthlyRate(Integer monthlyRate) {
        this.monthlyRate = monthlyRate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MultiplePlan that = (MultiplePlan) o;
        return getAnnualPoints().equals(that.getAnnualPoints()) && getDiscount().equals(that.getDiscount()) && getMonthlyPoints().equals(that.getMonthlyPoints()) && getMonthlyRate().equals(that.getMonthlyRate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAnnualPoints(), getDiscount(), getMonthlyPoints(), getMonthlyRate());
    }

    public static MultiplePlan basico() {
        return new MultiplePlan(4000,0.95, 1000, 245);
    }

    public static MultiplePlan elite() {
        return new MultiplePlan(10000, 0.75, 25000, 5799);
    }

    public static MultiplePlan max() {
        return new MultiplePlan(28000, 0.8, 7000, 1699);
    }

    public static MultiplePlan practico() {
        return new MultiplePlan(8000, 0.9, 2000, 479);
    }

    public static MultiplePlan premium() {
        return new MultiplePlan(40000, 0.75, 10000, 2300);
    }
}
