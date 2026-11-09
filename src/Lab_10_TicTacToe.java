import java.util.Scanner;

public class Lab_10_TicTacToe
{
    private static final int ROWS = 3;
    private static final int COLS = 3;

    private static String[][] board = new String[ROWS][COLS];

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        boolean playAgain;

        do
        {
            clearBoard();

            String player = "X";
            int moves = 0;
            boolean gameOver = false;

            while(!gameOver)
            {
                display();

                int row;
                int col;

                do
                {
                    row = SafeInput.getRangedInt(
                            in,
                            player + " Row",
                            1,
                            3) - 1;

                    col = SafeInput.getRangedInt(
                            in,
                            player + " Col",
                            1,
                            3) - 1;

                    if(!isValidMove(row, col))
                    {
                        System.out.println("Invalid move! Space already taken.");
                    }

                } while(!isValidMove(row, col));

                board[row][col] = player;
                moves++;

                if(moves >= 5)
                {
                    if(isWin(player))
                    {
                        display();
                        System.out.println(player + " WINS!");
                        gameOver = true;
                    }
                    else if(isTie())
                    {
                        display();
                        System.out.println("TIE GAME!");
                        gameOver = true;
                    }
                }

                if(!gameOver)
                {
                    if(player.equals("X"))
                    {
                        player = "O";
                    }
                    else
                    {
                        player = "X";
                    }
                }
            }

            playAgain = SafeInput.getYNConfirm(
                    in,
                    "Play again?");

        } while(playAgain);

        System.out.println("Thanks for playing!");
    }

    private static void clearBoard()
    {
        for(int r = 0; r < ROWS; r++)
        {
            for(int c = 0; c < COLS; c++)
            {
                board[r][c] = " ";
            }
        }
    }

    private static void display()
    {
        System.out.println();

        System.out.println("    1   2   3");

        for(int r = 0; r < ROWS; r++)
        {
            System.out.print((r + 1) + " ");

            for(int c = 0; c < COLS; c++)
            {
                System.out.print(" " + board[r][c] + " ");

                if(c < COLS - 1)
                {
                    System.out.print("|");
                }
            }

            System.out.println();

            if(r < ROWS - 1)
            {
                System.out.println("   ---+---+---");
            }
        }

        System.out.println();
    }

    private static boolean isValidMove(int row, int col)
    {
        return board[row][col].equals(" ");
    }

    private static boolean isWin(String player)
    {
        return isRowWin(player) ||
                isColWin(player) ||
                isDiagonalWin(player);
    }

    private static boolean isRowWin(String player)
    {
        for(int r = 0; r < ROWS; r++)
        {
            if(board[r][0].equals(player) &&
                    board[r][1].equals(player) &&
                    board[r][2].equals(player))
            {
                return true;
            }
        }

        return false;
    }

    private static boolean isColWin(String player)
    {
        for(int c = 0; c < COLS; c++)
        {
            if(board[0][c].equals(player) &&
                    board[1][c].equals(player) &&
                    board[2][c].equals(player))
            {
                return true;
            }
        }

        return false;
    }

    private static boolean isDiagonalWin(String player)
    {
        if(board[0][0].equals(player) &&
                board[1][1].equals(player) &&
                board[2][2].equals(player))
        {
            return true;
        }

        if(board[0][2].equals(player) &&
                board[1][1].equals(player) &&
                board[2][0].equals(player))
        {
            return true;
        }

        return false;
    }

    private static boolean isTie()
    {
        for(int r = 0; r < ROWS; r++)
        {
            for(int c = 0; c < COLS; c++)
            {
                if(board[r][c].equals(" "))
                {
                    return false;
                }
            }
        }

        return true;
    }
}