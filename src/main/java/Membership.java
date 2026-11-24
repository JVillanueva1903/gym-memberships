import java.math.BigDecimal;

public abstract class Membership {

    private String memberName;
    private int months;
    private BigDecimal baseRate;

    public Membership(String memberName, int months, BigDecimal baseRate) {
        this.memberName = memberName;
        this.months = months;
        this.baseRate = baseRate;
    }

    public Membership() {

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

    public abstract BigDecimal getMonthlyPrice();

    public BigDecimal getSignUpFee() {
        return new BigDecimal("49.00");
    }

    public BigDecimal getContractTotal() {
        return getMonthlyPrice()
                .multiply(BigDecimal.valueOf(months))
                .add(getSignUpFee());
    }

    @Override
    public String toString() {
        return memberName + ", Monthly Price: $" + getMonthlyPrice();
    }
}

class BasicMembership extends Membership {

    private boolean offPeakOnly;

    public BasicMembership(String memberName,
                           int months,
                           BigDecimal baseRate,
                           boolean offPeakOnly) {
        super(memberName, months, baseRate);
        this.offPeakOnly = offPeakOnly;
    }

    public boolean isOffPeakOnly() {
        return offPeakOnly;
    }

    public void setOffPeakOnly(boolean offPeakOnly) {
        this.offPeakOnly = offPeakOnly;
    }

    // Class 'BasicMembership' must either be declared abstract
    // or implement abstract method 'getMonthlyPrice()' in 'Membership'
    @Override
    public BigDecimal getMonthlyPrice() {

        if (offPeakOnly) {
            return getBaseRate().subtract(new BigDecimal("5.00"));
        }

        return getBaseRate();
    }

    @Override
    public String toString() {
        return "Basic | "
                + getMemberName()
                + " | "
                + getMonths()
                + " months | off-peak only: "
                + offPeakOnly;
    }
}


class PremiumMembership extends Membership {

    private int guestPasses;

    public PremiumMembership(String memberName,
                             int months,
                             BigDecimal baseRate,
                             int guestPasses) {
        super(memberName, months, baseRate);
        this.guestPasses = guestPasses;
    }

    public int getGuestPasses() {
        return guestPasses;
    }

    public void setGuestPasses(int guestPasses) {
        this.guestPasses = guestPasses;
    }

    @Override
    public BigDecimal getMonthlyPrice() {
        return getBaseRate().add(new BigDecimal("18.50"));
    }

    public void useGuestPass() {

        if (guestPasses > 0) {
            guestPasses--;
            System.out.println(
                    "Guest pass used. Remaining passes: "
                            + guestPasses);
        } else {
            System.out.println(
                    "No guest passes remaining.");
        }
    }

    @Override
    public String toString() {
        return "Premium | "
                + getMemberName()
                + " | "
                + getMonths()
                + " months | guest passes: "
                + guestPasses;
    }
}

class FamilyMembership extends Membership {

    private int extraMembers;

    public FamilyMembership(String memberName,
                            int months,
                            BigDecimal baseRate,
                            int extraMembers) {
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
    public BigDecimal getMonthlyPrice() {

        BigDecimal monthlyPrice =
                getBaseRate().add(
                        BigDecimal.valueOf(extraMembers)
                                .multiply(new BigDecimal("12.50"))
                );

        if (extraMembers >= 3) {
            monthlyPrice =
                    monthlyPrice.multiply(new BigDecimal("0.90"));
        }

        return monthlyPrice;
    }

    @Override
    public String toString() {
        return "Family | "
                + getMemberName()
                + " | "
                + getMonths()
                + " months | extra members: "
                + extraMembers;
    }
}