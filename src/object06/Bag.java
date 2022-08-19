package object06;

public class Bag {
    private Invitation invitation;
    private Ticket ticket;
    private Long amount;


    public Bag(Long amount) {
        this(null, amount);
    }

    public Bag(Invitation invitation, Long amount) {
        this.invitation = invitation;
        this.amount = amount;
    }
    private boolean hasInvitation() {
        return invitation!=null;
    }

    private boolean hasTicket() {
        return ticket != null;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    private void plusAmount(Long amount) {
        this.amount += amount;
    }

    public void minAmount(Long amount) {
        this.amount -= amount;

    }


    public Long hold(Ticket ticket) {

        if (hasInvitation()) {
            this.setTicket(ticket);
            return 0L;
        } else {
            this.minAmount(ticket.getFee());
            this.setTicket(ticket);
        }
        return ticket.getFee();
    }
}
