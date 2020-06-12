package Lab03;


import java.util.Date;

public class GateEvent {
    private int cardId;
    private boolean success;
    private Date date;
    private int id;

    private int count = 0;

    public GateEvent(int c, boolean s, Date d) {
        id = count;
        count++;

        cardId = c;
        success = s;
        date = d;
    }

    public int getCardId() {
        return cardId;
    }
}
