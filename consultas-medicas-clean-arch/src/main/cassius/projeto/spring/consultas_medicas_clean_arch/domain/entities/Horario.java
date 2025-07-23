package cassius.projeto.spring.consultas_medicas_clean_arch.domain.entities;

import cassius.projeto.spring.consultas_medicas_clean_arch.domain.enums.StatusHorario;
import cassius.projeto.spring.consultas_medicas_clean_arch.domain.exceptions.horario.DataHoraInicioOuFimInvalidoException;
import cassius.projeto.spring.consultas_medicas_clean_arch.domain.exceptions.horario.HorarioInvalidoException;
import cassius.projeto.spring.consultas_medicas_clean_arch.domain.exceptions.horario.StatusHorarioInvalidoException;
import java.time.LocalDateTime;
import java.util.UUID;

public class Horario {
    private final UUID id;
    private final LocalDateTime dataHoraInicio;
    private final LocalDateTime dataHoraFim;
    private StatusHorario status;
    private final Medico medico;
    private LocalDateTime atualizadoEm;

    public Horario(UUID id, LocalDateTime dataHoraInicio, LocalDateTime dataHoraFim, StatusHorario status, Medico medico, LocalDateTime atualizadoEm){
        if(id == null){
            throw new HorarioInvalidoException("ID do paciente não pode ser nulo.");
        }
        if(dataHoraInicio == null || dataHoraFim == null){
            throw new DataHoraInicioOuFimInvalidoException("Horário de início e horário de fim não podem ser nulos.");
        }


        this.id = id;
        this.dataHoraInicio = dataHoraInicio;
        this.dataHoraFim = dataHoraFim;
        this.status = status;
        this.medico = medico;
        this.atualizadoEm = atualizadoEm;
    }

    public UUID getId() {
        return id;
    }

    public LocalDateTime getDataHoraInicio() {
        return dataHoraInicio;
    }

    public LocalDateTime getDataHoraFim() {
        return dataHoraFim;
    }

    public StatusHorario getStatus() {
        return status;
    }

    public Medico getMedico() {
        return medico;
    }

    public LocalDateTime getAtualizadoEm() {
        return atualizadoEm;
    }

    public void agendar(){
        if(this.status == StatusHorario.BLOQUEADO){
            throw new StatusHorarioInvalidoException("Não é possível agendar uma consulta em um horário bloqueado.");
        }
        if (this.status == StatusHorario.AGENDADO) {
            throw new StatusHorarioInvalidoException("Este horário já foi agendado.");
        }
        this.status = StatusHorario.AGENDADO;
        this.atualizadoEm = LocalDateTime.now();
    }

    public void liberar(){
        if(this.status != StatusHorario.AGENDADO){
            throw new StatusHorarioInvalidoException("Você não pode liberar um horário LIVRE ou BLOQUEADO.");
        }
        this.status = StatusHorario.LIVRE;
        this.atualizadoEm = LocalDateTime.now();
    }

}
