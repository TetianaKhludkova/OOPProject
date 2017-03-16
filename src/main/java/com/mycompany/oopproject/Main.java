package com.mycompany.oopproject;

import com.mycompany.oopproject.human.Crock;
import com.mycompany.oopproject.human.Human;
import com.mycompany.oopproject.human.HumanQueue;

import java.util.*;

public class Main {

    public static LinkedList<Human> listeners = new LinkedList<>();
    private static LinkedHashMap<Ticket, Human> humanWithTicketsMap;
    private static final int INITIAL_COUNT_OF_PEOPLE = 30;

    public static void main(String[] args) {

        HumanQueue humanQueue = new HumanQueue();
        listeners = humanQueue.addHumanToQueue(INITIAL_COUNT_OF_PEOPLE);
        listeners = humanQueue.addHumanToQueue(3);

        MyLinkedList<Human> myLinkedList = new MyLinkedList<>();
        MyLinkedList<? extends Human> humanMyLinkedList = myLinkedList.addListeners();
        myLinkedList.printListeners(humanMyLinkedList);

        humanWithTicketsMap = (new TicketWindow()).sellTicket(listeners);
        System.out.println(humanWithTicketsMap);

        Competition.startCompetitionByTheLeastRespect(humanWithTicketsMap);
        Competition.printCompetitionByTheGreatestNumberOfTickets(humanWithTicketsMap);

        HashSet<Crock> crockHashSet = Competition.startCompetitionByTheGreatestNumberOfTicketsForCrocks(humanWithTicketsMap);
        if (crockHashSet.size()!=0) {
            System.out.println("\nCrocks: \n" + crockHashSet);
        }else {
            System.out.printf("There are no crocks!)");
        }
    }

}