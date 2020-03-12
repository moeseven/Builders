package gui;

import world.Game;

public class Vision {
	private GameFrame game_frame;
	public Vision(Game game) {
		game_frame = new GameFrame(game);
	}
	public void update() {
		game_frame.update();
	}
	
	//getters and setters
	public GameFrame getGame_frame() {
		return game_frame;
	}
	public void setGame_frame(GameFrame game_frame) {
		this.game_frame = game_frame;
	}
	
}
