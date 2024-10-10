package com.thnote.thnotemod.recipe.crystalizer;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.thnote.thnotemod.recipe.ModRecipes;
import net.minecraft.item.ItemStack;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;

public record CrystalizerRecipe(Ingredient inputItem, ItemStack output) implements Recipe<CrystalizerRecipeInput> {
    @Override
    public DefaultedList<Ingredient> getIngredients() {
        DefaultedList<Ingredient> list = DefaultedList.of();
        list.add(this.inputItem);
        return list;
    }

    @Override
    public boolean matches(CrystalizerRecipeInput input, World world) {
        if(world.isClient()) {
            return false;
        }

        return inputItem.test(input.getStackInSlot(0));
    }

    @Override
    public ItemStack craft(CrystalizerRecipeInput input, RegistryWrapper.WrapperLookup lookup) {
        return output.copy();
    }

    @Override
    public boolean fits(int width, int height) {
        return true;
    }

    @Override
    public ItemStack getResult(RegistryWrapper.WrapperLookup registriesLookup) {
        return output;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return ModRecipes.CRYSTALIZER_SERIALIZER;
    }

    @Override
    public RecipeType<?> getType() {
        return ModRecipes.CRYSTALIZER_TYPE;
    }

    public static class Serializer implements RecipeSerializer<CrystalizerRecipe> {
        public static final MapCodec<CrystalizerRecipe> CODEC = RecordCodecBuilder.mapCodec(inst -> inst.group(
                Ingredient.DISALLOW_EMPTY_CODEC.fieldOf("ingredient").forGetter(CrystalizerRecipe::inputItem),
                ItemStack.CODEC.fieldOf("result").forGetter(CrystalizerRecipe::output)
        ).apply(inst, CrystalizerRecipe::new));
        public static final PacketCodec<RegistryByteBuf, CrystalizerRecipe> STREAM_CODEC =
                PacketCodec.tuple(
                        Ingredient.PACKET_CODEC, CrystalizerRecipe::inputItem,
                        ItemStack.PACKET_CODEC, CrystalizerRecipe::output,
                        CrystalizerRecipe::new);

        @Override
        public MapCodec<CrystalizerRecipe> codec() {
            return CODEC;
        }

        @Override
        public PacketCodec<RegistryByteBuf, CrystalizerRecipe> packetCodec() {
            return STREAM_CODEC;
        }
    }
}
