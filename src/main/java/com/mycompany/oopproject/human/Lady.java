package com.mycompany.oopproject.human;

public class Lady extends Human {
    private int amountOfBrooch;
    private int id;
    private static int ID = 0;
    private static final int MAX_AMOUNT_OF_BROOCH = 10;


    Lady(){
        this.setAmountOfBrooch((int)(Math.random()* MAX_AMOUNT_OF_BROOCH));
        this.setId(++ID);
        this.setAmountOfTickets((int)(Math.random()* MAX_AMOUNT_OF_Tickets));
    }

    public void setId(int id) {
            this.id = id;
    }
    private void setAmountOfBrooch(int amountOfBrooch) {
        this.amountOfBrooch = amountOfBrooch;
    }

    public int getId() {
        return id;
    }
    public int getRespect() {
        return amountOfBrooch;
    }


    @Override
    public String toString(){
        return this.getClass().getSimpleName()+" "+this.getId()+": amount of brooch: "+this.getRespect()+"  ";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Lady lady = (Lady) o;

        return amountOfBrooch == lady.amountOfBrooch && id == lady.id;

    }

    @Override
    public int hashCode() {
        int result = amountOfBrooch;
        result = 31 * result + id;
        return result;
    }


}
