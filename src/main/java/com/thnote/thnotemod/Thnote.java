package com.thnote.thnotemod;

import com.thnote.thnotemod.block.ModBlocks;
import com.thnote.thnotemod.block.entity.ModBlockEntities;
import com.thnote.thnotemod.fluid.FluidRenderer;
import com.thnote.thnotemod.fluid.ModFluidBlocks;
import com.thnote.thnotemod.fluid.ModFluids;
import com.thnote.thnotemod.item.ModItemGroup;
import com.thnote.thnotemod.item.ModItems;
import com.thnote.thnotemod.recipe.ModRecipes;
import com.thnote.thnotemod.screens.ModScreenHandlers;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Thnote implements ModInitializer {
	public static final String MOD_ID = "thnote";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModBlocks.registerBlocks();
		ModItems.registerModItems();
		ModItemGroup.registerItemGroup();
		ModBlockEntities.registerBlockEntities();
		ModRecipes.registerRecipes();
		ModScreenHandlers.registerScreenHandlers();
		ModFluids.registerFluids();
		ModFluidBlocks.registerFluidBlocks();
	}
}