package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController(value = "my-super-controller")
public class AccountController {

    private List<Account> accounts = Arrays.asList(
            new Account(1L, "Bob", "Smith", 45),
            new Account(2L, "John", "Douugh", 23),
            new Account(3L, "Sara", "Potter", 99)
    );


    @GetMapping(path = "accounts")
    public List<Account> getAllAccounts() {

        System.out.println("Called get all accounts");

        return accounts;
    }

    @GetMapping(path = "accounts/{id}")
    public Account getAccountById(@PathVariable Long id) {
        System.out.println("Called get account nr " + id);

        return accounts.stream()
                .filter(a -> a.getId().equals(id))
                .findAny()
                .orElseThrow(() -> new AccountNotFoundException(id));
    }

    @GetMapping(path = "deleteById/{id}")
    public void deleteById(@PathVariable Long id) {
        System.out.println("Delete account nr " + id);

        this.accounts = this.accounts.stream()
                .filter(a -> !a.getId().equals(id))
                .collect(Collectors.toList());

    }

}
