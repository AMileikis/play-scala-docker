package controllers

import play.api.mvc._

object IndexController extends IndexController

trait IndexController extends Controller{

  def home = Action { implicit request =>
    Ok(views.html.index("Hello, World"))
  }
}
