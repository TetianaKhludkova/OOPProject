package com.mycompany.oopproject.human;

public enum HumanEnum {
    MAN, Lady;

    public static HumanEnum getRandomHuman(){
        int random = (int)Math.round(Math.random());
        switch (random){
            case 0: return MAN;
            case 1: return Lady;
        }
        return null;
    }

}
