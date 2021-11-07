package com.felipeflohr.uno.logic;

interface PlayerChangeListener {

    void onPlayerChange();
    int getNextPlayer();
    void instantiateNextPlayer();
}
