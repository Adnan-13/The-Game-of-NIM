package com.srcCode;

public class NimHeaps
{
    private int numOfSticks_heap1;
    private int numOfSticks_heap2;
    private int numOfSticks_heap3;

    //default constructor
    public NimHeaps()
    {
        setNumSticks(0, 0 , 0);
    }

    //constructor that sets the value of sticks in each heap
    public NimHeaps(int n1, int n2, int n3)
    {
        setNumSticks(n1, n2, n3);
    }

    //sets number of sticks for each heaps separately
    public void setNumSticks(int n1, int n2, int n3)
    {
        if(n1 < 0 || n2 < 0 || n3 < 0)
        {
            System.out.println("Number of sticks cannot be less than zero");
            System.exit(0);
        }

        numOfSticks_heap1 = n1;
        numOfSticks_heap2 = n2;
        numOfSticks_heap3 = n3;
    }


    //sets number of sticks for each heaps with the same number
    public void setNumSticks(int n)
    {
        setNumSticks(n, n, n);
    }

    //gets the number of sticks in the given pile
    public int getNumSticks(int pileNum)
    {
        if(pileNum == 1)
        {
            return numOfSticks_heap1;
        }
        else if (pileNum == 2)
        {
            return  numOfSticks_heap2;
        }
        else if (pileNum == 3)
        {
            return numOfSticks_heap3;
        }
        else
        {
            return -1;
        }
    }

    //tries removing the given number of sticks from the given pile number only if both are valid
    public void pickUpSticks(int heapNumber, int sticksToPickup)
    {
        if (heapNumber < 1 || heapNumber > 3)
        {
            System.out.println("Invalid pile number");
            System.exit(0);
        }

        if(sticksToPickup < 1 || sticksToPickup > getNumSticks(heapNumber))
        {
            System.out.println("Invalid number of sticks");
            System.exit(0);
        }

        removeSticks(heapNumber, sticksToPickup);

    }

    //removes given number of sticks from the given heap number
    private void removeSticks(int heapNum, int stickNum)
    {
        if (heapNum == 1)
        {
            numOfSticks_heap1 -= stickNum;
        }
        else if (heapNum == 2)
        {
            numOfSticks_heap2 -= stickNum;
        }
        else if (heapNum == 3)
        {
            numOfSticks_heap3 -= stickNum;
        }
    }

    //checks if the game is over or not
    public boolean gameOver()
    {
        return getNumSticks(1) == 0 && getNumSticks(2) == 0 && getNumSticks(3) == 0;
    }

    //displays the status of the heaps (how many sticks are in each heap)
    public void displayHeaps()
    {
        System.out.println("+----+----+----+");
        System.out.println("|  "+ getNumSticks(1) +" |  "+ getNumSticks(2) + " |  "+ getNumSticks(3) +" |");
        System.out.println("+----+----+----+");

    }

}
