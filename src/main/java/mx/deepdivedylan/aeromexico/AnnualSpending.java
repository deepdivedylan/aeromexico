package mx.deepdivedylan.aeromexico;

import java.util.Objects;

public class AnnualSpending {
    Integer aeromexicoSpending;
    Integer normalSpending;

    public AnnualSpending() {
        this.aeromexicoSpending = 0;
        this.normalSpending = 0;
    }

    public AnnualSpending(Integer aeromexicoSpending, Integer normalSpending) {
        this.aeromexicoSpending = aeromexicoSpending;
        this.normalSpending = normalSpending;
    }

    public Integer getAeromexicoSpending() {
        return aeromexicoSpending;
    }

    public void setAeromexicoSpending(Integer aeromexicoSpending) {
        this.aeromexicoSpending = aeromexicoSpending;
    }

    public Integer getNormalSpending() {
        return normalSpending;
    }

    public void setNormalSpending(Integer normalSpending) {
        this.normalSpending = normalSpending;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AnnualSpending that = (AnnualSpending) o;
        return getAeromexicoSpending().equals(that.getAeromexicoSpending()) && getNormalSpending().equals(that.getNormalSpending());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAeromexicoSpending(), getNormalSpending());
    }
}
