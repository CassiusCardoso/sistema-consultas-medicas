package cassius.projeto.spring.consultas_medicas_clean_arch.domain.exceptions.horario;

public class StatusHorarioInvalidoException extends RuntimeException {
    public StatusHorarioInvalidoException(String message) {
        super(message);
    }
}
