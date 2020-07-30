package app;

import base.Role;
import model.*;


/**
 * @author 675056544@qq.com
 */
public class Main {

    public static void main(String[] args) {
        //前者胜利次数
        int formerWin = 0;
        //模拟次数
        int times = 100000;
        String formerName = "";
        String latterName = "";
        for (int i = 0; i < times; i++) {

            Role former = new Sheele2020();
            Role latter = new Bronya2020();
            if (i == 0) {
                formerName = former.getName();
                latterName = latter.getName();
            }
            if (vs(former, latter) == 1){
                formerWin ++;
            }
        }
        System.out.println(formerName + "胜利" + formerWin + "次");
        System.out.println(latterName + "胜利" + (times - formerWin) + "次");
    }

    private static int vs (Role former, Role latter) {
        int currentRole = 1;
        while (former.getHp() > 0 && latter.getHp() > 0) {
            if (currentRole == 1) {
                former.myTurn(latter);
                currentRole = 2;
            } else {
                latter.myTurn(former);
                currentRole = 1;
            }
        }
        if (former.getHp() > 0) {
            System.out.println("【" + former.getName() + "胜利-------------------】\n");
            return 1;
        } else {
            System.out.println("【" + latter.getName() + "胜利-------------------】\n");
            return 2;
        }
    }
}
