package com.matheusmaia.todo_simple_API.Controller;


import com.matheusmaia.todo_simple_API.Model.Task.CadastroTask;
import com.matheusmaia.todo_simple_API.Model.Task.DadosListagemTasks;
import com.matheusmaia.todo_simple_API.Model.Task.Task;
import com.matheusmaia.todo_simple_API.Model.Task.UpdateTask;
import com.matheusmaia.todo_simple_API.Repositories.TaskRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.TransactionScoped;
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
    @Transactional //Ajuda no suporte a transações que azem modificações/inserções no BD
    public ResponseEntity create(@RequestBody @Valid CadastroTask dados, UriComponentsBuilder uriBuilder){
        var task = new Task(dados); //Cria um objeto novo com os dados a serem cadastrados
        taskRepository.save(task); // Salva no BD com o Jpa
        return ResponseEntity.ok(new DadosListagemTasks(task)); //Retorna a Task que o usuário acabou de cadastrar, junto do ID
    }

    @GetMapping
    @Transactional(readOnly = true) //garante que a leitura nao fara nenhuma modificacao no DB, sendo mais segura
    public ResponseEntity readTasks(){
        var allProducts = taskRepository.findAll(); //Busco por todas com o Jpa
        return ResponseEntity.ok(allProducts); //Retorno

    }

      @GetMapping("/{id}")
      @Transactional(readOnly = true)
     public ResponseEntity findTaskById(@PathVariable Long id){
            var task = taskRepository.getById(id); //Identifico a Task pesquisada
            var taskRepresentacao = new DadosListagemTasks(task); //Adiciono a referencia dela em um DTO
            return ResponseEntity.ok(taskRepresentacao); //Retorno o DTO com os dados da Task

      }

      @DeleteMapping("/{id}")
      @Transactional
      public ResponseEntity deleteTaskById(@PathVariable Long id){
        var task = taskRepository.getReferenceById(id);
        taskRepository.deleteById(id);
        return ResponseEntity.ok("Tarefa excluída!");
      }

      @PutMapping
      @TransactionScoped
      public ResponseEntity updateTask(@RequestBody @Valid UpdateTask dados){
       var task =  taskRepository.getReferenceById(dados.id());
       task.atualizarInformacoes(dados);
       taskRepository.save(task);
        return ResponseEntity.ok(new DadosListagemTasks(task));


      }


}
