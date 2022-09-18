package mx.deepdivedylan.aeromexico;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class AnnualSpendingPlan {
    protected Map<CreditCard, AnnualSpending> creditCardUsage;
    protected Double exchangeRate;
    protected List<Integer> pointsPurchases;

    public AnnualSpendingPlan() {
        this.creditCardUsage = new HashMap<CreditCard, AnnualSpending>();
        this.exchangeRate = 20.0;
        this.pointsPurchases = new LinkedList<Integer>();
    }

    public AnnualSpendingPlan(Double exchangeRate) {
        this.creditCardUsage = new HashMap<CreditCard, AnnualSpending>();
        this.exchangeRate = exchangeRate;
        this.pointsPurchases = new LinkedList<Integer>();
    }

    public Map<CreditCard, AnnualSpending> getCreditCardUsage() {
        return creditCardUsage;
    }

    public List<Integer> getPointsPurchases() {
        return pointsPurchases;
    }
}
