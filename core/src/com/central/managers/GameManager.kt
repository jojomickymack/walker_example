package com.central.managers

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.utils.Array
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.maps.MapLayer
import com.badlogic.gdx.maps.tiled.TiledMapImageLayer
import com.badlogic.gdx.maps.tiled.TmxMapLoader
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer
import com.central.actors.Background
import com.central.actors.Player
import com.central.hudactors.ScreenBorder
import com.central.hudactors.TextWindow
import com.central.screens.GameObj
import com.central.hudactors.trigger


class GameManager {

    private var textures = Array<Texture>()

    private val border = ScreenBorder()
    var tw = TextWindow(GameObj.textArray[GameObj.textNum])
    val background = Background(textures)

    val player = Player()

    val map = TmxMapLoader().load("maps/map01.tmx")
    val mr = OrthogonalTiledMapRenderer(map)

    val imgLayer = map.layers.get("img01") as TiledMapImageLayer
    val fieldLayer = map.layers.get("fields01") as MapLayer
    val myTexts = fieldLayer.objects

    val music = Gdx.audio.newMusic(Gdx.files.internal("theme.ogg"))

    init {

        for (i in 1..6) textures.add(Texture(Gdx.files.internal("parallax/img$i.png")))

        val background = Background(textures)

        with(GameObj) {
            backgroundStg.addActor(background)
            stg.addActor(player)

            hudStg.addActor(border)
            hudStg.addActor(osgp)
            sr.projectionMatrix = cam.combined.scl(unitScale)
            mr.setView(cam)
        }

        music.isLooping = true
        music.play()
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
        with(mr) {
            batch.begin()
            batch.draw(imgLayer.textureRegion, imgLayer.x - player.mapPos.x + GameObj.stg.width / 2 - player.w / 2, imgLayer.y)
            batch.end()
        }
    }
}