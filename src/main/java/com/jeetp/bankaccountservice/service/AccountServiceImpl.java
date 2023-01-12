package com.jeetp.bankaccountservice.service;

import com.jeetp.bankaccountservice.dto.BankAccountRequestDTO;
import com.jeetp.bankaccountservice.dto.BankAccountResponseDTO;
import com.jeetp.bankaccountservice.entities.BankAccount;
import com.jeetp.bankaccountservice.mappers.AccountMapper;
import com.jeetp.bankaccountservice.repositories.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

@Service @Transactional
public class AccountServiceImpl implements AccountService{
    @Autowired
    private BankAccountRepository bankAccountRepository;
    @Autowired
    private AccountMapper accountMapper;
    @Override
    public BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountRequestDTO) {
        /*BankAccount bankAccount = accountMapper.fromBankAccountRequestDTO(bankAccountRequestDTO);*/
        BankAccount bankAccount = BankAccount.builder()
                .id(UUID.randomUUID().toString())
                .createdAt(new Date())
                .balance(bankAccountRequestDTO.getBalance())
                .type(bankAccountRequestDTO.getType())
                .currency(bankAccountRequestDTO.getCurrency())
                .build();
        BankAccount savedBankAccount = bankAccountRepository.save(bankAccount);
        BankAccountResponseDTO bankAccountResponseDTO = accountMapper.fromBankAccount(savedBankAccount);
        return bankAccountResponseDTO;
    }
}
