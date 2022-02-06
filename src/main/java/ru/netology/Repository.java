package ru.netology;

public class Repository {

    private Ticket[] tickets;

    public Repository(Ticket[] tickets) {
        this.tickets = tickets;
    }

    public Ticket[] getTickets() {
        return tickets;
    }

    public void save(Ticket ticket){
        int length = this.tickets.length + 1;
        Ticket[] copy = new Ticket[length];
        System.arraycopy(tickets, 0, copy, 0, tickets.length);
        int lastIndex = copy.length - 1;
        copy[lastIndex] = ticket;
        tickets = copy;
    }


    public void deleteById(int findedId){
        for (Ticket ticket : tickets){
            if (findedId == ticket.getId()){
                findedId = ticket.getId();
            }
        }
        Ticket[] copy = new Ticket[tickets.length - 1];
        int index = 0;
        for (int i = 0; i < tickets.length; i++){
            if (tickets[i].getId() != findedId){
                copy[index] = tickets[i];
                index++;
            }
        }
        tickets = copy;
    }


}

