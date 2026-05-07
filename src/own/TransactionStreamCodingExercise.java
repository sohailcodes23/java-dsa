package own;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class TransactionStreamCodingExercise {
    //You have a List<Transaction> where Transaction has:
    //- String accountId
    //- String status  ("PENDING", "COMPLETED", "FAILED")
    //- Double amount
    //
    //Write Stream pipelines for:
    //
    //1. Get total amount of all COMPLETED transactions
    //2. Find all PENDING transactions above 1000, sorted by amount descending
    //3. Group transactions by accountId,
    //   get count of transactions per account
    //4. Check if any transaction has amount above 50000

    //1. Get total amount of all COMPLETED transactions
    private Double totalAmoutnPOfCompleted(List<Transaction> transactionList) {

        return transactionList.stream()
                .filter(t -> t.getStatus().equals("COMPLETED"))
                .collect(Collectors.summingDouble(Transaction::getAmount));
    }

    //2. Find all PENDING transactions above 1000, sorted by amount descending
    private List<Transaction> pendingTransaction(List<Transaction> transactionList) {

        return transactionList.stream()
                .filter(t -> t.getStatus().equals("PENDING"))
                .filter(t -> t.getAmount() > 1000)
//                .sorted(Comparator.comparingDouble(Transaction::getAmount))//ASC
                .sorted(Comparator.comparingDouble(Transaction::getAmount).reversed())// DESC
                .collect(Collectors.toList());

        //OLD
        // .collect(Collectors.);// here somethign is added like reverseOrder which will sort it, I know i have to use Comparator, but couldn't remember sysntax
    }


    //3. Group transactions by accountId,
    //   get count of transactions per account

    private Map<String, Long> groupTransaction(List<Transaction> transactionList) {

        //counting() ──► Collectors.counting()  — correct
        //count()    ──► Stream.count()         — terminal operation, different thing

        return transactionList.stream()
                .collect(Collectors.groupingBy(Transaction::getAccountId, Collectors.counting()));
        //OLD
        // don't remeber next things, it was something like groupingBy(Transaction::getAccountId, Collectors.count())
    }

    //4. Check if any transaction has amount above 50000
    private boolean anyTransaction(List<Transaction> transactionList) {

        //OLD
        Optional<Transaction> transaction = transactionList.stream()
                .filter(t -> t.getAmount() > 50000)
                .findFirst();

        //new
        return transactionList.stream()
                .anyMatch(t -> t.getAmount() > 50000);

    }

    //Given List<Transaction>, find the accountId
    //that has the highest TOTAL transaction amount.
    private String findAccount(List<Transaction> transactionList) {

        return transactionList.stream()
                .collect(Collectors.groupingBy(Transaction::getAccountId, Collectors.summingDouble(Transaction::getAmount)))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);

        //Explanations:

//        return transactionList.stream()
//                // Step 1 — group and sum amounts per account
//                .collect(Collectors.groupingBy(
//                        Transaction::getAccountId,
//                        Collectors.summingDouble(Transaction::getAmount)
//                ))
//                // Step 2 — now we have Map<String, Double>
//                // open a new stream on its entries
//                .entrySet().stream()
//                // Step 3 — find entry with maximum value
//                .max(Map.Entry.comparingByValue())
//                // Step 4 — extract just the key (accountId)
//                .map(Map.Entry::getKey)
//                // Step 5 — handle empty list case
//                .orElse(null);


        //Pattern to Remember
        //Whenever you need to find max/min from a grouped Map:
        //javamap.entrySet().stream()
        //   .max(Map.Entry.comparingByValue())  // or minByValue
        //   .map(Map.Entry::getKey)
        //   .orElse(null);
        //This pattern appears constantly in fintech — top spending account, highest revenue category, most frequent transaction type.
    }
}