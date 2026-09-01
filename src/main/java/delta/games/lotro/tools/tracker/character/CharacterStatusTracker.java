package delta.games.lotro.tools.tracker.character;

import java.util.ArrayList;
import java.util.List;

import delta.games.lotro.tools.tracker.TrackedDataProvider;
import delta.games.lotro.tools.tracker.TrackedElement;
import delta.games.lotro.tools.tracker.TrackedElementTypes;
import delta.games.lotro.tools.tracker.engine.Tracker;

/**
 * Tracker for the status of characters..
 * @author DAM
 */
public class CharacterStatusTracker implements Tracker
{
  /**
   * Constructor.
   */
  public CharacterStatusTracker()
  {
    // Nothing yet!
  }

  @Override
  public List<String> getTrackedElementTypes()
  {
    List<String> ret=new ArrayList<String>();
    ret.add(TrackedElementTypes.CHARACTER_LEVEL);
    ret.add(TrackedElementTypes.CHARACTER_MONEY);
    return ret;
  }

  @Override
  public TrackedDataProvider getDataProvider(TrackedElement element)
  {
    String type=element.getType();
    return new CharacterStatusTrackedDataProvider(type);
  }
}
