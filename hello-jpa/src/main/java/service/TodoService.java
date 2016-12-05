/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.TodoDao;
import entity.Todo;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

/**
 *
 * @author bodaiji
 */
@ApplicationScoped
@Transactional
public class TodoService {
    
    @Inject
    TodoDao dao;
            
    List<Todo> list;
    /**
     * 登録処理をします。
     * @param todo
     */
    public void addTodo(String todo) {
        dao.addTodo(todo);
    }
    
    /**
     * 全件検索処理をします。
     * @return 検索結果
     */
    public List<Todo> findAll() {
        list = dao.findAll();
        return list;
    }
    
    /**
     * 検索処理をします。
     * @param searchWord
     * @return 検索結果
     */
    public List<Todo> searchTodo(String searchWord) {
        list = dao.searchTodo(searchWord);
        return list;
    }
    
    /**
     * 削除処理をします。
     * @param id
     */
    public void deleteTodo(Long id) {
        dao.deleteTodo(id);
    }
    
   /**
    * 更新処理をします。
    * @param id
    * @param updateTodo
    */
    public void updateTodo(Long id,String updateTodo) {
        dao.updateTodo(id, updateTodo);
    }
    
    /**
     * idからデータを取得します。
     * @param id
     * @return データ
     */
    public Todo find(Long id) {
        return dao.find(id);
    }
}
