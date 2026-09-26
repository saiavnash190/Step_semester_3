public class Character {
    private final int maxHealth;
    private int health;

    public Character(int maxHealth) {
        this.maxHealth = maxHealth;
        this.health = maxHealth;
    }

    public int getHealth() {
        return health;
    }

    public void takeDamage(int amount) {
        if (amount > 0) {
            health -= amount;
            if (health < 0) {
                health = 0;
            }
        }
    }

    public void heal(int amount) {
        if (amount > 0) {
            health += amount;
            if (health > maxHealth) {
                health = maxHealth;
            }
        }
    }

    public static void main(String[] args) {
        Character c = new Character(100);
        c.takeDamage(30);
        System.out.println(c.getHealth());
        c.heal(50);
        System.out.println(c.getHealth());
        c.takeDamage(150);
        System.out.println(c.getHealth());
    }
}