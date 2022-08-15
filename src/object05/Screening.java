package object05;

import object02.Customer;
import object02.Money;
import object03.Reservation;

import java.time.LocalDateTime;

public class Screening {
    private Movie movie;
    private int sequence;
    private LocalDateTime whenScreened;


    public Reservation reserve(Customer customer, int audienceCount) {
        return new Reservation();
    }

    private Money calculateFee(int audienceCount) {
        return movie.calculateFee(this)
                    .times(audienceCount);
    }

    public Movie getMovie() {
        return movie;
    }

    public int getSequence() {
        return sequence;
    }

    public LocalDateTime getWhenScreened() {
        return whenScreened;
    }
}
