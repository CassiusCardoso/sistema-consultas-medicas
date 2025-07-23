package java.cassius.projeto.spring.consultas_medicas_clean_arch.application.ports.out.senha;

public interface SenhaEncoderPort {
    String encode(String senha);
    boolean matches(String senha, String senhaCodificada);
}
