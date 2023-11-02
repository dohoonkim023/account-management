package com.example.account.dto;

import com.example.account.domain.Account;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class AccountDto {

    private final Long userId;
    private final String accountNumber;
    private final Long balance;

    private final LocalDateTime registeredAt;
    private final LocalDateTime unRegisteredAt;

    public static AccountDto formEntity(Account account) {
        return AccountDto.builder()
            .userId(account.getAccountUser().getId())
            .accountNumber(account.getAccountNumber())
            .balance(account.getBalance())
            .registeredAt(account.getRegisterAt())
            .unRegisteredAt(account.getUnRegisterAt())
            .build();
    }
}
