package caesarcipher;

import java.util.List;
import java.util.Scanner;

public class CaesarCipher {
    // Rotate a character k-positions
    public static char cipher(char c, int k) {
        // declare some helping constants
        final int alphaLength = 26;
        final char asciiShift = Character.isUpperCase(c) ? 'A' : 'a';
        final int cipherShift = k % alphaLength;

        // shift down to 0..25 for a..z
        char shifted = (char) (c - asciiShift);
        // rotate the letter and handle "wrap-around" for negatives and value >= 26
        shifted = (char) ((shifted + cipherShift + alphaLength) % alphaLength);
        // shift back up to english characters
        return (char) (shifted + asciiShift);
    }

    // Rotate a string k-positions
    public static String cipher(String s, int k) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            sb.append(cipher(s.charAt(i), k));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        String password;
        int key;

        System.out.print("Please enter a Word: ");
        password = keyboard.nextLine();

       
        for(int h = 1; h <= 26; h++){
            
        String encryption = cipher(password, h);
        System.out.println("Key\t"+h +"\t"+ password+" after encryption will be "+"\"" + encryption+ "\".");
        }
        
    }
    
      private static void findOptions( String string, List<String> lowercase )
    {
        int[] freq = toFreq( string );
        for ( String l : lowercase )
        {
            int[] freqIn = toFreq( l );
            if ( matches( freq, freqIn ) )
            {
                System.out.println( l );
            }
        }
    }

    /**
     * Returns true if all the frequencies of the letters match.
     * 
     * @param freq
     * @param freqIn
     * @return
     */
    private static boolean matches( int[] freq, int[] freqIn )
    {
        for ( int i = 0; i < 26; i++ )
        {
            if ( freq[i] == 0 && freqIn[i]>0)
            {
                return false;
            }
            else if (freq[i] < freqIn[i])
            {
                return false;
            }

        }
        return true;
    }

    /**
     * Encode a word in to a freqceny array. int[0] = #a's, int[1] = #b's etc.
     * 
     * @param string
     * @return
     */
    private static int[] toFreq( String string )
    {
        int[] freq = new int[26];
        for ( char c : string.toCharArray() )
        {
            if ( ( c - 'a' ) >= 0 && ( c - 'a' ) < 26 )
            {
                freq[c - 'a']++;
            }
        }
        return freq;
    }
    
}
