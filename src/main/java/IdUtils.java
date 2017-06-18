/**
 * Created by gastonfournier[at]gmail.com on 15/06/17.
 */
public class IdUtils {
    // this alphabet is taken from Base64.Encoder.toBase64URL private variable
    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_";
    public static boolean DEBUG = false;

    public static String hex2bits(String hexString) {
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < hexString.length(); i++) {
            char hexCharacter = hexString.charAt(i);
            // convert hex 2 decimal
            Integer value = Integer.parseInt(String.valueOf(hexCharacter), 16);
            String binString = Integer.toBinaryString(value);
            // complete with zeros padding left
            String formattedBinString = String.format("%04d", Integer.parseInt(binString));
            result.append(formattedBinString);
            if (DEBUG) {
                System.out.println(String.format("%s -> %2d -> %s", hexCharacter, value, formattedBinString));
            }
        }
        return result.toString();
    }

    public static String bitsToBase64(String bits) {
        int length = bits.length();
        int pad = getPad(length);
        String paddedBits = String.format("%" + (length + pad) + "s", bits).replace(' ', '0');
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < paddedBits.length() ; i += 6) {
            String sixBits = paddedBits.substring(i, i + 6);
            Integer decimalValue = Integer.parseInt(sixBits, 2);
            char base64Character = ALPHABET.charAt(decimalValue);
            result.append(base64Character);
            if (DEBUG) {
                System.out.println(sixBits + " -> " + decimalValue + " -> " + base64Character);
            }
        }
        return result.toString();
    }

    protected static int getPad(int length) {
        int pad = 6 - (length % 6);
        if (pad == 6) {
            return 0; // instead of adding 6 digits add none
        } else {
            return pad;
        }
    }

    public static String decimal2base64(Integer number) {
        String bits = Integer.toBinaryString(number);
        if (DEBUG){
            System.out.println(number + " -> " + bits);
        }
        return bitsToBase64(bits);
    }

    public static String hex2base64(String hexString) {
        return bitsToBase64(hex2bits(hexString));
    }
}
