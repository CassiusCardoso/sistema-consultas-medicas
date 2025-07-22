package java.cassius.projeto.spring.consultas_medicas_clean_arch.domain.exceptions.medico;

public class MedicoStatusIndisponivelException extends RuntimeException {
    public MedicoStatusIndisponivelException(String message) {
        super(message);
    }
}
