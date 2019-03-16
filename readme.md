# Walker Example

This is an example I made for myself as I attempted to make a simple parallaxing effect as you move your character left or 
right across a tilemap. It also has dialogs that you see when colliding with different regions on the map.

![walker.gif](.github/walker.gif?raw=true)

After you pass the frog, there's nothing else to see, you'll end up walking right forever - however, you can walk left again 
and redo the dialogs by colliding with the characters again.

One thing I was learning about with this project is the concept of a 'skin'. Box2d has a system called scene2d which makes it easy to add Actors to a Stage - and there are classes for Windows, Buttons, and all sorts of things that all extend Actor.

When instantiating Windows, Buttons, and things like that, you can give them a 'skin', which is something you can load that defines what the window background, font, and other aspects of its appearance are. Fonts can be included in a skin. The skin that this project uses is in the assets directory in a folder called 'custom'. I made that skin using an excellent utility called [Skin Composer](https://github.com/raeleus/skin-composer).

If you're new to using skins, this might be a good example project for playing around with Skin Composer. If you want to do that, I'd recommend opening up the 'skin.scmp' file and doing a search and replace to change the location that my project was in when it was on my computer - 'C:/projects/libgdx_projects/speech003/' and making all the referrences to that point to wherever you have the project on your computer. That way, when you open the 'skin.scmp' file in Skin Composer, it'll be able to find most of the files it needs. All the textures and fonts used in that skin are in the 'raw' directory.

The game itself reads from the 'skin.json' file in the 'skin' folder - to apply changes you make to the skin, use the 'export' option from the menu in Skin Composer and save over that file.

