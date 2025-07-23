package cassius.projeto.spring.consultas_medicas_clean_arch.domain.repositories;

import cassius.projeto.spring.consultas_medicas_clean_arch.domain.entities.Consulta;
import cassius.projeto.spring.consultas_medicas_clean_arch.domain.enums.StatusConsulta;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ConsultaRepository {
    Consulta salvar (Consulta consulta);
    Optional<Consulta> buscarConsultaPorId(UUID consultaId);
    List<Consulta> buscarConsultaPorMedicoId(UUID medicoId);
    List<Consulta> buscarConsultaPorPacienteId(UUID pacienteId);
   List<Consulta> buscarConsultaPorStatus(StatusConsulta status);
    List<Consulta> buscarConsultaPorEndereco(UUID medicoEnderecoId);
}
