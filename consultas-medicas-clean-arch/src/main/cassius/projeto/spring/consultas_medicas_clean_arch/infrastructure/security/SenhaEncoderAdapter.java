package cassius.projeto.spring.consultas_medicas_clean_arch.infrastructure.security;

import cassius.projeto.spring.consultas_medicas_clean_arch.application.ports.out.senha.SenhaEncoderPort;
import org.springframework.security.crypto.password.PasswordEncoder;

public class SenhaEncoderAdapter implements SenhaEncoderPort {
    private final PasswordEncoder encoder;
    public SenhaEncoderAdapter(PasswordEncoder encoder) {
        this.encoder = encoder;
    }

    @Override
    public String encode(String senha) {
        return encoder.encode(senha);
    }

    @Override
    public boolean matches(String senhaBruta, String senhaCodificada){
        return  encoder.matches(senhaBruta, senhaCodificada);
    }

}
