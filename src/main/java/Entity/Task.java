/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

/**
 *
 * @author Tchiwila
 */
@Entity
@Table(name = "task")
public class Task implements Serializable  {
    

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
        name = "UUID",
        strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Type(type = "org.hibernate.type.UUIDCharType")
    @Column(name = "id", nullable = false, columnDefinition = "VARCHAR(36)")
    private UUID id;
    
    @NotBlank(message = "O título não pode ser vazio.") 
    private String titulo;
    
    @NotBlank(message = "A descrição não pode ser vazia.") 
    @Column(name = "descricao",  nullable = false, columnDefinition = "TEXT")
    private String descricao;
    
    @NotNull(message = "A data de criação não pode ser nula.")
    private LocalDate dataCriacao;
   
    @NotNull(message = "A data de conclusão não pode ser nula.")
    private LocalDate dataConclusao;
    
    @Enumerated(EnumType.STRING) // Isso indica que o valor será armazenado como String
    private TaskStatus status;

    public Task() {
    }

    public Task(String titulo, String descricao, LocalDate dataCriacao, LocalDate dataConclusao, TaskStatus status) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataCriacao = dataCriacao;
        this.dataConclusao = dataConclusao;
        this.status = status;
    }    
    
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
    
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public LocalDate getDataConclusao() {
        return dataConclusao;
    }

    public void setDataConclusao(LocalDate dataConclusao) {
        this.dataConclusao = dataConclusao;
    }

     public String getStatus() {
        return status.toString();  // Converte TaskStatus para String
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return  id  + titulo +  descricao + dataCriacao + dataConclusao + status ;
    }
    
    public enum TaskStatus{
        PENDENTE,
        EM_PROGRESSO,
        CONCLUIDA;

        public static TaskStatus valueOf(Object selectedItem) {
            throw new UnsupportedOperationException("Not supported yet."); 
        }
    }
    
    public boolean validation(String titulo, String descricao, LocalDate dataCriacao, LocalDate dataConclusao, TaskStatus status){
        // Verificar se o título é nulo ou vazio
            if (titulo == null || titulo.isBlank()) {

                throw new IllegalArgumentException("O título não pode ser vazio ou nulo.");
            }

            // Verificar se a descrição é nula ou vazia
            if (descricao == null || descricao.isBlank()) {


                throw new IllegalArgumentException("A descrição não pode ser vazia ou nula.");
            }


        // Verificar se as datas são nulas
            if (dataCriacao == null) {

                     throw new IllegalArgumentException("A data de criação não pode ser nula.");
            }

          if (dataConclusao == null || dataConclusao.isBefore(dataCriacao)) {
                throw new IllegalArgumentException("A data de conclusão não pode ser nula nem  invalida.");
            }

        // Verificar se o status é nulo
            if (status == null) {


                 throw new IllegalArgumentException("O status não pode ser nulo.");
            }
            
        return true;
    }

}
