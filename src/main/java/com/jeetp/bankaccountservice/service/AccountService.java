package com.jeetp.bankaccountservice.service;

import com.jeetp.bankaccountservice.dto.BankAccountRequestDTO;
import com.jeetp.bankaccountservice.dto.BankAccountResponseDTO;

public interface AccountService {
    BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountDTO);
}
