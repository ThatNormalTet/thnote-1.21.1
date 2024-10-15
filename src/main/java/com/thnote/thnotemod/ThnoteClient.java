package com.thnote.thnotemod;

import com.thnote.thnotemod.fluid.FluidRenderer;
import com.thnote.thnotemod.screens.ModScreenHandlers;
import com.thnote.thnotemod.screens.crystalizer.CrystalizerScreen;
import com.thnote.thnotemod.screens.oremizer.OremizerScreen;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.gui.screen.ingame.HandledScreens;

public class ThnoteClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        HandledScreens.register(ModScreenHandlers.CRYSTALIZER_SCREEN_HANDLER, CrystalizerScreen::new);
        HandledScreens.register(ModScreenHandlers.OREMIZER_SCREEN_HANDLER, OremizerScreen::new);

        FluidRenderer.registerFluidRenderers();
    }
}
