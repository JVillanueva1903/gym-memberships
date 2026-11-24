import java.math.BigDecimal;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        System.out.println("=== Gym Memberships ===");

        ArrayList<Membership> memberships = new ArrayList<>();

        Membership henry = new Membership(
                "Henry Clark",
                3,
                new BigDecimal("30.00"));

        BasicMembership alice = new BasicMembership(
                "Alice Johnson",
                6,
                new BigDecimal("30.00"),
                true);

        BasicMembership bob = new BasicMembership(
                "Bob Smith",
                2,
                new BigDecimal("30.00"),
                false);

        PremiumMembership carol = new PremiumMembership(
                "Carol White",
                12,
                new BigDecimal("45.00"),
                2);

        PremiumMembership frank = new PremiumMembership(
                "Frank Miller",
                3,
                new BigDecimal("48.50"),
                0);

        FamilyMembership grace = new FamilyMembership(
                "Grace Lee",
                12,
                new BigDecimal("30.00"),
                3);

        FamilyMembership emma = new FamilyMembership(
                "Emma Wilson",
                6,
                new BigDecimal("30.00"),
                1);

        memberships.add(henry);
        memberships.add(alice);
        memberships.add(bob);
        memberships.add(carol);
        memberships.add(frank);
        memberships.add(grace);
        memberships.add(emma);

        BigDecimal monthlyIncome = BigDecimal.ZERO;
        BigDecimal allContracts = BigDecimal.ZERO;

        // Loop #1
        for (Membership membership : memberships) {
            System.out.println(membership);

            printCosts(membership);

            monthlyIncome = monthlyIncome.add(
                    membership.getMonthlyPrice());

            allContracts = allContracts.add(
                    membership.getContractTotal());
        }

        System.out.println();
        System.out.println("Number of memberships: "
                + memberships.size());

        System.out.printf("Monthly income: $%.2f%n",
                monthlyIncome);

        System.out.printf("All contracts total: $%.2f%n",
                allContracts);

        // Loop #2
        System.out.println();
        System.out.println("--- Membership Actions ---");

        for (Membership membership : memberships) {

            if (membership instanceof BasicMembership basic) {

                if (basic.isOffPeakOnly()) {
                    System.out.println(
                            basic.getMemberName()
                                    + " may enter between 10:00 and 16:00 only.");
                }

            } else if (membership instanceof PremiumMembership premium) {

                premium.useGuestPass();

            } else if (membership instanceof FamilyMembership family) {

                int keyCards = family.getExtraMembers() + 1;

                System.out.println(
                        family.getMemberName()
                                + ": print "
                                + keyCards
                                + " key cards.");
            }
        }

        // Loop #3
        System.out.println();
        System.out.println("--- Membership Types ---");

        for (Membership membership : memberships) {
            System.out.println(
                    membership.getMemberName()
                            + " -> "
                            + membership.getClass().getSimpleName());
        }
    }

    public static void printCosts(Membership membership) {
        System.out.printf(
                "   Monthly: $%.2f | Sign-up Fee: $%.2f | Contract Total: $%.2f%n",
                membership.getMonthlyPrice(),
                membership.getSignUpFee(),
                membership.getContractTotal());
    }
}