// @SOURCE:/home/aurimas/play_docker_project/my-app/conf/app.routes
// @HASH:dcd3bae8d5c1db2c3526340bd48bd8d28b5b8458
// @DATE:Thu Feb 26 16:45:59 GMT 2015

import app.Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.Router.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._
import _root_.controllers.Assets.Asset

import Router.queryString


// @LINE:1
package controllers {

// @LINE:1
class ReverseIndexController {


// @LINE:1
def home(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix)
}
                        

}
                          
}
                  


// @LINE:1
package controllers.javascript {
import ReverseRouteContext.empty

// @LINE:1
class ReverseIndexController {


// @LINE:1
def home : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.IndexController.home",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + """"})
      }
   """
)
                        

}
              
}
        


// @LINE:1
package controllers.ref {


// @LINE:1
class ReverseIndexController {


// @LINE:1
def home(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.IndexController.home(), HandlerDef(this.getClass.getClassLoader, "", "controllers.IndexController", "home", Seq(), "GET", """""", _prefix + """""")
)
                      

}
                          
}
        
    