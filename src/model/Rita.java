package model;

import base.Damage;
import base.Role;

/**
 * @author 675056544@qq.com 2019-07-12 20:59:17
 */
public class Rita extends Role {
    public static final String NAME = "丽塔";
    private static final Long ATK = 26L;
    private static final Long DEF = 8L;
    private static final Long HP = 100L;
    private static final double SKILL_PROBABILITY = 0.20;

    private static final double CURE_RATE = 0.30;

    public Rita (){
        super(NAME, ATK, DEF, HP, 0.0, SKILL_PROBABILITY, 0);
    }

    @Override
    public void afterAttack(Role target, Damage damage) {
        // 30%概率攻击回血
        if (Math.random() <= CURE_RATE) {
            this.setHp(this.getHp() + damage.getPhysicDamage());
            if (this.getHp() >= HP) {
                this.setHp(100L);
            }
            System.out.println(this.getName() + "对" + target.getName() + "造成了" + damage.getPhysicDamage() + "点伤害" +
                    "，并恢复了" + damage.getPhysicDamage() + "点生命");
        } else {
            System.out.println(this.getName() + "对" + target.getName() + "造成了" + damage.getPhysicDamage() + "点伤害");
        }

    }

    @Override
    public void skillAttack(Role role) {
        //攻击并封锁对手攻击一回合
        normalAttack(role);
        role.setForbiddenRound(1);
        System.out.println(this.getName() + "发动必杀技，使" + role.getName() + "下回合无法攻击");
    }
}
