/*
#       Written by : Rose (Pratama Azmi A)
#       Date : Unknown 
#       Text editor : AndroidStudio + VIM
*/
package com.example.worldcupapp;

public class CountryModel {

    private String countryName;
    private int countryWins;
    private int countryImage;

    public CountryModel(String countryName, int countryWins, int countryImage)
    {
        this.countryImage = countryImage;
        this.countryName = countryName;
        this.countryWins = countryWins;
    }


    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public int getCountryWins() {
        return countryWins;
    }

    public void setCountryWins(int countryWins) {
        this.countryWins = countryWins;
    }

    public int getCountryImage() {
        return countryImage;
    }

    public void setCountryImage(int countryImage) {
        this.countryImage = countryImage;
    }
    @Override
    public String toString()
    {
        return getCountryName() + " " + getCountryWins() ;
    }
}



