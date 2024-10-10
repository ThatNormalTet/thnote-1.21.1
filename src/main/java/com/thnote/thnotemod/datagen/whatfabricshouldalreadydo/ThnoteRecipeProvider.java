package com.thnote.thnotemod.datagen.whatfabricshouldalreadydo;

import com.thnote.thnotemod.Thnote;
import net.minecraft.advancement.AdvancementCriterion;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.data.server.recipe.CookingRecipeJsonBuilder;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.predicate.NumberRange;
import net.minecraft.predicate.item.ItemPredicate;
import net.minecraft.recipe.*;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ThnoteRecipeProvider {
    public static void offerBlasting(RecipeExporter exporter, List<ItemConvertible> inputs, RecipeCategory category, ItemConvertible output, float experience, int cookingTime, String group){
        offerMultipleOptions(exporter, RecipeSerializer.BLASTING, BlastingRecipe::new, inputs, category, output, experience, cookingTime, group, "_from_blasting");
    }

    public static void offerSmelting(RecipeExporter exporter, List<ItemConvertible> inputs, RecipeCategory category, ItemConvertible output, float experience, int cookingTime, String group){
        offerMultipleOptions(exporter, RecipeSerializer.SMELTING, SmeltingRecipe::new, inputs, category, output, experience, cookingTime, group, "_from_smelting");
    }

    public static void offerReversibleCompactingRecipes(
            RecipeExporter exporter,
            RecipeCategory reverseCategory,
            ItemConvertible baseItem,
            RecipeCategory compactingCategory,
            ItemConvertible compactItem,
            @Nullable String baseGroup,
            @Nullable String compactingGroup
    ) {
        String compactingId = "thnote:"+getItemPath(compactItem);
        String reverseId = "thnote:"+getItemPath(baseItem);

        ShapelessRecipeJsonBuilder.create(reverseCategory, baseItem, 9)
                .input(compactItem)
                .group(baseGroup)
                .criterion(hasItem(compactItem), conditionsFromItem(compactItem))
                .offerTo(exporter, Identifier.of(reverseId));
        ShapedRecipeJsonBuilder.create(compactingCategory, compactItem)
                .input('#', baseItem)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .group(compactingGroup)
                .criterion(hasItem(baseItem), conditionsFromItem(baseItem))
                .offerTo(exporter, Identifier.of(compactingId));
    }

    public static void offerReversibleCompactingRecipes(
            RecipeExporter exporter,
            RecipeCategory reverseCategory,
            ItemConvertible baseItem,
            RecipeCategory compactingCategory,
            ItemConvertible compactItem
    ) {
        String compactingId = "thnote:"+getItemPath(compactItem);
        String reverseId = "thnote:"+getItemPath(baseItem);

        ShapelessRecipeJsonBuilder.create(reverseCategory, baseItem, 9)
                .input(compactItem)
                .criterion(hasItem(compactItem), conditionsFromItem(compactItem))
                .offerTo(exporter, Identifier.of(reverseId));
        ShapedRecipeJsonBuilder.create(compactingCategory, compactItem)
                .input('#', baseItem)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .criterion(hasItem(baseItem), conditionsFromItem(baseItem))
                .offerTo(exporter, Identifier.of(compactingId));
    }

    public static <T extends AbstractCookingRecipe> void offerMultipleOptions(
            RecipeExporter exporter,
            RecipeSerializer<T> serializer,
            AbstractCookingRecipe.RecipeFactory<T> recipeFactory,
            List<ItemConvertible> inputs,
            RecipeCategory category,
            ItemConvertible output,
            float experience,
            int cookingTime,
            String group,
            String suffix
    ){
        for (ItemConvertible itemConvertible : inputs) {
            CookingRecipeJsonBuilder.create(Ingredient.ofItems(itemConvertible), category, output, experience, cookingTime, serializer, recipeFactory)
                    .group(group)
                    .criterion(hasItem(itemConvertible), conditionsFromItem(itemConvertible))
                    .offerTo(exporter, Thnote.MOD_ID + ":" + getItemPath(output) + suffix + "_" + getItemPath(itemConvertible));
        }
    }

    public static String hasItem(ItemConvertible item) {
        return "has_" + getItemPath(item);
    }

    public static String getItemPath(ItemConvertible item) {
        return Registries.ITEM.getId(item.asItem()).getPath();
    }

    public static AdvancementCriterion<InventoryChangedCriterion.Conditions> conditionsFromItem(NumberRange.IntRange count, ItemConvertible item) {
        return conditionsFromPredicates(ItemPredicate.Builder.create().items(item).count(count));
    }

    public static AdvancementCriterion<InventoryChangedCriterion.Conditions> conditionsFromItem(ItemConvertible item) {
        return conditionsFromPredicates(ItemPredicate.Builder.create().items(item));
    }

    public static AdvancementCriterion<InventoryChangedCriterion.Conditions> conditionsFromPredicates(ItemPredicate.Builder... predicates) {
        return conditionsFromItemPredicates((ItemPredicate[]) Arrays.stream(predicates).map(ItemPredicate.Builder::build).toArray(ItemPredicate[]::new));
    }

    public static AdvancementCriterion<InventoryChangedCriterion.Conditions> conditionsFromItemPredicates(ItemPredicate... predicates) {
        return Criteria.INVENTORY_CHANGED
                .create(new InventoryChangedCriterion.Conditions(Optional.empty(), InventoryChangedCriterion.Conditions.Slots.ANY, List.of(predicates)));
    }
}
