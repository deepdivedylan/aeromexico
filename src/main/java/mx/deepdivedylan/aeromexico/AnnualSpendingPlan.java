package mx.deepdivedylan.aeromexico;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

public class AnnualSpendingPlan {
    protected Map<CreditCard, AnnualSpending> creditCardUsage;
    protected Double exchangeRate;
    protected MultiplePlan multiplePlan;
    protected List<Integer> pointsPurchases;

    public AnnualSpendingPlan() {
        this.creditCardUsage = new HashMap<CreditCard, AnnualSpending>();
        this.exchangeRate = 20.0;
        this.multiplePlan = new MultiplePlan();
        this.pointsPurchases = new LinkedList<Integer>();
    }

    public AnnualSpendingPlan(Double exchangeRate, MultiplePlan multiplePlan) {
        this.creditCardUsage = new HashMap<CreditCard, AnnualSpending>();
        this.exchangeRate = exchangeRate;
        this.multiplePlan = multiplePlan;
        this.pointsPurchases = new LinkedList<Integer>();
    }

    public Map<CreditCard, AnnualSpending> getCreditCardUsage() {
        return creditCardUsage;
    }

    public Double getExchangeRate() {
        return exchangeRate;
    }

    public MultiplePlan getMultiplePlan() {
        return multiplePlan;
    }

    public List<Integer> getPointsPurchases() {
        return pointsPurchases;
    }

    public Integer calculatePoints() {
        AtomicReference<Integer> points = new AtomicReference<Integer>(0), spent = new AtomicReference<Integer>(0);
        this.creditCardUsage.forEach((card, spending) -> {
            Integer currPoints = (int)Math.round(card.getMultiplierAeromexico() * spending.getAeromexicoSpending() / exchangeRate + card.getMultiplier() * spending.getNormalSpending() / exchangeRate);
            Integer currSpending = spending.getAeromexicoSpending() + spending.getNormalSpending() + card.getAnnualFee();
            if (card.getNewCard() && currSpending / exchangeRate >= card.getWelcomeThreshold()) {
                currPoints += card.getWelcomeBonus();
            }
            if (currSpending >= card.getAnnualThreshold()) {
                currPoints += card.getAnnualBonus();
            }
            if (currSpending >= card.getSecondThreshold()) {
                currPoints += card.getSecondBonus();
            }
            Integer finalCurrPoints = currPoints;
            points.updateAndGet(v -> v + finalCurrPoints);
            spent.updateAndGet(v -> v + currSpending);
        });
        this.pointsPurchases.forEach(purchase -> {
            Integer price = (int)Math.round((15.0 * multiplePlan.getDiscount()) / exchangeRate * Math.floor((double)(purchase / 1000)));
            points.updateAndGet(v -> v + purchase);
            spent.updateAndGet(v -> v + price);
        });
        Integer multiplierPlanPoints = multiplePlan.getMonthlyPoints() * 12 + multiplePlan.getAnnualPoints();
        points.updateAndGet(v -> v + multiplierPlanPoints);
        return points.get();
    }
}
