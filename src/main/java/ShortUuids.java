import suuid.SUUID;

import java.security.SecureRandom;
import java.util.Base64;
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
        String bits = IdUtils.hex2bits(uuidValuesOnly);
        System.out.println(bits + " length: " + bits.length());
        String base64 = IdUtils.bitsToBase64(bits);
        System.out.println(base64 + " length: " + base64.length());

        // test a shorten version of the resource name
        String resource = "Name of resource. This can be very long and contain special characters!! :-s";
        Integer hash = resource.hashCode();
        System.out.println("'" + resource + "' -> " + IdUtils.decimal2base64(hash));

        byte[] randomBytes = new byte[16];
        new SecureRandom().nextBytes(randomBytes);
        randomBytes[6]  &= 0x0f;  /* clear version        */
        randomBytes[6]  |= 0x40;  /* set to version 4     */
        randomBytes[8]  &= 0x3f;  /* clear variant        */
        randomBytes[8]  |= 0x80;  /* set to IETF variant  */

        byte[] data = randomBytes;
        long msb = 0;
        long lsb = 0;
        for (int i = 0; i<8; i++)
            msb = (msb << 8) | (data[i] & 0xff);
        for (int i = 8; i<16; i++)
            lsb = (lsb << 8) | (data[i] & 0xff);

        Base64.Encoder encoder = Base64.getEncoder().withoutPadding();
        UUID randomUuid = new UUID(msb, lsb);
        System.out.println("randomUUID = " +randomUuid.toString());
        String javaB64 = encoder.encodeToString(randomBytes);
        System.out.println(javaB64  + " length: " + javaB64.length());
        base64 = IdUtils.hex2base64(randomUuid.toString().replaceAll("-", ""));
        System.out.println(base64 + " length: " + base64.length());

        SUUID suuid = new SUUID(msb, lsb);
        System.out.println("suuid: " + suuid + " length: " + suuid.toString().length());

        System.out.println(toStringUuid(uuid));
    }

    private static String toStringUuid(UUID uuid) {
        // mostSigBits >> 32 removes the 32 least significant bits
        long mostSigBits = uuid.getMostSignificantBits();
        long leastSigBits = uuid.getLeastSignificantBits();
        return (digits(mostSigBits >> 32, 8) + "-" +
                digits(mostSigBits >> 16, 4) + "-" +
                digits(mostSigBits, 4) + "-" +
                digits(leastSigBits >> 48, 4) + "-" +
                digits(leastSigBits, 12));
    }

    /** Returns val represented by the specified number of hex digits. */
    private static String digits(long val, int digits) {
        // this hi is because if val is less than digits, then it'll get cut off
        // ex if you need 4 digits but you're given the number 1, its hex representation
        // will be just 1 and not 0001. The trick is to represent 10001 and then remove the
        // first 1
        long hi = 1L << (digits * 4);
        // if hi is 10000b then hi - 1 is 1111b
        // doing val & (hi - 1) leaves only the important bits
        // if val is     11010011
        // then hi is        1111
        // and the result is 0011
        // so we'll calculate the hexString of 10011 which results in 13
        // then we remove the first 1 of 13 and we end with 3 the actual hex value
        // (equally decimal value)
        return Long.toHexString(hi | (val & (hi - 1))).substring(1);
    }

}
