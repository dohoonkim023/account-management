package com.example.account.dto;

import com.example.account.domain.Transaction;
import com.example.account.type.TransactionResultType;
import com.example.account.type.TransactionType;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@Builder
public class TransactionDto {

    private final String accountNumber;
    private final TransactionType transactionType;
    private final TransactionResultType transactionResultType;
    private final Long amount;
    private final Long balanceSnapshot;
    private final String transactionId;
    private final LocalDateTime transactedAt;

    public static TransactionDto fromEntity(Transaction transaction) {
        return TransactionDto.builder()
            .accountNumber(transaction.getAccount().getAccountNumber())
            .transactionType(transaction.getTransactionType())
            .transactionResultType(transaction.getTransactionResultType())
            .amount(transaction.getAmount())
            .balanceSnapshot(transaction.getBalanceSnapshot())
            .transactionId(transaction.getTransactionId())
            .transactedAt(transaction.getTransactedAt())
            .build();
    }
}
