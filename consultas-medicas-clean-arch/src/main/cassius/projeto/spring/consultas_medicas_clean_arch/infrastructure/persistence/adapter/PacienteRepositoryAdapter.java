package cassius.projeto.spring.consultas_medicas_clean_arch.infrastructure.persistence.adapter;

import cassius.projeto.spring.consultas_medicas_clean_arch.domain.entities.Paciente;
import cassius.projeto.spring.consultas_medicas_clean_arch.domain.enums.StatusPaciente;
import cassius.projeto.spring.consultas_medicas_clean_arch.domain.repositories.PacienteRepository;
import cassius.projeto.spring.consultas_medicas_clean_arch.infrastructure.persistence.jpa.PacienteRepositoryJpa;
import cassius.projeto.spring.consultas_medicas_clean_arch.infrastructure.persistence.mapper.PacientePersistenceMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class PacienteRepositoryAdapter implements PacienteRepository {
    private final PacienteRepositoryJpa jpaRepository;
    private final PacientePersistenceMapper mapper;

    public PacienteRepositoryAdapter(PacienteRepositoryJpa jpaRepository, PacientePersistenceMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public Paciente salvar(Paciente paciente){
        var model = mapper.toModel(paciente);
        var pacienteSalvo = jpaRepository.save(model);
        return mapper.toDomain(pacienteSalvo);
    }

    @Override
    public Optional<Paciente> buscarPorId(UUID pacienteId){
        return jpaRepository.findById(pacienteId).map(mapper::toDomain);
    }

    @Override
    public List<Paciente> buscarTodos(){
        return jpaRepository.findAll().stream().map(mapper::toDomain).collect(Collectors.toList());
    }

    @Override
    public Optional<Paciente> buscarPorCpf(String cpf){
        return jpaRepository.findByCpf(cpf).map(mapper::toDomain);
    }

    @Override
    public Optional<Paciente> buscarPorEmail(String email){
        return jpaRepository.findByEmail(email).map(mapper::toDomain);
    }

    @Override
    public List<Paciente> buscarPorNome(String nome){
        return jpaRepository.findByNome(nome).stream().map(mapper::toDomain).collect(Collectors.toList());
    }

    @Override
    public List<Paciente> buscarPorStatus(StatusPaciente status){
        return jpaRepository.findByStatus(status).stream().map(mapper::toDomain).collect(Collectors.toList());
    }



}
