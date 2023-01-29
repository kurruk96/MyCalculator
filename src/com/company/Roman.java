package com.company;

public enum Roman {NONE(0), I(1), II(2),
    III(3), IV(4), V(5), VI(6),
    VII(7), VIII(8), IX(9), X(10);

    private int arab;

    Roman(int arab) {
        this.arab = arab;
    }

    public int getArab() {
        return arab;
    }

    public void setArab(int arab) {
        this.arab = arab;
    }
}
