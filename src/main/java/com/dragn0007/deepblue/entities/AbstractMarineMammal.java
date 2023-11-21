package com.dragn0007.deepblue.entities;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.control.SmoothSwimmingLookControl;
import net.minecraft.world.entity.ai.control.SmoothSwimmingMoveControl;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.animal.Bucketable;
import net.minecraft.world.entity.animal.WaterAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.pathfinder.BlockPathTypes;

import javax.annotation.Nullable;
import java.util.EnumSet;
import java.util.Random;

public abstract class AbstractMarineMammal extends WaterAnimal implements Bucketable {
    protected AbstractMarineMammal(EntityType<? extends AbstractMarineMammal> p_30341_, Level p_30342_) {
        super(p_30341_, p_30342_);
        this.setPathfindingMalus(BlockPathTypes.WATER, 0.0F);
        this.moveControl = new SmoothSwimmingMoveControl(this, 85, 10, 0.02F, 0.1F, true);
        this.lookControl = new SmoothSwimmingLookControl(this, 10);
    }
    private static final EntityDataAccessor<Boolean> FROM_BUCKET = SynchedEntityData.defineId(AbstractMarineMammal.class, EntityDataSerializers.BOOLEAN);

    public boolean requiresCustomPersistence() {
        return super.requiresCustomPersistence() || this.fromBucket();
    }

