package entity;

import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-02T15:09:25")
@StaticMetamodel(Todo.class)
public class Todo_ { 

    public static volatile SingularAttribute<Todo, String> todo;
    public static volatile SingularAttribute<Todo, Long> id;
    public static volatile SingularAttribute<Todo, Timestamp> createDate;

}