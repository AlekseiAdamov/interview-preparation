package ru.alexeiadamov.javacore.pingpong;

public class Player implements Runnable {
    private static final int TIMEOUT = 1000;
    private static Turn currentTurn = Turn.PONG;
    private final Turn turn;

    public Player(Turn turn) {
        this.turn = turn;
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            playTurn();
        }
    }

    private void playTurn() {
        synchronized (Player.class) {
            waitForOtherPlayersTurn();
            makeTurn();
        }
    }

    private void waitForOtherPlayersTurn() {
        while (turn.equals(currentTurn)) {
            try {
                Player.class.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
//                    return;
            }
        }
    }

    private void makeTurn() {
        System.out.println(turn.getName());
        currentTurn = turn;
        try {
            Thread.sleep(TIMEOUT);
            Player.class.notify();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
