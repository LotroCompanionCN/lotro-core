package delta.games.lotro.tools.tracker.engine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import delta.games.lotro.tools.tracker.TrackedDataProvider;
import delta.games.lotro.tools.tracker.TrackedElement;
import delta.games.lotro.tools.tracker.character.CharacterStatusTracker;
import delta.games.lotro.tools.tracker.deeds.DeedStatusTracker;

/**
 * Registry of known status data trackers.
 * @author DAM
 */
public class TrackersRegistry
{
  private List<Tracker> _trackers;
  private Map<String,Tracker> _mapTypesToTracker;

  /**
   * Constructor.
   */
  public TrackersRegistry()
  {
    _trackers=new ArrayList<Tracker>();
    _mapTypesToTracker=new HashMap<String,Tracker>();
    init();
    initTypesMap();
  }

  private void init()
  {
    DeedStatusTracker deedTracker=new DeedStatusTracker();
    _trackers.add(deedTracker);
    CharacterStatusTracker characterTracker=new CharacterStatusTracker();
    _trackers.add(characterTracker);
  }

  private void initTypesMap()
  {
    for(Tracker tracker : _trackers)
    {
      List<String> types=tracker.getTrackedElementTypes();
      for(String type : types)
      {
        _mapTypesToTracker.put(type,tracker);
      }
    }
  }

  /**
   * Get a provider for the given tracked element.
   * @param element Tracked element to use.
   * @return A data provider or <code>null</code> if not found.
   */
  public TrackedDataProvider getProvider(TrackedElement element)
  {
    Tracker tracker=_mapTypesToTracker.get(element.getType());
    if (tracker!=null)
    {
      return tracker.getDataProvider(element);
    }
    return null;
  }
}
