package com.mycompany.oopproject.human;

public class Lady extends Human {
    private int respect, id;
    private static int ID = 0;
    private static final int MAX_AMOUNT_OF_BROOCH = 8;


    Lady(){
        this.setRespect((int)(Math.random()* MAX_AMOUNT_OF_BROOCH));
        this.setId(++ID);
        this.setAmountOfTickets((int)(Math.random()* MAX_AMOUNT_OF_Tickets));
    }

    @Override
    public String toString(){
        return this.getClass().getSimpleName()+" "+this.getId()+": amount of brooch: "+this.getRespect()+"  ";
    }

}
