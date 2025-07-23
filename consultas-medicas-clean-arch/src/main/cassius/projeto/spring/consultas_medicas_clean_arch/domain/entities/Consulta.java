package cassius.projeto.spring.consultas_medicas_clean_arch.domain.entities;

import cassius.projeto.spring.consultas_medicas_clean_arch.domain.enums.StatusConsulta;
import cassius.projeto.spring.consultas_medicas_clean_arch.domain.exceptions.consulta.ConsultaHorarioInvalidoException;
import cassius.projeto.spring.consultas_medicas_clean_arch.domain.exceptions.consulta.ConsultaInvalidaException;
import cassius.projeto.spring.consultas_medicas_clean_arch.domain.exceptions.consulta.ConsultaStatusInvalidoException;
import java.time.LocalDateTime;
import java.util.UUID;

public class Consulta {
    private final UUID id;
    private StatusConsulta status;
    private final LocalDateTime criadaEm;
    private LocalDateTime atualizadaEm;
    private final Medico medico;
    private final Paciente paciente;
    private final Horario horario;
    private final MedicoEndereco medicoEndereco;

    public Consulta(UUID id, StatusConsulta status, LocalDateTime criadaEm, LocalDateTime atualizadaEm, Medico medico, Paciente paciente, Horario horario, MedicoEndereco medicoEndereco){
        if(id == null){
            throw new ConsultaInvalidaException("ID do paciente não pode ser nulo.");
        }
        if(status == null){
            throw new ConsultaStatusInvalidoException("Status da consulta não pode ser nulo.");
        }
        this.id = id;
        this.status = status;
        this.criadaEm = criadaEm;
        this.atualizadaEm = atualizadaEm;
        this.medico = medico;
        this.paciente = paciente;
        this.horario = horario;
        this.medicoEndereco = medicoEndereco;
    }

    public UUID getId() {
        return id;
    }

    public StatusConsulta getStatus() {
        return status;
    }

    public LocalDateTime getCriadaEm() {
        return criadaEm;
    }

    public LocalDateTime getAtualizadaEm() {
        return atualizadaEm;
    }

    public Medico getMedico() {
        return medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public Horario getHorario() {
        return horario;
    }

    public MedicoEndereco getMedicoEndereco() {
        return medicoEndereco;
    }

    // Cancelar uma consulta
    public void cancelar(){
        if(this.horario.getDataHoraInicio().isBefore(LocalDateTime.now().plusHours(24))){
            throw new ConsultaHorarioInvalidoException("Consultas só podem ser canceladas com mais de 24h de antecedência.");
        }
        if(this.status == StatusConsulta.REALIZADA){
            throw new ConsultaStatusInvalidoException("Não é possível cancelar uma consulta realizada.");
        }
        if(this.status == StatusConsulta.CANCELADA){
            throw new ConsultaStatusInvalidoException("Não é possível cancelar uma consulta já cancelada.");
        }

        this.status = StatusConsulta.CANCELADA;
        this.atualizadaEm = LocalDateTime.now();
        this.horario.liberar();
    }

    public void finalizar(){
        if(this.status == StatusConsulta.CANCELADA){
            throw new ConsultaStatusInvalidoException("Não é possível finalizar uma consulta cancelada.");
        }
        if(this.horario.getDataHoraInicio().isAfter(LocalDateTime.now())){
            throw new ConsultaHorarioInvalidoException("Não é possível finalizar que ainda não ocorreu.");
        }

        this.status = StatusConsulta.REALIZADA;
        this.atualizadaEm = LocalDateTime.now();
    }

}
