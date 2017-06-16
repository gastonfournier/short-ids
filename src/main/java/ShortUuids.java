import java.util.UUID;

/**
 * Created by gastonfournier[at]gmail.com on 15/06/17.
 */
public class ShortUuids {
    public static void main(String[] args){
        UUID uuid = UUID.randomUUID();
        System.out.println(uuid + " length: " + uuid.toString().length());
        String uuidValuesOnly = uuid.toString().replaceAll("-", "");
        System.out.println(uuidValuesOnly + " length: " + uuidValuesOnly.length());
        String bits = HexUtils.hex2bits(uuidValuesOnly);
        System.out.println(bits + " length: " + bits.length());
        String base64 = HexUtils.bitsToBase64(bits);
        System.out.println(base64 + " length: " + base64.length());
    }
}
