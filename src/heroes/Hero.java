package heroes;

public abstract class Hero {
    private String name;

    public Hero(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void attackEnemy() {
        System.out.println(this + " " + getName() + " атакует врага");
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}
