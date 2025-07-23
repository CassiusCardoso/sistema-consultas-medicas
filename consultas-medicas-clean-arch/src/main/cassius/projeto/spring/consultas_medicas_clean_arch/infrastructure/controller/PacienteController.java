package cassius.projeto.spring.consultas_medicas_clean_arch.infrastructure.controller;

import cassius.projeto.spring.consultas_medicas_clean_arch.application.dto.request.paciente.CadastrarPacienteRequest;
import cassius.projeto.spring.consultas_medicas_clean_arch.application.dto.response.paciente.PacienteResponse;
import cassius.projeto.spring.consultas_medicas_clean_arch.application.usecases.paciente.CadastrarPacienteUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/pacientes")
@Tag(name = "Paciente", description = "Endpoints para autenticação e gerenciamento do Paciente.")
public class PacienteController {

    private final CadastrarPacienteUseCase  cadastrarPacienteUseCase;

    public PacienteController(CadastrarPacienteUseCase cadastrarPacienteUseCase) {
        this.cadastrarPacienteUseCase = cadastrarPacienteUseCase;
    }

    // - Endpoints

    @PostMapping
    @Operation(summary = "Cadastra um paciente", description = "Cria uma conta de paciente no sistema.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Paciente cadastrado com sucesso", content = @Content(schema = @Schema(implementation = PacienteResponse.class))),
            @ApiResponse(responseCode = "400", description = "Dados inválidos ou CPF/Email já existente", content = @Content)
    })
    public ResponseEntity<PacienteResponse> cadastrar(@RequestBody CadastrarPacienteRequest request){
        PacienteResponse response = cadastrarPacienteUseCase.execute(request);

        // Constrói a URI para o novo paciente criado
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(response.id())
                .toUri();

        // Retorna 201 Created com a location e o corpo da resposta
        return ResponseEntity.created(location).body(response);
    }
}