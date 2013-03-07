package au.com.ri

import javax.persistence.Entity
import java.util.UUID
import javax.persistence.Column
import javax.persistence.MappedSuperclass
import javax.persistence.Id

/**
 * Inheriting from Parent here will cause a org.hibernate.MappingException
 * with "Duplicate property mapping of bitmap$init$0 found" when instantiating a EMF in the index action.
 */
@Entity
class EntityWithError(id: UUID, _name: String) extends Parent(id) {

  @Column(name = "name") var name = _name

  def this() = this(UUID.randomUUID(), "")
}

@MappedSuperclass
abstract class Parent(_id: UUID) {

  @Id
  @Column(nullable = false, name = "id") val id: String = _id.toString()
}

