package com.thnote.thnotemod;

import com.thnote.thnotemod.screens.ModScreenHandlers;
import com.thnote.thnotemod.screens.crystalizer.CrystallizerScreen;
import com.thnote.thnotemod.screens.oremizer.OremizerScreen;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.gui.screen.ingame.HandledScreens;

public class ThnoteClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        HandledScreens.register(ModScreenHandlers.CRYSTALLIZER_SCREEN_HANDLER, CrystallizerScreen::new);
        HandledScreens.register(ModScreenHandlers.OREMIZER_SCREEN_HANDLER, OremizerScreen::new);
    }
}
