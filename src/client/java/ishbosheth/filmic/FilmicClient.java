package ishbosheth.filmic;

import org.lwjgl.glfw.GLFW;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.text.Text;

public class FilmicClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		// This entrypoint is suitable for setting up client-specific logic, such as rendering.
		KeyBinding keyBinding;

	    keyBinding = KeyBindingHelper.registerKeyBinding(new KeyBinding(
	        "key.filmic.spook", 
    	    InputUtil.Type.KEYSYM, 
        	GLFW.GLFW_KEY_R, 
       	 "category.filmic.test" 
    ));

	ClientTickEvents.END_CLIENT_TICK.register(client -> {
    	while (keyBinding.wasPressed()) {
		client.player.sendMessage(Text.literal("Key 1 was pressed!"), false);
		client.setScreen(new RecordingManager());
    	}
	});

	}
}