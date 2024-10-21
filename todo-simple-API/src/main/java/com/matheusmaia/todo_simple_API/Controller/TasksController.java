package com.matheusmaia.todo_simple_API.Controller;


import com.matheusmaia.todo_simple_API.Model.Task.CadastroTaskDTO;
import com.matheusmaia.todo_simple_API.Model.Task.DadosListagemTasksDTO;
import com.matheusmaia.todo_simple_API.Model.Task.Task;
import com.matheusmaia.todo_simple_API.Model.Task.UpdateTaskDTO;
import com.matheusmaia.todo_simple_API.Repositories.TaskRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;


@RestController
@RequestMapping("tasks")
public class TasksController {

    //Aplicando injeção de dependênicas para conseguir acessar os métodos da classe em questão
    @Autowired
    private TaskRepository taskRepository;


    @PostMapping
    @Transactional
    public ResponseEntity create(@RequestBody @Valid CadastroTaskDTO dados, UriComponentsBuilder uriBuilder){
        var task = new Task(dados);
        taskRepository.save(task); // Salva no BD com o Jpa
        return ResponseEntity.ok(new DadosListagemTasksDTO(task)); //Retorna a Task que o usuário acabou de cadastrar, junto do ID
    }

    @GetMapping
    @Transactional(readOnly = true) //garante que a leitura nao fara nenhuma modificacao no DB, sendo mais segura
    public ResponseEntity readTasks(){
        var allProducts = taskRepository.findAll(); //Busco por todas as tasks com o Jpa
        return ResponseEntity.ok(allProducts); //Retorno no corpo do Body

    }

      @GetMapping("/{id}")
      @Transactional(readOnly = true)
     public ResponseEntity findTaskById(@PathVariable Long id){
            var task = taskRepository.getById(id); //Identifico a Task pesquisada
            var taskRepresentacao = new DadosListagemTasksDTO(task); //Adiciono a referencia dela em um DTO
            return ResponseEntity.ok(taskRepresentacao); //Retorno o DTO com os dados da Task

      }

      @DeleteMapping("/{id}")
      @Transactional
      public ResponseEntity deleteTaskById(@PathVariable Long id){
        var task = taskRepository.getReferenceById(id);
        taskRepository.deleteById(id); //Deleta do BD
        return ResponseEntity.ok("Tarefa excluída!");
      }

      @PutMapping
      @Transactional
      public ResponseEntity updateTask(@RequestBody @Valid UpdateTaskDTO dados){
       var task =  taskRepository.getReferenceById(dados.id()); //Verifica a existência
       task.atualizarInformacoes(dados); //Atualiza os dados
       taskRepository.save(task); //Salva alteração
        return ResponseEntity.ok(new DadosListagemTasksDTO(task)); //Retorno da Task Atualizada


      }


}
