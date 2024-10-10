package com.thnote.thnotemod.datagen;

import com.thnote.thnotemod.Thnote;
import com.thnote.thnotemod.block.ModBlocks;
import com.thnote.thnotemod.datagen.whatfabricshouldalreadydo.ThnoteRecipeProvider;
import com.thnote.thnotemod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    private static final List<ItemConvertible> RUBY_SMELTABLES = List.of(ModBlocks.RUBY_ORE, ModBlocks.DEEPSLATE_RUBY_ORE);

    @Override
    public void generate(RecipeExporter exporter) {
        ThnoteRecipeProvider.offerBlasting(exporter, RUBY_SMELTABLES, RecipeCategory.MISC, ModItems.RUBY, 0.7f, 100, "ruby");
        ThnoteRecipeProvider.offerSmelting(exporter, RUBY_SMELTABLES, RecipeCategory.MISC, ModItems.RUBY, 0.7f, 100, "ruby");

        ThnoteRecipeProvider.offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.RUBY, RecipeCategory.BUILDING_BLOCKS, ModBlocks.RUBY_BLOCK, "ruby", "ruby_blocks");
        ThnoteRecipeProvider.offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.POTATO_RUBY, RecipeCategory.BUILDING_BLOCKS, ModBlocks.POTATO_RUBY_BLOCK, "potato_ruby", "ruby_blocks");

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.POTATO_RUBY)
                .input(ModItems.RUBY)
                .input(Items.POTATO)
                .group("potato_ruby")
                .criterion(FabricRecipeProvider.hasItem(ModItems.RUBY), FabricRecipeProvider.conditionsFromItem(ModItems.RUBY))
                .criterion(FabricRecipeProvider.hasItem(ModItems.POTATO_RUBY), FabricRecipeProvider.conditionsFromItem(ModItems.POTATO_RUBY))
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.POTATO_RUBY_BLOCK), FabricRecipeProvider.conditionsFromItem(ModBlocks.POTATO_RUBY_BLOCK))
                .offerTo(exporter, Thnote.MOD_ID + ":" + getItemPath(ModItems.POTATO_RUBY) + "_shapeless");

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.RUBY, 4)
                .input(ModItems.CONDENSED_RUBY)
                .group("ruby")
                .criterion(FabricRecipeProvider.hasItem(ModItems.RUBY), FabricRecipeProvider.conditionsFromItem(ModItems.RUBY))
                .criterion(FabricRecipeProvider.hasItem(ModItems.CONDENSED_RUBY), FabricRecipeProvider.conditionsFromItem(ModItems.CONDENSED_RUBY))
                .offerTo(exporter, Thnote.MOD_ID + ":" + getItemPath(ModItems.RUBY) + "_from_condensed_ruby");

        offer2x2CompactingRecipe(exporter, RecipeCategory.MISC, ModItems.CONDENSED_RUBY, ModItems.RUBY);
    }
}