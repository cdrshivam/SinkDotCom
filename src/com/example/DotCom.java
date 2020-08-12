package com.example;

import java.util.*;

public class DotCom {
    private ArrayList<String> locationCells;
    private String name;

    public void setLocationCells(ArrayList<String> locationCells) {
        this.locationCells = locationCells;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String checkYourself(String userInput){
        String result = "Miss";
        int index = locationCells.indexOf(userInput);

        if(index >= 0){
            locationCells.remove(index);

            if(locationCells.isEmpty()){
                result = "Kill";
                System.out.println("\n\n\t\t\tYeahhh!!");
                System.out.println("You just sunk "+name);
            }
            else{
                result = "Hit";
            }
        }
        return result;
    }
}
