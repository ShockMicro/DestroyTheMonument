package eu.pb4.destroythemonument;

import eu.pb4.destroythemonument.blocks.DtmBlocks;
import eu.pb4.destroythemonument.game.BaseGameLogic;
import eu.pb4.destroythemonument.kit.KitsRegistry;
import eu.pb4.destroythemonument.items.DtmItems;
import eu.pb4.destroythemonument.other.DtmUtil;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.tag.TagFactory;
import net.minecraft.block.Block;
import net.minecraft.tag.Tag;
import xyz.nucleoid.plasmid.game.GameSpace;
import xyz.nucleoid.plasmid.game.GameType;
import net.minecraft.util.Identifier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import eu.pb4.destroythemonument.game.GameConfig;
import eu.pb4.destroythemonument.game.WaitingLobby;

import java.util.Random;
import java.util.WeakHashMap;

public class DTM implements ModInitializer {
    public static final String ID = "destroy_the_monument";
    public static final Logger LOGGER = LogManager.getLogger(ID);
    public static final Random RANDOM = new Random();
    public static final Tag<Block> SPAWNABLE_TAG = TagFactory.BLOCK.create(DtmUtil.id("spawnable"));

    public static final GameType<GameConfig> TYPE = GameType.register(
            new Identifier(ID, ID),
            GameConfig.CODEC,
            WaitingLobby::open
    );

    public static final WeakHashMap<GameSpace, BaseGameLogic> ACTIVE_GAMES = new WeakHashMap<>();

    @Override
    public void onInitialize() {
        DtmItems.registerItems();
        DtmBlocks.register();
        KitsRegistry.register();
    }
}
