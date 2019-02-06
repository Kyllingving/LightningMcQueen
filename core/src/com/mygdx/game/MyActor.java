package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.actions.MoveByAction;
import com.badlogic.gdx.scenes.scene2d.actions.RotateByAction;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.mygdx.game.Enum.Direction;
import com.mygdx.game.Enum.Rotation;

public class MyActor extends Image {

    public MyActor(Texture texture) {
        super(texture);

        final Player player = new Player(new Position(1,1), Direction.NORTH, 9);

        setBounds(getX(), getY(), getWidth(), getHeight());

        addListener(new InputListener() {
            @Override
            public boolean keyDown(InputEvent event, int keycode) {
                setOrigin(getWidth()/2, getHeight()/2);
                MoveByAction moveByAction = new MoveByAction();
                RotateByAction rotateByAction = new RotateByAction();
                switch (keycode) {
                    case Input.Keys.LEFT:
                        rotateByAction.setAmount(90f);
                        rotateByAction.setDuration(0.3f);

                        MyActor.this.addAction(rotateByAction);
                        player.rotate(Rotation.L);
                        break;
                    case Input.Keys.RIGHT:
                        rotateByAction.setAmount(-90f);
                        rotateByAction.setDuration(0.3f);

                        MyActor.this.addAction(rotateByAction);
                        player.rotate(Rotation.R);
                        break;
                    case Input.Keys.UP:
                        switch (player.getDirection()) {
                            case NORTH:
                                moveByAction.setAmount(0f, 64f);
                                moveByAction.setDuration(0.3f);

                                MyActor.this.addAction(moveByAction);
                                break;
                            case EAST:
                                moveByAction.setAmount(64f, 0f);
                                moveByAction.setDuration(0.3f);

                                MyActor.this.addAction(moveByAction);
                                break;
                            case SOUTH:
                                moveByAction.setAmount(0f, -64f);
                                moveByAction.setDuration(0.3f);

                                MyActor.this.addAction(moveByAction);
                                break;
                            case WEST:
                                moveByAction.setAmount(-64f, 0f);
                                moveByAction.setDuration(0.3f);

                                MyActor.this.addAction(moveByAction);
                                break;
                        }
                        player.move(1);
                        break;
                    case Input.Keys.DOWN:
                        switch (player.getDirection()) {
                            case NORTH:
                                moveByAction.setAmount(0f, -64f);
                                moveByAction.setDuration(0.3f);

                                MyActor.this.addAction(moveByAction);
                                break;
                            case EAST:
                                moveByAction.setAmount(-64f, 0f);
                                moveByAction.setDuration(0.3f);

                                MyActor.this.addAction(moveByAction);
                                break;
                            case SOUTH:
                                moveByAction.setAmount(0f, 64f);
                                moveByAction.setDuration(0.3f);

                                MyActor.this.addAction(moveByAction);
                                break;
                            case WEST:
                                moveByAction.setAmount(64f, 0f);
                                moveByAction.setDuration(0.3f);

                                MyActor.this.addAction(moveByAction);
                                break;
                        }
                        player.move(1);
                        break;
                }
                return true;
            }
        });
    }
}
