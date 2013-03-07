package controllers

import play.api._
import play.api.mvc._
import javax.persistence.Persistence

object Application extends Controller {
  
  def index = Action {
    // the next line is just to cause Hibernate to built the DDL
    Persistence.createEntityManagerFactory("defaultPersistenceUnit")
    Ok(views.html.index("Your new application is ready."))
  }
  
}