package com.thnote.thnotemod.compat.crystalizer;

import com.thnote.thnotemod.Thnote;
import com.thnote.thnotemod.block.ModBlocks;
import me.shedaniel.math.Point;
import me.shedaniel.math.Rectangle;
import me.shedaniel.rei.api.client.gui.Renderer;
import me.shedaniel.rei.api.client.gui.widgets.Widget;
import me.shedaniel.rei.api.client.gui.widgets.Widgets;
import me.shedaniel.rei.api.client.registry.display.DisplayCategory;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.display.basic.BasicDisplay;
import me.shedaniel.rei.api.common.util.EntryStacks;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.LinkedList;
import java.util.List;

public class CrystalizerCategory implements DisplayCategory<BasicDisplay> {
    public static final Identifier TEXTURE = Identifier.of(Thnote.MOD_ID, "textures/gui/crystalizer-rei.png");
    public static final CategoryIdentifier<CrystalizerDisplay> CRYSTALIZER =
            CategoryIdentifier.of(Thnote.MOD_ID, "crystalizer");

    @Override
    public CategoryIdentifier<? extends BasicDisplay> getCategoryIdentifier() {
        return CRYSTALIZER;
    }

    //Titulo de la categoria
    @Override
    public Text getTitle() {
        return Text.translatable("thnote.rei.crystalizer");
    }

    //Icono de la categoria
    @Override
    public Renderer getIcon() {
        return EntryStacks.of(ModBlocks.CRYSTALIZER.asItem().getDefaultStack());
    }

    @Override
    public List<Widget> setupDisplay(BasicDisplay display, Rectangle bounds) {
        Point startPoint = new Point(bounds.getCenterX() - 60, bounds.getCenterY() - 18);
        List<Widget> widgets = new LinkedList<>();

        //Dibuja la textura crystalizer-rei.png
        widgets.add(Widgets.createTexturedWidget(TEXTURE, new Rectangle(startPoint.x, startPoint.y, 114, 37), 0, 0, 114, 37));

        //Dibuja el fondo de slot resultado
        widgets.add(Widgets.createResultSlotBackground(new Point(startPoint.x + 83, startPoint.y + 11)));

        //Dibuja la animacion de la flecha
        widgets.add(Widgets.createArrow(new Point(startPoint.x + 41, startPoint.y + 11)).animationDurationTicks(40));

        //Crea slots de input
        widgets.add(Widgets.createSlot(new Point(startPoint.x + 11, startPoint.y + 11))
                .entries(display.getInputEntries().get(0)).markInput());

        //Crea slots de output
        widgets.add(Widgets.createSlot(new Point(startPoint.x + 83, startPoint.y + 11))
                .entries(display.getOutputEntries().get(0)).disableBackground().markOutput());

        return widgets;
    }

    //Altura del display que sale detras
    @Override
    public int getDisplayHeight() {
        return 37;
    }

    //Ancho del display que sale detras
    @Override
    public int getDisplayWidth(BasicDisplay display) {
        return 105;
    }
}