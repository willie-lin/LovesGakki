package com.gakki.love;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.security.SecureRandom;


@Slf4j
public class EncryptTest {

    @Test
    public void testEncryTest() {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10, new SecureRandom("love".getBytes()));

        log.debug(encoder.encode("Gakki"));
    }
}
