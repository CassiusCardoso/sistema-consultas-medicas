package cassius.projeto.spring.consultas_medicas_clean_arch.application.dto.response.paciente;

import java.time.LocalDateTime;
import java.util.UUID;

public record PacienteResponse(
        UUID id,
        String nome,
        String cpf,
        String email,
        String plano,
        String status,
        String endereco,
        LocalDateTime criadoEm
) {
}
