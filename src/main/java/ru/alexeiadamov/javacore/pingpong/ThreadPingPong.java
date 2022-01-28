package ru.alexeiadamov.javacore.pingpong;

public class ThreadPingPong {
    public static void main(String[] args) {
        final Player player1 = new Player(Turn.PING);
        final Player player2 = new Player(Turn.PONG);
        new Thread(player1).start();
        new Thread(player2).start();
    }
}
