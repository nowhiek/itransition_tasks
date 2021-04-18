package by.bsuir.runner;

import by.bsuir.service.GameSession;
import by.bsuir.service.HMAC;
import by.bsuir.service.exception.GameException;
import by.bsuir.service.validator.impl.CountArgsValidatorImpl;
import by.bsuir.service.validator.impl.DuplicateArgsValidatorImpl;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        GameSession session = new GameSession();
        HMAC hmac = new HMAC();

        try {
            if (!new CountArgsValidatorImpl().validate(args) || !new DuplicateArgsValidatorImpl().validate(args)) {
                throw new GameException("Sorry, not valid args. Example : rock paper scissors lizard spock");
            }

            String computerMove = args[new SecureRandom().nextInt(args.length)];

            byte[] key = hmac.generateKey();
            byte[] hmacComputerMove = hmac.generateHMAC(computerMove, key);

            System.out.printf("HMAC : %s\n", hmac.bytesToString(hmacComputerMove));

            int playerMove = menu(args);

            System.out.printf("Your move : %s\nComputer move : %s\n", args[playerMove - 1], computerMove);

            int index = Arrays.asList(args).indexOf(computerMove) + 1;
            session.getWinner(args, playerMove, index);
            System.out.printf("HMAC key : %s", hmac.bytesToString(key));
        } catch (GameException e) {
            System.out.println(e.getMessage());
        }
    }

    private static int menu(String[] args){
        Scanner scanner = new Scanner(System.in);
        int choose = 0;

        System.out.println("Available moves : ");
        while (true) {
            for (int i = 0; i < args.length; i++) {
                System.out.printf("%d - %s\n", i + 1, args[i]);
            }

            System.out.println("0 - exit");
            System.out.print("Enter your move : ");

            while (!scanner.hasNextInt()) {
                scanner.next();
            }

            choose = scanner.nextInt();

            if (choose > 0 && choose <= args.length){
                return choose;
            } else if (choose == 0) {
                System.exit(0);
            }
        }
    }
}
