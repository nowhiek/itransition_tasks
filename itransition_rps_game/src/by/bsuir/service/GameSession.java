package by.bsuir.service;

import java.util.ArrayList;
import java.util.List;

public class GameSession {

    public void getWinner(String[] args, int playerMove, int computerMove) {
        List<Integer> winCombines = getWinCombinations(args.length, computerMove);

        if (playerMove == computerMove) {
            System.out.println("Draw!");
        } else if (winCombines.contains(playerMove)){
            System.out.println("You win!");
        } else {
            System.out.println("You lose!");
        }
    }

    private List<Integer> getWinCombinations(int argsLength, int computerMove) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < argsLength / 2; i++) {
            list.add((i + computerMove) % argsLength + 1);
        }

        return list;
    }
}
