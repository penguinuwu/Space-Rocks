package model;

import java.util.ArrayList;
import javafx.scene.shape.Polygon;

public class GameModel {
	private static final int SCREEN_HEIGHT = 500;
	private static final int SCREEN_WIDTH = 500;
	
	private static final int PLAYER_MAX_VEL = 100;
	private static final int PLAYER_ACC = 20;
	
	private static final int BULLET_VEL = 150;
	private static final float BULLET_LIFETIME = 3.0f;
	
	private static final int L_ASTEROID_MAX_VEL = 20;
	private static final int L_ASTEROID_MIN_VEL = 10;
	private static final int M_ASTEROID_MAX_VEL = 30;
	private static final int M_ASTEROID_MIN_VEL = 20;
	private static final int S_ASTEROID_MAX_VEL = 40;
	private static final int S_ASTEROID_MIN_VEL = 30;
	
	private static final int NUM_ASTEROIDS = 20;
	
	private ArrayList<Bullet> bullets;
	private ArrayList<Asteroid> asteroids;
	private Player player;
	
	private ArrayList<Polygon> addedPolygons;
	private ArrayList<Polygon> removedPolygons;
	
	private int score = 0;
	private int lives = 0;
	private boolean gameOver = false;
	
	public GameModel() {
		for (int i=0; i<NUM_ASTEROIDS; i++) {
			Asteroid asteroid = new Asteroid();
			this.asteroids.add(asteroid);
			this.addedPolygons.add(asteroid.getBody());
		}
		
		this.player = new Player();
		this.addedPolygons.add(this.player.getBody());
	}
	
	/**
	 * Update all game objects according to the parameters. Create a new bullet if the space bar is being
	 * pressed and add its body to addedPolygons. Call bulletVSAsteroid() and playerVSAsteroid() to check
	 * for collisions.
	 * 
	 * @param dt
	 * @param moveForward true if 'w' key is being pressed
	 * @param turnRight true if 'd' key is being pressed
	 * @param turnLeft true if 'a' key is being pressed
	 * @param shoot true if the space bar is being pressed
	 */
	public void update(float dt, boolean moveForward, boolean turnRight, boolean turnLeft, boolean shoot) {
		for (Asteroid asteroid: this.asteroids) {
			asteroid.update(dt);
		}
		for (Bullet bullet: this.bullets) {
			bullet.update(dt);
		}
		this.player.update(dt, moveForward, turnRight, turnLeft);
		
		if (shoot) {
			rotation = this.player.getRotation();
			Bullet bullet = new Bullet(rotation);
			this.bullets.add(bullet);
			this.addedPolygons.add(bullet.getBody());
		}
		
		this.bulletVSAsteroid();
		this.playerVSAsteroid();
	}
	
	private void bulletVSAsteroid(){
		//NOT IMPLEMENTED
	}
	
	private void playerVSAsteroid(){
		//NOT IMPLEMENTED
	}
	
	/**
	 * 
	 * @return lives
	 */
	public int getLives() {
		return this.lives;
	}
	
	/**
	 * 
	 * @return score
	 */
	public int getScore() {
		return this.score;
	}
	
	/**
	 * Returns a shallow copy of the ArrayList of polygons that have been added to the game. A side effect of this
	 * method is that this.addedPolygons is emptied. 
	 * 
	 * @return ArrayList of added polygons
	 */
	public ArrayList<Polygon> getAddedPolygons() {
		//create shallow copy (object references copied) of addedPolygons
		ArrayList<Polygon> added = (ArrayList<Polygon>)this.addedPolygons.clone();
		this.addedPolygons.clear(); //empty addedPolygons
		return added;
	}
	
	/**
	 * Returns a shallow copy of the ArrayList of polygons that have been removed from the game. A side effect of this
	 * method is that this.removedPolygons is emptied. 
	 * 
	 * @return ArrayList of removed polygons
	 */
	public ArrayList<Polygon> getRemovedPolygons(){
		//create shallow copy (object references copied) of removedPolygons
		ArrayList<Polygon> removed = (ArrayList<Polygon>)this.removedPolygons.clone();
		this.removedPolygons.clear(); //empty removedPolygons
		return removed;
	}

}