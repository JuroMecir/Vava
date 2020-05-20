package com.db.vava;

import com.itextpdf.text.*;

public class WriteController {

    public void writeCharacter(Document document, Character character) throws DocumentException {

        // Set different types of font for pdf writing
        Font maxTitleFont = FontFactory.getFont(FontFactory.TIMES_BOLD, 28, BaseColor.BLACK);
        Font titleFont = FontFactory.getFont(FontFactory.TIMES_BOLD, 16, BaseColor.BLACK);
        Font textFont = FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, BaseColor.BLACK);

        // Main title
        document.add(new Paragraph("\n"));
        document.add(new Chunk("DND CHARACTER", maxTitleFont));
        document.add(new Paragraph("\n\n\n"));

        // Write whole character class
        document.add(new Chunk("Class: " + character.getCharacterClass().getName(), titleFont));
        document.add(new Paragraph("\n\n"));
        document.add(new Chunk("Features: ", titleFont));
        document.add(new Paragraph("\n"));
        document.add(new Chunk(character.getCharacterClass().getFeature1(), textFont));
        if (!character.getCharacterClass().getFeature2().equals("NULL")) {
            document.add(new Paragraph("\n"));
            document.add(new Chunk(character.getCharacterClass().getFeature2(), textFont));
        }
        if (!character.getCharacterClass().getFeature3().equals("NULL")) {
            document.add(new Paragraph("\n"));
            document.add(new Chunk(character.getCharacterClass().getFeature3(), textFont));
        }
        if (!character.getCharacterClass().getFeature4().equals("NULL")) {
            document.add(new Paragraph("\n"));
            document.add(new Chunk(character.getCharacterClass().getFeature4(), textFont));
        }
        if (!character.getCharacterClass().getFeature5().equals("NULL")) {
            document.add(new Paragraph("\n"));
            document.add(new Chunk(character.getCharacterClass().getFeature5(), textFont));
        }
        if (!character.getCharacterClass().getFeature6().equals("NULL")) {
            document.add(new Paragraph("\n"));
            document.add(new Chunk(character.getCharacterClass().getFeature6(), textFont));
        }
        if (!character.getCharacterClass().getFeature7().equals("NULL")) {
            document.add(new Paragraph("\n"));
            document.add(new Chunk(character.getCharacterClass().getFeature7(), textFont));
        }
        if (!character.getCharacterClass().getFeature8().equals("NULL")) {
            document.add(new Paragraph("\n"));
            document.add(new Chunk(character.getCharacterClass().getFeature8(), textFont));
        }
        if (!character.getCharacterClass().getFeature9().equals("NULL")) {
            document.add(new Paragraph("\n"));
            document.add(new Chunk(character.getCharacterClass().getFeature9(), textFont));
        }
        if (!character.getCharacterClass().getFeature10().equals("NULL")) {
            document.add(new Paragraph("\n"));
            document.add(new Chunk(character.getCharacterClass().getFeature10(), textFont));
        }
        document.add(new Paragraph("\n\n\n"));

        // Write whole character subclass
        document.add(new Chunk("Subclass: " + character.getCharacterSubclass().getName(), titleFont));
        document.add(new Paragraph("\n\n"));
        document.add(new Chunk("Features: ", titleFont));
        document.add(new Paragraph("\n"));
        document.add(new Chunk(character.getCharacterSubclass().getFeature1(), textFont));
        if (!character.getCharacterSubclass().getFeature2().equals("NULL")) {
            document.add(new Paragraph("\n"));
            document.add(new Chunk(character.getCharacterSubclass().getFeature2(), textFont));
        }
        if (!character.getCharacterSubclass().getFeature3().equals("NULL")) {
            document.add(new Paragraph("\n"));
            document.add(new Chunk(character.getCharacterSubclass().getFeature3(), textFont));
        }
        if (!character.getCharacterSubclass().getFeature4().equals("NULL")) {
            document.add(new Paragraph("\n"));
            document.add(new Chunk(character.getCharacterSubclass().getFeature4(), textFont));
        }
        if (!character.getCharacterSubclass().getFeature5().equals("NULL")) {
            document.add(new Paragraph("\n"));
            document.add(new Chunk(character.getCharacterSubclass().getFeature5(), textFont));
        }
        if (!character.getCharacterSubclass().getFeature6().equals("NULL")) {
            document.add(new Paragraph("\n"));
            document.add(new Chunk(character.getCharacterSubclass().getFeature6(), textFont));
        }
        if (!character.getCharacterSubclass().getFeature7().equals("NULL")) {
            document.add(new Paragraph("\n"));
            document.add(new Chunk(character.getCharacterSubclass().getFeature7(), textFont));
        }
        if (!character.getCharacterSubclass().getFeature8().equals("NULL")) {
            document.add(new Paragraph("\n"));
            document.add(new Chunk(character.getCharacterSubclass().getFeature8(), textFont));
        }
        if (!character.getCharacterSubclass().getFeature9().equals("NULL")) {
            document.add(new Paragraph("\n"));
            document.add(new Chunk(character.getCharacterSubclass().getFeature9(), textFont));
        }
        if (!character.getCharacterSubclass().getFeature10().equals("NULL")) {
            document.add(new Paragraph("\n"));
            document.add(new Chunk(character.getCharacterSubclass().getFeature10(), textFont));
        }
        document.add(new Paragraph("\n\n\n"));

