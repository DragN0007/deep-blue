package com.dragn0007.deepblue.deepblueblocks.vox;

import com.dragn0007.deepblue.deepblueblocks.rot.WaterloggableDecorRotator;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.stream.Stream;

public class Platform extends WaterloggableDecorRotator {

    public Platform() {
        super(NORTH, EAST, SOUTH, WEST);
    }

    public static final VoxelShape NORTH = Stream.of(
            Block.box(0, 14, -7, 16, 16, 14),
            Block.box(0, 14, 14, 16, 17, 16)
    ).reduce((v1, v2) -> Shapes.join(v1, v2,BooleanOp.OR)).get();

    public static final VoxelShape EAST = Stream.of(
            Block.box(2, 14, 0, 23, 16, 16),
            Block.box(0, 14, 0, 2, 17, 16)
    ).reduce((v1, v2) -> Shapes.join(v1, v2,BooleanOp.OR)).get();

    public static final VoxelShape SOUTH = Stream.of(
            Block.box(0, 14, 2, 16, 16, 23),
            Block.box(0, 14, 0, 16, 17, 2)
    ).reduce((v1, v2) -> Shapes.join(v1, v2,BooleanOp.OR)).get();

    public static final VoxelShape WEST = Stream.of(
            Block.box(-7, 14, 0, 14, 16, 16),
            Block.box(14, 14, 0, 16, 17, 16)
    ).reduce((v1, v2) -> Shapes.join(v1, v2,BooleanOp.OR)).get();


}
