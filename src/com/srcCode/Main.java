package com.srcCode;

import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    //initiates the game
    static void initGame(NimHeaps nimHeapsObj)
    {
        nimHeapsObj.setNumSticks(7);
        nimHeapsObj.displayHeaps();

    }

    //gets the number of heap from the user
    static int getHeapNum(NimHeaps nimHeapsObj, int playerNum)
    {
        while (true)
        {
            System.out.println("Player "+ playerNum +" please choose a heap: (1-3)");

            int chosenHeap = sc.nextInt();

            int numOfSticksInTheChosenHeap = nimHeapsObj.getNumSticks(chosenHeap);

            if(numOfSticksInTheChosenHeap == -1)
            {
                System.out.println("Invalid heap");
            }
            else if (numOfSticksInTheChosenHeap == 0)
            {
                System.out.println("No sticks in the chosen heap");
            }

            else return chosenHeap;

        }
    }

    //gets the number of sticks to pick up from user
    static int getSticksToPickUp(NimHeaps nimHeapsObj, int heapNum)
    {
        int sticksInHeap = nimHeapsObj.getNumSticks(heapNum);

        while (true)
        {
            System.out.println("Choose the number of sticks to pick up: (1-"+ sticksInHeap +")");

            int numOfStick = sc.nextInt();

            if(numOfStick < 1 || numOfStick > sticksInHeap)
            {
                System.out.println("Invalid number of sticks");
            }
            else return numOfStick;

        }


    }

    //switch player
    static int otherPlayer(int player)
    {
        if(player == 1) return 2;
        else return 1;
    }

    //controls the game
    static void playGame(NimHeaps nimHeapsObj)
    {
        int player = 1;

        while (true)
        {
            int heapNum = getHeapNum(nimHeapsObj, player);
            int numOfSticks = nimHeapsObj.getNumSticks(heapNum);

            int sticksToPickUp;

            if(numOfSticks > 1)
            {
                sticksToPickUp = getSticksToPickUp(nimHeapsObj, heapNum);
            }
            else sticksToPickUp = 1;

            nimHeapsObj.pickUpSticks(heapNum, sticksToPickUp);

            nimHeapsObj.displayHeaps();

            player = otherPlayer(player);

            if(nimHeapsObj.gameOver())
            {
                System.out.println("Player "+ player +" wins!");
                break;
            }
        }
    }


    //main method
    public static void main(String[] args) {

        System.out.println("Welcome to Adnan's game of Nim!");


        boolean shouldWePlay = true;

        while (shouldWePlay)
        {
            NimHeaps nimHeapsObj = new NimHeaps();
            initGame(nimHeapsObj);

            playGame(nimHeapsObj);

            System.out.println("Would you like to play another game? (yes/no)");

            boolean ansNotValid = true;

            while (ansNotValid)
            {
                String ans = sc.next();

                if(ans.equals("yes"))
                {
                    ansNotValid = false;
                    shouldWePlay = true;
                }
                else if(ans.equals("no"))
                {
                    ansNotValid = false;
                    shouldWePlay = false;

                    System.out.println("Thank you for playing Adnan's Game of Nim");
                }
                else
                {
                    System.out.println("Invalid answer. Ony yes/no is valid.\nPlease try again:");
                    ansNotValid = true;
                }
            }
        }
    }
}
