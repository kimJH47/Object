package object01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TicketOffice {
    private Long amount;
    private List<Ticket> tickets = new ArrayList<>();


    public TicketOffice(Long amount, Ticket... tickets) {
        this.amount = amount;
        this.tickets.addAll(Arrays.asList(tickets));

    }

    public Ticket getTicket() {
        return tickets.remove(0);
    }

    private void plusAmount(Long amount) {
        this.amount += amount;
    }

    public void minAmount(Long amount) {
        this.amount -= amount;


    }

    public void sellTicketTo(Audience audience) {
        this.plusAmount(audience.buy(this.getTicket()));

    }
}
