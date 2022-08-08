package com.example.account.domain;

import com.example.account.exception.AccountException;
import com.example.account.type.AccountStatus;
import com.example.account.type.ErrorCode;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@EntityListeners(AuditingEntityListener.class) //@CreatedDate과 @LastModifiedDate 가 동장할 수 있도록 해준다.
public class Account  {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private AccountUser accountUser;
    private String accountNumber;

    @Enumerated(EnumType.STRING)
    private AccountStatus accountStatus;
    private Long balance;


    private LocalDateTime registerAt;
    private LocalDateTime unRegisterAt;

    @CreatedDate  //자동으로 날짜를 생성해서 저장해줌.
    private LocalDateTime createAt;
    @LastModifiedDate //자동으로 업데이트 날짜를 생성해서 저장해줌.
    private LocalDateTime updateAt;

    public void useBalance(Long amount) {
        if (amount > balance) {
            throw new AccountException(ErrorCode.ACCOUNT_EXCEED_BALANCE);
        }
        balance -= amount;
    }

    public void cancelBalance(Long amount) {
        if (amount < 0) {
            throw new AccountException(ErrorCode.INVALID_REQUEST);
        }
        balance += amount;
    }

}
