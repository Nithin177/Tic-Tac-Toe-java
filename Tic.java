import java.util.*;

public class Tic {
    static HashSet<Integer> ur_set = new HashSet<Integer>();
    static HashSet<Integer> comp_set = new HashSet<Integer>();

    public static void main(String[] args) {

        char[][] g_board = {
                {' ', '|', ' ', '|', ' '},
                {'-', '|', '-', '|', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '|', '-', '|', '-'},
                {' ', '|', ' ', '|', ' '}
        };

        print_board(g_board);
        Scanner in = new Scanner(System.in);

        while (true) {
            System.out.println("Enter Values From 1-9");
            int user_position = in.nextInt();
            while (ur_set.contains(user_position) || comp_set.contains(user_position)) {
                System.out.println("Retry...! Enter Values From 1-9");
                user_position = in.nextInt();
            }
            p_holder(g_board, user_position, "You");

            String res = check_Winner();
            if (res.length() > 0) {
                System.out.println(res);
                break;
            }

            int comp_position = gen_random();
            while (ur_set.contains(comp_position) || comp_set.contains(comp_position)) {
                comp_position = gen_random();
            }
            p_holder(g_board, comp_position, "Comp");
            res = check_Winner();
            if (res.length() > 0) {
                System.out.println(res);
                break;
            }
        }
    }

    static String check_Winner() {
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

        HashSet<HashSet<Integer>> set = new HashSet<HashSet<Integer>>();
        set.add(r1);
        set.add(r2);
        set.add(r3);
        set.add(c1);
        set.add(c2);
        set.add(c3);
        set.add(d1);
        set.add(d2);

        for (HashSet<Integer> C : set) {
            if (ur_set.containsAll(C))
                return "Hurray......! You Won";
            else if (comp_set.containsAll(C))
                return "Opps! You lost";
        }
        if (ur_set.size() + comp_set.size() == 9)
            return "Draw";

        return "";
    }

    static int gen_random() {
        int max = 9;
        int min = 1;
        int range = max - min + 1;
        return (int) (Math.random() * range) + min;
    }

    static void print_board(char[][] g_board) {
        for (int i = 0; i < g_board.length; i++) {
            for (int j = 0; j < g_board[0].length; j++) {
                System.out.print(g_board[i][j]);
            }
            System.out.println();
        }
    }

    static void p_holder(char[][] g_board, int pos, String user) {
        char style = 'X';
        if (user.equals("You")) {
            style = 'X';
            ur_set.add(pos);
        } else if (user.equals("Comp")) {
            style = 'O';
            comp_set.add(pos);
        }
        switch (pos) {
            case 1:
                g_board[0][0] = style;
                break;
            case 2:
                g_board[0][2] = style;
                break;
            case 3:
                g_board[0][4] = style;
                break;
            case 4:
                g_board[2][0] = style;
                break;
            case 5:
                g_board[2][2] = style;
                break;
            case 6:
                g_board[2][4] = style;
                break;
            case 7:
                g_board[4][0] = style;
                break;
            case 8:
                g_board[4][2] = style;
                break;
            case 9:
                g_board[4][4] = style;
                break;
            default:
                System.out.println("Please Enter the valid input.........!");
        }
        print_board(g_board);
    }
}
