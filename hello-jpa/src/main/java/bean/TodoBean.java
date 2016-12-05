/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entity.Todo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
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
public class TodoBean implements Serializable {
    
    @Size(min=1, message="入力してください。")
    private String todo;
    private List<Todo> listTodo;
    private Long id;
    private Todo entity;
    private String searchWord;
   
    @Inject
    TodoService ts;
    
    /**
     * 初期表示時
     */
    @PostConstruct
    public void init() {
        listTodo = new ArrayList();
        todo     = null;
        findAll();
    }
    
    /**
     * 登録ボタン押下時
     */
    public void addTodo() {
        ts.addTodo(todo);
        findAll();
        todo       = "";
        searchWord = "";
    }
    
    /**
     * 全件表示します。
     * @return メイン画面
     */
    public String findAll() {
        listTodo = ts.findAll();
        return "todo.xhtml";
    }
    
    /**
     * 削除ボタン押下時
     */
    public void deleteTodo() {
        ts.deleteTodo(id);
        searchTodo();
    }
    
    /**
     * 上書きボタン押下時
     * @return 編集画面
     */
    public String moveEditScr() {
        entity = ts.find(id);
        return "editTodo.xhtml";
    }
    
    /**
     * 検索ボタン押下時
     * @return メイン画面
     */
    public String searchTodo() {
        listTodo = ts.searchTodo(searchWord);
        return "todo.xhtml";
    }
    
    // getter,setter
    public String getTodo() {
        return todo;
    }
    public void setTodo(String todo) {
        this.todo = todo;
    }
    public List<Todo> getListTodo() {
        return listTodo;
    }
    public void setListTodo(List<Todo> listTodo) {
        this.listTodo = listTodo;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Todo getEntity() {
        return entity;
    }
    public void setEntity(Todo entity) {
        this.entity = entity;
    }
    public String getSearchWord() {
         if(searchWord == null) {
            searchWord = "";
        }
        return searchWord;
    }
    public void setSearchWord(String searchWord) {
        if(searchWord == null) {
            searchWord = "";
        }
        this.searchWord = searchWord;
    }
}
