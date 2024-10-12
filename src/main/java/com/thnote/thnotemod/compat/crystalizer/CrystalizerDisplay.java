package com.thnote.thnotemod.compat.crystalizer;

import com.thnote.thnotemod.recipe.crystalizer.CrystalizerRecipe;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.display.basic.BasicDisplay;
import me.shedaniel.rei.api.common.entry.EntryIngredient;
import me.shedaniel.rei.api.common.util.EntryIngredients;
import me.shedaniel.rei.api.common.util.EntryStacks;
import net.minecraft.recipe.RecipeEntry;

import java.util.List;

public class CrystalizerDisplay extends BasicDisplay {
    public CrystalizerDisplay(RecipeEntry<CrystalizerRecipe> recipe) {
        super(List.of(EntryIngredients.ofIngredient(recipe.value().getIngredients().get(0))),
                List.of(EntryIngredient.of(EntryStacks.of(recipe.value().getResult(null)))));
    }

    @Override
    public CategoryIdentifier<?> getCategoryIdentifier() {
        return CrystalizerCategory.CRYSTALIZER;
    }
}