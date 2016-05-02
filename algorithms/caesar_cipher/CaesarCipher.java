import java.util.Scanner;

public class CaesarCipher {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String s = in.next();
        int k = in.nextInt();
        
        System.out.println(encodeString(s, k));
        in.close();
    }
    
    private static String encodeString(String s, int k){
    	char[] cArray = s.toCharArray();
    	boolean isCapital = false;
    	for (int i = 0; i < cArray.length; i++) {
    		int asciiCode = cArray[i];
    		
    		// skip character if not a letter.
    		if((asciiCode<65 || asciiCode > 90) && (asciiCode < 97 || asciiCode > 122)){
    			continue;
    		}
    		
    		isCapital = (asciiCode> 64 && asciiCode < 91)?true:false;
    		
			int scaledLetter = getScaledValue(asciiCode, isCapital);
			
			cArray[i] = getEncodedCode(scaledLetter, k, isCapital);
		}
    	return String.valueOf(cArray);
    }
    

	// Scale ASCII value on 0 - 25 scala based on CASE of letter
    private static int getScaledValue(int asciiCode, boolean isCapital){
    	if(isCapital){
    		return asciiCode - 65;
    	}
    	return asciiCode - 97;
    }
    
    private static char getEncodedCode(int scaledLetter, int key, boolean isCapital) {
    	char c = 0;
    	if(isCapital){
    		c = (char) (((scaledLetter + key) % 26) + 65);
    		return c;
    	}else{
    		c = (char) (((scaledLetter + key) % 26) + 97);
    		return c;
    	}
    }
}
