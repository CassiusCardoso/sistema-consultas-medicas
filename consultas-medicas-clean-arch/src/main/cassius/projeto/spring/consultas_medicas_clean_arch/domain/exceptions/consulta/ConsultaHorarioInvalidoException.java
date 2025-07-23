package cassius.projeto.spring.consultas_medicas_clean_arch.domain.exceptions.consulta;

public class ConsultaHorarioInvalidoException extends RuntimeException {
    public ConsultaHorarioInvalidoException(String message) {
        super(message);
    }
}
