package com.bridgelabz.assignment;

    import java.util.Random;

    public class SnakeAndLadderGame {
        private static final int BOARD_SIZE = 100;
        private static final int WINNING_POSITION = 100;
        private static final int NUM_SNAKES = 6;
        private static final int NUM_LADDERS = 9;
        private static final int MAX_DICE_VALUE = 6;
        private static final int[] SNAKE_POSITIONS = {32, 47, 49, 56, 68};
        private static final int[] SNAKE_DESTINATIONS = {9, 26, 12, 53, 99};
        private static final int[] LADDER_START_POSITIONS = {5, 13, 33, 45, 63};
        private static final int[] LADDER_DESTINATIONS = {29, 46, 50, 69, 92};

        private static final Random random = new Random();

        private static int rollDice() {
            return random.nextInt(MAX_DICE_VALUE) + 1;
        }

        private static int applySnakeOrLadder(int currentPosition) {
            for (int i = 0; i < NUM_SNAKES; i++)
                if (SNAKE_POSITIONS[i] == currentPosition)
                    return SNAKE_DESTINATIONS[i];

            for (int i = 0; i < NUM_LADDERS; i++) {
                if (currentPosition == LADDER_START_POSITIONS[i]) {
                    return LADDER_DESTINATIONS[i];
                }
            }

            return currentPosition;
        }

        public static void main(String[] args) {
            int currentPlayerPosition = 0;

            while (currentPlayerPosition < WINNING_POSITION) {
                int diceValue = rollDice();
                currentPlayerPosition += diceValue;

                if (currentPlayerPosition > BOARD_SIZE) {
                    currentPlayerPosition -= diceValue;
                    continue;
                }

                currentPlayerPosition = applySnakeOrLadder(currentPlayerPosition);

                System.out.println("Player moved to position: " + currentPlayerPosition);

                if (currentPlayerPosition == WINNING_POSITION) {
                    System.out.println("Player wins!");
                    break;
                }
            }
        }
    }
