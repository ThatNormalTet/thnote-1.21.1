package com.thnote.thnotemod.fluid;

import com.thnote.thnotemod.Thnote;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.FluidBlock;
import net.minecraft.block.MapColor;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModFluidBlocks {
    public static final Block POTATO_WATER = registerBlock(
            "potato_water",
            new FluidBlock(
                    ModFluids.STILL_POTATO_WATER,
                    AbstractBlock.Settings.create()
                            .mapColor(MapColor.WATER_BLUE)
                            .replaceable()
                            .noCollision()
                            .strength(100.0F)
                            .pistonBehavior(PistonBehavior.DESTROY)
                            .dropsNothing()
                            .liquid()
                            .sounds(BlockSoundGroup.INTENTIONALLY_EMPTY)
            )
    );

    private static Block registerBlock(String name, Block block){
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(Thnote.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block){
        Registry.register(Registries.ITEM, Identifier.of(Thnote.MOD_ID, name), new BlockItem(block, new Item.Settings()));
    }

    public static void registerFluidBlocks(){
        Thnote.LOGGER.info("Registering Fluid Blocks for " + Thnote.MOD_ID);
    }
}
