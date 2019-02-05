package aircraftcarrier;

public class Aircraft {
    public final String type;
    private int max_ammo;
    public final int base_damage;
    public int ammo_store = 0;
    public boolean isPriority;

    Aircraft(String type, int max_ammo, int base_damage) {
        this.type = type;
        this.max_ammo = max_ammo;
        this.base_damage = base_damage;
        if (type.equals("F16")) {
            isPriority = false;
        }
        else {
            isPriority = true;
        }
    }

    public int fight() {
        int damage = base_damage * ammo_store;
        ammo_store = 0;
        return damage;
    }

    public int refill(int ammo) {
        if (ammo > max_ammo) {
            ammo_store = max_ammo;
            return ammo - max_ammo;
        }
        else if (ammo > 0) {
            ammo_store += ammo;
        }
        return 0;
    }

    public String getType() {
        return type;
    }

    public void getStatus() {
        System.out.println("Type " + type + ", Ammo: " + ammo_store + ", Base Damage: " + base_damage + ", All Damage: " + ammo_store * base_damage);
    }
}
