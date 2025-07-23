package cassius.projeto.spring.consultas_medicas_clean_arch.domain.exceptions.consulta;

public class ConsultaStatusInvalidoException extends RuntimeException {
    public ConsultaStatusInvalidoException(String message) {
        super(message);
    }
}
