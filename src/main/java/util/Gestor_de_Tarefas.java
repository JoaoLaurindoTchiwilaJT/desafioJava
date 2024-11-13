/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package util;

import Entity.Task;
import Entity.Task.TaskStatus;
import Repository.TaskManager;
import java.util.List;

/**
 *
 * @author Tchiwila
 */
public class Gestor_de_Tarefas {

    public static void main(String[] args) {
        List<Task> dados = null;
        
         Task task1 = new Task();
         TaskManager manager = new TaskManager();
        // Task task1 = new Task("Criador Aplicativo","Aplicativo em java gestor de tarefas",LocalDate.now(),LocalDate.of(2024,11,8),TaskStatus.CONCLUIDA);
        // dados = manager.addTask(task1);
        // dados = manager.getListTask();
         dados = manager.getListTaskForStatus(TaskStatus.CONCLUIDA);
        
       // String uuidString = "e271a092-7ce6-47d1-92b5-931fe5a351ab";
        
        //Processo processo = new Processo();
    
        //task1.setId(UUID.fromString(processo.ConvertUUID(uuidString)));
        //dados = manager.deleteTask(id);
       //UUID taskId = task1.getId();  // Obtém o UUID da tarefa

       /*
        task1.setTitulo("Web Developer");
        task1.setDescricao("Criaremos um app");
        task1.setStatus(Task.TaskStatus.CONCLUIDA);
        dados = manager.updateTask(task1);*/
        
        System.out.println(dados);
    }
}
