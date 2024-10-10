package com.thnote.thnotemod.block.entity;

import com.thnote.thnotemod.Thnote;
import com.thnote.thnotemod.block.ModBlocks;
import com.thnote.thnotemod.block.entity.custom.CrystalizerBlockEntity;
import com.thnote.thnotemod.block.entity.custom.OremizerBlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlockEntities {
    public static final BlockEntityType<CrystalizerBlockEntity> CRYSTALLIZER_BE =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(Thnote.MOD_ID, "crystallizer_be"),
                    BlockEntityType.Builder.create(CrystalizerBlockEntity::new, ModBlocks.CRYSTALIZER).build(null));

    public static final BlockEntityType<OremizerBlockEntity> OREMIZER_BE =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(Thnote.MOD_ID, "oremizer_be"),
                    BlockEntityType.Builder.create(OremizerBlockEntity::new, ModBlocks.OREMIZER).build(null));

    public static void registerBlockEntities() {
        Thnote.LOGGER.info("Registering Block Entities for " + Thnote.MOD_ID);
    }
}
