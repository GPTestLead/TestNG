package randomString;

import org.testng.annotations.Test;

public class RandomAlphabetString {

	@Test
	public static String generateRandomString(int length) {

        String text ="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
                StringBuilder sb = new StringBuilder(length);
        for( int i = 0; i < length; i++ )
            //sb.append( text.charAt( random.nextInt(text.length()) ) );
        	sb.append(text);
        return sb.toString();

    }
}
