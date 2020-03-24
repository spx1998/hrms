package com.hrms.security.entity;

import java.io.Serializable;
import java.util.List;

public class Mod_Submods implements Serializable {

    private static final long serialVersionUID = -7383320235153886031L;
    private String modName;
    private List<Submodule> submodName;

    public Mod_Submods(String name, List<Submodule> modSubmods) {
        this.modName = name;
        this.submodName = modSubmods;
    }

    public String getModName() {
        return modName;
    }

    public void setModName(String modName) {
        this.modName = modName;
    }

    public List<Submodule> getSubmodName() {
        return submodName;
    }

    public void setSubmodName(List<Submodule> submodName) {
        this.submodName = submodName;
    }
}
