package com.thnote.thnotemod.fluid;

import com.thnote.thnotemod.Thnote;
import com.thnote.thnotemod.fluid.fluids.PotatoWaterFluid;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModFluids {

    public static final FlowableFluid FLOWING_POTATO_WATER = register("flowing_potato_water", new PotatoWaterFluid.Flowing());
    public static final FlowableFluid STILL_POTATO_WATER = register("still_potato_water", new PotatoWaterFluid.Still());


    private static <T extends Fluid> T register(String id, T value) {
        return Registry.register(Registries.FLUID, Identifier.of(Thnote.MOD_ID, id), value);
    }

    public static void registerFluids(){
        Thnote.LOGGER.info("Registering Fluids for " + Thnote.MOD_ID);
    }
}
