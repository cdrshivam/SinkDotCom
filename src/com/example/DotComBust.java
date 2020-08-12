package com.example;

import java.util.*;

public class DotComBust {
    private final GameHelper helper = new GameHelper();
    private final ArrayList<DotCom> dotComList = new ArrayList<>();
    private int numOfGuesses = 0;

    public void setUpGame(){
        DotCom one = new DotCom();
        one.setName("Pets.com");
        DotCom two = new DotCom();
        two.setName("Earth.com");
        DotCom three = new DotCom();
        three.setName("Classic.com");
        dotComList.add(one);
        dotComList.add(two);
        dotComList.add(three);

        System.out.println("Your goal is to sink all the 3 dot coms in least number of guesses");
        System.out.println("* Pets.com");
        System.out.println("* Earth.com");
        System.out.println("* Classic.com");

        printGrid();

        for(DotCom dotComToSet : dotComList){
            ArrayList<String> newLocation = helper.placeDotCom(3);
            dotComToSet.setLocationCells(newLocation);
        }
    }

    public void startPlaying(){
        while(!dotComList.isEmpty()){
            String userGuess = helper.getUserInput("Enter a guess : ");
            checkUserGuess(userGuess);
        }
        finishGame();
    }

    private void checkUserGuess(String userGuess){
        numOfGuesses++;
        String result = "Miss";

        for(DotCom dotComToTest : dotComList){
            result = dotComToTest.checkYourself(userGuess);

            if(result.equals("Hit")){
                break;
            }
            if(result.equals("Kill")){
                dotComList.remove(dotComToTest);
                break;
            }
        }
        System.out.println(result);
    }

    private void finishGame(){
        System.out.println("\n\n\t\tCongratulations!!!");
        System.out.println("You sink all the dot coms");
        System.out.println("You took "+ numOfGuesses+" hits to sink all dot coms");
    }

    private void printGrid(){
        char[] alphabet={'A','B','C','D','E','F','G'};
        System.out.println("   __ __ __ __ __ __ __ ");
        for(int i=0;i<7;i++){
            System.out.print(alphabet[i] + " ");
            for(int j=0;j<7;j++){
                System.out.print("|__");
            }
            System.out.print("|");
            System.out.println();
        }
        System.out.print(" ");
        for(int i=0;i<7;i++){
            System.out.print("  "+ i + "");
        }
        System.out.println("\n\n");
    }
}
