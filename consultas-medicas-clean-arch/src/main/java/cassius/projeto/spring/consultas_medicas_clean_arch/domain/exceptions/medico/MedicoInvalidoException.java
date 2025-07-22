package java.cassius.projeto.spring.consultas_medicas_clean_arch.domain.exceptions.medico;

public class MedicoInvalidoException extends RuntimeException {
    public MedicoInvalidoException(String message) {
        super(message);
    }
}
