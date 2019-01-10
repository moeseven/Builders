package Game;

public class Main {

	public static void main(String[] args) {
		Game game= new Game();
		while(true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			game.onTick();
		}

	}

}
