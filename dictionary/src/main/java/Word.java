import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;



public class Word(){
  private String mWord;
  private static ArrayList<Category> instances = new ArrayList<Category>();
  private int mId;
  private List<Word> mWords;



  public Word(String word){
    mWord = word;
    instances.add(this);
    mId = instances.size();
    mWords = new ArrayList<Word>();
  }
}
