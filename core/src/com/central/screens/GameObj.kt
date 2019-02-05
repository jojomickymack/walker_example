package com.central.screens

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.ui.Skin
import com.badlogic.gdx.utils.viewport.FitViewport
import com.central.hudactors.OnScreenGamepad
import com.central.managers.GameManager
import com.central.managers.GamepadManager
import com.central.managers.InputManager


object GameObj {
    val unitScale = 1f
    var paused = false
    var textbox = false
    val width = Gdx.graphics.width.toFloat()
    val height = Gdx.graphics.height.toFloat()
    val skin = Skin(Gdx.files.internal("custom/skin/skinui.json"))
    val sb = SpriteBatch()
    val sr = ShapeRenderer()

    val cam = OrthographicCamera(width, height)
    val hud = OrthographicCamera(width, height)
    val backgroundView = FitViewport(800f, 480f, cam)
    val view = FitViewport(800f, 480f, cam)
    val hudView = FitViewport(800f, 480f, hud)
    val stg = Stage(view, sb)
    val hudStg = Stage(hudView, sb)
    val backgroundStg = Stage(backgroundView, sb)

    var textNum = 0
    val textArray = arrayOf("Hey, welcome to the game, there's really nothing to do but walk to the right. Basically, this is a prototype. Keep moving to the right, see what there is over there, and then quit.",
            "Greetings, I am the wizard of Achalobar. Beware of the frog people, they've invaded the area. Take this magic wand, you'll need it to defend yourself",
            "Burp... I'm willie the frogman, you are now entering the frogzone. There are carnivorous frogs in the ice worlds that prey on humans, hopefully you know how to protect yourself from these murderous amphibians"
    )

    val osgp = OnScreenGamepad()
    val im = InputManager()
    var gpm = GamepadManager()
    val gm = GameManager()
}