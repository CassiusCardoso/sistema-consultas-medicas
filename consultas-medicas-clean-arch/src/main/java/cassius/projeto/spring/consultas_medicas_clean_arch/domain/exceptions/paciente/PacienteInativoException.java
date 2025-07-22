package java.cassius.projeto.spring.consultas_medicas_clean_arch.domain.exceptions.paciente;

public class PacienteInativoException extends RuntimeException {
    public PacienteInativoException(String message) {
        super(message);
    }
}
