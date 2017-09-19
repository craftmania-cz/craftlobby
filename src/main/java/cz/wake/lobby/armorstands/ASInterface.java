package cz.wake.lobby.armorstands;

public interface ASInterface {

    /**
     * Spawn ArmorStandu.
     */
    void spawn();

    /**
     * Spawn hologramu
     */
    default void hologramSpawn() {
        return;
    }

    /**
     * Text pod hl. hologramem
     */
    default void subtextSpawn() {
        return;
    }

    /**
     * Detekce spawnuteho ArmorStandu
     */
    default boolean isActive() {
        return false;
    }

    /**
     * Odebráni armorstandu
     */
    void remove();

    /**
     * Update Armorstand a automaticke prepinani do rezimu udrzby
     */
    void updateArmorStand(String s, int i);
}
