package cz.wake.lobby.armorstands;

public interface ASInterface {

    /**
     * Spawn ArmorStandu.
     */
    void spawn();

    /**
     * Spawn hologramu
     */
    void hologramSpawn();

    /**
     * Text pod hl. hologramem
     */
    void subtextSpawn();

    /**
     * Detekce spawnuteho ArmorStandu.
     * @return
     */
    boolean isActive();

    /**
     * Teleport na urcity server nebo lobby.
     */
    void serverTeleport();

    /**
     * Odebráni armorstandu
     */
    void remove();

    /**
     Update Armorstand a automaticke prepinani do rezimu udrzby
     */
    void updateArmorStand(String s, int i);
}
