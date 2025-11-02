package com.apihack.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ConsentRequest {
    private String client_id;
    private List<String> permissions = List.of("ReadAccountsDetail", "ReadBalances", "ReadTransactionsDetail");
    private String reason = "Агрегация счетов для HackAPI";
    private String requesting_bank = "team098";
    private String requesting_bank_name = "Team 098 App";
}
