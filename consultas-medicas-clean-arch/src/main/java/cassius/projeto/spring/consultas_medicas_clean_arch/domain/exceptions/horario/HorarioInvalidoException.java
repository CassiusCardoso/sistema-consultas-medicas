package java.cassius.projeto.spring.consultas_medicas_clean_arch.domain.exceptions.horario;

public class HorarioInvalidoException extends RuntimeException {
    public HorarioInvalidoException(String message) {
        super(message);
    }
}
