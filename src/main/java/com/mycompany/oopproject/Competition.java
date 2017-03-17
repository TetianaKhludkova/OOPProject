package com.mycompany.oopproject;

import com.mycompany.oopproject.human.Crock;
import com.mycompany.oopproject.human.Human;
import com.mycompany.oopproject.human.Lady;
import com.mycompany.oopproject.human.Man;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

class Competition {

    //methods for competition by the least respect
    private static int[] getTheSmallestRespect(LinkedHashMap<Ticket, Human> humanWithTicketsMap){
        Human humanWithTheSmallestNumberOfBrooch = getHumanWithTheSmallestRespect(humanWithTicketsMap, Lady.class);
        Human humanWithTheLeastLengthOfMustache = getHumanWithTheSmallestRespect(humanWithTicketsMap, Man.class);
        return new int[]{humanWithTheLeastLengthOfMustache.getRespect(), humanWithTheSmallestNumberOfBrooch.getRespect()};
    }

    private static Human getHumanWithTheSmallestRespect(LinkedHashMap<Ticket, Human> humanWithTicketsMap, Class clazz) {
        return humanWithTicketsMap.values().stream()
                    .filter(human -> human.getClass().equals(clazz))
                    .min(Comparator.comparingInt(Human::getRespect))
                    .get();
    }

    private static void markWinTicketsByRespect(LinkedHashMap<Ticket, Human> humanWithTicketsMap){
        int theLeastLengthOfMustache = getTheSmallestRespect(humanWithTicketsMap)[0];
        int theSmallestNumberOfBrooch = getTheSmallestRespect(humanWithTicketsMap)[1];
        Set<Map.Entry<Ticket, Human>> set = humanWithTicketsMap.entrySet();

        set.stream().filter( human ->
                ((human.getValue().getClass().equals(Man.class))
                        & (human.getValue().getRespect()== theLeastLengthOfMustache)
                 || (human.getValue().getClass().equals(Lady.class))
                        & (human.getValue().getRespect()== theSmallestNumberOfBrooch)))
                .forEach( human -> human.getKey().setWin(true));
    }

    static void startCompetitionByTheLeastRespect(LinkedHashMap<Ticket, Human> humanWithTicketsMap){
        System.out.println("\nCompetition for the least number of respect is started!...\nWinners: ");
        Competition.markWinTicketsByRespect(humanWithTicketsMap);
        Set<Map.Entry<Ticket, Human>> entrySet = humanWithTicketsMap.entrySet();

        entrySet.stream().filter(hum -> hum.getKey().getIsWin())
                .forEach( hum -> System.out.println(
                        hum.getValue()+ ":  "+hum.getKey()));
    }

    //Methods for competition by the greatest number of tickets
    private static int getTheGreatestNumberOfTickets(List<Human> list){
        Human theGreatestNumberOfTickets = list.stream()
                .max(Comparator.comparingInt(Human::getAmountOfTickets))
                .get();
        return theGreatestNumberOfTickets.getAmountOfTickets();
    }

    private static HashSet<Human> findListOfHumanWithTheGreatestNumberOfTickets(List<Human> list){
        int theGreatestNumberOfTickets = getTheGreatestNumberOfTickets(list);
        Set<Human> hashSet = list.stream().filter(human -> human.getAmountOfTickets() == theGreatestNumberOfTickets)
                .collect(Collectors.toSet());
        return (HashSet<Human>) hashSet;
    }

    private static HashSet<Human> startCompetitionByTheGreatestNumberOfTickets(LinkedHashMap<Ticket, Human> humanWithTicketsMap) {
        List<Human> listOfWinnersByNumberOfTickets =
                humanWithTicketsMap.values().stream().distinct().collect(toList());
        return Competition.findListOfHumanWithTheGreatestNumberOfTickets(listOfWinnersByNumberOfTickets);
    }

    static void printCompetitionByTheGreatestNumberOfTickets(LinkedHashMap<Ticket, Human> humanWithTicketsMap) {

        HashSet<Human> hashSetOfWinnersByNumberOfTickets = Competition.startCompetitionByTheGreatestNumberOfTickets(humanWithTicketsMap);
        if (hashSetOfWinnersByNumberOfTickets.size()!=0) {
            System.out.println("\nCompetition for the greatest number of tickets is started!...\nWinners: ");
            for (Human hum : hashSetOfWinnersByNumberOfTickets) {
                System.out.println(hum.getClass().getSimpleName() + hum.getId() +
                        ": amount of tickets: " + hum.getAmountOfTickets());
            }
        }else System.out.printf("Nobody bought more than 1 ticket.");
    }

    static HashSet<Crock> startCompetitionByTheGreatestNumberOfTicketsForCrocks(LinkedHashMap<Ticket, Human> humanWithTicketsMap) {

        HashSet<Crock> hashSet = new HashSet<>();
        HashSet<Human> hashSet1 = Competition.startCompetitionByTheGreatestNumberOfTickets(humanWithTicketsMap);
        for (Human human: humanWithTicketsMap.values()){
            if ((human.getId()%3==0)&& !(hashSet1.contains(human))){
                Crock crock = new Crock(human.getId(), human.getAmountOfTickets(), human.getClass().getSimpleName(), human.getRespect());
                hashSet.add(crock);
            }
        }

        return hashSet;
    }


}
