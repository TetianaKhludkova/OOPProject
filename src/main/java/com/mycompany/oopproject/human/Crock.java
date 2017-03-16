package com.mycompany.oopproject.human;

import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Crock extends Human{
    @Setter
    private int id;
    private int amountOfTickets;
    private String gender;
    public int respect;
    public static final int MIN_RESPECT = -1;

    @Override
    public boolean equals(Object o) {
        return false;
    }


    @Override
    public String toString() {
        return "{"+ gender +
                " id" + id +
                ": respect=" + respect +
                ": amountOfTickets=" + amountOfTickets +
                "}\n";
    }

    @Override
    public int compareTo(Human o) {
        return 1;
    }
}