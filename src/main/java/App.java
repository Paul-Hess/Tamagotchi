import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  static boolean isAlive = true;
  public static void main (String[] args){

    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/tamagotchi", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Tamagotchi newTamagotchi = new Tamagotchi(request.queryParams("name"));
      request.session().attribute("tamagotchi", newTamagotchi);
      model.put("isAlive", isAlive);
      model.put("newTamagotchi", newTamagotchi);
      model.put("template", "templates/Tamagotchi.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/feed",(request, response) -> {

      Map<String, Object> model = new HashMap<String, Object>();
      Tamagotchi newTamagotchi = request.session().attribute("tamagotchi");
      newTamagotchi.increaseLevel("food");
      model.put("isAlive", isAlive);
      model.put("newTamagotchi", newTamagotchi);
      model.put("template", "templates/Tamagotchi.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/sleep",(request, response) -> {

      Map<String, Object> model = new HashMap<String, Object>();
      Tamagotchi newTamagotchi = request.session().attribute("tamagotchi");
      newTamagotchi.increaseLevel("sleep");
      model.put("isAlive", isAlive);
      model.put("newTamagotchi", newTamagotchi);
      model.put("template", "templates/Tamagotchi.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/activity",(request, response) -> {

      Map<String, Object> model = new HashMap<String, Object>();
      Tamagotchi newTamagotchi = request.session().attribute("tamagotchi");
      newTamagotchi.increaseLevel("activity");
      model.put("isAlive", isAlive);
      model.put("newTamagotchi", newTamagotchi);
      model.put("template", "templates/Tamagotchi.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/time",(request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Tamagotchi newTamagotchi = request.session().attribute("tamagotchi");
      newTamagotchi.timePasses();
      isAlive = newTamagotchi.checkHealthStatus();
      model.put("isAlive", isAlive);
      model.put("newTamagotchi", newTamagotchi);
      model.put("template", "templates/Tamagotchi.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

  }
}
