package ru.netology;

public class Ticket implements Comparable<Ticket> {

    int id;
    int ticketPrice;
    String departureAirport;
    String arrivalAirport;
    int timeToFly;

    public Ticket(int id, int ticketPrice, String departureAirport, String arrivalAirport, int timeToFly) {
        this.id = id;
        this.ticketPrice = ticketPrice;
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.timeToFly = timeToFly;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }

    public int getId() {
        return id;
    }


    @Override
    public int compareTo(Ticket o) {
        return this.ticketPrice - o.ticketPrice;
    }

    @Override
    public boolean equals(Object o) {

        Ticket ticket = (Ticket) o;
        return id == ticket.id && ticketPrice == ticket.ticketPrice && timeToFly == ticket.timeToFly && departureAirport.equals(ticket.departureAirport) && arrivalAirport.equals(ticket.arrivalAirport);
    }


}
