// @SOURCE:/home/aurimas/play_docker_project/my-app/conf/app.routes
// @HASH:dcd3bae8d5c1db2c3526340bd48bd8d28b5b8458
// @DATE:Thu Feb 26 16:45:59 GMT 2015
package app

import play.core._
import play.core.Router._
import play.core.Router.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._
import _root_.controllers.Assets.Asset

import Router.queryString

object Routes extends Router.Routes {

import ReverseRouteContext.empty

private var _prefix = "/"

def setPrefix(prefix: String): Unit = {
  _prefix = prefix
  List[(String,Routes)]().foreach {
    case (p, router) => router.setPrefix(prefix + (if(prefix.endsWith("/")) "" else "/") + p)
  }
}

def prefix = _prefix

lazy val defaultPrefix = { if(Routes.prefix.endsWith("/")) "" else "/" }


// @LINE:1
private[this] lazy val controllers_IndexController_home0_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix))))
private[this] lazy val controllers_IndexController_home0_invoker = createInvoker(
controllers.IndexController.home,
HandlerDef(this.getClass.getClassLoader, "app", "controllers.IndexController", "home", Nil,"GET", """""", Routes.prefix + """"""))
        
def documentation = List(("""GET""", prefix,"""controllers.IndexController.home""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
  case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
  case l => s ++ l.asInstanceOf[List[(String,String,String)]]
}}
      

def routes:PartialFunction[RequestHeader,Handler] = {

// @LINE:1
case controllers_IndexController_home0_route(params) => {
   call { 
        controllers_IndexController_home0_invoker.call(controllers.IndexController.home)
   }
}
        
}

}
     