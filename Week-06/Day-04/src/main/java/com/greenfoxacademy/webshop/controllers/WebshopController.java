package com.greenfoxacademy.webshop.controllers;

import com.greenfoxacademy.webshop.models.ShopItem;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@Controller
public class WebshopController {
    private List<ShopItem> shopItemList = new ArrayList<>() {{
        add(new ShopItem("Amazing iCloud Driver", "Destroys your local documents", 20000000, 1));
        add(new ShopItem("Bird-a-Poo iphone game", "The game of every edgy kids", 270, 1000));
        add(new ShopItem("Black hole", "It might not be real", 300000, 124424));
        add(new ShopItem("Combat knife", "Might come handy in Kertész utca", 77000, 0));
        add(new ShopItem("Vanilla Coke", "Greenfoxers favourite", 380, 50000));
        add(new ShopItem("Generic stuff", "For statistics", 243298, 345434));
        add(new ShopItem("Nike", "Cool shoe", 19000, 44));
        add(new ShopItem("Shoe", "Cool Nike", 19000, 44));
    }};

    @RequestMapping("/webshop")
    public String makeWebshop(Model model) {
        model.addAttribute("table", "table");
        model.addAttribute("shoppingList", shopItemList);
        model.addAttribute("result", "none");
        return "webshop";
    }

    @RequestMapping("/only-available")
    public String makeWebshopWithOnlyAvailable(Model model) {
        model.addAttribute("table", "table");
        model.addAttribute("shoppingList", shopItemList.stream()
                .filter(shopItem -> shopItem.getQuantity() != 0)
                .collect(Collectors.toList()));
        model.addAttribute("result", "none");
        return "webshop";
    }

    @RequestMapping("/cheapest-first")
    public String makeWebshopWithCheapestFirst(Model model) {
        model.addAttribute("table", "table");
        model.addAttribute("shoppingList", new ArrayList<>(shopItemList) {{
            this.sort(Comparator.comparing(ShopItem::getPrice));}});
        model.addAttribute("result", "none");
        return "webshop";
    }

    @RequestMapping("/contains-nike")
    public String makeWebshopWithNike(Model model) {
        model.addAttribute("table", "table");
        model.addAttribute("shoppingList", shopItemList.stream()
                .filter(shopItem -> shopItem.getName().contains("Nike") || shopItem.getDescription().contains("Nike"))
                .collect(Collectors.toList()));
        model.addAttribute("result", "none");
        return "webshop";
    }

    @RequestMapping("contains-item")
    public String makeWebshopWithItem(Model model, @RequestParam(name = "itemName") String itemName) {
        model.addAttribute("table", "table");
        model.addAttribute("shoppingList", shopItemList.stream()
                .filter(shopItem -> shopItem.getName().contains(itemName) || shopItem.getDescription().contains(itemName))
                .collect(Collectors.toList()));
        model.addAttribute("result", "none");
        return "webshop";
    }

    @RequestMapping("/average-stock")
    public String makeWebshopWithAverageStock(Model model) {
        model.addAttribute("table", "none");
        model.addAttribute("result", "result");
        model.addAttribute("value", shopItemList.stream()
                .map(shopItem -> shopItem.getQuantity())
                .mapToDouble(n -> n)
                .average()
                .orElse(0));
        model.addAttribute("name", "Average stock: ");
        return "webshop";
    }

    @RequestMapping("/most-expensive")
    public String makeWebshopWithMostExpensive(Model model) {
        model.addAttribute("table", "none");
        model.addAttribute("result", "result");
        model.addAttribute("value", shopItemList.stream()
                .max(Comparator.comparing(ShopItem::getPrice))
                .get()
                .getName());
        model.addAttribute("name", "Most expensive item: ");
        return "webshop";
    }
}
