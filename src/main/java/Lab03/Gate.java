package Lab03;


import java.sql.Time;
import java.text.spi.DateFormatProvider;
import java.util.Date;

public class Gate {
    public Gate() {
    }

    public boolean CheckCard(Card card) {
        boolean result = false;
        if(IsActiveCard(card, new Date())){
            if(card.getCardType().equals(CardType.QuantityCard)){
                if(DecrementRide(card)){
                    result = true;
                }
            }
            else {
                if(CheckTime(card.getTimeCardType(), new Date())){
                    result = true;
                }
            }
        }
        return result;
    }

    public boolean CheckTime(TimeCardType t, Date d) {
        boolean result = false;
        switch (t.ordinal()) {
            case 0:
                if(d.getHours() < 14 && d.getHours() >= 9)
                    result = true;
                break;
            case 1:
                if(d.getHours() < 19 && d.getHours() >= 14)
                    result = true;
                break;
            case 2:
                if(d.getHours() < 24 && d.getHours() >= 19)
                    result = true;
                break;
            default:
                result = false;
                break;
        }
        return result;
    }

    public boolean IsActiveCard(Card card, Date date) {
        boolean result = false;
        if(card.isActive() ) {
            String currentSeason = "Summer";
            if( card.getTimeLimit() == TimeLimit.Season && card.getSeason() == currentSeason){
                result = true;
            }
            else if (card.getTimeLimit() == TimeLimit.Days && card.getDateEnd().after(date)) {
                result = true;
            }
            else {
                result = false;
            }
        }
        else {
            result = false;
        }
        return result;
    }

    public boolean DecrementRide(Card card) {
        boolean result = false;
        if(card.getRidesCount() - 1 >= 0) {
            card.setRidesCount(card.getRidesCount() - 1);
            result = true;
        }
        return result;
    }

    public void TryPass(Registry r, Card card, Date date) {
        GateEvent gateEvent = new GateEvent(card.getId(), CheckCard(card), date);
        r.gateEventsList.add(gateEvent);
    }
}