package com.dragn0007.deepblue.entities.greatwhite;

import com.dragn.bettas.BettasMain;
import com.dragn0007.deepblue.entities.AbstractShark;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.Dolphin;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import software.bernie.geckolib3.core.AnimationState;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.builder.ILoopType;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.util.GeckoLibUtil;

import javax.annotation.Nullable;
import java.util.UUID;

public class GreatWhite extends AbstractShark implements IAnimatable {

    private final AnimationFactory factory = GeckoLibUtil.createFactory(this);

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 25d)
                .add(Attributes.MOVEMENT_SPEED, 3d)
                .add(Attributes.ATTACK_DAMAGE, 8f);
    }

    public GreatWhite(EntityType<? extends AbstractShark> entity, Level level) {
        super(entity, level);
        this.noCulling = true;
    }

    protected SoundEvent getAmbientSound() {
        return null;
    }

    protected SoundEvent getDeathSound() {
        return null;
    }

    protected SoundEvent getHurtSound(DamageSource p_184601_1_) {
        return SoundEvents.RAVAGER_HURT;
    }

    protected SoundEvent getFlopSound() {
        return SoundEvents.ELDER_GUARDIAN_FLOP;
    }

    private <E extends IAnimatable>PlayState predicate(AnimationEvent<E> event) {

        if (event.isMoving()) {
            if (isAggressive()) {
                event.getController().setAnimation(new AnimationBuilder().addAnimation("swimfast", ILoopType.EDefaultLoopTypes.LOOP));

            } else
                event.getController().setAnimation(new AnimationBuilder().addAnimation("swim", ILoopType.EDefaultLoopTypes.LOOP));

        } else
            event.getController().setAnimation(new AnimationBuilder().addAnimation("idle", ILoopType.EDefaultLoopTypes.LOOP));

        return PlayState.CONTINUE;
    }

    private PlayState attackPredicate(AnimationEvent event) {
        if (this.swinging && event.getController().getAnimationState().equals(AnimationState.Stopped)) {
            event.getController().markNeedsReload();
            event.getController().setAnimation(new AnimationBuilder().addAnimation("bite", ILoopType.EDefaultLoopTypes.PLAY_ONCE));
            this.swinging = false;
        }

        return PlayState.CONTINUE;
    }


    //Controls animations
    @Override
    public void registerControllers(AnimationData data) {
        data.addAnimationController(new AnimationController(this,"controller",5,this::predicate));
        data.addAnimationController(new AnimationController(this,"attackController",5,this::attackPredicate));
    }

    @Override
    public AnimationFactory getFactory() {
        return factory;
    }



    private static final EntityDataAccessor<Integer> VARIANT = SynchedEntityData.defineId(GreatWhite.class, EntityDataSerializers.INT);
    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(VARIANT, 0);
    }

    public int getTexture() {
        return this.entityData.get(VARIANT);
    }

    public void setTexture(int texture) {
        this.entityData.set(VARIANT, texture);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compoundTag) {
        super.addAdditionalSaveData(compoundTag);
        compoundTag.putInt("Variant", getTexture());
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compoundTag) {
        super.readAdditionalSaveData(compoundTag);
        if(compoundTag.contains("Variant")) {
            setTexture(compoundTag.getInt("Variant"));
        }
    }

    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor levelAccessor, DifficultyInstance difficultyInstance, MobSpawnType mobSpawnType, @Nullable SpawnGroupData spawnGroupData, @Nullable CompoundTag compoundTag) {
        if(compoundTag != null && compoundTag.contains("Variant")) {
            setTexture(compoundTag.getInt("Variant"));
        } else {
            setTexture(BettasMain.RANDOM.nextInt(GreatWhiteVariant.values().length));
        }
        return super.finalizeSpawn(levelAccessor, difficultyInstance, mobSpawnType, spawnGroupData, compoundTag);
    }

}

