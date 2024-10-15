package com.thnote.thnotemod.fluid;

import com.thnote.thnotemod.Thnote;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.util.Identifier;

public class FluidRenderer {
    public static void registerFluidRenderers() {
        Thnote.LOGGER.info("Registering Fluid Renders for " + Thnote.MOD_ID);

        FluidRenderHandlerRegistry.INSTANCE.register(ModFluids.STILL_POTATO_WATER, ModFluids.FLOWING_POTATO_WATER, new SimpleFluidRenderHandler(
                Identifier.of("minecraft:block/water_still"),
                Identifier.of("minecraft:block/water_flow"),
                0xffffff
        ));

        BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(), ModFluids.STILL_POTATO_WATER, ModFluids.FLOWING_POTATO_WATER);
    }
}
