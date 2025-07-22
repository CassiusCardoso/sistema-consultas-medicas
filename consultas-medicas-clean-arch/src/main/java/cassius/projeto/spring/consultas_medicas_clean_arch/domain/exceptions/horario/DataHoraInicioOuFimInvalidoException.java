package java.cassius.projeto.spring.consultas_medicas_clean_arch.domain.exceptions.horario;

public class DataHoraInicioOuFimInvalidoException extends RuntimeException {
    public DataHoraInicioOuFimInvalidoException(String message) {
        super(message);
    }
}
