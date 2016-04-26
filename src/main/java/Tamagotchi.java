import java.util.HashMap;

public class Tamagotchi {
  private String mName;
  private int mFoodLevel = 10;
  private int mSleepLevel = 10;
  private int mActivityLevel = 10;

  public Tamagotchi(String name){
    mName = name;
  }

  public String getName(){
    return mName;
  }

  public int getFoodLevel() {
    return mFoodLevel;
  }

  public int getSleepLevel() {
    return mSleepLevel;
  }

  public int getActivityLevel(){
    return mActivityLevel;
  }

  // public void feed(){
  //   mFoodLevel += 1;
  // }

  public void increaseLevel(String level){
    if (level == "food"){
      mFoodLevel ++;
    } else if (level == "sleep"){
      mSleepLevel ++;
    } else if (level == "activity"){
      mActivityLevel ++;
    }
  }

}
