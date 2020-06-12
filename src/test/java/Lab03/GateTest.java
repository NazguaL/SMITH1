package Lab03;


import org.junit.Assertions;
import org.junit.Test;

import java.util.Date;



class GateTest {

    @Test
    void checkCard() {
        Gate gate = new Gate();
        Card cardQ1 = new Card(CardType.QuantityCard, 5, null, PricesType.Common, TimeLimit.Season, "Summer", null);
        Card cardQ2 = new Card(CardType.QuantityCard, 0, null, PricesType.Common, TimeLimit.Season, "Summer", null);
        Card cardT1 = new Card(CardType.TimeCard, 0, TimeCardType.MorningCard, PricesType.Common, TimeLimit.Season, "Summer", null);
        Card cardT2 = new Card(CardType.TimeCard, 0, TimeCardType.EveningCard, PricesType.Common, TimeLimit.Days, "", new Date(2020, 11, 15));
        Card cardBlocked = new Card(CardType.QuantityCard, 5, null, PricesType.Common, TimeLimit.Season, "Summer", null);
        cardBlocked.setActive(false);


        assertTrue(gate.CheckCard(cardQ1));
        assertFalse(gate.CheckCard(cardQ2));
        assertFalse(gate.CheckCard(cardT1));
        assertFalse(gate.CheckCard(cardT2));
        assertFalse(gate.CheckCard(cardBlocked));
    }

    @Test
    void checkTime() {
        Gate gate = new Gate();
        TimeCardType timeCardType1 = TimeCardType.MorningCard;
        TimeCardType timeCardType2 = TimeCardType.EveningCard;
        TimeCardType timeCardType3 = TimeCardType.NightCard;

        Date date = new Date(2020, 11, 15, 20, 30);

        assertFalse(gate.CheckTime(timeCardType1, date));
        assertFalse(gate.CheckTime(timeCardType2, date));
        assertTrue(gate.CheckTime(timeCardType3, date));
    }

    @Test
    void isActiveCard() {
        Gate gate = new Gate();

        Card card1 = new Card(CardType.TimeCard, 0, TimeCardType.MorningCard, PricesType.Common, TimeLimit.Season, "Summer", null);
        Card card2 = new Card(CardType.TimeCard, 0, TimeCardType.EveningCard, PricesType.Common, TimeLimit.Days, "", new Date(2020, 11, 15));

        Date date1 = new Date();
        Date date2 = new Date(2020, 11, 16);

        assertTrue(gate.IsActiveCard(card1, date1));
        assertTrue(gate.IsActiveCard(card2, date1));
        assertFalse(gate.IsActiveCard(card2, date2));
    }

    @Test
    void decrementRide() {
        Gate gate = new Gate();

        Card cardQ1 = new Card(CardType.QuantityCard, 5, null, PricesType.Common, TimeLimit.Season, "Summer", null);
        Card cardQ2 = new Card(CardType.QuantityCard, 0, null, PricesType.Common, TimeLimit.Season, "Summer", null);

        assertTrue(gate.CheckCard(cardQ1));
        assertFalse(gate.CheckCard(cardQ2));
    }

    @Test
    void tryPass() {
        Gate gate = new Gate();
        Registry registry = new Registry();
        registry.AddCard(CardType.QuantityCard, 5, null, PricesType.Common, TimeLimit.Season, "Summer", null);

        gate.TryPass(registry, registry.GetCardById(0), new Date());
        gate.TryPass(registry, registry.GetCardById(0), new Date());
        gate.TryPass(registry, registry.GetCardById(0), new Date());
        gate.TryPass(registry, registry.GetCardById(0), new Date());
        gate.TryPass(registry, registry.GetCardById(0), new Date());
        gate.TryPass(registry, registry.GetCardById(0), new Date());

        Assertions.assertEquals(6, registry.gateEventsList.size());
    }
}