package victorjeanjr.stackitem.objects;

import java.text.DecimalFormat;

public class DoubleFormat {

    public static String format(final double money) {
        if (money < 1000000.0) {
            return new DecimalFormat("#,###.#").format(money);
        }
        if (money < 1.0E9) {
            return String.valueOf(new DecimalFormat("#,###.#").format(money / 1000000.0)) + "M";
        }
        if (money < 1.0E12) {
            return String.valueOf(new DecimalFormat("#,###.#").format(money / 1.0E9)) + "B";
        }
        if (money < 1.0E15) {
            return String.valueOf(new DecimalFormat("#,###.#").format(money / 1.0E12)) + "T";
        }
        if (money < 1.0E18) {
            return String.valueOf(new DecimalFormat("#,###.#").format(money / 1.0E15)) + "Q";
        }
        if (money < 1.0E21) {
            return String.valueOf(new DecimalFormat("#,###.#").format(money / 1.0E18)) + "QQ";
        }
        if (money < 1.0E24) {
            return String.valueOf(new DecimalFormat("#,###.#").format(money / 1.0E21)) + "S";
        }
        if (money < 1.0E27) {
            return String.valueOf(new DecimalFormat("#,###.#").format(money / 1.0E24)) + "SS";
        }
        if (money < 1.0E30) {
            return String.valueOf(new DecimalFormat("#,###.#").format(money / 1.0E27)) + "OC";
        }
        if (money < 1.0E33) {
            return String.valueOf(new DecimalFormat("#,###.#").format(money / 1.0E30)) + "N";
        }
        if (money < 1.0E36) {
            return String.valueOf(new DecimalFormat("#,###.#").format(money / 1.0E33)) + "D";
        }
        if (money < 1.0E39) {
            return String.valueOf(new DecimalFormat("#,###.#").format(money / 1.0E36)) + "UN";
        }
        if (money < 1.0E42) {
            return String.valueOf(new DecimalFormat("#,###.#").format(money / 1.0E39)) + "DD";
        }
        if (money < 1.0E45) {
            return String.valueOf(new DecimalFormat("#,###.#").format(money / 1.0E42)) + "TR";
        }
        if (money < 1.0E48) {
            return String.valueOf(new DecimalFormat("#,###.#").format(money / 1.0E45)) + "QT";
        }
        if (money < 1.0E51) {
            return String.valueOf(new DecimalFormat("#,###.#").format(money / 1.0E48)) + "QN";
        }
        if (money < 1.0E54) {
            return String.valueOf(new DecimalFormat("#,###.#").format(money / 1.0E51)) + "SD";
        }
        if (money < 1.0E57) {
            return String.valueOf(new DecimalFormat("#,###.#").format(money / 1.0E54)) + "SPD";
        }
        if (money < 1.0E60) {
            return String.valueOf(new DecimalFormat("#,###.#").format(money / 1.0E57)) + "OD";
        }
        if (money < 1.0E63) {
            return String.valueOf(new DecimalFormat("#,###.#").format(money / 1.0E60)) + "ND";
        }
        if (money < 1.0E66) {
            return String.valueOf(new DecimalFormat("#,###.#").format(money / 1.0E63)) + "VG";
        }
        if (money < 1.0E69) {
            return String.valueOf(new DecimalFormat("#,###.#").format(money / 1.0E66)) + "UVG";
        }
        if (money < 1.0E72) {
            return String.valueOf(new DecimalFormat("#,###.#").format(money / 1.0E69)) + "DVG";
        }
        if (money < 1.0E75) {
            return String.valueOf(new DecimalFormat("#,###.#").format(money / 1.0E72)) + "TVG";
        }
        if (money < 1.0E78) {
            return String.valueOf(new DecimalFormat("#,###.#").format(money / 1.0E75)) + "QTV";
        }
        if (money < 1.0E81) {
            return String.valueOf(new DecimalFormat("#,###.#").format(money / 1.0E78)) + "QNV";
        }
        if (money < 1.0E84) {
            return String.valueOf(new DecimalFormat("#,###.#").format(money / 1.0E81)) + "SEV";
        }
        if (money < 1.0E87) {
            return String.valueOf(new DecimalFormat("#,###.#").format(money / 1.0E84)) + "SPV";
        }
        if (money < 1.0E90) {
            return String.valueOf(new DecimalFormat("#,###.#").format(money / 1.0E87)) + "OVG";
        }
        if (money < 1.0E93) {
            return String.valueOf(new DecimalFormat("#,###.#").format(money / 1.0E90)) + "NVG";
        }
        if (money < 1.0E96) {
            return String.valueOf(new DecimalFormat("#,###.#").format(money / 1.0E93)) + "TG";
        }
        return new DecimalFormat("#,###.#").format(money);
    }

}
