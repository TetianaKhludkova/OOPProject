package com.mycompany.oopproject;

import com.mycompany.oopproject.human.Human;

import java.util.*;

class TicketWindow{
 
    LinkedHashMap<Ticket, Human> sellTicket(LinkedList<Human> listeners){
        LinkedHashMap<Ticket, Human> humanWithTicketsMap = new LinkedHashMap<>();

        for (Human listener: listeners){
            for (int i = 0; i < listener.getAmountOfTickets(); i++) {
                Ticket ticket = new Ticket();
                humanWithTicketsMap.put(ticket, listener);
            }
        }

        System.out.println("\nListeners bought tickets: ");
        return humanWithTicketsMap;
    }
}
