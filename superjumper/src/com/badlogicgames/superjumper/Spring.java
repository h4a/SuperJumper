/*******************************************************************************
 * Copyright 2011 See AUTHORS file.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/

package com.badlogicgames.superjumper;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Spring extends DynamicGameObject {
	public static float SPRING_WIDTH = 2f;
	public static float SPRING_HEIGHT = 2f;
	float stateTime;

	public Spring (float x, float y) {
		super(x, y, SPRING_WIDTH, SPRING_HEIGHT);
	}
	public void draw(SpriteBatch batch,TextureRegion variable) {
		batch.draw(variable,position.x,position.y,SPRING_WIDTH/2,SPRING_HEIGHT/2, SPRING_WIDTH, SPRING_HEIGHT, 1, 1, stateTime*20);
	}
	public void update(float deltaTime) {
		position.add(velocity.x*deltaTime,velocity.y*deltaTime);
		bounds.x = position.x - SPRING_WIDTH / 2;
		bounds.y = position.y - SPRING_HEIGHT / 2;
		this.stateTime += deltaTime*5;
	}
	/*public void update(float deltaTime,DynamicGameObject dst) {
		this.stateTime += deltaTime*5;
		totaltime += deltaTime;
		this.position.x = (float) (dst.position.x + 1*Math.cos(totaltime));
		this.position.y = (float) (dst.position.y + 1*Math.sin(totaltime));
	}
	*/
}
