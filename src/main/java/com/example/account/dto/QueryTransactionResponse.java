package com.example.account.dto;

import com.example.account.type.TransactionResultType;
import com.example.account.type.TransactionType;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class QueryTransactionResponse {

    private final String accountNumber;
    private final TransactionType transactionType;
    private final TransactionResultType transactionResult;
    private final String transactionId;
    private final Long amount;
    private final LocalDateTime transactedAt;

    public static QueryTransactionResponse from(TransactionDto transactionDto) {
        return QueryTransactionResponse.builder()
            .accountNumber(transactionDto.getAccountNumber())
            .transactionType(transactionDto.getTransactionType())
            .transactionResult(transactionDto.getTransactionResultType())
            .transactionId(transactionDto.getTransactionId())
            .amount(transactionDto.getAmount())
            .transactedAt(transactionDto.getTransactedAt())
            .build();
    }
}
