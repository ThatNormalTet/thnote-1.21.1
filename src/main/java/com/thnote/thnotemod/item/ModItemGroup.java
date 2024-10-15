package com.thnote.thnotemod.item;

import com.thnote.thnotemod.Thnote;
import com.thnote.thnotemod.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroup {

    public static final ItemGroup ThNoTe_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Thnote.MOD_ID, "thnote"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.RUBY, 1))
                    .displayName(Text.translatable("itemGroup.thnote"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.RUBY);
                        entries.add(ModItems.CONDENSED_RUBY);
                        entries.add(ModItems.POTATO_RUBY);
                        entries.add(ModBlocks.RUBY_BLOCK);
                        entries.add(ModBlocks.POTATO_RUBY_BLOCK);
                        entries.add(ModBlocks.RUBY_ORE);
                        entries.add(ModBlocks.DEEPSLATE_RUBY_ORE);
                        entries.add(ModBlocks.CRYSTALIZER);
                        entries.add(ModBlocks.OREMIZER);
                        entries.add(ModItems.POTATO_WATER_BUCKET);
                    }).build());

    public static void registerItemGroup(){
        Thnote.LOGGER.info("Registering Item Groups for " + Thnote.MOD_ID);
    }
}
