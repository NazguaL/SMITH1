package Lab03;


import java.util.Date;

public class Card {
    private CardType cardType;
    private int ridesCount;
    private TimeCardType timeCardType;

    private PricesType pricesType;

    private TimeLimit timeLimit;
    private String season;
    private Date dateEnd;

    private int id;
    private boolean active;

    static int count = 0;

    public Card(CardType c, int r, TimeCardType t, PricesType p, TimeLimit l, String s, Date d){
        id = count;
        count++;

        active = true;

        cardType = c;
        ridesCount = r;
        timeCardType = t;

        pricesType = p;

        timeLimit = l;
        season = s;
        dateEnd = d;
    }


    public int getId() {
        return id;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public CardType getCardType() {
        return cardType;
    }

    public int getRidesCount() {
        return ridesCount;
    }

    public void setRidesCount(int ridesCount) {
        this.ridesCount = ridesCount;
    }

    public TimeCardType getTimeCardType() {
        return timeCardType;
    }

    public String getSeason() {
        return season;
    }

    public TimeLimit getTimeLimit() {
        return timeLimit;
    }

    public Date getDateEnd() {
        return dateEnd;
    }
}

