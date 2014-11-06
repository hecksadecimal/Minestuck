package com.mraof.minestuck.client.settings;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;

import com.mraof.minestuck.client.gui.playerStats.GuiGristCache;
import com.mraof.minestuck.client.gui.playerStats.GuiPlayerStats;
import com.mraof.minestuck.editmode.ClientEditHandler;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;

public class MinestuckKeyHandler {
	
	KeyBinding statKey;
	KeyBinding editKey;
	boolean statKeyPressed = false;
	boolean editKeyPressed = false;
	
	public MinestuckKeyHandler() {
		statKey = new KeyBinding("key.statsGui", 34, "key.categories.minestuck");
		ClientRegistry.registerKeyBinding(statKey);
		editKey = new KeyBinding("key.exitEdit", 45, "key.categories.minestuck");
		ClientRegistry.registerKeyBinding(editKey);
	}
	
	@SubscribeEvent
	public void onTick(TickEvent.ClientTickEvent event) {
		if(statKey.getIsKeyPressed() && !statKeyPressed) {
			
			GuiPlayerStats.openGui(false);
			
		} else if(editKey.getIsKeyPressed() && !editKeyPressed) {
			
			if(Minecraft.getMinecraft().currentScreen == null)
				ClientEditHandler.onKeyPressed();
			
		}
		
		statKeyPressed = statKey.getIsKeyPressed();
		editKeyPressed = editKey.getIsKeyPressed();
		
	}
	
}