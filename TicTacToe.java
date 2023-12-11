import java.util.Scanner;
import java.util.HashSet;

public class TicTacToe {
    // Enter Your Methods Here
    static HashSet<Integer> p1_set = new HashSet<Integer>();
    static HashSet<Integer> p2_set = new HashSet<Integer>();

    static String checkForWin(String user) {
        String res;
        HashSet<Integer> r1 = new HashSet<Integer>();
        r1.add(1);
        r1.add(2);
        r1.add(3);
        HashSet<Integer> r2 = new HashSet<Integer>();
        r2.add(4);
        r2.add(5);
        r2.add(6);
        HashSet<Integer> r3 = new HashSet<Integer>();
        r3.add(7);
        r3.add(8);
        r3.add(9);
        HashSet<Integer> c1 = new HashSet<Integer>();
        c1.add(1);
        c1.add(4);
        c1.add(7);
        HashSet<Integer> c2 = new HashSet<Integer>();
        c2.add(2);
        c2.add(5);
        c2.add(8);
        HashSet<Integer> c3 = new HashSet<Integer>();
        c3.add(3);
        c3.add(6);
        c3.add(9);
        HashSet<Integer> d1 = new HashSet<Integer>();
        d1.add(1);
        d1.add(5);
        d1.add(9);
        HashSet<Integer> d2 = new HashSet<Integer>();
        d2.add(3);
        d2.add(5);
        d2.add(7);

        HashSet<HashSet> set = new HashSet<HashSet>();
        set.add(r1);
        set.add(r2);
        set.add(r3);
        set.add(c1);
        set.add(c2);
        set.add(c3);
        set.add(d1);
        set.add(d2);
        for (HashSet c : set) {
            if (p1_set.containsAll(c)) {
                res = "Hurray ! " + user + " is the WINNER :)";
                return res;
            } else if (p2_set.containsAll(c)) {
                res = "Hurray ! " + user + " is the WINNER :)";
                return res;
            }
        }
        int len = p1_set.size() + p2_set.size();
        if (len == 9) {
            return "It's Draw  ^_____^";
        }
        return "";
    }

    static void updateGameBoard(char[][] game_board, int pos, char symbol) {
        switch (pos) {
            case 1:
                game_board[0][0] = symbol;
                print_board(game_board);
                break;
            case 2:
                game_board[0][2] = symbol;
                print_board(game_board);
                break;
            case 3:
                game_board[0][4] = symbol;
                print_board(game_board);
                break;
            case 4:
                game_board[2][0] = symbol;
                print_board(game_board);
                break;
            case 5:
                game_board[2][2] = symbol;
                print_board(game_board);
                break;
            case 6:
                game_board[2][4] = symbol;
                print_board(game_board);
                break;
            case 7:
                game_board[4][0] = symbol;
                print_board(game_board);
                break;
            case 8:
                game_board[4][2] = symbol;
                print_board(game_board);
                break;
            case 9:
                game_board[4][4] = symbol;
                print_board(game_board);
                break;
            default:
                System.out.println("Invalid input !!!");
                break;
        }

    }

    static void switchPlayer(String user, String player1, String player2) {

        if (user == player1) {
            user = player2;
        } else {
            user = player1;
        }

    }

    static void print_board(char[][] game_board) {
        for (int i = 0; i < game_board.length; i++) {
            for (int j = 0; j < game_board[0].length; j++) {
                System.out.print(game_board[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("---------Welcome to TicTacToe Game---------");
        System.out.println();

        System.out.println("Enter the name of player 1 : ");
        String player1 = scan.next();
        System.out.println();

        System.out.println("Select your symbol : O or X");
        String p1_symbol = scan.next().toUpperCase();
        System.out.println();

        if (p1_symbol.equals("O") || p1_symbol.equals("X")) {
            System.out.println(player1 + " symbol : " + p1_symbol);
        }
        else{
            System.out.println("Select appropriate symbol O_O");
            System.out.println("Select your symbol : O or X");
            p1_symbol = scan.next().toUpperCase();
        }
        System.out.println();

        System.out.println("Enter the name of player 2 : ");
        String player2 = scan.next();
        System.out.println();

        String p2_symbol;
        if (p1_symbol.equals("O")) {
            p2_symbol = "X";
        } else {
            p2_symbol = "O";
        }
        System.out.println(player2 + " symbol : " + p2_symbol);
        System.out.println();

        System.out.println("---------Let's Enter Into The Game---------");
        System.out.println();

        String user;
        System.out.println("Who is taking first turn : Enter 1 for player1 and 2 for player2");
        int temp = scan.nextInt();
        System.out.println();
        if (temp == 1) {
            user = player1;
        } else {
            user = player2;
        }

        char[][] game_board = {
                { ' ', '|', ' ', '|', ' ' },
                { '-', ' ', '-', ' ', '-' },
                { ' ', '|', ' ', '|', ' ' },
                { '-', ' ', '-', ' ', '-' },
                { ' ', '|', ' ', '|', ' ' }
        };
        print_board(game_board);
        System.out.println();

        while (true) {
            System.out.println();
            System.out.println(user + ": Enter a number from 1-9");
            int pos = scan.nextInt();
            while (p1_set.contains(pos) || p2_set.contains(pos)) {
                System.out.println("Sorry ! that position is already filled");
                System.out.println(user + ": Enter a number from 1-9");
                pos = scan.nextInt();
            }
            if (user.equals(player1)) {
                p1_set.add(pos);
                updateGameBoard(game_board, pos, p1_symbol.charAt(0));
            } else {
                p2_set.add(pos);
                updateGameBoard(game_board, pos, p2_symbol.charAt(0));
            }

            String result = checkForWin(user);
            if (result.length() > 0) {
                System.out.println(result);
                scan.close();
                break;
            }

            if (user == player1) {
                user = player2;
            } else {
                user = player1;
            }

        }
    }
}