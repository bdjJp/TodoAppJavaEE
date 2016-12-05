/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.Size;
import service.TodoService;

/**
 *
 * @author bodaiji
 */
@Named
@ApplicationScoped
public class EditTodoBean {
    
    @Size(min = 1, message="入力してください。")
    private String updateTodo;
    private Long id;
    
    @Inject
    TodoService ts;
    
    @Inject
    TodoBean todoBean;
    
    /**
     * 上書きボタン押下時
     * @return メイン画面
     */
    public String updateTodo() {
        ts.updateTodo(id, updateTodo);
        updateTodo = "";
        return todoBean.searchTodo();
    }
    
    //setter,getter
    public String getUpdateTodo() {
        return updateTodo;
    }
    public void setUpdateTodo(String updateTodo) {
        this.updateTodo = updateTodo;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
}
