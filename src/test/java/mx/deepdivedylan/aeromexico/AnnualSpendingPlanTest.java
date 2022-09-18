package mx.deepdivedylan.aeromexico;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnnualSpendingPlanTest {
    @Test
    public void testEmptySpendingPlan() {
        AnnualSpendingPlan annualSpendingPlan = new AnnualSpendingPlan();
        assertEquals(annualSpendingPlan.calculatePoints(), 0);
    }

    @Test
    public void testOneSimpleCard() {
        CreditCard blanca = CreditCard.blanca(false);
        AnnualSpending annualSpending = new AnnualSpending(1000, 1000);
        HashMap<CreditCard, AnnualSpending> creditCardAnnualSpending = new HashMap<CreditCard, AnnualSpending>();
        creditCardAnnualSpending.put(blanca, annualSpending);
        LinkedList<Integer> purchases = new LinkedList<Integer>();
        purchases.add(2000);
        AnnualSpendingPlan annualSpendingPlan = new AnnualSpendingPlan(creditCardAnnualSpending, 20.0, purchases);
        assertEquals(annualSpendingPlan.calculatePoints(), 2125);
    }

    @Test
    public void testOneSimpleCardWithBonuses() {
        CreditCard blanca = CreditCard.blanca(true);
        AnnualSpending annualSpending = new AnnualSpending(100000, 100000);
        HashMap<CreditCard, AnnualSpending> creditCardAnnualSpending = new HashMap<CreditCard, AnnualSpending>();
        creditCardAnnualSpending.put(blanca, annualSpending);
        LinkedList<Integer> purchases = new LinkedList<Integer>();
        purchases.add(2500);
        purchases.add(2500);
        AnnualSpendingPlan annualSpendingPlan = new AnnualSpendingPlan(creditCardAnnualSpending, 20.0, purchases);
        assertEquals(annualSpendingPlan.calculatePoints(), 22500);
    }

    @Test
    public void testOneCardWithBonusesAndMultiplierPlan() {
        CreditCard blanca = CreditCard.blanca(true);
        AnnualSpending annualSpending = new AnnualSpending(100000, 100000);
        HashMap<CreditCard, AnnualSpending> creditCardAnnualSpending = new HashMap<CreditCard, AnnualSpending>();
        creditCardAnnualSpending.put(blanca, annualSpending);
        LinkedList<Integer> purchases = new LinkedList<Integer>();
        purchases.add(2500);
        purchases.add(2500);
        MultiplePlan multiplePlan = MultiplePlan.practico();
        AnnualSpendingPlan annualSpendingPlan = new AnnualSpendingPlan(creditCardAnnualSpending, 20.0, multiplePlan, purchases);
        assertEquals(annualSpendingPlan.calculatePoints(), 54500);
    }

    @Test
    public void testInfiniteCardWithBonusesAndMultiplierPlan() {
        CreditCard infinite = CreditCard.infinite(true);
        AnnualSpending annualSpendingInfinite = new AnnualSpending(1000000, 1000000);
        HashMap<CreditCard, AnnualSpending> creditCardAnnualSpending = new HashMap<CreditCard, AnnualSpending>();
        creditCardAnnualSpending.put(infinite, annualSpendingInfinite);
        LinkedList<Integer> purchases = new LinkedList<Integer>();
        purchases.add(2500);
        purchases.add(2500);
        MultiplePlan multiplePlan = MultiplePlan.premium();
        AnnualSpendingPlan annualSpendingPlan = new AnnualSpendingPlan(creditCardAnnualSpending, 20.0, multiplePlan, purchases);
        assertEquals(annualSpendingPlan.calculatePoints(), 495000);
    }

    @Test
    public void testMultipleCardsWithBonusesAndMultiplierPlan() {
        CreditCard blanca = CreditCard.blanca(true);
        CreditCard infinite = CreditCard.infinite(true);
        AnnualSpending annualSpendingBlanca = new AnnualSpending(100000, 100000);
        AnnualSpending annualSpendingInfinite = new AnnualSpending(1000000, 1000000);
        HashMap<CreditCard, AnnualSpending> creditCardAnnualSpending = new HashMap<CreditCard, AnnualSpending>();
        creditCardAnnualSpending.put(blanca, annualSpendingBlanca);
        creditCardAnnualSpending.put(infinite, annualSpendingInfinite);
        LinkedList<Integer> purchases = new LinkedList<Integer>();
        purchases.add(2500);
        purchases.add(2500);
        MultiplePlan multiplePlan = MultiplePlan.premium();
        AnnualSpendingPlan annualSpendingPlan = new AnnualSpendingPlan(creditCardAnnualSpending, 20.0, multiplePlan, purchases);
        assertEquals(annualSpendingPlan.calculatePoints(), 512500);
    }
}
