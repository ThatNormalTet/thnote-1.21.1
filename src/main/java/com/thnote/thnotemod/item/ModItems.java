package com.thnote.thnotemod.item;

import com.thnote.thnotemod.Thnote;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.component.type.AttributeModifiersComponent;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterials;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item RUBY = registerItem("ruby", new Item(new Item.Settings()));
    public static final Item CONDENSED_RUBY = registerItem("condensed_ruby", new Item(new Item.Settings()));
    public static final Item POTATO_RUBY = registerItem("potato_ruby", new Item(new Item.Settings()));

    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, Identifier.of(Thnote.MOD_ID, name), item);
    }

    private static void addItemsToBuildingBlocksTabItemGroup(FabricItemGroupEntries entries){

    }
    private static void addItemsToColoredBlocksTabItemGroup(FabricItemGroupEntries entries){

    }
    private static void addItemsToNaturalTabItemGroup(FabricItemGroupEntries entries){

    }
    private static void addItemsToFunctionalTabItemGroup(FabricItemGroupEntries entries){

    }
    private static void addItemsToRedstoneTabItemGroup(FabricItemGroupEntries entries){

    }
    private static void addItemsToToolsTabItemGroup(FabricItemGroupEntries entries){

    }
    private static void addItemsToCombatTabItemGroup(FabricItemGroupEntries entries){

    }
    private static void addItemsToFoodTabItemGroup(FabricItemGroupEntries entries){

    }
    private static void addItemsToIngredientsTabItemGroup(FabricItemGroupEntries entries){

    }
    private static void addItemsToSpawnEggsTabItemGroup(FabricItemGroupEntries entries){

    }


    public static void registerModItems(){
        Thnote.LOGGER.info("Registering Items for "+ Thnote.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(ModItems::addItemsToBuildingBlocksTabItemGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COLORED_BLOCKS).register(ModItems::addItemsToColoredBlocksTabItemGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(ModItems::addItemsToNaturalTabItemGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(ModItems::addItemsToFunctionalTabItemGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.REDSTONE).register(ModItems::addItemsToRedstoneTabItemGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(ModItems::addItemsToToolsTabItemGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(ModItems::addItemsToCombatTabItemGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(ModItems::addItemsToFoodTabItemGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientsTabItemGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.SPAWN_EGGS).register(ModItems::addItemsToSpawnEggsTabItemGroup);
    }
}
