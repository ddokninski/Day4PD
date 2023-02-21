package org.example;

public class Country {

    private String countryName;

    private char countrySign;

    public Country(String countryName, char countrySign) {
        this.countryName = countryName;
        this.countrySign = countrySign;
    }

    public Country() {
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public char getCountrySign() {
        return countrySign;
    }

    public void setCountrySign(char countrySign) {
        this.countrySign = countrySign;
    }

    @Override
    public String toString() {
        return "Country{" +
                "countryName='" + countryName + '\'' +
                ", countrySign=" + countrySign +
                '}';
    }
}
