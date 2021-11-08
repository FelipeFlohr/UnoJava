package com.felipeflohr.uno.logic.ailogic;

import com.felipeflohr.uno.logic.Player;

public class AIPlayer extends Player {

    public AIPlayer(int id) {
        super(id);
        this.setAiEnabled(true);
    }
}
