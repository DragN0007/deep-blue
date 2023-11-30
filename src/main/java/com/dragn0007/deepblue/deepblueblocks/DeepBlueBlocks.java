package com.dragn0007.deepblue.deepblueblocks;

import com.dragn.bettas.BettasMain;
import com.dragn0007.deepblue.DeepBlueMain;
import com.dragn0007.deepblue.deepblueblocks.vox.Platform;
import com.dragn0007.deepblue.deepblueblocks.vox.Trashcan;
import com.dragn0007.deepblue.deepblueitems.DeepBlueItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class DeepBlueBlocks {
    public static final DeferredRegister<Block> BLOCKS
            = DeferredRegister.create(ForgeRegistries.BLOCKS, DeepBlueMain.MODID);

    public static final RegistryObject<Block> AQUA_GLASS = registerBlock("aqua_glass",
            () -> new GlassBlock(BlockBehaviour.Properties.copy(Blocks.GLASS).strength(0.3F).sound(SoundType.GLASS)
                    .noOcclusion().isViewBlocking(DeepBlueBlocks::never)));
    public static final RegistryObject<Block> AQUA_GLASS_SLAB = registerBlock("aqua_glass_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.GLASS).strength(0.3F).sound(SoundType.GLASS)
                    .noOcclusion().isViewBlocking(DeepBlueBlocks::never)));
    public static final RegistryObject<Block> PLATFORM = registerBlock("platform",
            () -> new Platform());
    public static final RegistryObject<Block> TRASHCAN = registerBlock("trashcan",
            () -> new Trashcan());



    private static boolean never(BlockState p_50806_, BlockGetter p_50807_, BlockPos p_50808_) {
        return false;
    }
    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }
    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        DeepBlueItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().tab(BettasMain.TANK_TAB)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
