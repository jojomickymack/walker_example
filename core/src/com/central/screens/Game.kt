package com.central.screens

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.GL20
import com.central.App
import ktx.app.KtxScreen


class Game(val application: App) : KtxScreen {

    init {
        Gdx.input.inputProcessor = GameObj.hudStg
    }

    override fun render(delta: Float) {
        Gdx.gl.glClearColor(0f, 0f, 0f, 1f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT or GL20.GL_DEPTH_BUFFER_BIT)

        with(GameObj) {
            if (!paused) stg.act(delta)
            hudStg.act(delta)
            backgroundStg.act(delta)
            backgroundStg.draw()
            gm.render()
            stg.draw()
            hudStg.draw()
            hudStg.batch.color = Color.WHITE
            gm.handleInput()
            gm.checkObjects()
        }
    }

    override fun dispose() {
        GameObj.dispose()
        println("all disposable memory freed")
        super.dispose()
    }
}
