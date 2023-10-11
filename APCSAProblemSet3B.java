import java.io.*;

public class APCSAProblemSet3B {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        while (true) {
            System.out.println("Human, let\u2019s have an epic game of Rock, Paper, Crossblades!");
            //System.out.print("You: If he's in my mind I must have no mind. I must eliminate all thought! Yes if I never make a decision he will never be able to predict me! It's beautifully perfect. Father, you'd be proud. ");
            String str = readLine();
            int player;
            boolean bad = false;
            // rock = 0; paper = 1; crossblade = 2;

            if (str.length() < 50) {
                bad = true;
            }
            if (str.substring(str.length() - 4).toLowerCase().equals("rock")) {
                player = 0;
            } else if (str.substring(str.length() - 5).equals("paper")) {
                player = 1;
            } else if (str.substring(str.length() - 11).equals("crossblades")) {
                player = 2;
            } else {
                System.out.println(str);
                System.out.println("Me: You have failed to adhere to the ancient traditions of Rock, Paper, Crossblades! You have lost by disqualification! Disgraceful!");
                System.out.println("Result: As I predicted, I have won this battle. The kingdom is MINE!");
                continue;
            }

            int comp = (int) (Math.random() * 3);
            if (bad) {
                if (player == 0) comp = 1;
                else if (player == 1) comp = 2;
                else comp = 0;
                System.out.print("Pathetic. You cannot hope to beat me without the passion of a thousand suns, without the dedication of a Pleistocene glacier! I choose ");
            } else {
                System.out.print("Does he know my strategy? Two stones in a row... what are the chances? Did he steal my notes? Did he follow me into the archives? No, stay the course: ");
            }
            if (comp == 0) {
                System.out.println("ROCK!");
            } else if (comp == 1) {
                System.out.println("Paper!");
            } else {
                System.out.println("CROSSBLADES!");
            }

            //win = 0; tie = 1; lose = 2;
            // rock = 0; paper = 1; crossblade = 2;
            int result;
            if (player == comp) {
                result = 1;
            } else if (player == 0 && comp == 1) {
                result = 2;
            } else if (player == 0 && comp == 2) {
                result = 0;
            } else if (player == 1 && comp == 0) {
                result = 0;
            } else if (player == 1 && comp == 2) {
                result = 2;
            } else if (player == 2 && comp == 0) {
                result = 2;
            } else {
                result = 0;
            }

            if (result == 0) {
                System.out.println("Alas, in an unexpected twist of fate, the victory I so confidently foresaw slipped through my grasp.");
            } else if (result == 1) {
                System.out.println("Unbelievable! We have tied! *Eye twitches*");
            } else if (result == 2) {
                System.out.println("As I predicted, I have won this battle. The kingdom is MINE!");
            }
        }
    }

    static String readLine() throws IOException {
        return br.readLine().trim();
    }
}