    public boolean removeWhenFarAway(double p_27492_) {
        return !this.fromBucket() && !this.hasCustomName();
    }

    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(FROM_BUCKET, false);
    }
    public boolean fromBucket() {
        return this.entityData.get(FROM_BUCKET);
    }

    public void setFromBucket(boolean p_27498_) {
        this.entityData.set(FROM_BUCKET, p_27498_);
    }

    public void addAdditionalSaveData(CompoundTag p_27485_) {
        super.addAdditionalSaveData(p_27485_);
        p_27485_.putBoolean("FromBucket", this.fromBucket());
    }

    public void readAdditionalSaveData(CompoundTag p_27465_) {
        super.readAdditionalSaveData(p_27465_);
        this.setFromBucket(p_27465_.getBoolean("FromBucket"));
    }

    public void saveToBucketTag(ItemStack p_27494_) {
        Bucketable.saveDefaultDataToBucketTag(this, p_27494_);
    }

    public void loadFromBucketTag(CompoundTag p_148708_) {
        Bucketable.loadDefaultDataFromBucketTag(this, p_148708_);
    }

    public SoundEvent getPickupSound() {
        return SoundEvents.BUCKET_FILL_FISH;
    }
    protected InteractionResult mobInteract(Player p_27477_, InteractionHand p_27478_) {
        return Bucketable.bucketMobPickup(p_27477_, p_27478_, this).orElse(super.mobInteract(p_27477_, p_27478_));
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(0, new BreathAirGoal(this));
        this.goalSelector.addGoal(0, new TryFindWaterGoal(this));
        this.goalSelector.addGoal(2, new AbstractMarineMammal.WhaleSwimWithPlayerGoal(this, 4.0D));
        this.goalSelector.addGoal(4, new RandomSwimmingGoal(this, 1.0D, 10));
//        this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(5, new LookAtPlayerGoal(this, Player.class, 6.0F));
        this.goalSelector.addGoal(8, new FollowBoatGoal(this));
        this.goalSelector.addGoal(9, new AvoidEntityGoal<>(this, AbstractShark.class, 8.0F, 1.0D, 1.0D));
    }

    public static final int TOTAL_AIR_SUPPLY = 4800;
    @Nullable
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor p_28332_, DifficultyInstance p_28333_, MobSpawnType p_28334_, @Nullable SpawnGroupData p_28335_, @Nullable CompoundTag p_28336_) {
        this.setAirSupply(this.getMaxAirSupply());
        this.setXRot(0.0F);
        return super.finalizeSpawn(p_28332_, p_28333_, p_28334_, p_28335_, p_28336_);
    }

    public static boolean checkWhaleSpawnRules(EntityType<? extends WaterAnimal> entityType, LevelAccessor levelAccessor, MobSpawnType mobSpawnType, BlockPos pos, Random random) {
        return levelAccessor.isWaterAt(pos) && levelAccessor.isWaterAt(pos.north()) && levelAccessor.isWaterAt(pos.east()) && levelAccessor.isWaterAt(pos.south()) && levelAccessor.isWaterAt(pos.west());
    }

    public boolean canBreatheUnderwater() {
        return false;
    }

    protected void handleAirSupply(int p_28326_) {
    }
    public int getMaxAirSupply() {
        return 4800;
    }

    protected int increaseAirSupply(int p_28389_) {
        return this.getMaxAirSupply();
    }


    protected SoundEvent getHurtSound(DamageSource p_28374_) {
        return SoundEvents.DOLPHIN_HURT;
    }

    @Nullable
    protected SoundEvent getDeathSound() {
        return SoundEvents.DOLPHIN_DEATH;
    }

    @Nullable
    protected SoundEvent getAmbientSound() {
        return this.isInWater() ? SoundEvents.DOLPHIN_AMBIENT_WATER : SoundEvents.DOLPHIN_AMBIENT;
    }

    protected SoundEvent getSwimSplashSound() {
        return SoundEvents.DOLPHIN_SPLASH;
    }

    protected SoundEvent getSwimSound() {
        return SoundEvents.DOLPHIN_SWIM;
    }

    public MobType getMobType() {
        return MobType.WATER;
    }

    public boolean checkSpawnObstruction(LevelReader p_30348_) {
        return p_30348_.isUnobstructed(this);
    }

    public int getAmbientSoundInterval() {
        return 120;
    }

    protected int getExperienceReward(Player p_30353_) {
        return 1 + this.level.random.nextInt(3);
    }

    public void baseTick() {
        int i = this.getAirSupply();
        super.baseTick();
        this.handleAirSupply(i);
    }

    public boolean isPushedByFluid() {
        return false;
    }

    public boolean canBeLeashed(Player p_30346_) {
        return false;
    }



    static final TargetingConditions SWIM_WITH_PLAYER_TARGETING = TargetingConditions.forNonCombat().range(10.0D).ignoreLineOfSight();
    static class WhaleSwimWithPlayerGoal extends Goal {
        private final AbstractMarineMammal marineMammal;
        private final double speedModifier;
        @Nullable
        private Player player;

        WhaleSwimWithPlayerGoal(AbstractMarineMammal marineMammal, double p_28414_) {
            this.marineMammal = marineMammal;
            this.speedModifier = p_28414_;
            this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
        }

        public boolean canUse() {
            this.player = this.marineMammal.level.getNearestPlayer(AbstractMarineMammal.SWIM_WITH_PLAYER_TARGETING, this.marineMammal);
            if (this.player == null) {
                return false;
            } else {
                return this.player.isSwimming() && this.marineMammal.getTarget() != this.player;
            }
        }

        public boolean canContinueToUse() {
            return this.player != null && this.player.isSwimming() && this.marineMammal.distanceToSqr(this.player) < 256.0D;
        }

        public void start() {
            this.player.addEffect(new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 100), this.marineMammal);
        }

        public void stop() {
            this.player = null;
            this.marineMammal.getNavigation().stop();
        }

        public void tick() {
            this.marineMammal.getLookControl().setLookAt(this.player, (float)(this.marineMammal.getMaxHeadYRot() + 20), (float)this.marineMammal.getMaxHeadXRot());
            if (this.marineMammal.distanceToSqr(this.player) < 6.25D) {
                this.marineMammal.getNavigation().stop();
            } else {
                this.marineMammal.getNavigation().moveTo(this.player, this.speedModifier);
            }

            if (this.player.isSwimming() && this.player.level.random.nextInt(6) == 0) {
                this.player.addEffect(new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 100), this.marineMammal);
            }

        }
    }
}