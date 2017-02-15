package cz.wake.lobby.armorstands;

import cz.wake.lobby.Main;

public class ArmorStandUpdateTask implements Runnable {

    @Override
    public void run() {
        Main.getInstance().getASM().updatePlayers();
    }
}
