package woowacourse.auth.support;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.springframework.stereotype.Component;

@Component
public class PasswordEncoder {

    private static final String BYTE_TO_HEX = "%02x";
    private static final String HASH_ALGORITHM = "SHA-256";

    public String encode(String password) {
        MessageDigest messageDigest = getMessageDigest();
        messageDigest.update(password.getBytes());
            return bytesToHex(messageDigest.digest());
    }

    private MessageDigest getMessageDigest() {
        try {
            return MessageDigest.getInstance(HASH_ALGORITHM);
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException();
        }
    }

    private String bytesToHex(byte[] bytes) {
        StringBuilder builder = new StringBuilder();
        for (byte oneByte : bytes) {
            builder.append(String.format(BYTE_TO_HEX, oneByte));
        }
        return builder.toString();
    }

}
