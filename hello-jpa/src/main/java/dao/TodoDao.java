/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Todo;
import java.sql.Timestamp;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author bodaiji
 */
@ApplicationScoped
public class TodoDao {
     
    @PersistenceContext
    EntityManager entityManager;
     
    /**
     * 登録処理をします。
     * @param todo
     */
    public void addTodo(String todo) {
       Todo entity = new Todo();
       entity.setTodo(todo);
       entity.setCreateDate(getCurrentTime());
       entityManager.persist(entity);
    }
    
    /**
     * 全件検索処理をします。
     * @return 登録されている全データ
     */
    public List<Todo> findAll() {
        return entityManager.createQuery("SELECT x FROM Todo x", Todo.class)
                .getResultList();
    }
    
    /**
     * 削除処理をします。
     * @param id
     */
    public void deleteTodo(Long id) {
        Todo entity = entityManager.find(Todo.class, id);
        entityManager.remove(entity);
    }
    
    /**
     * 更新処理をします。
     * @param id 
     * @param updateTodo 編集画面で入力したTodo
     */
    public void updateTodo(Long id, String updateTodo) {
        Todo entity = entityManager.find(Todo.class, id);
        entity.setTodo(updateTodo);
        entityManager.persist(entity);
    }
    
    /**
     * あいまい検索処理をします。
     * @param searchWord
     * @return 検索結果
     */
    public List<Todo> searchTodo(String searchWord) {
       return entityManager.createQuery("SELECT x FROM Todo x Where x.todo like :searchWord", Todo.class)
               .setParameter("searchWord", "%" + searchWord + "%") 
               .getResultList();
    }
    
    /**
     * 現在時刻を取得します。
     * @return 現在時刻
     */
    public Timestamp getCurrentTime() {
        Timestamp currentTime = new Timestamp(System.currentTimeMillis());
        return currentTime;
    }
    
    /**
     * idからTodoデータを取得します。
     * @param id
     * @return Todoデータ
     */
    public Todo find(Long id) {
        Todo entity = entityManager.find(Todo.class, id);
        return entity;
    }
    
}
