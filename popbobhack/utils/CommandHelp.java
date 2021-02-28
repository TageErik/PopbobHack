package popbobhack.utils;

import java.util.ArrayList;

public class CommandHelp {
	public static ArrayList<String> commandHelp = new ArrayList<String>();
	public static void commandHelplist() {
		//Fly
	commandHelp.add("<popbob> Flies. Doesn't bypass. Do .Fly speed NUMBER to change horizontal speed and .Fly yspeed NUMBER to change vertical speed");
		//Teleport
	commandHelp.add("<popbob> Teleports you, doesn't even bypass vanilla ac. Do .Tele x NUMBER to change place you wanna teleport to");
		//FullBright
	commandHelp.add("<popbob> Brightness slider go brr!");
		//NoFall
	commandHelp.add("<popbob> removes fall damage, doesn't bypass");
		//Xray
	commandHelp.add("<popbob> do .xray add BLOCKID or BLOCKNAME to add a block to the xray list. Do .xray del BLOCKID or BLOCKNAME to remove a block from the xray list");
		//Jesus
	commandHelp.add("<popbob> walks on water, doesnt work with sprint");
		//Sprint
	commandHelp.add("<popbob> sprints!");
		//GamerFov
	commandHelp.add("<popbob> UPSIDE DOWN!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		//SuperJesus
	commandHelp.add("<popbob> yes");
		//FastPlace
	commandHelp.add("<popbob> places blocks fast");
		//AutoMine
	commandHelp.add("<popbob> mines for you");
		//AutoWalk
	commandHelp.add("<popbob> walks for you");
		//AutoEat
	commandHelp.add("<popbob> eats for you");
		//Tracers
	commandHelp.add("<popbob> .help tracers");
		//NickName
	commandHelp.add("<popbob> LOL!!!");
		//ChestFinder
	commandHelp.add("<popbob> finds chests");
		//KillAura
	commandHelp.add("<popbob> this is shit don't use. do .KillAura delay NUMBER to change the hit delay");
		//Scaffold
	commandHelp.add("<popbob> scaffold moment.");
		//Freecam
	commandHelp.add("<popbob> makes your cam free");
		//Spam
	commandHelp.add("<popbob> spams. do .Spam delay NUMBER to change the delay");
		//PlayerCoords
	commandHelp.add("<popbob> Displays player coords");
		//AutoArmor
	commandHelp.add("<popbob> equips armor for you");
		//SafeWalk
	commandHelp.add("<popbob> does that shift block thing without shifting");
		//AutoSwim
	commandHelp.add("<popbob> swims for you");
		//PlaceHolder
	commandHelp.add("<popbob> its a place holder");
		//LongMessages
	commandHelp.add("<popbob> removes chat box limit and splits the message into multiple if it's too long (mc kicks you if you send messages longer than 100 characters)");
		//NoWeather
	commandHelp.add("<popbob> noweather is hardcoded in this client. This module is for if you want to pretend it isn't");
		//CustomBook
	commandHelp.add("<popbob> do .CustomAuthor PlayerName to epic prank people. Do .CustomTitle title to be lazy, server kicks you if its longer than 16 characters btw.");
		//CensorWords
	commandHelp.add("<popbob> Censors certain words. do .CensorWords add WORD to add a word to the censor list. Do .CensorWords del WORD to remove a word from the list. Do .CensorWords print to display the list. Do .CensorWords Default to apply the default censor words list!");
		//Glide
	commandHelp.add("<popbob> I want you to glide into my pussy ;)");
		//EnderShit
	commandHelp.add("<popbob> does shit with ender pearls");
		//LogOnSight
	commandHelp.add("<popbob> Log on sight of players on the log on sight list. Do .LogOnSight add playerName to add a player to the log on sight list. Do .LogOnSight del playerName to remove one. .LogOnSight print prints the list");
		//Recording
	commandHelp.add("<popbob> do .Recording recordingName to start a recording");
		//Macro
	commandHelp.add("<popbob> do .Macro macroName to play back a recording");
		//SendCommands
	commandHelp.add("<popbob> sends messages even if they have the . prefix. This is peak funny");
		//AutoR
	commandHelp.add("<popbob> automatically writes /r in the beggining of messages");
		//AntiFall
	commandHelp.add("<popbob> stops you from falling by using magic");
		//AutoWhisper
	commandHelp.add("<popbob> Automatically whispers so you don't have to do shit. Do .AutoWhisper playerName to set the player you want to whisper to");
		//AutoDisconnect
	commandHelp.add("<popbob> Disconnects if health is less than a certain value. Do .Autodisconnect NUMBER to set this value.");
		//NoClip
	commandHelp.add("<popbob> enables noclip");
		//BlockFinder
	commandHelp.add("<popbob> Tells you where blocks you want to find are. Do .BlockFinder add blockName or blockID to add a block to the list of blocks you wanna find. Do .BlockFinder del blockName or blockID to remove a block from the list. Do .BlockFinder Print to print the list.");
		//NoHurtCam
	commandHelp.add("<popbob> removes the hurt cam");
		//AntiKB
	commandHelp.add("<popbob> removes knockback");
		//BucketMLG
	commandHelp.add("<popbob> this sucks you have to look down to use it this is an embrassment but i dont feel like fixing it because i dont care");
		//DisconnectNoFall
	commandHelp.add("<popbob> Disconnect right before you land after falling a certain distance. When you relog you won't take fall damage. Do .DisconnectNoFall NUMBER to set this number");
		//SignBot
	commandHelp.add("<popbob> todo: add tutorial on how to use this");
	}
}
