package com.greenfoxacademy.bankofsymba.controllers;

import com.greenfoxacademy.bankofsymba.models.BankAccount;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
public class BankAccountController {
    private List<BankAccount> bankAccounts = new ArrayList<>() {{
        add(new BankAccount("Simba", 500, "lion", false, true));
        add(new BankAccount("Big Chungus", 50, "rabbit", true, true));
        add(new BankAccount("Winnie the Pooh", 1, "bear", false, true));
        add(new BankAccount("Big boi", 1000, "vizilo", true, false));
        add(new BankAccount("Tyrannasaurus Rekt", 300, "dinosaur", false, false));
    }};

    @RequestMapping("/show")
    public String showBankAccounts(Model model) {
        model.addAttribute("table", "table");
        model.addAttribute("bankAccounts", bankAccounts);
        model.addAttribute("account", new BankAccount());
        return "bank";
    }

    @RequestMapping("/htmltext")
    public String showHtmlText(Model model) {
        model.addAttribute("table", "none");
        model.addAttribute("htmlString", "This is an <em>HTML</em> text. <b>Enjoy yourself!</b>");
        return "bank";
    }

    @RequestMapping("/raise")
    public String raiseBalance(Model model) {
        int randomOwnerIndex = (int)(Math.random() * bankAccounts.size());
        if (bankAccounts.get(randomOwnerIndex).isKing()) {
            bankAccounts.get(randomOwnerIndex).increaseBalanceWith(100);
        }
        else {
            bankAccounts.get(randomOwnerIndex).increaseBalanceWith(10);
        }

        model.addAttribute("table", "table");
        model.addAttribute("bankAccounts", bankAccounts);
        model.addAttribute("account", new BankAccount());
        return "bank";
    }

    @RequestMapping(value = "/addAccount", method=RequestMethod.POST)
    public String processForm(Model model, @ModelAttribute(value="account") BankAccount account) {
        System.out.println(account.getName());
        bankAccounts.add(account);
        model.addAttribute("table", "table");
        model.addAttribute("bankAccounts", bankAccounts);
        model.addAttribute("account", new BankAccount());
        return "bank";
    }
}
