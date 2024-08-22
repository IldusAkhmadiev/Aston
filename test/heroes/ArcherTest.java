package heroes;

import enemies.Troll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArcherTest {

    @Test
    void heroIsNotAlive() {
        Troll troll = new Troll(300, 500, 100);
        Archer lego = new Archer(100, 10, "Lego", 100);
        troll.attackEnemy(lego);
        assertFalse(lego.isAlive());
    }

    @Test
    void attackEnemy() {
        Troll troll = new Troll(300, 500, 100);
        Archer lego = new Archer(100, 10, "Lego", 100);
        lego.attackEnemy(troll);
        assertEquals(290,troll.getHealth(),"После обычного удара здоровье тролля должно быть 300-10=290");
    }
    @Test
    void canUseAbility() {
        Troll troll = new Troll(300, 500, 100);
        Archer lego = new Archer(100, 10, "Lego", 100);
        assertTrue(lego.canUseAbility());
        assertTrue(lego.canUseAbility(100));
        assertTrue(lego.canUseAbility(99));
    }
    @Test
    void cantUseAbility() {
        Troll troll = new Troll(300, 500, 100);
        Archer lego = new Archer(100, 10, "Lego", 0);
        Archer lego2 = new Archer(100, 10, "Lego", 1);
        assertFalse(lego.canUseAbility());
        assertFalse(lego.canUseAbility(0));
        assertFalse(lego.canUseAbility(1));
    }

    @Test
    void setHealth() {
        Archer lego = new Archer(100, 10, "Lego", 100);
        lego.setHealth(lego.getHealth()+50);
        assertEquals(150,lego.getHealth());
    }

    @Test
    void useAbility() {
        Archer lego = new Archer(100, 10, "Lego", 100);
        Troll troll = new Troll(300, 500, 100);
        lego.useAbility(troll);
        assertEquals(280,troll.getHealth());
    }

}