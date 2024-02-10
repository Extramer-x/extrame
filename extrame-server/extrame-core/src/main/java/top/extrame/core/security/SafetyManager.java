package top.extrame.core.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import top.extrame.common.util.RSAUtils;
import top.extrame.core.config.RsaProperties;

import java.security.KeyPair;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.Base64;

@Component
public class SafetyManager {

    private final KeyPair rsaKeyPair;

    @Autowired
    public SafetyManager(RsaProperties rsaProperties) {
        rsaKeyPair = RSAUtils.generateRSAKeyPair(rsaProperties.getSize());
    }

    public final RSAPublicKey getRsaPublicKey() {
        return (RSAPublicKey) this.rsaKeyPair.getPublic();
    }
    public final String getBase64RsaPublicKey() {
        return Base64.getEncoder().encodeToString(this.rsaKeyPair.getPublic().getEncoded());
    }
    public final RSAPrivateKey getRsaPrivetKey() {
        return (RSAPrivateKey) this.rsaKeyPair.getPrivate();
    }
    public final String  getBase64RsaPrivetKey() {
        return Base64.getEncoder().encodeToString(this.rsaKeyPair.getPrivate().getEncoded());
    }
}
