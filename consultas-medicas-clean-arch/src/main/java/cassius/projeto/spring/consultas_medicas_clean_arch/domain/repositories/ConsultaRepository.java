package java.cassius.projeto.spring.consultas_medicas_clean_arch.domain.repositories;

import java.cassius.projeto.spring.consultas_medicas_clean_arch.domain.entities.Consulta;
import java.cassius.projeto.spring.consultas_medicas_clean_arch.domain.enums.StatusConsulta;
import java.util.Optional;
import java.util.UUID;

public interface ConsultaRepository {
    Consulta salvar (Consulta consulta);
    Optional<Consulta> buscarConsultaPorId(UUID consultaId);
    Optional<Consulta> buscarConsultaPorMedicoId(UUID medicoId);
    Optional<Consulta> buscarConsultaPorPacienteId(UUID pacienteId);
    Optional<Consulta> buscarConsultaPorStatus(StatusConsulta status);
    Optional<Consulta> buscarConsultaPorEndereco(UUID medicoEnderecoId);
}
