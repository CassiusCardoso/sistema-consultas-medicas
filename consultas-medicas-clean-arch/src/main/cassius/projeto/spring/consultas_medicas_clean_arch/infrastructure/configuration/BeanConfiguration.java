package cassius.projeto.spring.consultas_medicas_clean_arch.infrastructure.configuration;

import cassius.projeto.spring.consultas_medicas_clean_arch.application.ports.out.senha.SenhaEncoderPort;
import cassius.projeto.spring.consultas_medicas_clean_arch.infrastructure.security.SenhaEncoderAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class BeanConfiguration {
    // ADICIONE ESTE MÉTODO
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SenhaEncoderPort senhaEncoderPort(PasswordEncoder encoder) {
        return new SenhaEncoderAdapter(encoder);
    }

}

