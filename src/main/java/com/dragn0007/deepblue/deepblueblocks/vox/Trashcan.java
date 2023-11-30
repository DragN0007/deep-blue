package com.dragn0007.deepblue.deepblueblocks.vox;

import com.dragn0007.deepblue.deepblueblocks.rot.DecorRotator;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.stream.Stream;

public class Trashcan extends DecorRotator {

    public Trashcan() {
        super(NORTH, EAST, SOUTH, WEST);
    }

    public static final VoxelShape NORTH = Stream.of(
            Block.box(1, 0, 1, 15, 14, 4),
            Block.box(4, 0, 4, 12, 2, 12),
            Block.box(1, 0, 12, 15, 14, 15),
            Block.box(1, 0, 4, 4, 14, 12),
            Block.box(12, 0, 4, 15, 14, 12),
            Block.box(1, 22, 1, 15, 24, 15),
            Block.box(2, 21, 2, 14, 22, 14),
            Block.box(1, 14, 1, 3, 22, 3),
            Block.box(13, 14, 1, 15, 22, 3),
            Block.box(1, 14, 13, 3, 22, 15),
            Block.box(13, 14, 13, 15, 22, 15)
    ).reduce((v1, v2) -> Shapes.join(v1, v2,BooleanOp.OR)).get();

    public static final VoxelShape EAST = Stream.of(
            Block.box(1, 0, 1, 15, 14, 4),
            Block.box(4, 0, 4, 12, 2, 12),
            Block.box(1, 0, 12, 15, 14, 15),
            Block.box(1, 0, 4, 4, 14, 12),
            Block.box(12, 0, 4, 15, 14, 12),
            Block.box(1, 22, 1, 15, 24, 15),
            Block.box(2, 21, 2, 14, 22, 14),
            Block.box(1, 14, 1, 3, 22, 3),
            Block.box(13, 14, 1, 15, 22, 3),
            Block.box(1, 14, 13, 3, 22, 15),
            Block.box(13, 14, 13, 15, 22, 15)
    ).reduce((v1, v2) -> Shapes.join(v1, v2,BooleanOp.OR)).get();

    public static final VoxelShape SOUTH = Stream.of(
            Block.box(1, 0, 1, 15, 14, 4),
            Block.box(4, 0, 4, 12, 2, 12),
            Block.box(1, 0, 12, 15, 14, 15),
            Block.box(1, 0, 4, 4, 14, 12),
            Block.box(12, 0, 4, 15, 14, 12),
            Block.box(1, 22, 1, 15, 24, 15),
            Block.box(2, 21, 2, 14, 22, 14),
            Block.box(1, 14, 1, 3, 22, 3),
            Block.box(13, 14, 1, 15, 22, 3),
            Block.box(1, 14, 13, 3, 22, 15),
            Block.box(13, 14, 13, 15, 22, 15)
    ).reduce((v1, v2) -> Shapes.join(v1, v2,BooleanOp.OR)).get();

    public static final VoxelShape WEST = Stream.of(
            Block.box(1, 0, 1, 15, 14, 4),
            Block.box(4, 0, 4, 12, 2, 12),
            Block.box(1, 0, 12, 15, 14, 15),
            Block.box(1, 0, 4, 4, 14, 12),
            Block.box(12, 0, 4, 15, 14, 12),
            Block.box(1, 22, 1, 15, 24, 15),
            Block.box(2, 21, 2, 14, 22, 14),
            Block.box(1, 14, 1, 3, 22, 3),
            Block.box(13, 14, 1, 15, 22, 3),
            Block.box(1, 14, 13, 3, 22, 15),
            Block.box(13, 14, 13, 15, 22, 15)
    ).reduce((v1, v2) -> Shapes.join(v1, v2,BooleanOp.OR)).get();


}
