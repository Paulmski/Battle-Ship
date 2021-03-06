/**
 * @author Paul Molczanski
 * @email paulmski@gmail.com
 * @create date November 16, 2021 09:44
 * @modify date 2021-11-17 13:12:25
 * @desc The main class which will execute.
 */

public class Main {
  public static void main(String[] args) {
      while (true) {
        GameEngine gameEngine = new GameEngine(48, 27);
        gameEngine.showMenu();
        if (!gameEngine.isRunning()) {return;}
        gameEngine.startGame();
      }
  }
}
