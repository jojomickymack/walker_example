package com.central.screens

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.GL20
import com.central.Application
import ktx.app.KtxScreen


class Game(val application: Application) : KtxScreen {

    init {
        Gdx.input.inputProcessor = GameObj.hudStg
    }

    override fun render(delta: Float) {
        Gdx.gl.glClearColor(0f, 0f, 0f, 1f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT or GL20.GL_DEPTH_BUFFER_BIT)
        if (!GameObj.paused) GameObj.stg.act(delta)
        GameObj.hudStg.act(delta)
        GameObj.backgroundStg.act(delta)
        GameObj.backgroundStg.draw()
        GameObj.gm.render()
        GameObj.stg.draw()
        GameObj.hudStg.draw()
        GameObj.hudStg.batch.color = Color.WHITE
        GameObj.gm.handleInput()
        GameObj.gm.checkObjects()
    }
}
