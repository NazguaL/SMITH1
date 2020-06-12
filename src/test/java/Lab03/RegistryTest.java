package Lab03;


import org.junit.Assertions;
import org.junit.Test;

import java.util.Date;

class RegistryTest {

    @Test
    void addCard() {
        Registry registry = new Registry();
        registry.AddCard(CardType.QuantityCard, 5, null, PricesType.Common, TimeLimit.Season, "Summer", null);

        assertEquals(1, registry.cardList.size());
    }

    @org.junit.jupiter.api.Test
    void getCardById() {
        Registry registry = new Registry();
        registry.AddCard(CardType.QuantityCard, 3, null, PricesType.Common, TimeLimit.Season, "Summer", null);
        registry.AddCard(CardType.QuantityCard, 5, null, PricesType.Common, TimeLimit.Season, "Summer", null);
        registry.AddCard(CardType.QuantityCard, 7, null, PricesType.Common, TimeLimit.Season, "Summer", null);


        Assertions.assertEquals(3, registry.GetCardById(0).getRidesCount());
        Assertions.assertEquals(5, registry.GetCardById(1).getRidesCount());
        Assertions.assertEquals(7, registry.GetCardById(2).getRidesCount());
    }

    @org.junit.jupiter.api.Test
    void blockCard() {
        Registry registry = new Registry();
        registry.AddCard(CardType.QuantityCard, 3, null, PricesType.Common, TimeLimit.Season, "Summer", null);
        registry.AddCard(CardType.QuantityCard, 5, null, PricesType.Common, TimeLimit.Season, "Summer", null);

        registry.BlockCard(0);

        assertFalse(registry.GetCardById(0).isActive());
        assertTrue(registry.GetCardById(1).isActive());
    }

    @org.junit.jupiter.api.Test
    void getEventsByCardId() {
        Gate gate = new Gate();
        Registry registry = new Registry();

        registry.AddCard(CardType.QuantityCard, 3, null, PricesType.Common, TimeLimit.Season, "Summer", null);
        gate.TryPass(registry, registry.GetCardById(0), new Date());
        gate.TryPass(registry, registry.GetCardById(0), new Date());
        gate.TryPass(registry, registry.GetCardById(0), new Date());
        gate.TryPass(registry, registry.GetCardById(0), new Date());

        registry.AddCard(CardType.QuantityCard, 5, null, PricesType.Common, TimeLimit.Season, "Summer", null);


        Assertions.assertEquals(4, registry.GetEventsByCardId(0).size());
        assertTrue(registry.GetEventsByCardId(1).isEmpty());
    }

    @org.junit.jupiter.api.Test
    void getEventsByCardType() {
        Gate gate = new Gate();
        Registry registry = new Registry();

        registry.AddCard(CardType.QuantityCard, 3, null, PricesType.Common, TimeLimit.Season, "Summer", null);
        gate.TryPass(registry, registry.GetCardById(0), new Date());
        gate.TryPass(registry, registry.GetCardById(0), new Date());
        gate.TryPass(registry, registry.GetCardById(0), new Date());
        gate.TryPass(registry, registry.GetCardById(0), new Date());

        registry.AddCard(CardType.TimeCard, 0, TimeCardType.EveningCard, PricesType.Common, TimeLimit.Season, "Summer", null);
        gate.TryPass(registry, registry.GetCardById(1), new Date());
        gate.TryPass(registry, registry.GetCardById(1), new Date());

        Assertions.assertEquals(4, registry.GetEventsByCardType(CardType.QuantityCard).size());
        Assertions.assertEquals(2, registry.GetEventsByCardType(CardType.TimeCard).size());

    }
}