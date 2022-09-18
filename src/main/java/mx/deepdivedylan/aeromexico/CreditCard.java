package mx.deepdivedylan.aeromexico;

import java.util.Objects;

public class CreditCard {
    protected Integer annualBonus;
    protected Integer annualFee;
    protected Integer annualThreshold;
    protected Double multiplier;
    protected Double multiplierAeromexico;
    protected Boolean newCard;
    protected Integer secondBonus;
    protected Integer secondThreshold;
    protected Integer welcomeBonus;
    protected Integer welcomeThreshold;

    public CreditCard() {
        this.annualBonus = 0;
        this.annualFee = 0;
        this.annualThreshold = 0;
        this.multiplier = 0.0;
        this.multiplierAeromexico = 0.0;
        this.newCard = false;
        this.secondBonus = 0;
        this.secondThreshold = 0;
        this.welcomeBonus = 0;
        this.welcomeThreshold = 0;
    }

    public CreditCard(Integer annualBonus, Integer annualFee, Integer annualThreshold, Double multiplier, Double multiplierAeromexico, Boolean newCard, Integer secondBonus, Integer secondThreshold, Integer welcomeBonus, Integer welcomeThreshold) {
        this.annualBonus = annualBonus;
        this.annualFee = annualFee;
        this.annualThreshold = annualThreshold;
        this.multiplier = multiplier;
        this.multiplierAeromexico = multiplierAeromexico;
        this.newCard = newCard;
        this.secondBonus = secondBonus;
        this.secondThreshold = secondThreshold;
        this.welcomeBonus = welcomeBonus;
        this.welcomeThreshold = welcomeThreshold;
    }

    public Integer getAnnualBonus() {
        return annualBonus;
    }

    public void setAnnualBonus(Integer annualBonus) {
        this.annualBonus = annualBonus;
    }

    public Integer getAnnualFee() {
        return annualFee;
    }

    public void setAnnualFee(Integer annualFee) {
        this.annualFee = annualFee;
    }

    public Integer getAnnualThreshold() {
        return annualThreshold;
    }

    public void setAnnualThreshold(Integer annualThreshold) {
        this.annualThreshold = annualThreshold;
    }

    public Double getMultiplier() {
        return multiplier;
    }

    public void setMultiplier(Double multiplier) {
        this.multiplier = multiplier;
    }

    public Boolean getNewCard() {
        return newCard;
    }

    public void setNewCard(Boolean newCard) {
        this.newCard = newCard;
    }

    public Double getMultiplierAeromexico() {
        return multiplierAeromexico;
    }

    public void setMultiplierAeromexico(Double multiplierAeromexico) {
        this.multiplierAeromexico = multiplierAeromexico;
    }

    public Integer getSecondBonus() {
        return secondBonus;
    }

    public void setSecondBonus(Integer secondBonus) {
        this.secondBonus = secondBonus;
    }

    public Integer getSecondThreshold() {
        return secondThreshold;
    }

    public void setSecondThreshold(Integer secondThreshold) {
        this.secondThreshold = secondThreshold;
    }

    public Integer getWelcomeBonus() {
        return welcomeBonus;
    }

    public void setWelcomeBonus(Integer welcomeBonus) {
        this.welcomeBonus = welcomeBonus;
    }

    public Integer getWelcomeThreshold() {
        return welcomeThreshold;
    }

    public void setWelcomeThreshold(Integer welcomeThreshold) {
        this.welcomeThreshold = welcomeThreshold;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreditCard that = (CreditCard) o;
        return getAnnualBonus().equals(that.getAnnualBonus()) && getAnnualFee().equals(that.getAnnualFee()) && getAnnualThreshold().equals(that.getAnnualThreshold()) && getMultiplier().equals(that.getMultiplier()) && getMultiplierAeromexico().equals(that.getMultiplierAeromexico()) && getNewCard().equals(that.getNewCard()) && getSecondBonus().equals(that.getSecondBonus()) && getSecondThreshold().equals(that.getSecondThreshold()) && getWelcomeBonus().equals(that.getWelcomeBonus()) && getWelcomeThreshold().equals(that.getWelcomeThreshold());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAnnualBonus(), getAnnualFee(), getAnnualThreshold(), getMultiplier(), getMultiplierAeromexico(), getNewCard(), getSecondBonus(), getSecondThreshold(), getWelcomeBonus(), getWelcomeThreshold());
    }

    public static CreditCard blanca(Boolean newCard) {
        return new CreditCard(0, 0, 0, 1.0, 1.5, newCard, 0, 0, 5000, 250);
    }

    public static CreditCard infinite(Boolean newCard) {
        return new CreditCard(24000, 5000, 300000, 2.0, 3.0, newCard, 24000, 700000, 32000, 1000);
    }

    public static CreditCard platino(Boolean newCard) {
        return new CreditCard(16000,3000, 150000, 1.6, 2.0, newCard, 0, 0, 16000, 500);
    }
}