        // Write whole character background
        document.add(new Chunk("Background: " + character.getCharacterBackground().getName(), titleFont));
        document.add(new Paragraph("\n\n"));
        document.add(new Chunk("Features: ", titleFont));
        document.add(new Paragraph("\n"));
        document.add(new Chunk(character.getCharacterBackground().getFeature1(), textFont));
        if (!character.getCharacterBackground().getFeature2().equals("NULL")) {
            document.add(new Paragraph("\n"));
            document.add(new Chunk(character.getCharacterBackground().getFeature2(), textFont));
        }
        if (!character.getCharacterBackground().getFeature3().equals("NULL")) {
            document.add(new Paragraph("\n"));
            document.add(new Chunk(character.getCharacterBackground().getFeature3(), textFont));
        }
        if (!character.getCharacterBackground().getFeature4().equals("NULL")) {
            document.add(new Paragraph("\n"));
            document.add(new Chunk(character.getCharacterBackground().getFeature4(), textFont));
        }
        if (!character.getCharacterBackground().getFeature5().equals("NULL")) {
            document.add(new Paragraph("\n"));
            document.add(new Chunk(character.getCharacterBackground().getFeature5(), textFont));
        }
        if (!character.getCharacterBackground().getFeature6().equals("NULL")) {
            document.add(new Paragraph("\n"));
            document.add(new Chunk(character.getCharacterBackground().getFeature6(), textFont));
        }
        if (!character.getCharacterBackground().getFeature7().equals("NULL")) {
            document.add(new Paragraph("\n"));
            document.add(new Chunk(character.getCharacterBackground().getFeature7(), textFont));
        }
        if (!character.getCharacterBackground().getFeature8().equals("NULL")) {
            document.add(new Paragraph("\n"));
            document.add(new Chunk(character.getCharacterBackground().getFeature8(), textFont));
        }
        if (!character.getCharacterBackground().getFeature9().equals("NULL")) {
            document.add(new Paragraph("\n"));
            document.add(new Chunk(character.getCharacterBackground().getFeature9(), textFont));
        }
        if (!character.getCharacterBackground().getFeature10().equals("NULL")) {
            document.add(new Paragraph("\n"));
            document.add(new Chunk(character.getCharacterBackground().getFeature10(), textFont));
        }
        document.add(new Paragraph("\n\n\n"));

        // Write whole character race
        document.add(new Chunk("Race: " + character.getCharacterRace().getName(), titleFont));
        document.add(new Paragraph("\n\n"));
        document.add(new Chunk("Features: ", titleFont));
        document.add(new Paragraph("\n"));
        document.add(new Chunk(character.getCharacterRace().getFeature1(), textFont));
        if (!character.getCharacterRace().getFeature2().equals("NULL")) {
            document.add(new Paragraph("\n"));
            document.add(new Chunk(character.getCharacterRace().getFeature2(), textFont));
        }
        if (!character.getCharacterRace().getFeature3().equals("NULL")) {
            document.add(new Paragraph("\n"));
            document.add(new Chunk(character.getCharacterRace().getFeature3(), textFont));
        }
        if (!character.getCharacterRace().getFeature4().equals("NULL")) {
            document.add(new Paragraph("\n"));
            document.add(new Chunk(character.getCharacterRace().getFeature4(), textFont));
        }
        if (!character.getCharacterRace().getFeature5().equals("NULL")) {
            document.add(new Paragraph("\n"));
            document.add(new Chunk(character.getCharacterRace().getFeature5(), textFont));
        }
        if (!character.getCharacterRace().getFeature6().equals("NULL")) {
            document.add(new Paragraph("\n"));
            document.add(new Chunk(character.getCharacterRace().getFeature6(), textFont));
        }
        if (!character.getCharacterRace().getFeature7().equals("NULL")) {
            document.add(new Paragraph("\n"));
            document.add(new Chunk(character.getCharacterRace().getFeature7(), textFont));
        }
        if (!character.getCharacterRace().getFeature8().equals("NULL")) {
            document.add(new Paragraph("\n"));
            document.add(new Chunk(character.getCharacterRace().getFeature8(), textFont));
        }
        if (!character.getCharacterRace().getFeature9().equals("NULL")) {
            document.add(new Paragraph("\n"));
            document.add(new Chunk(character.getCharacterRace().getFeature9(), textFont));
        }
        if (!character.getCharacterRace().getFeature10().equals("NULL")) {
            document.add(new Paragraph("\n"));
            document.add(new Chunk(character.getCharacterRace().getFeature10(), textFont));
        }

    }

}
