package ru.netology;

import java.util.Arrays;

public class Manager {

    private Repository tickets;

    public Manager(Repository tickets) {
        this.tickets = tickets;
    }

    public Ticket[] getTickets(){
        return tickets.getTickets();
    }

    public Ticket[] searchTickets(String departureAir, String arrivalAir){
        Ticket[] result = new Ticket[0];
        for (Ticket ticket : tickets.getTickets()){
            if (matchesDepartureAirport(ticket, departureAir)
                && matchesArrivalAirport(ticket, arrivalAir)
            ){
                Ticket[] copy = new Ticket[result.length + 1];
                System.arraycopy(result, 0, copy, 0, result.length);
                copy[copy.length - 1] = ticket;
                result = copy;
            }
        }
        Arrays.sort(result, Ticket::compareTo);
        return result;
    }

    public boolean matchesDepartureAirport(Ticket ticket, String search) {
        if (ticket.getDepartureAirport().contains(search)) {
            return true;
        }
        return false;
    }

    public boolean matchesArrivalAirport(Ticket ticket, String search) {
        if (ticket.getArrivalAirport().contains(search)) {
            return true;
        }
        return false;
    }

    public void addTicket(Ticket ticket){
        tickets.save(ticket);
    }

    public void deleteTicket(int id){
        tickets.deleteById(id);
    }
}
