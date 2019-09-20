package ru.job4j.oop;


public class BallStory {

    public static void main(String[] args) {
        Hare hare = new Hare();
        Wolf grey = new Wolf();
        Fox foxy = new Fox();
        Ball bun = new Ball();

        bun.runAwayFromHome();
        hare.tryEat(bun);
        bun.runAway();
        grey.tryEat(bun);
        bun.runAway();
        foxy.tryEat(bun);
        bun.runLightAway();
        foxy.tryHardEat(bun);
    }
}
