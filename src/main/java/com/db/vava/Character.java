package com.db.vava;

public class Character {
    private Class characterClass;
    private Subclass characterSubclass;
    private Background characterBackground;
    private Race characterRace;

    public Class getCharacterClass() {
        return characterClass;
    }

    public void setCharacterClass(Class characterClass) {
        this.characterClass = characterClass;
    }

    public Subclass getCharacterSubclass() {
        return characterSubclass;
    }

    public void setCharacterSubclass(Subclass characterSubclass) {
        this.characterSubclass = characterSubclass;
    }

    public Background getCharacterBackground() {
        return characterBackground;
    }

    public void setCharacterBackground(Background characterBackground) {
        this.characterBackground = characterBackground;
    }

    public Race getCharacterRace() {
        return characterRace;
    }

    public void setCharacterRace(Race characterRace) {
        this.characterRace = characterRace;
    }
}