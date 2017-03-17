package com.mycompany.oopproject.human;

import com.mycompany.oopproject.Main;

import java.util.LinkedList;

public class HumanQueue<T extends Human> implements HumanObserver{

    private Observers<HumanQueue> observers = null;

    public static Human getHuman(){
        HumanEnum randomHuman = HumanEnum.getRandomHuman();
        assert randomHuman != null;
        switch (randomHuman) {
            case MAN:
                return new Man();
            case Lady:
                return new Lady();
            default: return null;
        }
    }

    public LinkedList<Human> addHumanToQueue(int countOfPeople) {

        for (int i = 0; i < countOfPeople; i++) {
            Main.listeners.add(getHuman());
            Main.listeners.sort(new Human());
            new Human().sortByRespect();
        }

        if (observers == null) {
            observers = new Observers<>();
            observers.add(new HumanQueue());
            observers.notifyObjectCreated(this);
        }else{
            observers.notifyObjectModified(this);
        }
        return Main.listeners;
    }

    @Override
    public void objectCreated(Object obj) {
        System.out.println("Human queue is created. Size: "+ Main.listeners.size()+". Queue:\n"+ Main.listeners);
    }

    @Override
    public void objectModified(Object obj) {
        System.out.println("Human queue is modified. Size: "+ Main.listeners.size()+". Queue:\n"+ Main.listeners);
    }

}
