/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Repository;

import Entity.Task;
import jakarta.validation.ConstraintViolationException;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.jupiter.api.DisplayName;

/**
 *
 * @author Tchiwila
 */
public class TaskManagerTest {
    
    private Task task;
    private EntityManagerFactory Factory;
    private EntityManager manager;
    private List<Task> sql;
    
    
    public TaskManagerTest() {
    }
    

    
    @BeforeClass
    public static void setUpClass() {
         
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
         task = new Task();
         Factory = Persistence.createEntityManagerFactory("desafio");
         manager = Factory.createEntityManager();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addTask method, of class TaskManager.
     */
    @Test
    @DisplayName("Deve adicionar uma task")
    public void testAddTask() {
       task.setTitulo("Cristec pro tem que melhorar");
       task.setDescricao("Não será facil mais iremos conseguir");
       task.setDataCriacao(LocalDate.MIN);
       task.setDataConclusao(LocalDate.EPOCH);
       task.setStatus(Task.TaskStatus.PENDENTE);
       
       manager.getTransaction().begin();
       manager.persist(task);
       manager.getTransaction().commit();
       sql = manager.createQuery("SELECT t FROM Task t",Task.class).getResultList();
       

        assertEquals(1, sql.size());
    }
    
    @Test
    @DisplayName("Não deve adicionar uma task com um campo vazio")
    public void testNotAddTask() {
            boolean validate = false ;
            task.setTitulo(""); // Deixe o campo 'titulo' vazio
            task.setDescricao("Não será facil mais iremos conseguir");
            task.setDataCriacao(LocalDate.MIN);
            task.setDataConclusao(LocalDate.EPOCH);

            try {
                               
                    manager.getTransaction().begin();
                    manager.persist(task);
                    manager.getTransaction().commit();
                    assertThrows(IllegalArgumentException.class, () -> {boolean validation = task.validation("Lugar", "", LocalDate.MIN, LocalDate.EPOCH, Task.TaskStatus.PENDENTE);
                    });
                    
            } catch (ConstraintViolationException e) {
                // A exceção é esperada quando a validação falha
                JOptionPane.showMessageDialog(null,"Erro de validação: " + e.getMessage());
            }
            
            
    }

    
    /**
     * Test of updateTask method, of class TaskManager.
     */
    @Test
    @DisplayName("Deve actualizar uma task existente ")
    public void testUpdateTask() {
       
      // Primeiro, insira a tarefa no banco de dados
    task.setTitulo("Tarefa original");
    task.setDescricao("Descrição original");
    task.setDataCriacao(LocalDate.MIN);
    task.setDataConclusao(LocalDate.EPOCH);
    task.setStatus(Task.TaskStatus.PENDENTE);

    manager.getTransaction().begin();
    manager.persist(task);
    manager.getTransaction().commit();

    // Agora recupere a tarefa com o ID gerado
    Task existingTask = manager.find(Task.class, task.getId());
    assertNotNull("A tarefa deve existir no banco de dados.", existingTask);

    // Modifique os atributos
    manager.getTransaction().begin();
    existingTask.setTitulo("Tarefa atualizada");
    existingTask.setDescricao("Descrição atualizada");
    existingTask.setStatus(Task.TaskStatus.CONCLUIDA);
    manager.getTransaction().commit();

    // Recupere a tarefa novamente para verificar se a atualização foi bem-sucedida
    Task updatedTask = manager.find(Task.class, task.getId());

    // Valide que as mudanças foram aplicadas
    assertEquals("O título não foi atualizado corretamente.", "Tarefa atualizada", updatedTask.getTitulo());
    assertEquals("A descrição não foi atualizada corretamente.", "Descrição atualizada", updatedTask.getDescricao());
    assertEquals("O status não foi atualizado corretamente.", Task.TaskStatus.CONCLUIDA.name(), updatedTask.getStatus());
    
    }

    /**
     * Test of deleteTask method, of class TaskManager.
     */
    @Test
    @DisplayName("Deve deletar uma task")
    public void testDeleteTask() {
        // Primeiro, insira a tarefa no banco de dados
        task.setTitulo("Tarefa original");
        task.setDescricao("Descrição original");
        task.setDataCriacao(LocalDate.MIN);
        task.setDataConclusao(LocalDate.EPOCH);
        task.setStatus(Task.TaskStatus.PENDENTE);

        manager.getTransaction().begin();
        manager.persist(task);
        manager.getTransaction().commit();
    
        //Agora recupere a Tarefa com id
        Task existingTask = manager.find(Task.class, task.getId());
        assertNotNull("A tarefa deve existir no banco de dados.", existingTask);
        System.out.println(existingTask);
        
        manager.getTransaction().begin();
        manager.remove(existingTask);
        manager.getTransaction().commit();
        
        //Verifique se a task foi removida
        Task existiTask = manager.find(Task.class, task.getId());
        System.out.println(existiTask);
        assertNull("A tarefa deve existir no banco de dados.", existiTask);
   
    }

    /**
     * Test of getListTask method, of class TaskManager.
     */
    @Test
    @DisplayName("Deve buscar pelo menos uma task")
    public void testGetListTask() {
        // Insere uma tarefa para garantir que temos pelo menos uma tarefa no banco
        task.setTitulo("Tarefa 1");
        task.setDescricao("Descrição da tarefa 1");
        task.setDataCriacao(LocalDate.MIN);
        task.setDataConclusao(LocalDate.EPOCH);
        task.setStatus(Task.TaskStatus.PENDENTE);

        manager.getTransaction().begin();
        manager.persist(task);
        manager.getTransaction().commit();

        // Agora recupere a lista de tarefas
        sql = manager.createQuery("SELECT t FROM Task t", Task.class).getResultList();
        assertNotNull("A lista de tarefas não pode ser nula", sql);
        assertTrue("Deve haver pelo menos uma tarefa na lista", sql.size() > 0);
    }

    /**
     * Test of getListTaskForStatus method, of class TaskManager.
     */
    @Test
    @DisplayName("Deve buscar todas task via Status")
    public void testGetListTaskForStatus() {
         // Insere algumas tarefas com diferentes status
        task.setTitulo("Tarefa Pendente");
        task.setDescricao("Descrição da tarefa pendente");
        task.setDataCriacao(LocalDate.MIN);
        task.setDataConclusao(LocalDate.EPOCH);
        task.setStatus(Task.TaskStatus.PENDENTE);
        manager.getTransaction().begin();
        manager.persist(task);
        manager.getTransaction().commit();

        task.setTitulo("Tarefa Concluída");
        task.setDescricao("Descrição da tarefa concluída");
        task.setDataCriacao(LocalDate.MIN);
        task.setDataConclusao(LocalDate.EPOCH);
        task.setStatus(Task.TaskStatus.CONCLUIDA);
        manager.getTransaction().begin();
        manager.persist(task);
        manager.getTransaction().commit();

        // Agora recupere as tarefas com status PENDENTE
        List<Task> pendingTasks = manager.createQuery("SELECT t FROM Task t WHERE t.status = :status", Task.class)
                .setParameter("status", Task.TaskStatus.PENDENTE)
                .getResultList();

        assertNotNull("A lista de tarefas pendentes não pode ser nula", pendingTasks);
        assertTrue("Deve haver pelo menos uma tarefa pendente", pendingTasks.size() >= 1);
        
    }


    
}
