package com.thnote.thnotemod.screens;

import com.thnote.thnotemod.Thnote;
import com.thnote.thnotemod.screens.crystalizer.CrystalizerScreenHandler;
import com.thnote.thnotemod.screens.oremizer.OremizerScreenHandler;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

public class ModScreenHandlers {
    public static final ScreenHandlerType<CrystalizerScreenHandler> CRYSTALIZER_SCREEN_HANDLER =
            Registry.register(Registries.SCREEN_HANDLER, Identifier.of(Thnote.MOD_ID, "crystalizer_screen_handler"),
                    new ExtendedScreenHandlerType<>(CrystalizerScreenHandler::new, BlockPos.PACKET_CODEC));

    public static final ScreenHandlerType<OremizerScreenHandler> OREMIZER_SCREEN_HANDLER =
            Registry.register(Registries.SCREEN_HANDLER, Identifier.of(Thnote.MOD_ID, "oremizer_screen_handler"),
                    new ExtendedScreenHandlerType<>(OremizerScreenHandler::new, BlockPos.PACKET_CODEC));

    public static void registerScreenHandlers() {
        Thnote.LOGGER.info("Registering Screen Handlers for " + Thnote.MOD_ID);
    }
}
