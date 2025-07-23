package cassius.projeto.spring.consultas_medicas_clean_arch.domain.exceptions.paciente;

public class PacienteInvalidoException extends RuntimeException {
    public PacienteInvalidoException(String message) {
        super(message);
    }
}
