package cassius.projeto.spring.consultas_medicas_clean_arch.application.usecases.paciente;

import cassius.projeto.spring.consultas_medicas_clean_arch.application.dto.request.paciente.CadastrarPacienteRequest;
import cassius.projeto.spring.consultas_medicas_clean_arch.application.dto.response.paciente.PacienteResponse;
import cassius.projeto.spring.consultas_medicas_clean_arch.application.mapper.PacienteMapper;
import cassius.projeto.spring.consultas_medicas_clean_arch.application.ports.out.senha.SenhaEncoderPort;
import cassius.projeto.spring.consultas_medicas_clean_arch.domain.entities.Paciente;
import cassius.projeto.spring.consultas_medicas_clean_arch.domain.enums.Plano;
import cassius.projeto.spring.consultas_medicas_clean_arch.domain.enums.StatusPaciente;
import cassius.projeto.spring.consultas_medicas_clean_arch.domain.repositories.PacienteRepository;
import cassius.projeto.spring.consultas_medicas_clean_arch.domain.valueobjects.Cpf;
import cassius.projeto.spring.consultas_medicas_clean_arch.domain.valueobjects.Email;
import cassius.projeto.spring.consultas_medicas_clean_arch.domain.valueobjects.Endereco;
import cassius.projeto.spring.consultas_medicas_clean_arch.domain.valueobjects.Senha;

import java.time.LocalDateTime;
import java.util.UUID;

public class CadastrarPacienteUseCase {
    private final PacienteRepository pacienteRepository;
    private final PacienteMapper mapper;
    private final SenhaEncoderPort encoder;

    public CadastrarPacienteUseCase(PacienteRepository pacienteRepository, PacienteMapper mapper, SenhaEncoderPort encoder) {
        this.pacienteRepository = pacienteRepository;
        this.mapper = mapper;
        this.encoder = encoder;
    }

    public PacienteResponse execute(CadastrarPacienteRequest request) {
        pacienteRepository.buscarPorEmail(request.email()).ifPresent(
                p -> {
                    throw new IllegalArgumentException("Email já cadastrado.");
                });
        pacienteRepository.buscarPorCpf(request.cpf()).ifPresent(
                p -> {
                    throw new IllegalArgumentException("CPF já cadastrado.");
                });
        Cpf cpf = new Cpf(request.cpf());
        Email email = new Email(request.email());
        Endereco endereco = new Endereco(
                request.endereco().logradouro(),
                request.endereco().numero(),
                request.endereco().bairro(),
                request.endereco().cidade(),
                request.endereco().uf(),
                request.endereco().cep()
        );

        // SENHA
        Senha.validarFormato(request.senha());

        String senhaCodificada = encoder.encode(request.senha());

        Senha senhaSegura = Senha.carregar(senhaCodificada);

        Plano planoEnum;
        try{
            // valueOf() converte String ("BASICO") PARA O enum Plano
            // toUpperCase() garante que a conversão funcione mesmo se o request vier em minúsculas.
            planoEnum = Plano.valueOf(request.plano().toUpperCase());
        }catch(IllegalArgumentException e ){
            throw new IllegalArgumentException("Plano inválido: " + request.plano());
        }

        Paciente pacienteNovo = new Paciente(
                UUID.randomUUID(),
                request.nome(),
                cpf,
                email,
                senhaSegura,
                planoEnum,
                StatusPaciente.ATIVO,
                endereco,
                LocalDateTime.now(),
                LocalDateTime.now()
        );

        Paciente pacienteSalvo = pacienteRepository.salvar(pacienteNovo);
        return mapper.toResponse(pacienteSalvo);
    }
}
