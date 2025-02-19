import java.util.*;
import java.text.SimpleDateFormat;
import java.text.ParseException;

class Policy implements Comparable<Policy> {
    private String policyNumber;
    private String policyholderName;
    private Date expiryDate;
    private String coverageType;
    private double premiumAmount;

    public Policy(String policyNumber, String policyholderName, Date expiryDate, String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyholderName = policyholderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public String getCoverageType() {
        return coverageType;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Policy policy = (Policy) obj;
        return policyNumber.equals(policy.policyNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(policyNumber);
    }

    @Override
    public int compareTo(Policy other) {
        return this.expiryDate.compareTo(other.expiryDate);
    }

    @Override
    public String toString() {
        return "Policy{" +
                "Number='" + policyNumber + '\'' +
                ", Holder='" + policyholderName + '\'' +
                ", Expiry=" + expiryDate +
                ", Type='" + coverageType + '\'' +
                ", Premium=" + premiumAmount +
                '}';
    }
}

public class InsurancePolicyManagement {
    private Set<Policy> hashSetPolicies = new HashSet<>();
    private Set<Policy> linkedHashSetPolicies = new LinkedHashSet<>();
    private Set<Policy> treeSetPolicies = new TreeSet<>();

    public void addPolicy(Policy policy) {
        hashSetPolicies.add(policy);
        linkedHashSetPolicies.add(policy);
        treeSetPolicies.add(policy);
    }

    public void displayAllPolicies() {
        System.out.println("\nHashSet Policies: " + hashSetPolicies);
        System.out.println("\nLinkedHashSet Policies: " + linkedHashSetPolicies);
        System.out.println("\nTreeSet Policies (Sorted by Expiry Date): " + treeSetPolicies);
    }

    public void displayExpiringSoon() {
        Date today = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(today);
        cal.add(Calendar.DAY_OF_MONTH, 30);
        Date thresholdDate = cal.getTime();

        System.out.println("\nPolicies expiring in next 30 days:");
        for (Policy policy : treeSetPolicies) {
            if (policy.getExpiryDate().before(thresholdDate)) {
                System.out.println(policy);
            }
        }
    }

    public void displayByCoverageType(String type) {
        System.out.println("\nPolicies with coverage type: " + type);
        for (Policy policy : hashSetPolicies) {
            if (policy.getCoverageType().equalsIgnoreCase(type)) {
                System.out.println(policy);
            }
        }
    }

    public void findDuplicatePolicies() {
        Map<String, Integer> policyCount = new HashMap<>();
        for (Policy policy : hashSetPolicies) {
            policyCount.put(policy.getPolicyNumber(), policyCount.getOrDefault(policy.getPolicyNumber(), 0) + 1);
        }

        System.out.println("\nDuplicate Policies:");
        for (Map.Entry<String, Integer> entry : policyCount.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println("Policy Number: " + entry.getKey() + " (Count: " + entry.getValue() + ")");
            }
        }
    }

    public void comparePerformance() {
        List<Policy> policies = new ArrayList<>(hashSetPolicies);
        long start, end;

        Set<Policy> hashSet = new HashSet<>();
        start = System.nanoTime();
        hashSet.addAll(policies);
        end = System.nanoTime();
        System.out.println("\nHashSet Insert Time: " + (end - start) + " ns");

        Set<Policy> linkedHashSet = new LinkedHashSet<>();
        start = System.nanoTime();
        linkedHashSet.addAll(policies);
        end = System.nanoTime();
        System.out.println("LinkedHashSet Insert Time: " + (end - start) + " ns");

        Set<Policy> treeSet = new TreeSet<>();
        start = System.nanoTime();
        treeSet.addAll(policies);
        end = System.nanoTime();
        System.out.println("TreeSet Insert Time: " + (end - start) + " ns");
    }

    public static void main(String[] args) throws ParseException {
        InsurancePolicyManagement system = new InsurancePolicyManagement();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        system.addPolicy(new Policy("P001", "Alice", sdf.parse("2025-06-15"), "Health", 5000.0));
        system.addPolicy(new Policy("P002", "Bob", sdf.parse("2024-12-20"), "Auto", 3000.0));
        system.addPolicy(new Policy("P003", "Charlie", sdf.parse("2026-03-10"), "Home", 7000.0));
        system.addPolicy(new Policy("P004", "David", sdf.parse("2024-03-05"), "Auto", 4500.0));
        system.addPolicy(new Policy("P002", "Bob", sdf.parse("2024-12-20"), "Auto", 3000.0)); // Duplicate

        system.displayAllPolicies();
        system.displayExpiringSoon();
        system.displayByCoverageType("Auto");
        system.findDuplicatePolicies();
        system.comparePerformance();
    }
}
