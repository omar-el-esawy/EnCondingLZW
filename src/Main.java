import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        int c = 0;
        String s = "";
        Map<String, Integer> mp = new TreeMap<String, Integer>();
        Scanner cin = null;
        try {
            cin = new Scanner(new FileInputStream("input.txt"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        s = cin.next();


        for (int i = 0; i < 127; i++)
            mp.put("" + (char) i, i);

        int index = 128;
        String temp = "";

        ArrayList<Integer> com = new ArrayList<Integer>();
        for (char symbol : s.toCharArray()) {

            String Str_Symbol = temp + symbol;
            if (mp.containsKey(Str_Symbol))
                temp = Str_Symbol;
            else {
                com.add(mp.get(temp));

                mp.put(Str_Symbol, index++);
                temp = "" + symbol;
            }
        }
        if (!temp.equals(""))
            com.add(mp.get(temp));

        for (Integer x : com) System.out.println(x);


        try {
            BufferedWriter out = new BufferedWriter(new FileWriter("output.txt"));
            for (Integer x : com)
                out.write(x + "\n");
            out.flush();
            out.close();
        } catch (Exception e) {
        }


    }
}