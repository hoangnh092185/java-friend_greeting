import java.io.Console;
import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;


public class App {
  public static void main(String[] args){
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response)-> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/results", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      int intLength = Integer.parseInt(request.queryParams("length"));
      int intWidth = Integer.parseInt(request.queryParams("width"));
      Rectangle newRectangle = new Rectangle(intLength, intWidth);
      boolean squareResult = newRectangle.isSquare();
      String output = String.format("Is your rectangle a sqare too? %b", squareResult);
      model.put("output", output);
      model.put("template", "templates/results.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/rectangle", (request, response) -> {
  Map<String, Object> model = new HashMap<String, Object>();
  int length = Integer.parseInt(request.queryParams("length"));
  int width = Integer.parseInt(request.queryParams("width"));

  Rectangle myRectangle = new Rectangle(length, width);
  model.put("myRectangle", myRectangle);
  if (myRectangle.isSquare()) {
        Cube myCube = new Cube(myRectangle);
        model.put("myCube", myCube);
      }

  model.put("template", "templates/rectangle.vtl");
  return new ModelAndView(model, layout);
  }, new VelocityTemplateEngine());

  }
}