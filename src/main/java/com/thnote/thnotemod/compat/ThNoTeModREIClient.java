package com.thnote.thnotemod.compat;

import com.thnote.thnotemod.block.ModBlocks;
import com.thnote.thnotemod.compat.crystalizer.CrystalizerCategory;
import com.thnote.thnotemod.compat.crystalizer.CrystalizerDisplay;
import com.thnote.thnotemod.compat.oremizer.OremizerCategory;
import com.thnote.thnotemod.compat.oremizer.OremizerDisplay;
import com.thnote.thnotemod.recipe.ModRecipes;
import com.thnote.thnotemod.recipe.crystalizer.CrystalizerRecipe;
import com.thnote.thnotemod.recipe.oremizer.OremizerRecipe;
import com.thnote.thnotemod.screens.crystalizer.CrystalizerScreen;
import com.thnote.thnotemod.screens.oremizer.OremizerScreen;
import me.shedaniel.math.Rectangle;
import me.shedaniel.rei.api.client.plugins.REIClientPlugin;
import me.shedaniel.rei.api.client.registry.category.CategoryRegistry;
import me.shedaniel.rei.api.client.registry.display.DisplayRegistry;
import me.shedaniel.rei.api.client.registry.screen.ScreenRegistry;
import me.shedaniel.rei.api.common.util.EntryStacks;

public class ThNoTeModREIClient implements REIClientPlugin {
    @Override
    public void registerCategories(CategoryRegistry registry) {
        registry.add(new CrystalizerCategory());
        registry.add(new OremizerCategory());

        registry.addWorkstations(CrystalizerCategory.CRYSTALIZER, EntryStacks.of(ModBlocks.CRYSTALIZER));
        registry.addWorkstations(OremizerCategory.OREMIZER, EntryStacks.of(ModBlocks.OREMIZER));
    }

    @Override
    public void registerDisplays(DisplayRegistry registry) {
        registry.registerRecipeFiller(CrystalizerRecipe.class, ModRecipes.CRYSTALIZER_TYPE,
                CrystalizerDisplay::new);

        registry.registerRecipeFiller(OremizerRecipe.class, ModRecipes.OREMIZER_TYPE,
                OremizerDisplay::new);
    }

    @Override
    public void registerScreens(ScreenRegistry registry) {
        registry.registerClickArea(screen -> new Rectangle(((screen.width - 176) / 2) + 78,
                        ((screen.height - 166) / 2) + 30, 20, 25),
                CrystalizerScreen.class, CrystalizerCategory.CRYSTALIZER);

        registry.registerClickArea(screen -> new Rectangle(((screen.width - 176) / 2) + 78,
                        ((screen.height - 166) / 2) + 30, 20, 25),
                OremizerScreen.class, OremizerCategory.OREMIZER);
    }
}