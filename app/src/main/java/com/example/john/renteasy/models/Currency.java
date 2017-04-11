package com.example.john.renteasy.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by john on 4/6/17.
 */

public class Currency {

    List<String> quotes = new ArrayList<>();

    public Currency(List<String> quotes) {
        this.quotes = quotes;
    }

    public List<String> getQuotes() {
        return quotes;
    }
}
