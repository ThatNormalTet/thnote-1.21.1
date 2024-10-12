package com.thnote.thnotemod.recipe;

import com.thnote.thnotemod.Thnote;
import com.thnote.thnotemod.recipe.crystalizer.CrystalizerRecipe;
import com.thnote.thnotemod.recipe.oremizer.OremizerRecipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModRecipes {
    public static final RecipeSerializer<CrystalizerRecipe> CRYSTALIZER_SERIALIZER = Registry.register(
            Registries.RECIPE_SERIALIZER, Identifier.of(Thnote.MOD_ID, "crystalizing"), new CrystalizerRecipe.Serializer());
    public static final RecipeType<CrystalizerRecipe> CRYSTALIZER_TYPE = Registry.register(
            Registries.RECIPE_TYPE, Identifier.of(Thnote.MOD_ID, "crystalizing"), new RecipeType<>() {
                @Override
                public String toString() {
                    return "crystalizing";
                }
            });

    public static final RecipeSerializer<OremizerRecipe> OREMIZER_SERIALIZER = Registry.register(
            Registries.RECIPE_SERIALIZER, Identifier.of(Thnote.MOD_ID, "oremizing"), new OremizerRecipe.Serializer());
    public static final RecipeType<OremizerRecipe> OREMIZER_TYPE = Registry.register(
            Registries.RECIPE_TYPE, Identifier.of(Thnote.MOD_ID, "oremizing"), new RecipeType<>() {
                @Override
                public String toString() {
                    return "oremizing";
                }
            });

    public static void registerRecipes() {
        Thnote.LOGGER.info("Registering Custom Recipes for " + Thnote.MOD_ID);
    }
}
