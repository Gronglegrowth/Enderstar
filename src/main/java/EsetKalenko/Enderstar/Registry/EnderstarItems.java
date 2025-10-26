package EsetKalenko.Enderstar.Registry;

import EsetKalenko.Enderstar.Enderstar;
import EsetKalenko.Enderstar.Item.Material.AssemblyPowder;
import EsetKalenko.Enderstar.Item.Tool.BoundGem;
import EsetKalenko.Enderstar.Item.Tool.Primer;
import EsetKalenko.Enderstar.Item.Tool.SoulStone;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class EnderstarItems {

    public static final DeferredRegister.Items REGISTRAR = DeferredRegister.createItems(Enderstar.MODID);

    // Ingredients
    public static final DeferredItem<Item> AIR_CONDENSATE = REGISTRAR.registerItem("air_condensate", Item::new, new Item.Properties());
    public static final DeferredItem<Item> EARTH_CONDENSATE = REGISTRAR.registerItem("earth_condensate", Item::new, new Item.Properties());
    public static final DeferredItem<Item> FIRE_CONDENSATE = REGISTRAR.registerItem("fire_condensate", Item::new, new Item.Properties());
    public static final DeferredItem<Item> WATER_CONDENSATE = REGISTRAR.registerItem("water_condensate", Item::new, new Item.Properties());
    public static final DeferredItem<Item> ELEMENTAL_CONDENSATE = REGISTRAR.registerItem("elemental_condensate", Item::new, new Item.Properties());

    public static final DeferredItem<Item> ASSEMBLY_POWDER = REGISTRAR.registerItem("assembly_powder", AssemblyPowder::new, new Item.Properties());

    // Tools
    public static final DeferredItem<Item> PRIMER = REGISTRAR.registerItem("primer", Primer::new, new Item.Properties().stacksTo(1));
    public static final DeferredItem<Item> SOUL_STONE = REGISTRAR.registerItem("soul_stone", SoulStone::new, new Item.Properties().stacksTo(1));
    public static final DeferredItem<Item> BOUND_GEM = REGISTRAR.registerItem("bound_gem", BoundGem::new, new Item.Properties().stacksTo(1));
}
