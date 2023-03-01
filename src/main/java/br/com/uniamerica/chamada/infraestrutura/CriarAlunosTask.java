package br.com.uniamerica.chamada.infraestrutura;

import br.com.uniamerica.chamada.entity.Aluno;
import br.com.uniamerica.chamada.entity.Turma;
import br.com.uniamerica.chamada.repository.AlunoRepository;
import br.com.uniamerica.chamada.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Eduardo Sganderla
 *
 * @version 1.0.0, 28/02/2023
 * @since 1.0.0
 */
@Order(3)
@Component
public class CriarAlunosTask implements InitialTask {

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private TurmaRepository turmaRepository;

    /**
     *
     */
    @Override
    public void perform() {

        final Turma turma = this.turmaRepository.getReferenceById(1L);
        final List<Aluno> alunos = new ArrayList<Aluno>();

        alunos.add( new Aluno(504471, "Ademar Ramalho de Souza Neto", turma));
        alunos.add( new Aluno(504473, "Adilson Cury Neto", turma));
        alunos.add( new Aluno(503908, "Andre Gabriel Chang", turma));
        alunos.add( new Aluno(504650, "Andre Mai Velasco", turma));
        alunos.add( new Aluno(504040, "Andrei Gregori Back", turma));
        alunos.add( new Aluno(504220, "Anthony Gabriel Kuhnen Rodrigues", turma));
        alunos.add( new Aluno(504652, "Arthur Henrique Vieira Busanello", turma));
        alunos.add( new Aluno(504381, "Augusto Leão Soares", turma));
        alunos.add( new Aluno(503879, "Bouchra Assad Akl", turma));
        alunos.add( new Aluno(503889, "Camila Busnello", turma));
        alunos.add( new Aluno(500658, "Carlos de Mello Feliponi", turma));
        alunos.add( new Aluno(502998, "Cassiano Eduardo Balduino", turma));
        alunos.add( new Aluno(504169, "Cleyton da Silva Pires", turma));
        alunos.add( new Aluno(504250, "Cristovão Martins de Souza", turma));
        alunos.add( new Aluno(504211, "Donizeti dos Santos Junior", turma));
        alunos.add( new Aluno(504390, "Douglas Felipe de Oliveira", turma));
        alunos.add( new Aluno(504311, "Eduardo Souza", turma));
        alunos.add( new Aluno(503880, "Emílio Anastácio de Paula Correa", turma));
        alunos.add( new Aluno(504228, "Erick Rafael Nascimento Ojeda", turma));
        alunos.add( new Aluno(504496, "Frederico Enzo Pinheiro Peiter", turma));
        alunos.add( new Aluno(504506, "Gabriel da Cruz Bogo", turma));
        alunos.add( new Aluno(503155, "Gabriel Ruiz Mussi Bersot", turma));
        alunos.add( new Aluno(503982, "Gabriel Sottomaior Albuquerque", turma));
        alunos.add( new Aluno(503504, "Gabriel Wisniewski", turma));
        alunos.add( new Aluno(504320, "Gabriele Steinmetz", turma));
        alunos.add( new Aluno(504321, "Guilherme Cunha da Cruz", turma));
        alunos.add( new Aluno(504110, "Guilherme Narde da Lapa", turma));
        alunos.add( new Aluno(503997, "Gustavo Eduardo Müller Francisquina", turma));
        alunos.add( new Aluno(504117, "Gustavo Piegat Glizt da Silva", turma));
        alunos.add( new Aluno(504116, "Hasan Cayed Essaad", turma));
        alunos.add( new Aluno(504514, "Henrique Luiz Monteiro do Nascimento", turma));
        alunos.add( new Aluno(504240, "Hisham Esbier", turma));
        alunos.add( new Aluno(504230, "Homam Alsuyoufi", turma));
        alunos.add( new Aluno(503957, "Jean Felipe Moschen Buss", turma));
        alunos.add( new Aluno(504346, "João Victor Guillen", turma));
        alunos.add( new Aluno(504620, "José da Rosa Silveira Junior", turma));
        alunos.add( new Aluno(504088, "Josimar Henrique de Oliveira", turma));
        alunos.add( new Aluno(504038, "Kaue Sanches Gonçalves", turma));
        alunos.add( new Aluno(504185, "Leonardo Ramos Calegario", turma));
        alunos.add( new Aluno(504493, "Lucas Adriano Ferreira Gimenez", turma));
        alunos.add( new Aluno(504157, "Lucas Eduardo Alvez de Quadros", turma));
        alunos.add( new Aluno(504033, "Luis Eduardo Rodriguez Romero", turma));
        alunos.add( new Aluno(504237, "Luiz Roberto Henz", turma));
        alunos.add( new Aluno(502567, "Marcelo Nicolas Lujan Villalba", turma));
        alunos.add( new Aluno(503929, "Matheus El Marge Paes Santos", turma));
        alunos.add( new Aluno(504297, "Matheus Germano Pedroso Krohn", turma));
        alunos.add( new Aluno(504414, "Matheus Guilherme de Almeida", turma));
        alunos.add( new Aluno(504069, "Matheus Henrique Almeida", turma));
        alunos.add( new Aluno(504435, "Matheus Pereira Aguiar", turma));
        alunos.add( new Aluno(503940, "Matheus Ricardo Lopes da Silva", turma));
        alunos.add( new Aluno(504371, "Nestor Ulises Alcaraz", turma));
        alunos.add( new Aluno(504008, "Nicolas Yuji Aoyama", turma));
        alunos.add( new Aluno(502020, "Oliver João de Godoi", turma));
        alunos.add( new Aluno(503928, "Pablo Luis Lara Garcia", turma));
        alunos.add( new Aluno(504170, "Pedro Bulla Lima", turma));
        alunos.add( new Aluno(503871, "Pedro Henrique de Andrade Salvaro", turma));
        alunos.add( new Aluno(504372, "Pedro Henrique Klaus Santos", turma));
        alunos.add( new Aluno(503226, "Pedro Henrique Vieira de Oliveira", turma));
        alunos.add( new Aluno(504638, "Rafael Cherman Traczinski", turma));
        alunos.add( new Aluno(504244, "Reginaldo Santos Gomes", turma));
        alunos.add( new Aluno(504611, "Roberto Vinicius Passos Moreira de Lima", turma));
        alunos.add( new Aluno(504621, "Rubens Miguel Hablich do Prado", turma));
        alunos.add( new Aluno(504416, "Samir Charleston Barbosa Antunes", turma));
        alunos.add( new Aluno(504426, "Samuel Heidner Gomes Medeiros Leal", turma));
        alunos.add( new Aluno(504422, "Scheligan Gabriele Monzon", turma));
        alunos.add( new Aluno(504423, "Tailyne Bertoncelli", turma));
        alunos.add( new Aluno(504364, "Thiago Cavalcante de Oliveira", turma));
        alunos.add( new Aluno(503835, "Vinicius Gabriel Aquino Ferreira", turma));

        this.alunoRepository.saveAll(alunos);
    }
}
