package com.example.datavid_19.api;
import com.google.gson.annotations.SerializedName;

import java.util.Map;

public class CountryData {
    @SerializedName("updated")
    private String updated;
    private String country;
    private String cases;
    private String deaths;
    private String recovered;
    private String active;
    private String tests;
//    private String casesToday;
//    private String deathsToday;
//    private String recoveredToday;
    private Map<String, String> countryInfo;

//    public CountryData(String updated, String country, String cases, String deaths, String recovered, String active, String tests, String casesToday, String deathsToday, String recoveredToday, Map<String, String> countryInfo) {
//        this.updated = updated;
//        this.country = country;
//        this.cases = cases;
//        this.deaths = deaths;
//        this.recovered = recovered;
//        this.active = active;
//        this.tests = tests;
//        this.casesToday = casesToday;
//        this.deathsToday = deathsToday;
//        this.recoveredToday = recoveredToday;
//        this.countryInfo = countryInfo;
//    }

    public CountryData(String updated, String country, String cases, String deaths, String recovered, String active, String tests, Map<String, String> countryInfo) {
        this.updated = updated;
        this.country = country;
        this.cases = cases;
        this.deaths = deaths;
        this.recovered = recovered;
        this.active = active;
        this.tests = tests;
        this.countryInfo = countryInfo;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCases() {
        return cases;
    }

    public void setCases(String cases) {
        this.cases = cases;
    }

    public String getDeaths() {
        return deaths;
    }

    public void setDeaths(String deaths) {
        this.deaths = deaths;
    }

    public String getRecovered() {
        return recovered;
    }

    public void setRecovered(String recovered) {
        this.recovered = recovered;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getTests() {
        return tests;
    }

    public void setTests(String tests) {
        this.tests = tests;
    }

//    public String getCasesToday() {
//        return casesToday;
//    }
//
//    public void setCasesToday(String casesToday) {
//        this.casesToday = casesToday;
//    }
//
//    public String getDeathsToday() {
//        return deathsToday;
//    }
//
//    public void setDeathsToday(String deathsToday) {
//        this.deathsToday = deathsToday;
//    }
//
//    public String getRecoveredToday() {
//        return recoveredToday;
//    }
//
//    public void setRecoveredToday(String recoveredToday) {
//        this.recoveredToday = recoveredToday;
//    }

    public CountryData(String updated, String country, String cases, String deaths, String recovered, String active, String tests) {
        this.updated = updated;
        this.country = country;
        this.cases = cases;
        this.deaths = deaths;
        this.recovered = recovered;
        this.active = active;
        this.tests = tests;
    }

    public Map<String, String> getCountryInfo() {
        return countryInfo;
    }

    public void setCountryInfo(Map<String, String> countryInfo) {
        this.countryInfo = countryInfo;
    }
}
