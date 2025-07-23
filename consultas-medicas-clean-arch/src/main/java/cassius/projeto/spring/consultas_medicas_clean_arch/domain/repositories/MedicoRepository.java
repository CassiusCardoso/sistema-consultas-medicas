package java.cassius.projeto.spring.consultas_medicas_clean_arch.domain.repositories;

import java.cassius.projeto.spring.consultas_medicas_clean_arch.domain.entities.Medico;
import java.cassius.projeto.spring.consultas_medicas_clean_arch.domain.enums.StatusMedico;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface MedicoRepository {
    Medico salvar(Medico medico);
    Optional<Medico> buscarPorId(UUID medicoId);
    Optional<Medico> buscarPorCrm(String crm);
    Optional<Medico> buscarPorEmail(String email);
    List<Medico> buscarPorNome(String nome);
    List<Medico> buscarPorStatus(StatusMedico status);
    List<Medico> buscarTodos();
}
