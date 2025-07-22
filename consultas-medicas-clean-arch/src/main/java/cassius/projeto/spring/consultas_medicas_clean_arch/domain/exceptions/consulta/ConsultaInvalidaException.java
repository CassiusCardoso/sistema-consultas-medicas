package java.cassius.projeto.spring.consultas_medicas_clean_arch.domain.exceptions.consulta;

public class ConsultaInvalidaException extends RuntimeException {
    public ConsultaInvalidaException(String message) {
        super(message);
    }
}
