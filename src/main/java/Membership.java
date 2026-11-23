import java.math.BigDecimal;

public class Membership {

    private String memberName;
    private int months;
    private BigDecimal baseRate;

    // Constructor
    public Membership(String memberName, int months, BigDecimal baseRate) {
        this.memberName = memberName;
        this.months = months;
        this.baseRate = baseRate;
    }

    // Getters
    public String getMemberName() {
        return memberName;
    }

    public int getMonths() {
        return months;
    }

    public BigDecimal getBaseRate() {
        return baseRate;
    }

    // Setters
    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public void setMonths(int months) {
        this.months = months;
    }

    public void setBaseRate(BigDecimal baseRate) {
        this.baseRate = baseRate;
    }

    // Monthly price for a plain membership
    public BigDecimal getMonthlyPrice() {
        return baseRate;
    }
}
public class BasicMembership extends Membership {

    private boolean offPeakOnly;

    // Constructor
    public BasicMembership(String memberName, int months, double baseRate, boolean offPeakOnly) {
        super(memberName, months, BigDecimal.valueOf(baseRate));
        this.offPeakOnly = offPeakOnly;
    }

    // Getter
    public boolean isOffPeakOnly() {
        return offPeakOnly;
    }

    // Setter
    public void setOffPeakOnly(boolean offPeakOnly) {
        this.offPeakOnly = offPeakOnly;
    }

    // Override getMonthlyPrice()
    @Override
    public BigDecimal getMonthlyPrice() {
        if (offPeakOnly) {
            double v = getBaseRate() - 5.00;
            return v;
        }
        return getBaseRate();
    }
}
public class PremiumMembership extends Membership {

    private int guestPasses;

    public PremiumMembership(String memberName, int months, double baseRate, int guestPasses) {
        super(memberName, months, baseRate);
        this.guestPasses = guestPasses;
    }

    public PremiumMembership(String carolWhite, int months, BigDecimal bigDecimal) {
        super(carolWhite, months, bigDecimal);
    }

    public int getGuestPasses() {
        return guestPasses;
    }

    public void setGuestPasses(int guestPasses) {
        this.guestPasses = guestPasses;
    }

    @Override
    public double getMonthlyPrice() {
        return getBaseRate() + 18.50;
    }

    public void useGuestPass() {
        if (guestPasses > 0) {
            guestPasses--;
            System.out.println("Guest pass used. Remaining passes: " + guestPasses);
        } else {
            System.out.println("No guest passes remaining.");
        }
    }
}
public class FamilyMembership extends Membership {
    private int extraMembers;

    public FamilyMembership(String memberName, int months, double baseRate, int extraMembers) {
        super(memberName, months, baseRate);
        this.extraMembers = extraMembers;
    }

    public int getExtraMembers() {
        return extraMembers;
    }

    public void setExtraMembers(int extraMembers) {
        this.extraMembers = extraMembers;
    }

    @Override
    public double getMonthlyPrice() {
        double monthlyPrice = getBaseRate() + (extraMembers * 12.50);

        // Apply 10% discount for 3 or more extra members
        if (extraMembers >= 3) {
            monthlyPrice *= 0.90;
        }

        return monthlyPrice;
    }
}