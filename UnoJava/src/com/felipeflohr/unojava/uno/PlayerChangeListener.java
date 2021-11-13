package com.felipeflohr.unojava.uno;

interface PlayerChangeListener {

    int getNextPlayer();
    void moveToNextPlayer() throws InterruptedException;
}
