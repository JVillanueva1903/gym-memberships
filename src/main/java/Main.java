import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {

        System.out.println("=== Gym Memberships ===");

        Membership henry = new Membership(
                "Henry Clark", 3, new BigDecimal("30.00"));

        Membership alice = new Membership(
                "Alice Johnson", 6, new BigDecimal("35.00"));

        Membership bob = new Membership(
                "Bob Smith", 12, new BigDecimal("25.00"));

        PremiumMembership carol = new PremiumMembership(
                "Carol White", 12, new BigDecimal("50.00"));

        PremiumMembership frank = new PremiumMembership(
                "Frank Miller", 6, new BigDecimal("50.00"));

        FamilyMembership grace = new FamilyMembership(
                "Grace Lee", 12, new BigDecimal("30.00"), 3);

        FamilyMembership emma = new FamilyMembership(
                "Emma Wilson", 6, new BigDecimal("30.00"), 2);

        System.out.printf("%s, %d months, $%.2f per month%n",
                henry.getMemberName(),
                henry.getMonths(),
                henry.getMonthlyPrice());

        System.out.printf("%s, %d months, $%.2f per month%n",
                alice.getMemberName(),
                alice.getMonths(),
                alice.getMonthlyPrice());

        System.out.printf("%s, %d months, $%.2f per month%n",
                bob.getMemberName(),
                bob.getMonths(),
                bob.getMonthlyPrice());

        System.out.printf("%s, %d months, $%.2f per month%n",
                carol.getMemberName(),
                carol.getMonths(),
                carol.getMonthlyPrice());

        System.out.printf("%s, %d months, $%.2f per month%n",
                frank.getMemberName(),
                frank.getMonths(),
                frank.getMonthlyPrice());

        System.out.printf("%s, %d months, $%.2f per month%n",
                grace.getMemberName(),
                grace.getMonths(),
                grace.getMonthlyPrice());

        System.out.printf("%s, %d months, $%.2f per month%n",
                emma.getMemberName(),
                emma.getMonths(),
                emma.getMonthlyPrice());

        // Guest pass usage
        carol.useGuestPass();
        carol.useGuestPass();
        carol.useGuestPass();

        frank.useGuestPass();
    }
}