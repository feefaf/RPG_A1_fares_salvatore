import com.isep.rpg.mechants.Dragon;
import com.isep.rpg.gentils.Warrior;
import com.isep.rpg.items.Weapon;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CombatantTest {

    @Test
    void fightTest() {
        Warrior w = new Warrior("Ron");
        Weapon sword = new Weapon("sword", "Warrior", 1);
        w.take(sword);
        Dragon d = new Dragon("Dracofeu");
        d.attack(w);
        w.attack(d);
        assertTrue(d.getHealthPoint() == 4);
        assertEquals(3, w.getHealthPoint());
    }

}
