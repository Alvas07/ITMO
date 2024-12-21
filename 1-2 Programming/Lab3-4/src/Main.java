import Creatures.*;
import Enums.FaceColor;
import Enums.HeadWear;
import Enums.MoveType;
import Environment.*;
import Exceptions.IllegalBroomMove;

import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // Environment Initialization
        LivingRoom livingRoom = new LivingRoom();
        Kitchen kitchen = new Kitchen();
        Telephone telephone = new Telephone("iPhone", new ArrayList<String>());
        Telephone.Handset handset = new Telephone.Handset(new Random().nextBoolean());
        livingRoom.setItems(telephone, handset);
        Window window = new Window(new Random().nextBoolean());
        Window.Windowswill windowswill = window.new Windowswill();
        Broom broom = new Broom();
        windowswill.addItem(broom);

        System.out.println("\nEnvironment Initialization done\n");

        // Characters Initialization
        Carlson carlson = new Carlson();
        FrekenBok frekenBok = new FrekenBok();
        Frida frida = new Frida();
        Malysh malysh = new Malysh();
        MysteryCreature mysteryCreature = new MysteryCreature(FaceColor.getRandomFaceColor(), HeadWear.getRandomHeadWear(), new Random().nextBoolean());
        livingRoom.setCreatures(frekenBok, malysh);
        kitchen.addCreature(mysteryCreature);

        if (new Random().nextDouble() < 0.5) {
            livingRoom.addCreature(carlson);
        } else if (new Random().nextDouble() < 0.3) {
            kitchen.addCreature(carlson);
            try {
                broom.addPassenger(carlson);
            } catch (IllegalBroomMove e) {
                System.out.println(e.getMessage());
            }
        } 

        System.out.println("\nCharacters Initialization done\n");

        // Script
        try {
            malysh.move(MoveType.getRandomMoveType(), telephone);
            malysh.call(frida, handset);
            if (frekenBok.isFree()) {
                malysh.say("Фрекен Бок может подойти");
                frekenBok.move(MoveType.getRandomMoveType(), telephone);
            } else {
                malysh.say("Фрекен Бок не может подойти");
                frida.ask(malysh);
            }
            malysh.lookAt(carlson);
            if (livingRoom.getCreatures().contains(carlson)) {
                System.out.println("Карлсон был здесь");
                System.out.println("Сценарий окончен");
                System.exit(0);
            } else {
                System.out.println("Карлсона здесь не было");
                malysh.search(carlson);
            }
            livingRoom.removeCreature(malysh);
            malysh.move(MoveType.getRandomMoveType(), kitchen);
            kitchen.addCreature(malysh);
            malysh.move(MoveType.getRandomMoveType(), window);
            if (window.isWindowOpen()) {
                System.out.println("Окно открыто");
            } else {
                System.out.println("Окно закрыто");
            }
            malysh.lookAt(mysteryCreature);
            if (mysteryCreature.isLikeCarlson()) {
                System.out.println("Мистическое существо выглядело как Карлсон");
            } else {
                System.out.println("Мистическое существо не было похоже на Карлсона");
            }
            try {
                broom.addPassenger(mysteryCreature);
                mysteryCreature.prepareToFly();
                mysteryCreature.openWindow(window);
                mysteryCreature.flyAway();
            } catch (IllegalBroomMove e) {
                System.out.println(e.getMessage());
                windowswill.removeCreature(mysteryCreature);
                kitchen.removeCreature(mysteryCreature);
                mysteryCreature.move(MoveType.getRandomMoveType(), livingRoom);
            } finally {
                System.out.println("Сценарий закончен");
                System.exit(0);
            }
        } catch (RuntimeException e) {
            System.out.println("Ошибка при исполнении программы: " + e.getMessage());
        }
    }
}
