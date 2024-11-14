package Repository;

import Entity.Task;
import java.awt.HeadlessException;
import java.util.List;
import java.util.UUID;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

public class TaskManager {

    private EntityManagerFactory factory;
    private EntityManager manager;
    private List<Task> sql;
  

    public TaskManager() { 
        try {
            factory = Persistence.createEntityManagerFactory("desafio");
            manager = factory.createEntityManager();
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Erro na conexão, verifique o servidor " );
        }
    }
    
    public List<Task> addTask(Task task){
        
        try {
            manager.getTransaction().begin();
            manager.persist(task);
            manager.getTransaction().commit();
            JOptionPane.showMessageDialog(null, "Cadastrou uma nova tarefa");
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Verifique se a conexão com o seu banco está sendo realizada");
        }
      
        return this.getListTask();
    }
    
    public List<Task> updateTask(Task task){
                  
          
        if (task != null) {
            
            manager.getTransaction().begin();
            manager.merge(task);
            manager.getTransaction().commit();

            
            JOptionPane.showMessageDialog(null, "Task atualizada com sucesso.");
        } else {
            JOptionPane.showMessageDialog(null, "Task não encontrada!");
        }
        return getListTask();
    }
    
    public List<Task> deleteTask(UUID id){
        try {
                Task task = manager.find(Task.class, id);
            if (task != null) {
                manager.getTransaction().begin();
                manager.remove(task);
                manager.getTransaction().commit();
                JOptionPane.showMessageDialog(null, "Task deletada com sucesso.");
            } else {
                JOptionPane.showMessageDialog(null, "Task não encontrada!");
            }
        }catch (HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Verifique se a conexão com o seu banco está sendo realizada");
        }
        return getListTask();
    }
    
    public List<Task> getListTask(){
        try {
             sql = manager.createQuery("SELECT t FROM Task t", Task.class).getResultList();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Verifique se a conexão com o seu banco está sendo realizada");
        }
        return sql;
        
    }
    
    public List<Task> getListTaskForStatus(Task.TaskStatus status){
        try {
             manager.getTransaction().begin();
             sql = manager.createQuery(
                "SELECT t FROM Task t WHERE t.status = :status", Task.class)
                .setParameter("status", status)  
                .getResultList();
             manager.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Verifique se a conexão com o seu banco está sendo realizada");
        }
        return sql;
    }

    
    
}
