package delta.games.lotro.tools.tracker.engine;

import java.util.List;

import delta.games.lotro.character.CharacterFile;
import delta.games.lotro.tools.tracker.TrackedDataProvider;
import delta.games.lotro.tools.tracker.TrackedElement;

/**
 * Engine of the generic tracker.
 * @author DAM
 */
public class TrackerEngine
{
  private TrackersRegistry _registry;

  /**
   * Constructor.
   */
  public TrackerEngine()
  {
    _registry=new TrackersRegistry();
  }

  /**
   * Get the values of the given tracked element for the given characters. 
   * @param element Tracked element to use.
   * @param toons Characters to use.
   * @return the loaded values.
   */
  public TrackedElementValues assess(TrackedElement element, List<CharacterFile> toons)
  {
    TrackedDataProvider provider=_registry.getProvider(element);
    String icon=provider.getIcon();
    String name=provider.getName();
    TrackedElementValues ret=new TrackedElementValues(icon,name);
    for(CharacterFile toon : toons)
    {
      Object value=provider.getValue(toon);
      ret.addValue(value);
    }
    return ret;
  }
}
