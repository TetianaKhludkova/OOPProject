package com.mycompany.oopproject;

import lombok.Data;

import java.util.Random;

@Data
class Ticket {

    private int numberOfTicket;
    private static int number = 0;
    private int numberOfPlace;
    private int numberOfRow;
    private boolean isWin;
    private static final int COUNT_OF_PLACES = 15;
    private static final int COUNT_OF_ROWS = 20;

    Ticket(){
        Random random = new Random();
        this.setNumberOfTicket(++number);
        this.setNumberOfPlace(random.nextInt(COUNT_OF_PLACES)+1);
        this.setNumberOfRow(random.nextInt(COUNT_OF_ROWS)+1);
        this.setWin(false);
    }

    boolean getIsWin() {
        return isWin;
    }

    @Override
    public String toString() {
        return "Ticket " + numberOfTicket +
                "{ numberOfPlace=" + numberOfPlace +
                ", numberOfRow=" + numberOfRow +
                ", isWin=" + isWin +
                "} ";
    }

}
