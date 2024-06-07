package ishbosheth.filmic;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.tooltip.Tooltip;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;

@Environment(EnvType.CLIENT)
public class RecordingManager extends Screen {

    //private final Screen parent;

    //protected RecordingManager(Screen parent) {
    protected RecordingManager() {
        super(Text.literal("Recording Manager"));
        //this.parent = parent;
    }

    public ButtonWidget testbutton;

    @Override
    protected void init() {
        testbutton = ButtonWidget.builder(Text.literal("test"), button -> {
            System.out.println("test button!");
        })
        .dimensions(width / 2 - 205, 20, 200, 20)
        .tooltip(Tooltip.of(Text.literal("Tooltip of testbutton")))
        .build();

        addDrawableChild(testbutton);
    }

    @Override
    public void close(){
        //client.setScreen(parent);
        client.setScreen(null);
    }

}
