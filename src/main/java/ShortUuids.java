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

    }
}
