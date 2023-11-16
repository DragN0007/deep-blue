package com.dragn0007.deepblue.entities;

import com.dragn0007.deepblue.entities.greatwhite.GreatWhite;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Mth;
import net.minecraft.util.TimeUtil;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.control.SmoothSwimmingLookControl;
import net.minecraft.world.entity.ai.control.SmoothSwimmingMoveControl;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.navigation.WaterBoundPathNavigation;
import net.minecraft.world.entity.animal.*;
import net.minecraft.world.entity.monster.Drowned;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nullable;
import java.util.Random;
import java.util.UUID;
import java.util.function.Predicate;

public abstract class AbstractShark extends WaterAnimal implements NeutralMob  {

    private static final UniformInt PERSISTENT_ANGER_TIME = TimeUtil.rangeOfSeconds(20, 39);
    private int remainingPersistentAngerTime;
    @Nullable
    private UUID persistentAngerTarget;

    public AbstractShark(EntityType<? extends AbstractShark> p_27461_, Level p_27462_) {
        super(p_27461_, p_27462_);
//        this.moveControl = new AbstractShark.FishMoveControl(this);
        this.moveControl = new SmoothSwimmingMoveControl(this, 85, 10, 0.02F, 0.1F, true);
        this.lookControl = new SmoothSwimmingLookControl(this, 10);
    }

    public int getMaxSpawnClusterSize() {
        return 4;
    }

    public static boolean checkSharkSpawnRules(EntityType<? extends WaterAnimal> entityType, LevelAccessor levelAccessor, MobSpawnType mobSpawnType, BlockPos pos, Random random) {
        return levelAccessor.isWaterAt(pos) && levelAccessor.isWaterAt(pos.north()) && levelAccessor.isWaterAt(pos.east()) && levelAccessor.isWaterAt(pos.south()) && levelAccessor.isWaterAt(pos.west());
    }
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new AbstractShark.SharkMeleeAttackGoal());
        this.goalSelector.addGoal(1, new PanicGoal(this, 1.25D));
        this.goalSelector.addGoal(2, new AvoidEntityGoal<>(this, Dolphin.class, 8.0F, 1.6D, 1.4D, EntitySelector.NO_SPECTATORS::test));
        this.goalSelector.addGoal(4, new AbstractShark.SharkSwimGoal(this));
        this.targetSelector.addGoal(1, new AbstractShark.SharkHurtByTargetGoal());
        this.targetSelector.addGoal(2, new AbstractShark.SharkAttackPlayersGoal());
        this.goalSelector.addGoal(0, new TryFindWaterGoal(this));
        this.goalSelector.addGoal(4, new FollowBoatGoal(this));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Player.class, 10, true, false, this::isAngryAt));
