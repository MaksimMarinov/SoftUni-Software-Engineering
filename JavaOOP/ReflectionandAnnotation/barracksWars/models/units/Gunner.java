package barracksWars.models.units;

import barracksWars.interfaces.Unit;

public class Gunner extends AbstractUnit {
    private static final int GUNNER_HEALTH = 20;
    private static final int GUNNER_DAMAGE = 20;
    public Gunner() {
        super(GUNNER_HEALTH, GUNNER_DAMAGE);
    }
}
