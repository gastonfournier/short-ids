import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import suuid.SUUID;

/**
 * Created by gastonfournier[at]gmail.com on 15/06/17.
 */
public class Base64Range {
    public static void main(String[] args){
        Base64.Encoder encoder = Base64.getEncoder().withoutPadding();
        Integer bt = 0;
        for (int c = 0; c < 256; c++) {
            byte[] bytes = new byte[]{ bt.byteValue() };
            String enc = encoder.encodeToString(bytes);
            System.out.println(bt + ": " + enc + " - " + Integer.toBinaryString(bt));
            bt++;
        }
        // java.lang.IllegalArgumentException: Input byte[] should at least have 2 bytes for base64 bytes
        // AA, AQ, Ag
        byte[] bytes = Base64.getDecoder().decode("Ag");
        for (int i = 0; i < bytes.length; i++) {
            byte b = bytes[i];
            System.out.println(i + ": "+Byte.toString(b));
        }

        byte[] bs = new byte[]{0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0};
        System.out.println(encoder.encodeToString(bs));

        UUID uuid = UUID.randomUUID();
        System.out.println(new Long(uuid.getMostSignificantBits()).byteValue());
        System.out.println(new Long(uuid.getLeastSignificantBits()).byteValue());

    }
}
