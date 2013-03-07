play_jpa_mappedsuperclass
=========================

Duplicate property mapping of bitmap$init$0 found when using @MappedSuperclass in a Scala Play 2.0.4 app with Hibernate 3.6.10 JPA

The entity in question is extending a class annotated with @MappedSuperclass i.e.

    @Entity
    class EntityWithError(id: UUID,_name:String) extends Parent(id){

        @Column(name="name") var name = _name
    }
    
    @MappedSuperclass
    abstract class Parent(_id: UUID) {
    
        @Id
        @Column(nullable = false, name = "id") val id: String = _id.toString()
    }

This throws a org.hibernate.MappingException with "Duplicate property mapping of bitmap$init$0 found".