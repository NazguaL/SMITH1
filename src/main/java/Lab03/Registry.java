package Lab03;


import java.util.*;

public class Registry {
    public Registry(){
    }

    public ArrayList<Card> cardList = new ArrayList<>();
    public ArrayList<GateEvent> gateEventsList = new ArrayList<>();

    public void AddCard(CardType c, int r, TimeCardType t, PricesType p, TimeLimit l, String s, Date d){
        Card card = new Card(c, r, t, p, l, s, d);
        cardList.add(card);
    }

    public Card GetCardById(int id){
        for(Card card : cardList)
            if (card.getId() == id)
                return card;
        return null;
    }

    public void BlockCard(int id) {
        for(Card card : cardList)
            if (card.getId() == id)
                card.setActive(false);
    }

    public List<GateEvent> GetEventsByCardId(int id){
        ArrayList<GateEvent> result = new ArrayList<>();
        for (GateEvent gateEvent : gateEventsList) {
            if(gateEvent.getCardId() == id){
                result.add(gateEvent);
            }
        }
        return result;
    }

    public List<GateEvent> GetEventsByCardType(CardType cardType){
        ArrayList<GateEvent> result  = new ArrayList<>();
        for(Card card : cardList) {
            if (card.getCardType() == cardType) {
                for (GateEvent gateEvent : gateEventsList) {
                    if (gateEvent.getCardId() == card.getId()) {
                        result.add(gateEvent);
                    }
                }
            }
        }
        return result;
    }

}