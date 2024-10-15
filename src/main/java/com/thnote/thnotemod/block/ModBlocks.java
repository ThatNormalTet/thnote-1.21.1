package com.thnote.thnotemod.block;

import com.thnote.thnotemod.Thnote;
import com.thnote.thnotemod.block.custom.CrystalizerBlock;
import com.thnote.thnotemod.block.custom.OremizerBlock;
import net.minecraft.block.*;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {

    public static final Block RUBY_BLOCK = registerBlock("ruby_block", new Block(AbstractBlock.Settings.copy(Blocks.IRON_BLOCK)));
    public static final Block POTATO_RUBY_BLOCK = registerBlock("potato_ruby_block", new Block(AbstractBlock.Settings.copy(Blocks.IRON_BLOCK)));
    public static final Block RUBY_ORE = registerBlock("ruby_ore", new Block(AbstractBlock.Settings.copy(Blocks.IRON_ORE)));
    public static final Block DEEPSLATE_RUBY_ORE = registerBlock("deepslate_ruby_ore", new Block(AbstractBlock.Settings.copy(Blocks.DEEPSLATE_IRON_ORE)));
    public static final Block CRYSTALIZER = registerBlock("crystalizer", new CrystalizerBlock(AbstractBlock.Settings.create().strength(2).requiresTool()));
    public static final Block OREMIZER = registerBlock("oremizer", new OremizerBlock(AbstractBlock.Settings.create().strength(2).requiresTool()));

    private static Block registerBlock(String name, Block block){
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(Thnote.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block){
        Registry.register(Registries.ITEM, Identifier.of(Thnote.MOD_ID, name), new BlockItem(block, new Item.Settings()));
    }

    public static void registerBlocks(){
        Thnote.LOGGER.info("Registering blocks for "+ Thnote.MOD_ID);
    }
}
