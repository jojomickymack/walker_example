package com.central.managers

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.maps.MapLayer
import com.badlogic.gdx.maps.tiled.TiledMapImageLayer
import com.central.actors.Background
import com.central.actors.Player
import com.central.hudactors.ScreenBorder
import com.central.hudactors.TextWindow
import com.central.screens.GameObj
import com.central.hudactors.trigger
import ktx.actors.plusAssign
import ktx.graphics.use


class GameManager {

    private val border = ScreenBorder()
    var tw = TextWindow(GameObj.textArray[GameObj.textNum])
    val background = Background(GameObj.textures)

    val player = Player()

    val imgLayer = GameObj.map.layers.get("img01") as TiledMapImageLayer
    val fieldLayer = GameObj.map.layers.get("fields01") as MapLayer
    val myTexts = fieldLayer.objects

    init {

        for (i in 1..6) GameObj.textures = (GameObj.textures + Texture(Gdx.files.internal("parallax/img$i.png"))).toMutableList()

        val background = Background(GameObj.textures)

        with(GameObj) {
            backgroundStg += background
            stg += player

            hudStg += border
            hudStg += osgp
            sr.projectionMatrix = cam.combined.scl(unitScale)
            mr.setView(cam)
        }

        GameObj.music.isLooping = true
        GameObj.music.play()
    }

    fun incrementText() {
        with(GameObj) {
            textNum++
            if (textNum >= textArray.size) textNum = 0
            tw = TextWindow(textArray[textNum])
        }
    }

    fun handleInput() {
        GameObj.im.handleInput()
    }

    fun checkObjects() {
        for (text in myTexts) {
            if (text.properties["val"].toString().toInt() == GameObj.textNum && player.mapPos.x + player.w > text.properties["x"].toString().toFloat() && player.mapPos.x < text.properties["x"].toString().toFloat() + text.properties["width"].toString().toFloat()) {
                tw.trigger()
            }
        }
    }

    fun render() {
        with(GameObj.mr) {
            batch.use { batch.draw(imgLayer.textureRegion, imgLayer.x - player.mapPos.x + GameObj.stg.width / 2 - player.w / 2, imgLayer.y) }
        }
    }
}