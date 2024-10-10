package com.thnote.thnotemod.recipe.oremizer;

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

public record OremizerRecipe(Ingredient inputItem, ItemStack output) implements Recipe<OremizerRecipeInput> {
    @Override
    public DefaultedList<Ingredient> getIngredients() {
        DefaultedList<Ingredient> list = DefaultedList.of();
        list.add(this.inputItem);
        return list;
    }

    @Override
    public boolean matches(OremizerRecipeInput input, World world) {
        if(world.isClient()) {
            return false;
        }

        return inputItem.test(input.getStackInSlot(0));
    }

    @Override
    public ItemStack craft(OremizerRecipeInput input, RegistryWrapper.WrapperLookup lookup) {
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
        return ModRecipes.OREMIZER_SERIALIZER;
    }

    @Override
    public RecipeType<?> getType() {
        return ModRecipes.OREMIZER_TYPE;
    }

    public static class Serializer implements RecipeSerializer<OremizerRecipe> {
        public static final MapCodec<OremizerRecipe> CODEC = RecordCodecBuilder.mapCodec(inst -> inst.group(
                Ingredient.DISALLOW_EMPTY_CODEC.fieldOf("ingredient").forGetter(OremizerRecipe::inputItem),
                ItemStack.CODEC.fieldOf("result").forGetter(OremizerRecipe::output)
        ).apply(inst, OremizerRecipe::new));
        public static final PacketCodec<RegistryByteBuf, OremizerRecipe> STREAM_CODEC =
                PacketCodec.tuple(
                        Ingredient.PACKET_CODEC, OremizerRecipe::inputItem,
                        ItemStack.PACKET_CODEC, OremizerRecipe::output,
                        OremizerRecipe::new);

        @Override
        public MapCodec<OremizerRecipe> codec() {
            return CODEC;
        }

        @Override
        public PacketCodec<RegistryByteBuf, OremizerRecipe> packetCodec() {
            return STREAM_CODEC;
        }
    }
}
