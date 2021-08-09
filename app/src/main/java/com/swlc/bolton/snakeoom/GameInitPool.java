package com.swlc.bolton.snakeoom;

import java.util.ArrayList;
import java.util.List;

public class GameInitPool {

    private int poolSize = 5;
    private static List<Main> mainObjectsList = new ArrayList<>();

    private GameInitPool () {
        for (int i=0;i<poolSize;i++) {
            mainObjectsList.add(new Main());
        }
    }

    public static synchronized Main getMain() {
        if (mainObjectsList.isEmpty()) {
            new GameInitPool();
        }
        for (int i = 0; i< mainObjectsList.size(); i++) {
            if (!mainObjectsList.get(i).getStarted()) {
                return mainObjectsList.get(i);
            }
        }
        return null;
    }
}