//        this.targetSelector.addGoal(3, new AbstractShark.SharkEatFishGoal());
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, GreatWhite.class, 100, true, true, (Predicate<LivingEntity>)null));
    }

    protected PathNavigation createNavigation(Level p_27480_) {
        return new WaterBoundPathNavigation(this, p_27480_);
    }

    public void travel(Vec3 p_27490_) {
        if (this.isEffectiveAi() && this.isInWater()) {
            this.moveRelative(0.01F, p_27490_);
            this.move(MoverType.SELF, this.getDeltaMovement());
            this.setDeltaMovement(this.getDeltaMovement().scale(0.9D));
            if (this.getTarget() == null) {
                this.setDeltaMovement(this.getDeltaMovement().add(0.0D, -0.005D, 0.0D));
            }
        } else {
            super.travel(p_27490_);
        }

    }

    public void aiStep() {
        if (!this.isInWater() && this.onGround && this.verticalCollision) {
            this.setDeltaMovement(this.getDeltaMovement().add((double)((this.random.nextFloat() * 2.0F - 1.0F) * 0.05F), (double)0.4F, (double)((this.random.nextFloat() * 2.0F - 1.0F) * 0.05F)));
            this.onGround = false;
            this.hasImpulse = true;
            this.playSound(this.getFlopSound(), this.getSoundVolume(), this.getVoicePitch());
        }

        super.aiStep();
    }

    protected boolean canRandomSwim() {
        return true;
    }

    protected abstract SoundEvent getFlopSound();

    protected SoundEvent getSwimSound() {
        return SoundEvents.FISH_SWIM;
    }

    protected void playStepSound(BlockPos p_27482_, BlockState p_27483_) {
    }

    static class FishMoveControl extends MoveControl {
        private final AbstractShark fish;

        FishMoveControl(AbstractShark p_27501_) {
            super(p_27501_);
            this.fish = p_27501_;
        }

        public void tick() {
            if (this.fish.isEyeInFluid(FluidTags.WATER)) {
                this.fish.setDeltaMovement(this.fish.getDeltaMovement().add(0.0D, 0.005D, 0.0D));
            }

            if (this.operation == MoveControl.Operation.MOVE_TO && !this.fish.getNavigation().isDone()) {
                float f = (float)(this.speedModifier * this.fish.getAttributeValue(Attributes.MOVEMENT_SPEED));
                this.fish.setSpeed(Mth.lerp(0.125F, this.fish.getSpeed(), f));
                double d0 = this.wantedX - this.fish.getX();
                double d1 = this.wantedY - this.fish.getY();
                double d2 = this.wantedZ - this.fish.getZ();
                if (d1 != 0.0D) {
                    double d3 = Math.sqrt(d0 * d0 + d1 * d1 + d2 * d2);
                    this.fish.setDeltaMovement(this.fish.getDeltaMovement().add(0.0D, (double)this.fish.getSpeed() * (d1 / d3) * 0.1D, 0.0D));
                }

                if (d0 != 0.0D || d2 != 0.0D) {
                    float f1 = (float)(Mth.atan2(d2, d0) * (double)(180F / (float)Math.PI)) - 90.0F;
                    this.fish.setYRot(this.rotlerp(this.fish.getYRot(), f1, 90.0F));
                    this.fish.yBodyRot = this.fish.getYRot();
                }

            } else {
                this.fish.setSpeed(0.0F);
            }
        }
    }

    public boolean doHurtTarget(Entity p_29522_) {
        boolean flag = p_29522_.hurt(DamageSource.mobAttack(this), (float)((int)this.getAttributeValue(Attributes.ATTACK_DAMAGE)));
        if (flag) {
            this.doEnchantDamageEffects(this, p_29522_);
        }

        return flag;
    }
    class SharkHurtByTargetGoal extends HurtByTargetGoal {
        public SharkHurtByTargetGoal() {
            super(AbstractShark.this);
        }

        protected void alertOther(Mob p_29580_, LivingEntity p_29581_) {
            if (p_29580_ instanceof AbstractShark && !p_29580_.isBaby()) {
                super.alertOther(p_29580_, p_29581_);
            }

        }
    }
    class SharkEatFishGoal extends NearestAttackableTargetGoal<AbstractFish> {
        public SharkEatFishGoal() {
            super(AbstractShark.this, AbstractFish.class, 40, true, true, (Predicate<LivingEntity>)null);
        }
        protected double getFollowDistance() {
            return super.getFollowDistance() * 0.5D;
        }
    }
    class SharkAttackPlayersGoal extends NearestAttackableTargetGoal<Player> {
        public SharkAttackPlayersGoal() {
            super(AbstractShark.this, Player.class, 20, true, true, (Predicate<LivingEntity>)null);
        }
        protected double getFollowDistance() {
            return super.getFollowDistance() * 0.5D;
        }
    }
    class SharkMeleeAttackGoal extends MeleeAttackGoal {
        public SharkMeleeAttackGoal() {
            super(AbstractShark.this, 1.25D, true);
        }
        protected void checkAndPerformAttack(LivingEntity p_29589_, double p_29590_) {
            double d0 = this.getAttackReachSqr(p_29589_);
            if (p_29590_ <= d0 && this.isTimeToAttack()) {
                this.resetAttackCooldown();
                this.mob.doHurtTarget(p_29589_);
            } else if (p_29590_ <= d0 * 2.0D) {
                if (this.isTimeToAttack()) {

                    this.resetAttackCooldown();
                }
                if (this.getTicksUntilNextAttack() <= 10) {
                }
            } else {
                this.resetAttackCooldown();
            }

        }
    }

    public void startPersistentAngerTimer() {
        this.setRemainingPersistentAngerTime(PERSISTENT_ANGER_TIME.sample(this.random));
    }
    public void setRemainingPersistentAngerTime(int p_29543_) {
        this.remainingPersistentAngerTime = p_29543_;
    }

    public int getRemainingPersistentAngerTime() {
        return this.remainingPersistentAngerTime;
    }

    public void setPersistentAngerTarget(@Nullable UUID p_29539_) {
        this.persistentAngerTarget = p_29539_;
    }

    @Nullable
    public UUID getPersistentAngerTarget() {
        return this.persistentAngerTarget;
    }

    static class SharkSwimGoal extends RandomSwimmingGoal {
        public final AbstractShark fish;

        public SharkSwimGoal(AbstractShark p_27505_) {
            super(p_27505_, 1.0D, 40);
            this.fish = p_27505_;
        }

        public boolean canUse() {
            return this.fish.canRandomSwim() && super.canUse();
        }
    }
}

