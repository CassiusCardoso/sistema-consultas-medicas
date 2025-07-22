package java.cassius.projeto.spring.consultas_medicas_clean_arch.domain.repositories;

import java.cassius.projeto.spring.consultas_medicas_clean_arch.domain.entities.Paciente;
import java.cassius.projeto.spring.consultas_medicas_clean_arch.domain.enums.StatusPaciente;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PacienteRepository {
    Paciente salvar(Paciente paciente);
    Optional<Paciente> buscarPorCpf(String cpf);
    Optional<Paciente> buscarPorId(UUID pacienteId);
    List<Paciente> buscarTodos();
    Optional<Paciente> buscarPorEmail(String email);
    Optional<Paciente> buscarPorNome(String nome);
    Optional<Paciente> buscarPorAtivo(StatusPaciente ativo);
}
