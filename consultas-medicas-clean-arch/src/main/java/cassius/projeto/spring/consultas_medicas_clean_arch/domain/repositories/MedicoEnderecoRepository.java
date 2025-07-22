package java.cassius.projeto.spring.consultas_medicas_clean_arch.domain.repositories;

import java.cassius.projeto.spring.consultas_medicas_clean_arch.domain.entities.MedicoEndereco;
import java.util.Optional;
import java.util.UUID;

public interface MedicoEnderecoRepository {
    MedicoEndereco salvar(MedicoEndereco medicoEndereco);
    Optional<MedicoEndereco> buscarPorId(UUID medicoEnderecoId);
    Optional<MedicoEndereco> buscarPorMedicoId(UUID medicoId);
    Optional<MedicoEndereco> buscarPorCep(String cep);
    Optional<MedicoEndereco> buscarPorMedico(UUID medicoId);
}
