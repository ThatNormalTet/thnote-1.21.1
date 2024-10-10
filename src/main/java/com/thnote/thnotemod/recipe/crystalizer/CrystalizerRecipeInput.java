package com.thnote.thnotemod.recipe.crystalizer;

import net.minecraft.item.ItemStack;
import net.minecraft.recipe.input.RecipeInput;

public record CrystalizerRecipeInput(ItemStack input) implements RecipeInput {
    @Override
    public ItemStack getStackInSlot(int slot) {
        return input;
    }

    @Override
    public int getSize() {
        return 1;
    }
}
