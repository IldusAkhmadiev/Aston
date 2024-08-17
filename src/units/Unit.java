package units;

public abstract class Unit  {
    private int health;
    private int basicDamage;

    public String toString() {
        return getClass().getSimpleName();
    }

    public int getHealth() {
        return health;
    }

    public int getBasicDamage() {
        return basicDamage;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setBasicDamage(int basicDamage) {
        this.basicDamage = basicDamage;
    }

    public Unit(int health, int basicDamage) {
        this.health = health;
        this.basicDamage = basicDamage;
    }
}
