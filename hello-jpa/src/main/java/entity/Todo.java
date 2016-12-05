/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TableGenerator;

/**
 *
 * @author owner
 */
@Entity
public class Todo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "SEQ_GEN")
    @TableGenerator(name = "SEQ_GEN", table = "SEQUENCE", pkColumnName = "SEQ_NAME", valueColumnName = "SEQ_COUNT")
    private Long id;
    
    private String todo;
    
    private Timestamp createDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public String getTodo() {
        return todo;
    }
    public void setTodo(String todo) {
        this.todo = todo;
    }
    
    public Timestamp getCreateDate() {
        return createDate;
    }
    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Todo)) {
            return false;
        }
        Todo other = (Todo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Todo[ id=" + id + " ]";
    }
    
}
