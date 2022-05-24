package com.favouriteless.spectraledge;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;

import java.util.Arrays;
import java.util.List;

@Config(name = "spectraledge-common")
public class SpectralEdgeConfig implements ConfigData {

    public int levelCost;
    public int maxLevel;
    public float damagePercent;

}