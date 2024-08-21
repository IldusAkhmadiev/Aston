package heroes;

import enemies.Troll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArcherTest {

    @Test
    void heroIsDeath() {
        Troll troll = new Troll(300, 500, 100);
        Archer lego = new Archer(100, 10, "Lego", 100);
        troll.attackEnemy(lego);
        assertFalse(lego.isAlive());
    }
}