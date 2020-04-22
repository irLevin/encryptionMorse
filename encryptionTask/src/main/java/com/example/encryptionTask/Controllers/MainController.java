package com.example.encryptionTask.Controllers;

import Core.MethodEncryptDecrypt;
import Core.Morse;
import Utils.MethodsEnums;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class MainController {
    static List<String> encryptionTypes;
    static List<String> decryptionTypes;

    static {
        encryptionTypes = Arrays.stream(MethodsEnums.TypesEncryption.values())
                .map(MethodsEnums.TypesEncryption::name)
                .collect(Collectors.toList());
        decryptionTypes = Arrays.stream(MethodsEnums.TypesDecryption.values())
                .map(MethodsEnums.TypesDecryption::name)
                .collect(Collectors.toList());
    }

    /* home page */
    @GetMapping("/")
    public String main(Map<String, Object> model) {
        model.put("encryptionTypes", encryptionTypes);
        model.put("decryptionTypes", decryptionTypes);
        return "main";
    }

    /* encryption request */
    @GetMapping("encryption")
    public String encryptString(Map<String, Object> model,
                                @RequestParam String encryptStr,
                                @RequestParam String encryptionType) {
        if (!encryptionType.isEmpty() && !encryptStr.isEmpty()) {
            if (encryptionType.equalsIgnoreCase(MethodsEnums.TypesEncryption.Morse.name())) {
                MethodEncryptDecrypt method = new Morse(encryptionType);
                model.put("resultEncrypt", method.encrypt(encryptStr));
            }
        } else {
            model.put("resultEncrypt", "String and Encryption type should be provided.");
        }
        model.put("encryptionTypes", encryptionTypes);
        model.put("decryptionTypes", decryptionTypes);
        return "main";
    }

    /* decryption request */
    @GetMapping("decryption")
    public String decryptString(Map<String, Object> model,
                                @RequestParam String decryptStr,
                                @RequestParam String decryptionType) {
        if (!decryptionType.isEmpty() && !decryptStr.isEmpty()) {
            if (decryptionType.equalsIgnoreCase(MethodsEnums.TypesEncryption.Morse.name())) {
                MethodEncryptDecrypt method = new Morse(decryptionType);
                model.put("resultDecrypt", method.decrypt(decryptStr));
            }
        } else {
            model.put("resultDecrypt", "String and Decryption type should be provided.");
        }
        model.put("encryptionTypes", encryptionTypes);
        model.put("decryptionTypes", decryptionTypes);
        return "main";
    }
}
