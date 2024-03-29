package controller;

import controller.GameController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * Handles JavaFX Button press events for the restart game button.
 * 
 * @author Michael Shearer
 */
public class ButtonPressEventHandler implements EventHandler<ActionEvent>{
	GameController controller;
	
	/**
	 * Handler constructor
	 * @param controller: the game that we want to have attached
	 */
	public ButtonPressEventHandler(GameController controller) {
		this.controller = controller;
	}
	
	/**
	 * This method gets called upon a button being pressed, then updates the grid by calling observers
	 * @param event: the event being handled
	 */
	public void handle(ActionEvent event) {
		controller.resetGame();
	}
}
