import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReverseFile {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter file name: ");
        String filename = in.nextLine();
        try {
            Scanner fin = new Scanner(new FileInputStream(filename));
            ArrayList<String> lines = new ArrayList<String>();
            String line, word;
            while (fin.hasNextLine()) {
                lines.add(fin.nextLine());
            }
            // display output here
            for(int i = lines.size()-1; i >= 0; i--) {
                line = lines.get(i);
                if(line.isEmpty()) {
                    System.out.println(line);
                } else {
                    String words[] = line.split(" ");
                    for(int j = words.length-1; j >= 0; j--) {
                        word = words[j];
                        for(int k = word.length()-1; k >= 0; k--) {
                            System.out.print(word.charAt(k));
                        }
                        System.out.print(" ");
                    }
                    System.out.println();
                }
            }
            fin.close();
        } catch (FileNotFoundException e) {
            System.out.println("can not open " + filename + " to read!");
        }
    }

}
