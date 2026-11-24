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

    public Membership(String graceLee, int months, BigDecimal bigDecimal, int extraMembers) {

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

    public Object getSignUpFee() {
        return null;
    }

    public BigDecimal getContractTotal() {
        return null;
    }
}
public class BasicMembership extends Membership {

    private boolean offPeakOnly;
    @Override
    public String toString() {
        return "Basic | " + getMemberName() + " | " + getMonths()
                + " months | off-peak only: " + offPeakOnly;
    }
    // Constructor
    public BasicMembership(String memberName, int months, BigDecimal baseRate, boolean offPeakOnly) {
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

    public PremiumMembership(String memberName, int months, BigDecimal baseRate, int guestPasses) {
        super(memberName, months, baseRate);
        this.guestPasses = guestPasses;
    }

    public PremiumMembership(String carolWhite, int months, BigDecimal bigDecimal) {
        super(carolWhite, months, bigDecimal);
    }
    @Override
    public String toString() {
        return "Premium | " + getMemberName() + " | " + getMonths()
                + " months | guest passes: " + guestPasses;
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

    public FamilyMembership(String graceLee, int months, BigDecimal bigDecimal, int extraMembers) {
        super(graceLee, months, bigDecimal, extraMembers);
    }
    @Override
    public String toString() {
        return "Family | " + getMemberName() + " | " + getMonths()
                + " months | extra members: " + extraMembers;
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
public class membership {
    private String memberName;
    private int months;
    private BigDecimal baseRate;

    public Membership(String memberName, int months, BigDecimal baseRate) {
        this.memberName = memberName;
        this.months = months;
        this.baseRate = baseRate;
    }

    public String getMemberName() {
        return memberName;
    }

    public int getMonths() {
        return months;
    }

    public BigDecimal getBaseRate() {
        return baseRate;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public void setMonths(int months) {
        this.months = months;
    }

    public void setBaseRate(BigDecimal baseRate) {
        this.baseRate = baseRate;
    }

    // Sign-up fee for all memberships by default
    public BigDecimal getSignUpFee() {
        return new BigDecimal("49.00");
    }

    // Written once in Membership only
    public BigDecimal getContractTotal() {
        return baseRate
                .multiply(BigDecimal.valueOf(months))
                .add(getSignUpFee());
    }
}