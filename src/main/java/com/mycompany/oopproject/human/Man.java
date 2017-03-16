package com.mycompany.oopproject.human;

public class Man extends Human {

    private int lengthOfMustache;
    private int id;
    private static int ID = 0;
    private static final int maxLengthOfMustache = 10;

    Man(){
        this.setId(++ID);
        this.setLengthOfMustache( (int) (Math.random()* maxLengthOfMustache));
        this.setAmountOfTickets((int)(Math.random()* MAX_AMOUNT_OF_Tickets));
    }

    public void setId(int id) {
        this.id = id;
    }
    private void setLengthOfMustache(int lengthOfMustache) {
        this.lengthOfMustache = lengthOfMustache;
    }

    public int getId() {
        return id;
    }
    public int getRespect() {
        return lengthOfMustache;
    }

    @Override
    public String toString(){
//        NumberFormat nf = NumberFormat.getCurrencyInstance();
//        String formattedLengthOfMustache = nf.format(this.getRespect());
        return this.getClass().getSimpleName()+" "+this.getId()+": length of mustache: "+this.getRespect()+" ";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Man man = (Man) o;

        return lengthOfMustache == man.lengthOfMustache && id == man.id;

    }

    @Override
    public int hashCode() {
        int result = lengthOfMustache;
        result = 31 * result + id;
        return result;
    }
}
