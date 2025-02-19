import java.util.*;
import java.time.LocalDate;

class InsurancePolicy {
    private String policyNumber;
    private String policyholderName;
    private LocalDate expiryDate;
    private String coverageType;
    private double premiumAmount;

    public InsurancePolicy(String policyNumber, String policyholderName, LocalDate expiryDate, String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyholderName = policyholderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public String getPolicyholderName() {
        return policyholderName;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    @Override
    public String toString() {
        return "Policy Number: " + policyNumber + ", Holder: " + policyholderName +
               ", Expiry: " + expiryDate + ", Coverage: " + coverageType +
               ", Premium: $" + premiumAmount;
    }
}

class InsurancePolicyManager {
    private Map<String, InsurancePolicy> policyMap = new HashMap<>();
    private Map<String, InsurancePolicy> orderedPolicyMap = new LinkedHashMap<>();
    private TreeMap<LocalDate, InsurancePolicy> sortedPolicyMap = new TreeMap<>();

    public void addPolicy(InsurancePolicy policy) {
        policyMap.put(policy.getPolicyNumber(), policy);
        orderedPolicyMap.put(policy.getPolicyNumber(), policy);
        sortedPolicyMap.put(policy.getExpiryDate(), policy);
    }

    public InsurancePolicy getPolicyByNumber(String policyNumber) {
        return policyMap.get(policyNumber);
    }

    public List<InsurancePolicy> getPoliciesExpiringSoon() {
        List<InsurancePolicy> expiringPolicies = new ArrayList<>();
        LocalDate today = LocalDate.now();
        LocalDate cutoffDate = today.plusDays(30);

        for (Map.Entry<LocalDate, InsurancePolicy> entry : sortedPolicyMap.entrySet()) {
            if (entry.getKey().isAfter(today) && entry.getKey().isBefore(cutoffDate)) {
                expiringPolicies.add(entry.getValue());
            }
        }
        return expiringPolicies;
    }

    public List<InsurancePolicy> getPoliciesByHolder(String holderName) {
        List<InsurancePolicy> policies = new ArrayList<>();
        for (InsurancePolicy policy : policyMap.values()) {
            if (policy.getPolicyholderName().equalsIgnoreCase(holderName)) {
                policies.add(policy);
            }
        }
        return policies;
    }

    public void removeExpiredPolicies() {
        LocalDate today = LocalDate.now();
        Iterator<Map.Entry<LocalDate, InsurancePolicy>> iterator = sortedPolicyMap.entrySet().iterator();
        
        while (iterator.hasNext()) {
            Map.Entry<LocalDate, InsurancePolicy> entry = iterator.next();
            if (entry.getKey().isBefore(today)) {
                policyMap.remove(entry.getValue().getPolicyNumber());
                orderedPolicyMap.remove(entry.getValue().getPolicyNumber());
                iterator.remove();
            }
        }
    }

    public void displayPolicies(Collection<InsurancePolicy> policies) {
        if (policies.isEmpty()) {
            System.out.println("No policies found.");
        } else {
            for (InsurancePolicy policy : policies) {
                System.out.println(policy);
            }
        }
    }
}

public class InsuranceManagementSystem {
    public static void main(String[] args) {
        InsurancePolicyManager manager = new InsurancePolicyManager();
        
        manager.addPolicy(new InsurancePolicy("P101", "Alice", LocalDate.of(2025, 3, 15), "Health", 5000));
        manager.addPolicy(new InsurancePolicy("P102", "Bob", LocalDate.of(2024, 3, 5), "Auto", 3000));
        manager.addPolicy(new InsurancePolicy("P103", "Charlie", LocalDate.of(2024, 2, 25), "Home", 7000));
        manager.addPolicy(new InsurancePolicy("P104", "Alice", LocalDate.of(2024, 3, 10), "Auto", 4000));

        System.out.println("All Policies:");
        manager.displayPolicies(manager.getPoliciesByHolder("Alice"));

        System.out.println("\nPolicies Expiring Soon:");
        manager.displayPolicies(manager.getPoliciesExpiringSoon());

        System.out.println("\nRemoving Expired Policies...");
        manager.removeExpiredPolicies();

        System.out.println("\nPolicies After Cleanup:");
        manager.displayPolicies(manager.getPoliciesByHolder("Alice"));
    }
}
