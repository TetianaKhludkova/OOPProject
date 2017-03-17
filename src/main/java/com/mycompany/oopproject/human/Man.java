package com.mycompany.oopproject.human;

public class Man extends Human {

    private int respect, id;
    private static int ID = 0;
    private static final int maxLengthOfMustache = 10;

    Man(){
        this.setId(++ID);
        this.setRespect( (int) (Math.random()* maxLengthOfMustache));
        this.setAmountOfTickets((int)(Math.random()* MAX_AMOUNT_OF_Tickets));
    }


    @Override
    public String toString(){
        return this.getClass().getSimpleName()+" "+this.getId()+": length of mustache: "+this.getRespect()+" ";
    }

}
