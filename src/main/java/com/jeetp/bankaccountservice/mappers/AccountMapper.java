package com.jeetp.bankaccountservice.mappers;

import com.jeetp.bankaccountservice.dto.BankAccountRequestDTO;
import com.jeetp.bankaccountservice.dto.BankAccountResponseDTO;
import com.jeetp.bankaccountservice.entities.BankAccount;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {
    public BankAccountResponseDTO fromBankAccount(BankAccount bankAccount) {
        BankAccountResponseDTO bankAccountResponseDTO = new BankAccountResponseDTO();
        BeanUtils.copyProperties(bankAccount , bankAccountResponseDTO);
        return bankAccountResponseDTO;
    }

    public BankAccount fromBankAccountRequestDTO(BankAccountRequestDTO bankAccountRequestDTO) {
        BankAccount bankAccount = new BankAccount();
        BeanUtils.copyProperties(bankAccountRequestDTO , bankAccount);
        return bankAccount;
    }
}
